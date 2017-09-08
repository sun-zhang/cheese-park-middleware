package com.hangwei.wanke.middleware.common;

import com.hangwei.wanke.middleware.ws.server.K2Message;

/**
 * Created by Sam on 9/5/17.
 */
public class BaseBO {

    protected String strBsid;
    protected String strBoid;
    protected int iProcInstID;
    protected boolean iProcInstIDSpecified;
    protected K2Message[] msg;

    public String getStrBsid() {
        return strBsid;
    }

    public void setStrBsid(String strBsid) {
        this.strBsid = strBsid;
    }

    public String getStrBoid() {
        return strBoid;
    }

    public void setStrBoid(String strBoid) {
        this.strBoid = strBoid;
    }

    public int getiProcInstID() {
        return iProcInstID;
    }

    public void setiProcInstID(int iProcInstID) {
        this.iProcInstID = iProcInstID;
    }

    public boolean isiProcInstIDSpecified() {
        return iProcInstIDSpecified;
    }

    public void setiProcInstIDSpecified(boolean iProcInstIDSpecified) {
        this.iProcInstIDSpecified = iProcInstIDSpecified;
    }

    public K2Message[] getMsg() {
        return msg;
    }

    public void setMsg(K2Message[] msg) {
        this.msg = msg;
    }
}
