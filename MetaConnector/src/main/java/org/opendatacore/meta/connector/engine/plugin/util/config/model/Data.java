package org.opendatacore.meta.connector.engine.plugin.util.config.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data {
    private static final Logger _logger = Logger.getLogger(Data.class);
    public String name , type , value , subtype ;
    public Double dValue;

    public Data name(String name) {
        this.name = name;
        return this;
    }

    public Data type(String type) {
        this.type = type;
        return this;
    }

    public Data value(String value) {
        this.value = value;
        return this;
    }



    public Data dValue(double dValue) {
        this.dValue = dValue;
        this.type= DATA_TYPES.DOUBLE;
        return this;
    }

    //subType
    public Data subType(String subtype) {
        this.subtype = subtype;
        return this;
    }

    //add string value
    public Data addValue(String value) {
        this.value = value;
        this.type= DATA_TYPES.STRING;
        return this;
    }

    public Data addFilter(String name, String value) {
        this.name = name;
        this.value = value;
        this.type= DATA_TYPES.STRING;
        this.subtype = DATA_SUB_TYPE.FIlTER;
        return this;
    }



    public String toJson()  {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            return ow.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "error converting to json";
        }
    }


}
