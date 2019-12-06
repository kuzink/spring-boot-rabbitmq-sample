package com.devglan.springbootrabbitmq.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyMessage {

    private String type;
    private String msg;

    public MyMessage(@JsonProperty("type") final String type, @JsonProperty("msg") final String msg) {
        this.type = type;
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{type='" + type + '\'' + ", msg='" + msg + '\'' + '}';
    }
}
