package org.opendatacore.meta.connector.engine.plugin.model.service;
//JSON 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
//logging
import org.jboss.logging.Logger;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sample {
    private static final Logger _logger = Logger.getLogger(Sample.class);

    public String name,details;

    public MDCRequest request;
    public MDCResponse response;

    public Resource testResource;

    public Sample testResource(Resource resource){
        this.testResource = resource;
        return this;
    }

    public Sample testData(){

        this.name = "test";
        this.details = "Test Request Response  details";
        return this;
    }

    public Sample() {
    }

    public Sample(String name, String details) {
        this.name = name;
        this.details = details;
    }

    public Sample(String name, String details, MDCRequest request, MDCResponse response) {
        this.name = name;
        this.details = details;
        this.request = request;
        this.response = response;
    }

    // set name
    public Sample name(String name) {
        this.name = name;
        return this;
    }

    // set details
    public Sample details(String details) {
        this.details = details;
        return this;
    }

    // set request
    public Sample request(MDCRequest request) {
        this.request = request;
        return this;
    }

    // set response
    public Sample response(MDCResponse response) {
        this.response = response;
        return this;
    }




    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    // fromJson() function using Jackson
    public static Sample fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Sample.class);
    }
}
