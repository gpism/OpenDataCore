package org.opendatacore.meta.connector.engine.plugin.security;
//JSON 

import com.fasterxml.jackson.annotation.JsonInclude;
//logging
import org.jboss.logging.Logger;
import org.opendatacore.meta.connector.engine.plugin.util.io.FileHelper;

import java.util.UUID;

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
public class KeyHelper {
    private static final Logger _logger = Logger.getLogger(KeyHelper.class);
    Key key;

    public KeyHelper init(Key key) {
        this.key = key;
        return this;
    }
    public KeyHelper init() {
        this.key = new Key();
        return this;
    }

    public Key getKey() {
        return this.key;
    }

    //Generate guid
    public static String generateGuid() {
        return UUID.randomUUID().toString();
    }

    // Add more helper methods as needed
    public static Key  autoGenerate() {
        //ge

       return Key.builder().name("master").created(System.currentTimeMillis()).validTill(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365 * 10).
                role("admin").type("master").key(generateGuid()).secret(generateGuid()).
                build();

    }

    public  Key  autoGenIfNotExists() throws Exception {

        //ge
        if(!FileHelper.checkIfMasterKeyExists()){
            //log
            _logger.info("Master key not found, generating new master key");
            Key key = autoGenerate();
            FileHelper.writeMasterKeyFromFile(key);
            return key;

        }else{
            //log
            _logger.info("Master key found");
            String keyJson = FileHelper.readMasterKeyFromFile();
            return new Key().fromJson(keyJson);
        }

    }


}
