package com.hangwei.wanke.middleware.service;

import com.hangwei.wanke.middleware.common.AuditApprovementBO;
import com.hangwei.wanke.middleware.common.CloseApprovementBO;
import com.hangwei.wanke.middleware.common.Constant;
import com.hangwei.wanke.middleware.common.CreateApprovementBO;
import com.hangwei.wanke.middleware.ws.server.*;
import org.apache.commons.lang.StringUtils;
import sun.swing.StringUIClientPropertyKey;

import javax.jws.WebService;
import java.util.Date;

/**
 * Created by Sam on 5/18/17.
 */

@WebService(endpointInterface = "com.hangwei.wanke.middleware.ws.server.Approvement")
public class ApprovementImpl implements Approvement {

    /**
     * 获取连接地址
     *
     * @param strBSID
     * @param strBOID
     * @return
     */
    public BusinessObjectInfo[] GetInfo(String strBSID, String strBOID) {
        String response = TransferService.getTransferInstance().doGetInfoHttpPostTransferToPHP(strBSID,strBOID);
        return new BusinessObjectInfo[0];
    }

    /**
     * 获取当前状态，当前步骤以及最后一个已经审批过的审批步骤信息
     *
     * @param strBSID
     * @param strBOID
     * @return
     */
    public ProcessInstanceInfo[] GetStatus(String[] strBSID, String[] strBOID) {
        return new ProcessInstanceInfo[0];
    }

    /**
     * 获取当前状态，当前步骤以及最后一个已经审批过的审批步骤信息
     *
     * @param strBSID
     * @param strBOID
     * @return
     */
    public ProcessInstanceInfo[] GetKindsStatus(String[] strBSID, String[] strBOID) {
        return new ProcessInstanceInfo[0];
    }

    /**
     * 获取所给对象ID的流程实例的所有已审批的步骤信息
     *
     * @param strBSID
     * @param strBOID
     * @param iProcInstID
     * @return
     */
    public ApproveStepInfo[] GetAllProcessedSteps(String strBSID, String strBOID, int iProcInstID) {
        return new ApproveStepInfo[0];
    }

    /**
     * 创建审核流程
     *
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
    public String CreateResult(String strBsid, String strBoid, boolean bSuccess, boolean bSuccessSpecified, int iProcInstID, boolean iProcInstIDSpecified, String strMessage, K2Message[] msg) {
//      创建审批流程
        CreateApprovementBO createApprovementBO = new CreateApprovementBO();
        createApprovementBO.setStrBsid(strBsid);
        createApprovementBO.setStrBoid(strBoid);
        createApprovementBO.setiProcInstID(iProcInstID);
        createApprovementBO.setbSuccess(bSuccess);
        createApprovementBO.setbSuccessSpecified(bSuccessSpecified);
        createApprovementBO.setStrMessage(strMessage);
        createApprovementBO.setMsg(msg);
        String response = TransferService.getTransferInstance().doCreateHttpPostTransferToPHP(createApprovementBO);
        if (StringUtils.isNotEmpty(response)){
            return response;
        }
        return null;
    }

    /**
     * 审核结果
     *
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
    public String Audit(String strBsid, String strBoid, int iProcInstID, boolean iProcInstIDSpecified, String strStepName, String strApprover, String strAction, String strComment, Date dtTime, boolean dtTimeSpecified, K2Message[] msg) {
        AuditApprovementBO auditApprovementBO = new AuditApprovementBO();

        String response = TransferService.getTransferInstance().doAuditHttpPostTransferToPHP(auditApprovementBO);

        if (StringUtils.isNotEmpty(response)){
            return response;
        }
        return null;
    }

    /**
     * 审核流程结束
     *
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
    public String Close(String strBsid, String strBoid, int iProcInstID, boolean iProcInstIDSpecified, String strProcessInstanceResult, String strComment, Date dtTime, boolean dtTimeSpecified, K2Message[] msg) {
//      关闭审批流程
        CloseApprovementBO closeApprovementBO = new CloseApprovementBO();

        String response = TransferService.getTransferInstance().doCloseHttpPostTransferToPHP(closeApprovementBO);

        if (StringUtils.isNotEmpty(response)){
            return response;
        }
        return null;
    }
}
