package org.opendatacore.meta.connector.engine.plugin.security;
//JSON 

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

public class KeyBuilder {
    private static final Logger _logger = Logger.getLogger(KeyBuilder.class);

    public Key key;

    // init with key
    public KeyBuilder init(Key key) {
        this.key = key;
        return this;
    }

    //get Key by name
    public KeyBuilder name(String name) {
        this.key.name = name;
        return this;
    }

    //get Key by id
    public KeyBuilder id(String id) {
        this.key.id = id;
        return this;
    }

    //get Key by key
    public KeyBuilder key(String key) {
        this.key.key = key;
        return this;
    }

    //get Key by secret
    public KeyBuilder secret(String secret) {
        this.key.secret = secret;
        return this;
    }

    //get Key by role
    public KeyBuilder role(String role) {
        this.key.role = role;
        return this;
    }

    //get Key by type
    public KeyBuilder type(String type) {
        this.key.type = type;
        return this;
    }

    //get Key by created
    public KeyBuilder created(long created) {
        this.key.created = created;
        return this;
    }

    //get Key by validTill
    public KeyBuilder validTill(long validTill) {
        this.key.validTill = validTill;
        return this;
    }
    // build Key
    public Key build() {
        return this.key;
    }

}
