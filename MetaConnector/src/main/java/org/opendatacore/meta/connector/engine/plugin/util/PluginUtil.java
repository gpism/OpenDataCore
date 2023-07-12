package org.opendatacore.meta.connector.engine.plugin.util;

import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.model.Plugin;
import org.opendatacore.meta.connector.engine.plugin.registry.PluginRegistry;
import org.opendatacore.meta.connector.engine.plugin.storage.ResourceRegistry;
import org.opendatacore.meta.connector.engine.plugin.util.config.model.OPERATION_TYPES;
import org.opendatacore.meta.connector.engine.plugin.event.MDCRequest;
import org.opendatacore.meta.connector.engine.plugin.event.MDCResponse;
import org.opendatacore.meta.connector.engine.plugin.resource.Resource;
/**
 * ODC Meta Connector - Java Class
 *
 * This class is part of the ODC Meta Connector project.
 *
 * ODC Meta Connector is free software: you can redistribute it and/or modify
 * it under the terms of the Apache License, Version 2.0 (the "License").
 *
 * ODC Meta Connector is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Apache License, Version 2.0 for more details.
 *
 * You should have received a copy of the Apache License, Version 2.0
 * along with ODC Meta Connector. If not, see <https://www.apache.org/licenses/LICENSE-2.0>.
 */
public class PluginUtil {
    private static final Logger _logger = Logger.getLogger(PluginUtil.class);


    public MDCResponse processRequest(MDCRequest mdcRequest) {
        MDCResponse mdcResponse = new MDCResponse().request(mdcRequest);

        // get from registry
        try {

            _logger.info("1. Get Resource from id   : " + mdcRequest.resourceId);
            Resource resource1 = ResourceRegistry.getInstance().getResourceById(mdcRequest.resourceId);
            if(resource1 == null){
                _logger.error("1. Error in running tests   : " + "Resource not found");
                return mdcResponse.message("Resource not found").status("FAILED");
            }else{
                _logger.info("1. Resource found   : " + resource1.name);
                // Get plugin from registry from request type
                _logger.info("2. Get Plugin from name   : " + mdcRequest.type);
                Plugin plugin = PluginRegistry.getInstance().getPluginByName(mdcRequest.type);
                if(plugin == null){
                    _logger.error("2. Error in running tests   : " + "Plugin not found");
                    return mdcResponse.message("Plugin not found").status("FAILED");
                }else{
                    _logger.info("3. Plugin found   : " + plugin.name);
                    plugin.connect(resource1);
                    if(mdcRequest.operation!=null){
                        if(mdcRequest.operation.equals(OPERATION_TYPES.CHK_CONNECTION_STATUS)){
                            _logger.info("4. Operation found   : " + mdcRequest.operation);
                           return plugin.connect(resource1);
                        }
                    }
                    mdcResponse = plugin.execute(mdcRequest);
                    _logger.info("mdcResponse ->>>>> " + mdcResponse.toJson());
                    return  mdcResponse;
                }

            }


        } catch (Exception e) {
            _logger.error("Error in running tests   : " + e.getMessage());
            return mdcResponse.message(e.getMessage()).status("FAILED");


        }
    }

}
