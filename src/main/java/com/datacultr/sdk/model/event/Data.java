package com.datacultr.sdk.model.event;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by gauravp on 21/12/16.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Data implements Serializable {
    public String name ;
    public String value ;
    public String type;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public double lvalue;
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    public boolean bvalue;



    public Data() {
    }

    public Data(String name, String value) {
        this.name = name;
        this.value = value;

        this.type=DATA_TYPES.STR;
    }

    public Data(String name, double lvalue) {
        this.name = name;
        this.lvalue = lvalue;
        this.value=lvalue+"";
        this.type=DATA_TYPES.NUM;

    }
    public Data(String name, boolean bvalue) {
        this.name = name;
        this.bvalue = bvalue;
        this.value=bvalue+"";
        this.type=DATA_TYPES.BOOL;

    }

    @Override
    public String toString() {
        return "Data{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", type='" + type + '\'' +
                ", lvalue=" + lvalue +
                ", bvalue=" + bvalue +
                '}';
    }
}
