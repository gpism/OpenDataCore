package org.opendatacore.meta.connector.engine.plugin.agent.model;

import org.opendatacore.meta.connector.engine.plugin.event.MDCRequest;
import org.opendatacore.meta.connector.engine.plugin.event.MDCResponse;
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
public interface RemoteAgent {

    public Agent getAgent();
    public MDCResponse execute(MDCRequest request) ;

    public MDCResponse start() ;

    public MDCResponse status() ;
}
