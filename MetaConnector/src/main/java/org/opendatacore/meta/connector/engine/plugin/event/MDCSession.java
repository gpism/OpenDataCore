package org.opendatacore.meta.connector.engine.plugin.event;

import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.resource.Resource;

import java.util.UUID;
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
public class MDCSession {
    private static final Logger _logger = Logger.getLogger(MDCSession.class);
    public MDCRequest request;
    public MDCResponse response;
    public Resource resource;

    public String sessionId;

    public MDCSession sessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }

    //Generate session id as GUID
    public MDCSession generateSessionId() {
        sessionId= UUID.randomUUID().toString();
        return this;
    }



    public MDCSession request(MDCRequest request) {
        this.request = request;
        return this;
    }

    public MDCSession response(MDCResponse response) {
        this.response = response;
        return this;
    }

    public MDCSession resource(Resource resource) {
        this.resource = resource;
        return this;
    }


}
