package com.datacultr.sdk.model.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gauravp on 31/01/17.
 */

public final class MEDIA_TYPE {
    static final Logger log = LoggerFactory.getLogger(MEDIA_TYPE.class);

    public MEDIA_TYPE() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }

    public static int IMAGE=0;
    public static int VIDEO=1;
    public static int VR=2;


}
