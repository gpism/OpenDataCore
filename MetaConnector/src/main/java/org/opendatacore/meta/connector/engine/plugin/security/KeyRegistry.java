package org.opendatacore.meta.connector.engine.plugin.security;
//JSON 

//logging
import com.fasterxml.jackson.core.JsonProcessingException;
import org.jboss.logging.Logger;

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

public class KeyRegistry {
    private static final Logger _logger = Logger.getLogger(KeyRegistry.class);

    List<Key> keys = new ArrayList<Key>();


    //singleton
    private static KeyRegistry instance = null;
    protected KeyRegistry() {
        // Exists only to defeat instantiation.
    }
    public static KeyRegistry getInstance() {
        if(instance == null) {
            instance = new KeyRegistry();
        }
        return instance;
    }

    // get key by key using streams
    public Key getKeyByKey(String key) {
        return keys.stream().filter(k -> k.key.equals(key)).findFirst().orElse(null);
    }

    // get key by id using streams
    public Key getKeyById(String id) {
        return keys.stream().filter(k -> k.id.equals(id)).findFirst().orElse(null);
    }

    // get key by secret using streams
    public Key getKeyBySecret(String secret) {
        return keys.stream().filter(k -> k.secret.equals(secret)).findFirst().orElse(null);
    }

    // get key by key and secret using streams
    public Key getKeyByKeyAndSecret(String key, String secret) {
        return keys.stream().filter(k -> k.key.equals(key) && k.secret.equals(secret)).findFirst().orElse(null);
    }

   // get all keys by role
    public List<Key> getKeysByRole(String role) {
        return keys.stream().filter(k -> k.role.equals(role)).collect(Collectors.toList());
    }

    // add key
    public void addKey(Key key) {
        keys.add(key);
    }

    // remove key by id
    public void removeKey(String id) {
        keys.removeIf(k -> k.id.equals(id));
    }

    // remove key by key
    public void removeKeyByKey(String key) {
        keys.removeIf(k -> k.key.equals(key));
    }

    // remove key by secret
    public void removeKeyBySecret(String secret) {
        keys.removeIf(k -> k.secret.equals(secret));
    }

    // remove key by key and secret
    public void removeKeyByKeyAndSecret(String key, String secret) {
        keys.removeIf(k -> k.key.equals(key) && k.secret.equals(secret));
    }

    // remove all keys by role
    public void removeKeysByRole(String role) {
        keys.removeIf(k -> k.role.equals(role));
    }

    //update key by id
    public void updateKey( Key key) {
        Key k = getKeyByKey(key.key);
        if (k != null) {
            k.key = key.key;
            k.secret = key.secret;
            k.role = key.role;
        }
        //update key in keys
        removeKey(key.key);
        addKey(k);

    }


    //get file path
    public String getFilePath() {
        // Get base path
        String basePath = System.getProperty("user.dir");
        String path = basePath + "conf/keys/keys.json";
        return path;
    }

    //write keys to file
    public void writeKeysToFile() throws JsonProcessingException {

        String json = new KeyStore().init(keys).toJson();
        //write json to file
        String path = getFilePath();
        //write json to file using FileUtil
       // FileUtil.writeToFile(path, json);


      //write keys as json to file




    }




    //get Key by id



}
