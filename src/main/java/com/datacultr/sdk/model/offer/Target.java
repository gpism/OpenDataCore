package com.datacultr.sdk.model.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gauravp on 04/02/17.
 */

public class Target {
    static final Logger log = LoggerFactory.getLogger(Target.class);

    public Target() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }

    public String name, value ;
    public int type;

    public Target(String name, String value, int type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }


}
