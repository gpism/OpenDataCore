package org.opendatacore.meta.connector.engine.plugin.agent.model;
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
public class AgentHelper {
    private static final Logger _logger = Logger.getLogger(AgentHelper.class);


    public Agent agent;

    //init
    public AgentHelper init(){
         agent = new Agent();
         return this;
    }

    //init
    public AgentHelper init(Agent agent){
         this.agent = agent;
         return this;
    }

    //read write it to file
    public AgentHelper read(String path) throws JsonProcessingException{
         ObjectMapper mapper = new ObjectMapper();
        // agent = mapper.readValue(new File(path), Agent.class);
         return this;
    }
    //Write using file helper class
    public AgentHelper write() throws JsonProcessingException{
      //  FileHelper.writeToFile(agent.toJson(),"agent.json");
         ObjectMapper mapper = new ObjectMapper();
         //mapper.writeValue(new File(path), agent);
         return this;
    }
}
