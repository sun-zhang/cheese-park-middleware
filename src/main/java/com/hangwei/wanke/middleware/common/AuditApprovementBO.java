package com.hangwei.wanke.middleware.common;

import com.hangwei.wanke.middleware.ws.server.K2Message;

import java.util.Date;

/**
 * Created by Sam on 9/5/17.
 */
public class AuditApprovementBO extends BaseBO {

    private String strStepName;
    private String strApprover;
    private String strAction;
    private String strComment;
    private Date dtTime;
    private boolean dtTimeSpecified;

    public String getStrStepName() {
        return strStepName;
    }

    public void setStrStepName(String strStepName) {
        this.strStepName = strStepName;
    }

    public String getStrApprover() {
        return strApprover;
    }

    public void setStrApprover(String strApprover) {
        this.strApprover = strApprover;
    }

    public String getStrAction() {
        return strAction;
    }

    public void setStrAction(String strAction) {
        this.strAction = strAction;
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

    public K2Message[] getMsg() {
        return msg;
    }

    public void setMsg(K2Message[] msg) {
        this.msg = msg;
    }
}
