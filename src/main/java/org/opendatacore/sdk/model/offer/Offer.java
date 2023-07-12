package org.opendatacore.sdk.model.offer;


import org.opendatacore.sdk.model.event.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by gauravp on 31/01/17.
 */

public class Offer {
    static final Logger log = LoggerFactory.getLogger(Offer.class);

    public Offer() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }



    public String name , details , link  ,fallBackLink , id, scheduledCron;
    public  long start, stop;

    public  int type =OFFER_TYPE.LOCATION_BASED;
    public List<Data> dataList = new ArrayList<Data>();
    public List<Media> mediaList = new ArrayList<Media>();


    public List<Location > locations = new ArrayList<Location>();


    public Offer(String name, String details, String link) {
        this.name = name;
        this.details = details;
        this.link = link;
        this.stop = stop;
    }

    public void setDate(Date start, Date stop){
        this.start=start.getTime();
        this.stop=stop.getTime();

    }

    public void addData( String name, String value) {


        dataList.add(new Data(name, value));

    }

    public void addImageMedia(String url, String assetid){
        mediaList.add(new Media(url,assetid,MEDIA_TYPE.IMAGE));
    }

    public void setDate(String start, String stop){

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date startDate;
        Date stopDate;
        try {
            startDate = df.parse(start);
            stopDate = df.parse(stop);
            this.start=startDate.getTime();
            this.stop=stopDate.getTime();




        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
