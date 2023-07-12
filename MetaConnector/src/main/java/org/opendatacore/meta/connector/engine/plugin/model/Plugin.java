package org.opendatacore.meta.connector.engine.plugin.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.util.security.SecurityUtils;
import org.opendatacore.meta.connector.engine.plugin.util.security.conf.KEYS;
import org.opendatacore.meta.connector.engine.plugin.event.MDCRequest;
import org.opendatacore.meta.connector.engine.plugin.event.MDCResponse;
import org.opendatacore.meta.connector.engine.plugin.event.MDCSession;
import org.opendatacore.meta.connector.engine.plugin.resource.Resource;
import org.opendatacore.meta.connector.engine.plugin.model.service.ServiceInfo;

import java.util.ArrayList;
import java.util.List;
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
public abstract class Plugin {
    private static final Logger _logger = Logger.getLogger(Plugin.class);

    public String name,description;


    @JsonIgnore
    List<MDCSession> sessions = new ArrayList<MDCSession>();

    @JsonIgnore
    public Resource resource;

    public Plugin init(Resource resource) {
        this.resource = resource;
        return this;
    }

    protected String decryptPassword(String password){
        _logger.info("Getting decrypted password");
        try {
            String password1 = SecurityUtils.decrypt(password, KEYS.SIGN_KEY);
            _logger.info("Password decrypted →  " + password1);
            return password1;
        } catch (Exception e) {
            _logger.error("Error decrypting password : " + e.getMessage());
            return "error : " + e.getMessage() ;

        }


    }


    public abstract MDCResponse execute(MDCRequest mdcRequest) throws Exception;

    public abstract MDCResponse connect(Resource resource) throws Exception;


    public abstract ServiceInfo getServiceInfo() ;



    public abstract Plugin register() throws Exception;

    public abstract String getName() ;

    public abstract String getDescription() ;







    //Get session
}
