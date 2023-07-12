package org.opendatacore.meta.connector.engine.plugin.model.service;
//JSON 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;
//logging
import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.model.Plugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
public class ServiceInfo {
    private static final Logger _logger = Logger.getLogger(ServiceInfo.class);

    public String name,description,version="1.0" ,url,icon    ;
    public List<Feature> features = new ArrayList<>();
    public Sample sample = new Sample();


    public ServiceInfo() {
    }


    public ServiceInfo populate(Plugin plugin){
        this.name = plugin.getName();
        this.description = plugin.getDescription();

        return this;
    }

    public ServiceInfo populateForDb(){

        features.add(new Feature().name("userId").uiTypeString().description("User Id").required());
           features.add(new Feature().name("password").uiTypeString().description("Password").required());
       //serverName
        features.add(new Feature().name("serverName").uiTypeString().description("Server Name").required());
        //port
        features.add(new Feature().name("port").uiTypeInt().description("Port").required());

        //databaseName
        features.add(new Feature().name("databaseName").uiTypeString().description("Database Name").required());

       return this;

    }


    //sample
    public ServiceInfo sample(Sample sample) {
        this.sample = sample;
        return this;
    }






    public ServiceInfo(String name, String description, String version, String url, String icon) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.url = url;
        this.icon = icon;
    }

    public ServiceInfo name(String name) {
        this.name = name;
        return this;
    }

    public ServiceInfo description(String description) {
        this.description = description;
        return this;
    }

    public ServiceInfo version(String version) {
        this.version = version;
        return this;
    }

    public ServiceInfo url(String url) {
        this.url = url;
        return this;
    }

    public ServiceInfo icon(String icon) {
        this.icon = icon;
        return this;
    }

    public ServiceInfo features(List<Feature> features) {
        this.features = features;
        return this;
    }

    public ServiceInfo addFeature(Feature feature) {
        this.features.add(feature);
        return this;
    }

    public ServiceInfo addFeatures(List<Feature> features) {
        this.features.addAll(features);
        return this;
    }

    public ServiceInfo clearFeatures() {
        this.features.clear();
        return this;
    }

    public ServiceInfo removeFeature(Feature feature) {
        this.features.remove(feature);
        return this;
    }

    public ServiceInfo removeFeatures(List<Feature> features) {
        this.features.removeAll(features);
        return this;
    }

    public ServiceInfo removeFeature(int index) {
        this.features.remove(index);
        return this;
    }

    public ServiceInfo removeFeatures(int fromIndex, int toIndex) {
        this.features.subList(fromIndex, toIndex).clear();
        return this;
    }

    // get all features


    //Get all features of group ui type from using stream
    public List<Feature> getFeaturesByUiType() {
        return features.stream().filter(feature -> feature.group.equals(FEATURE_TYPES.UI_GROUP)).collect(Collectors.toList());
    }



    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    // fromJson() function using Jackson
    public static ServiceInfo fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, ServiceInfo.class);
    }
}
