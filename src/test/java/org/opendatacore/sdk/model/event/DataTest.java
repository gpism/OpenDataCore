package org.opendatacore.sdk.model.event;

import org.opendatacore.sdk.model.offer.Offer;

/**
 * Created by gauravp on 21/03/17.
 */
public class DataTest {
    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void sampleTestEventdata() throws Exception {
       Event event= new Event("i43sdf432","6542431Zen",EVENT_TYPES.OFFER_CLICKED);
       event.addData("url","http://ea.com/654123");
        event.addData("campaignid","98eerdf");
        event.addData("clickType","notificationBar");


        Event eventDeviceRegistration= new Event("i43sdf432",EVENT_TYPES.DEVICE_PROFILE_CREATE);
        eventDeviceRegistration.addData("deviceName","zen_click");
        eventDeviceRegistration.addData("osversion","24");
        eventDeviceRegistration.addData("brand","zenr");


    }

    @org.junit.Test
    public void sampleOfferEventdata() throws Exception {
        //Offer(String name, String details, String link)
        Offer offer = new Offer("titanfall 3","20% discount on coupon code ","http://ea.com/654123");
        offer.setDate("06/27/2017","06/29/2017");
        offer.addData("displayType","notificationBar");
        offer.addImageMedia("htpp//ea.com/iytr/titatnMob01.png","98765");



    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

}