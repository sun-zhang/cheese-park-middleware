package com.hangwei.wanke.middleware.ws.server;

/**
 * Created by Sam on 5/18/17.
 */
public class BusinessObjectInfo {

    private String _BusinessDataID;		//业务数据的ID。与业务数据信息中//的BDID对应。
    private String _BusinessDataValue;	//属性的值 。存储在流程实例的//业务数据中

    public String get_BusinessDataID() {
        return this._BusinessDataID;
    }

    public void set_BusinessDataID(String _BusinessDataID) {
        this._BusinessDataID = _BusinessDataID;
    }

    public String get_BusinessDataValue() {
        return _BusinessDataValue;
    }

    public void set_BusinessDataValue(String _BusinessDataValue) {
        this._BusinessDataValue = _BusinessDataValue;
    }
}
