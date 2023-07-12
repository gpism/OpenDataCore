package org.opendatacore.sdk.client;

import org.opendatacore.sdk.model.event.Event;
import org.opendatacore.sdk.model.offer.Offer;
import org.opendatacore.sdk.model.offer.OfferRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by gauravp on 21/03/17.
 */

public interface Proxy {
    static final Logger log = LoggerFactory.getLogger(Proxy.class);



    public void sendEvent(Event event);
    public List<Offer> getOffers(OfferRequest offerRequest);
    public List<Offer> getOffers();



}
