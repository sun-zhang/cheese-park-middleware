package com.hangwei.wanke.middleware.ws.server;

import java.util.Date;

/**
 * Created by Sam on 9/6/17.
 */
public class ApproveStepInfo {

    public String _strApprover;
    public String _eAction;
    public String _strStepName;
    public String _strApproverComment;
    public Date _dtApproveTime;

    public String get_strApprover() {
        return _strApprover;
    }

    public void set_strApprover(String _strApprover) {
        this._strApprover = _strApprover;
    }

    public String get_eAction() {
        return _eAction;
    }

    public void set_eAction(String _eAction) {
        this._eAction = _eAction;
    }

    public String get_strStepName() {
        return _strStepName;
    }

    public void set_strStepName(String _strStepName) {
        this._strStepName = _strStepName;
    }

    public String get_strApproverComment() {
        return _strApproverComment;
    }

    public void set_strApproverComment(String _strApproverComment) {
        this._strApproverComment = _strApproverComment;
    }

    public Date get_dtApproveTime() {
        return _dtApproveTime;
    }

    public void set_dtApproveTime(Date _dtApproveTime) {
        this._dtApproveTime = _dtApproveTime;
    }
}
