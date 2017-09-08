package com.hangwei.wanke.middleware.ws.server;

/**
 * Created by Sam on 9/6/17.
 */
public enum ProcessInstanceStatus {

    None,           //不存在该流程实例
    Active,         //正在审批流程中
    Approved,       //已审批通过
    Denied,         //已被拒绝
    Deleted,        //已被删除
    ApprovedDeleted //申请删除

}
