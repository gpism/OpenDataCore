package org.opendatacore.sdk.model.offer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * Created by gauravp on 31/01/17.
 */




@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Location implements Serializable {
    static final Logger log = LoggerFactory.getLogger(Location.class);

    public Location() {

        log.info("Initializing Default Constructor : " + this.getClass().getName());

    }
    @JsonInclude
    public double lat, lon;
    public  int proximityRadius;
    public  int insideTimeAlert;
    public  int insideAlert;
    @JsonIgnore
    public String hash ,block, city, country,region ,hash1,hash2,hash3 ;


    public Location(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }
}
