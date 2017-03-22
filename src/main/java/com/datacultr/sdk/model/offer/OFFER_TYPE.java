package com.datacultr.sdk.model.offer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gauravp on 31/01/17.
 */

public final class OFFER_TYPE {
    static final Logger log = LoggerFactory.getLogger(OFFER_TYPE.class);

    public OFFER_TYPE() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }

    public static int LOCATION_BASED=0;
    public static int TIME_BASED=1;
    public static int SCDEDULLED=2;
    public static int RANDOM=3;
    public static int LOYALITY=4;
    public static int COUPON=5;
    public static int CASH_BACK=5;

}
