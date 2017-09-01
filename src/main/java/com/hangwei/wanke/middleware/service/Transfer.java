package com.hangwei.wanke.middleware.service;

import com.hangwei.wanke.middleware.common.PropertiesUtil;
import com.hangwei.wanke.middleware.ws.server.K2Message;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 9/1/17.
 */
public class Transfer extends TransferService{

    private static Logger log  = LoggerFactory.getLogger(Transfer.class);

    /**
     * 请求PHP端的Http服务，创建审批流程
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

    public String doCreateHttpPostTransferToPHP(String strBsid, String strBoid, boolean bSuccess, boolean bSuccessSpecified, int iProcInstID, boolean iProcInstIDSpecified, String strMessage, K2Message[] msg) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesUtil.getParkHttpServerURL()+"/createResult");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("strBsid", strBsid));
        params.add(new BasicNameValuePair("strBoid", strBoid));
        params.add(new BasicNameValuePair("bSuccess", bSuccess+""));
        params.add(new BasicNameValuePair("bSuccessSpecified", bSuccessSpecified+""));
        params.add(new BasicNameValuePair("iProcInstID", iProcInstID+""));
        params.add(new BasicNameValuePair("iProcInstIDSpecified", iProcInstIDSpecified+""));
        params.add(new BasicNameValuePair("strMessage", strMessage));
        params.add(new BasicNameValuePair("msg", getParameterMsgToString(msg)));
        httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
            public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        };
        try {
            return  httpclient.execute(httpPost, responseHandler);
        } catch (ClientProtocolException e) {
            log.error("请求PHP服务时出现服务状态异常",e);
        } catch (IOException e) {
            log.error("请求PHP服务时出现IO异常",e);
        }finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                log.error("创建审批流程--关闭Http请求客户端出现异常");
            }
        }
        return "";
    }

    private String getParameterMsgToString(K2Message[] msg) {
        if (msg != null){
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<msg.length;i++){
                if(i == msg.length-1){
                    sb.append(msg[i]);
                }else{
                    sb.append(msg[i]).append(",");
                }
            }
        }
        return "";
    }

    /**
     * 请求PHP端的Http服务，关闭审批流程
     * @param req
     * @return
     */
    public String doCloseHttpPostTransferToPHP(HttpServletRequest req) {
        return "";
    }

    /**
     * 请求PHP端的Http服务，执行审批
     * @param req
     * @return
     */
    public String doAuditHttpPostTransferToPHP(HttpServletRequest req) {
        return "";
    }
}
