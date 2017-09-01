package com.hangwei.wanke.middleware.service;

import com.hangwei.wanke.middleware.ws.server.Approvement;
import com.hangwei.wanke.middleware.ws.server.BusinessObjectInfo;
import com.hangwei.wanke.middleware.ws.server.K2Message;
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
        return new BusinessObjectInfo[0];
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
        String response = TransferService.getTransferInstance().doCreateHttpPostTransferToPHP(strBsid,strBoid,bSuccess,bSuccessSpecified,iProcInstID,iProcInstIDSpecified,strMessage,msg);
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
        return null;
    }
}
