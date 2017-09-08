package com.hangwei.wanke.middleware.common;

import com.hangwei.wanke.middleware.ws.server.K2Message;

import java.util.Date;

/**
 * Created by Sam on 9/5/17.
 */
public class CloseApprovementBO extends BaseBO {

    private String strProcessInstanceResult;
    private String strComment;
    private Date dtTime;
    private boolean dtTimeSpecified;

    public String getStrProcessInstanceResult() {
        return strProcessInstanceResult;
    }

    public void setStrProcessInstanceResult(String strProcessInstanceResult) {
        this.strProcessInstanceResult = strProcessInstanceResult;
    }

    public String getStrComment() {
        return strComment;
    }

    public void setStrComment(String strComment) {
        this.strComment = strComment;
    }

    public Date getDtTime() {
        return dtTime;
    }

    public void setDtTime(Date dtTime) {
        this.dtTime = dtTime;
    }

    public boolean isDtTimeSpecified() {
        return dtTimeSpecified;
    }

    public void setDtTimeSpecified(boolean dtTimeSpecified) {
        this.dtTimeSpecified = dtTimeSpecified;
    }
}
