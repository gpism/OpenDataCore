package org.opendatacore.meta.connector.engine.plugin.security;
//JSON 

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
//logging
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

public class Key {
    private static final Logger _logger = Logger.getLogger(Key.class);


    public String name;
    public String id;
    public String key ,secret, role;
    public String type;
    public long created , validTill;



    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //add pretty print
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);

    }
    //get builder
    @JsonIgnore
    public KeyBuilder getBuilder() {
        return new KeyBuilder().init(this);
    }

    // get builder
    public static KeyBuilder builder() {
        return new KeyBuilder().init(new Key());
    }
    //get helper
  @JsonIgnore
    public  KeyHelper getHelper() {
        return new KeyHelper().init(this);
    }
    //get helper
    public static KeyHelper helper() {
        return new KeyHelper().init();
    }





    // fromJson() function using Jackson
    public static Key fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Key.class);
    }
}
