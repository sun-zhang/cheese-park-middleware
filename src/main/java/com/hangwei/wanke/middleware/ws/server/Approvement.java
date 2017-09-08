package com.hangwei.wanke.middleware.ws.server;

import javax.jws.WebService;
import java.util.Date;

/**
 * webservice审批接口
 *
 * Created by Sam on 5/18/17.
 */

@WebService
public interface Approvement {

    /**
     * 获取连接地址
     * @param strBSID
     * @param strBOID
     * @return
     */
    public  BusinessObjectInfo[] GetInfo(String strBSID, String strBOID);


    /**
     * 获取当前状态，当前步骤以及最后一个已经审批过的审批步骤信息
     * @param strBSID
     * @param strBOID
     * @return
     */
    public ProcessInstanceInfo[] GetStatus(String[] strBSID, String[] strBOID);

    /**
     * 获取当前状态，当前步骤以及最后一个已经审批过的审批步骤信息
     * @param strBSID
     * @param strBOID
     * @return
     */
    public ProcessInstanceInfo[] GetKindsStatus(String[] strBSID, String[] strBOID);

    /**
     * 获取所给对象ID的流程实例的所有已审批的步骤信息
     * @param strBSID
     * @param strBOID
     * @param iProcInstID
     * @return
     */
    public  ApproveStepInfo[] GetAllProcessedSteps(String strBSID, String strBOID, int iProcInstID);


    /**
     * 创建审核流程
     * @param strBsid
     * @param strBoid
     * @param bSuccess
     * @param bSuccessSpecified
     * @param iProcInstID
     * @param iProcInstIDSpecified
     * @param strMessage
     * @param msg
     * @return
     */
    public String CreateResult(String strBsid, String strBoid, boolean bSuccess, boolean bSuccessSpecified, int iProcInstID, boolean iProcInstIDSpecified, String strMessage, K2Message[] msg);


    /**
     * 审核结果
     * @param strBsid
     * @param strBoid
     * @param iProcInstID
     * @param iProcInstIDSpecified
     * @param strStepName
     * @param strApprover
     * @param strAction
     * @param strComment
     * @param dtTime
     * @param dtTimeSpecified
     * @param msg
     * @return
     */
    public String Audit(String strBsid, String strBoid, int iProcInstID, boolean iProcInstIDSpecified, String strStepName, String strApprover, String strAction, String strComment, Date dtTime, boolean dtTimeSpecified, K2Message[] msg);


    /**
     * 审核流程结束
     * @param strBsid
     * @param strBoid
     * @param iProcInstID
     * @param iProcInstIDSpecified
     * @param strProcessInstanceResult
     * @param strComment
     * @param dtTime
     * @param dtTimeSpecified
     * @param msg
     * @return
     */
    public String Close(String strBsid, String strBoid, int iProcInstID, boolean iProcInstIDSpecified, String strProcessInstanceResult, String strComment, Date dtTime, boolean dtTimeSpecified, K2Message[] msg);

}
