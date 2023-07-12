package org.opendatacore.sdk.model.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gauravp on 01/02/17.
 */

public class Media {
    static final Logger log = LoggerFactory.getLogger(Media.class);

    public Media() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }

    public String url ,assetid,name ,description;
    public int duration , h, w,framerate ,type;

    public Media(String url, String assetid, int type) {
        this.url = url;
        this.assetid = assetid;

        this.type = type;
    }
}
