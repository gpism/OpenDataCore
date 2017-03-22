package com.datacultr.sdk.model.offer;


import com.datacultr.sdk.model.event.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gauravp on 31/01/17.
 */

public class OfferRequest {
    static final Logger log = LoggerFactory.getLogger(OfferRequest.class);

    public OfferRequest() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }
    public String deviceId ;
    public  Location location ;
    public List<Event> eventList =  new ArrayList<Event>();
    public List<Target> targets =  new ArrayList<Target>();



}
