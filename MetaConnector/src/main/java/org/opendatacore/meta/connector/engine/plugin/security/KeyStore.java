package org.opendatacore.meta.connector.engine.plugin.security;
//JSON 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//logging
import org.jboss.logging.Logger;

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

public class KeyStore {

    public String name;
    public List<Key> keys;

    //init with keys
    public KeyStore init(List<Key> keys) {
        this.keys = keys;
        return this;
    }
    private static final Logger _logger = Logger.getLogger(KeyStore.class);


    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    // fromJson() function using Jackson
    public static KeyStore fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, KeyStore.class);
    }
}
