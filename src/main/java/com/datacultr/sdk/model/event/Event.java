package com.datacultr.sdk.model.event;


import com.datacultr.sdk.model.offer.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.apache.commons.collections.map.HashedMap;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by gauravp on 21/12/16.
 */

public class Event  implements Serializable{
    public int type=EVENT_TYPES.LOCATION_UPDATE ;
    public  long ts;
    public List<Data> dataList = new ArrayList<Data>();
    public String deviceId;
    public String consumerId;
    public String token;
    public String time ;

    public Event( String deviceId,int type) {
        this.type = type;
        this.deviceId = deviceId;
        this.ts= System.currentTimeMillis();

    }

    public Location location;

    public void addEnrichedData(List<Data> data){

        dataList.addAll(data);

    }

    public Event() {
    }

    public Event(String deviceId, String consumerId) {
        this.deviceId = deviceId;
        this.consumerId = consumerId;
        ts=System.currentTimeMillis();
    }

    public Event(String deviceId, String consumerId, int type) {
        this.deviceId = deviceId;
        this.consumerId = consumerId;
        this.type = type;
        this.ts= System.currentTimeMillis();
    }

    public Event(long ts ,String deviceId, String consumerId, int type) {
        this.deviceId = deviceId;
        this.consumerId = consumerId;
        this.type = type;
        this.ts= ts;

    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
           return e.getMessage();
        }

    }


    public void addData( String name, String value){


        dataList.add(new Data(name,value));

    }

    public void addData( String name, long value){

        dataList.add(new Data(name,value));

    }
    public void addData( String name, double value){

        dataList.add(new Data(name,value));

    }

    public void addData( String name, boolean value){

        dataList.add(new Data(name,value));

    }

    @JsonIgnore
    public  Map<String, Object> getDataMap(){



        Map<String, Object> eventObj = new HashedMap();

        for(Data data:dataList){
            eventObj.put(data.name, data.value);

        }

        if (location!=null){

            eventObj.put("latitude", location.lat);
            eventObj.put("longitude", location.lon);
        }



        eventObj.put("ts",ts+"");
        eventObj.put("type",type);
        eventObj.put("type",type);
        eventObj.put("deviceId",deviceId);
        eventObj.put("consumerId",consumerId);
        eventObj.put("time",time);




        return eventObj;
    }


    @JsonIgnore
    public  ObjectNode getJsonObject(){



        ObjectNode eventObj = JsonNodeFactory.instance.objectNode(); // initializing;

        for(Data data:dataList){
            if(data.type.equalsIgnoreCase(DATA_TYPES.NUM)){
                eventObj.put(data.name, data.lvalue);
            }else{
                eventObj.put(data.name, data.value);
            }


        }

        if (location!=null){

            eventObj.put("latitude", location.lat);
            eventObj.put("longitude", location.lon);
        }



        eventObj.put("ts",ts+"");
        eventObj.put("time",time);
        eventObj.put("type",type);
        eventObj.put("type",type);
        eventObj.put("deviceId",deviceId);
        eventObj.put("consumerId",consumerId);



        return eventObj;
    }


@JsonIgnore
    public String getMapAsJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(getDataMap());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
           return e.getMessage();

        }

    }

    @JsonIgnore
    public String getJson() {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";

        }

    }







 }
