package org.opendatacore.meta.connector.engine.plugin.util.config.model;

import org.jboss.logging.Logger;
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
public class Config {
    private static final Logger _logger = Logger.getLogger(Config.class);
    public String name , type , subType , value ;
    public boolean isRequired;
    public String defaultValue;
    public String description;
    public int iValue ,code;

    public double dValue;

}
