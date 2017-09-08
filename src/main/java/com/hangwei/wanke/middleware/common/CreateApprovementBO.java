package com.hangwei.wanke.middleware.common;

import com.hangwei.wanke.middleware.ws.server.K2Message;

/**
 * Created by Sam on 9/5/17.
 */
public class CreateApprovementBO extends BaseBO {

    private boolean bSuccess;
    private boolean bSuccessSpecified;
    private String strMessage;

    public boolean isbSuccess() {
        return bSuccess;
    }

    public void setbSuccess(boolean bSuccess) {
        this.bSuccess = bSuccess;
    }

    public boolean isbSuccessSpecified() {
        return bSuccessSpecified;
    }

    public void setbSuccessSpecified(boolean bSuccessSpecified) {
        this.bSuccessSpecified = bSuccessSpecified;
    }

    public String getStrMessage() {
        return strMessage;
    }

    public void setStrMessage(String strMessage) {
        this.strMessage = strMessage;
    }
}
