package com.hangwei.wanke.middleware.enums;

/**
 * Created by Sam on 9/1/17.
 */
public enum ServiceErrorEnum {

    NO_SERVICE_NAME(101,"Parameter service name is empty"),
    NOT_FIND_SERVICE_NAME(102,"specified service name is not found "),;

    private int code;

    private String description;

    private ServiceErrorEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toJson(){
        return "{code:"+code+",description:'"+description+"'}";
    }
}
