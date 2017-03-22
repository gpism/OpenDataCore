package com.datacultr.sdk.model.event;

/**
 * Created by gauravp on 21/12/16.
 */

public class LocationEvent extends Event {
    public LocationEvent(String deviceId, String consumerId, int type) {
        super(deviceId, consumerId, type);
    }
}
