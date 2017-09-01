package com.hangwei.wanke.middleware.ws.server;

/**
 * Created by Sam on 5/18/17.
 */
public class K2Message {

    private String strMsgID;	//信息ID
    private String strMsg;		//信息内容
    private String strExtraInfo;	//信息的补充说明

    public String getStrMsgID() {
        return strMsgID;
    }

    public void setStrMsgID(String strMsgID) {
        this.strMsgID = strMsgID;
    }

    public String getStrMsg() {
        return strMsg;
    }

    public void setStrMsg(String strMsg) {
        this.strMsg = strMsg;
    }

    public String getStrExtraInfo() {
        return strExtraInfo;
    }

    public void setStrExtraInfo(String strExtraInfo) {
        this.strExtraInfo = strExtraInfo;
    }
}
