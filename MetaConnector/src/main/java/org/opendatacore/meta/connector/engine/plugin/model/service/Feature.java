package org.opendatacore.meta.connector.engine.plugin.model.service;
//JSON 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Feature {
    private static final Logger _logger = Logger.getLogger(Feature.class);
    public  String name, group,type , subType, description ,example, errorMsg,successMsg,uiType ,regex,value;
    public  boolean required;
    int ivalue;

    public Feature value(String value) {
        this.value = value;
        return this;
    }

    public Feature value(int value) {
        this.ivalue = value;
        return this;
    }


    int roleLevel;


    //required
    public Feature required() {
        this.required = true;
        return this;
    }
    //not required
    public Feature notRequired() {
        this.required = false;
        return this;
    }
    //set ui type as string
    public Feature uiTypeString() {
        this.uiType = FEATURE_TYPES.UI_TYPE_STRING;
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    //set ui type as int
    public Feature uiTypeInt() {
        this.uiType = FEATURE_TYPES.UI_TYPE_INT;
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    //set ui type as boolean

    public Feature uiTypeBoolean() {
        this.uiType = FEATURE_TYPES.UI_TYPE_BOOLEAN;
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    //set ui type as date
    public Feature uiTypeDate() {
        this.uiType = FEATURE_TYPES.UI_TYPE_DATE;
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    //set ui type as datetime
    public Feature uiTypeDateTime() {
        this.uiType = FEATURE_TYPES.UI_TYPE_DATETIME;
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    public Feature() {
    }

    public Feature(String name, String type, String description, String example, String errorMsg, String successMsg, boolean required, int roleLevel) {
        this.name = name;
        this.type = type;
        this.description = description;
        this.example = example;
        this.errorMsg = errorMsg;
        this.successMsg = successMsg;
        this.required = required;
        this.roleLevel = roleLevel;
    }

    //group
    public Feature group(String group) {
        this.group = group;
        return this;
    }

    // group as UI
    public Feature uiGroup() {
        this.group = FEATURE_TYPES.UI_GROUP;
        return this;
    }

    // type as ACCESS_SUB_TYPE
    public Feature accessSubType() {
        this.type = FEATURE_TYPES.ACCESS_SUB_TYPE;
        return this;
    }

    //subType

    public Feature subType(String subType) {
        this.subType = subType;
        return this;
    }

    public Feature name(String name) {
        this.name = name;
        return this;
    }

    public Feature type(String type) {
        this.type = type;
        return this;
    }

    public Feature description(String description) {
        this.description = description;
        return this;
    }

    public Feature example(String example) {
        this.example = example;
        return this;
    }


    public Feature errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    public Feature successMsg(String successMsg) {
        this.successMsg = successMsg;
        return this;
    }

    public Feature required(boolean required) {
        this.required = required;
        return this;
    }

    public Feature roleLevel(int roleLevel) {
        this.roleLevel = roleLevel;
        return this;
    }



    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    // fromJson() function using Jackson
    public static Feature fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Feature.class);
    }
}
