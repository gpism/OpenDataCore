package org.opendatacore.meta.connector.engine.plugin.model.service;
//JSON 

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
//logging
import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.model.Plugin;
import org.opendatacore.meta.connector.engine.plugin.registry.PluginRegistry;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PluginData {
    private static final Logger _logger = Logger.getLogger(PluginData.class);

    public String name,description,version="1.0" ,releaseNotes,icon ,fqdn_deployed , api_base_url, api_plugin_info, tenant_app;

    public List<ServiceInfo> plugins = new ArrayList<>();


    public PluginData() {
    }

    //tenant_app
    public PluginData tenant_app(String tenant_app) {
        this.tenant_app = tenant_app;
        return this;
    }

    // Get Plugins deployed  Summary  as String
    public String getPluginsSummary() {
      String banner=  "\n\n ******************************************************** "+"The ODC Meta Connector Module for  has started with following details  .. ********************************************** \n\n" +

              "     Started at : " + java.time.LocalDateTime.now() + "\n" +
              "     Name : "+ this.name + "\n" +
              "     version : " + this.version+ "\n" +
              "     No of Plugins Active : " + PluginRegistry.getInstance().getPluginCount()+"\n" +
              "     Deployed at : " +this.getFqdn_deployed(false) +" \n" +
              "     Release Notes : " + this.getReleaseNotesUrl() +" \n" +
              "     Plugin Info : " + this.getPluginInfoUrl() +" \n" +


              "\n\n ******************************************************** "+"Open Data Core: Composable Enterprise Fabric for Web 3 ********************************************** \n" ;
      return banner;

    }

    //Get reales notes url
    public String getReleaseNotesUrl() {
        return getFqdn_deployed(false)+ releaseNotes;
    }

    public String getPluginInfoUrl() {
        return getFqdn_deployed(false)+ api_plugin_info;
    }

    // api_plugin_info
    public PluginData api_plugin_info(String api_plugin_info) {
        this.api_plugin_info = api_plugin_info;
        return this;
    }
    // fqd_deployed
    public PluginData fqdn_deployed(String fqdn_deployed) {
        this.fqdn_deployed = fqdn_deployed;
        return this;
    }



    // base_url
    public PluginData base_url(String base_url) {
        this.api_base_url = base_url;
        return this;
    }

    // return http address
    public String getFqdn_deployed(boolean isHttps) {
        String fqdn_deployed_url = this.fqdn_deployed +"/"+ api_base_url;
        if (isHttps) {
            return "https://"+fqdn_deployed_url;
        }
        return "http://"+fqdn_deployed_url ;
    }

    public PluginData populate(String name, String description, String version, String releaseNotes, String icon){
        this.name = name;
        this.description = description;
        this.version = version;
        this.releaseNotes = releaseNotes;
        this.icon = icon;
        return this;
    }

    public PluginData populate(String name, String description, String version, String releaseNotes, String icon, List<ServiceInfo> plugins){
        this.name = name;
        this.description = description;
        this.version = version;
        this.releaseNotes = releaseNotes;
        this.icon = icon;
        this.plugins = plugins;
        return this;
    }

    // name
    public PluginData name(String name) {
        this.name = name;
        return this;
    }

    // description
    public PluginData description(String description) {
        this.description = description;
        return this;
    }

    // version
    public PluginData version(String version) {
        this.version = version;
        return this;
    }

    // releaseNotes
    public PluginData releaseNotes(String releaseNotes) {
        this.releaseNotes = releaseNotes;
        return this;
    }


    // get releaseNotes url
    public String getReleaseNotes() {
        return getFqdn_deployed(false) + api_base_url+this.releaseNotes;
    }
    // icon
    public PluginData icon(String icon) {
        this.icon = icon;
        return this;
    }


    // plugins
    public PluginData plugins() {
        List<Plugin> pluginsList = PluginRegistry.getInstance().getPlugins();
        for (Plugin plugin : pluginsList) {
            ServiceInfo serviceInfo =plugin.getServiceInfo();
            plugins.add(serviceInfo);
        }
        return this;
    }

    public PluginData plugins(List<Plugin> allPlugins) {

        _logger.info("plugins: " + allPlugins.size());
        plugins.clear();
        _logger.info("Cleared plugins: " + plugins.size());
        for (Plugin plugin : allPlugins) {
            ServiceInfo serviceInfo = plugin.getServiceInfo();
            _logger.info("Adding plugin: " + serviceInfo.name);
            plugins.add(serviceInfo);
        }

        return this;
    }




    public  int getPluginCount(){
        return plugins.size();
    }

    //get plugin by name via stream
    @JsonIgnore
    public ServiceInfo getPlugin(String name){
        return plugins.stream().filter(p->p.name.equals(name)).findFirst().orElse(null);
    }





    // toJson() function using Jackson
    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
    }

    // fromJson() function using Jackson
    public static PluginData fromJson(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, PluginData.class);
    }
}
