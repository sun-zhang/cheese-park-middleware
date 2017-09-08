package com.hangwei.wanke.middleware.service;

import com.hangwei.wanke.middleware.common.CloseApprovementBO;
import com.hangwei.wanke.middleware.common.CreateApprovementBO;
import com.hangwei.wanke.middleware.common.AuditApprovementBO;
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
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sam on 9/1/17.
 */
public class Transfer extends TransferService{

    private static Logger log  = LoggerFactory.getLogger(Transfer.class);

    /**
     * 请求PHP端的Http服务，创建审批流程
     * @param createApprovement
     * @return
     */

    public String doCreateHttpPostTransferToPHP(CreateApprovementBO createApprovement) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesUtil.getParkHttpServerURL()+"/createResult");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("strBsid", createApprovement.getStrBsid()));
        params.add(new BasicNameValuePair("strBoid", createApprovement.getStrBoid()));
        params.add(new BasicNameValuePair("bSuccess", createApprovement.isbSuccess()+""));
        params.add(new BasicNameValuePair("bSuccessSpecified", createApprovement.isbSuccessSpecified()+""));
        params.add(new BasicNameValuePair("iProcInstID", createApprovement.getiProcInstID()+""));
        params.add(new BasicNameValuePair("iProcInstIDSpecified", createApprovement.isbSuccessSpecified()+""));
        params.add(new BasicNameValuePair("strMessage", createApprovement.getStrMessage()));
        params.add(new BasicNameValuePair("msg", getParameterMsgToString(createApprovement.getMsg())));
        return doHttpPost(httpclient, httpPost, params);
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
     * @param closeApprovement
     * @return
     */
    public String doCloseHttpPostTransferToPHP(CloseApprovementBO closeApprovement) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesUtil.getParkHttpServerURL()+"/close");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("strBsid", closeApprovement.getStrBsid()));
        params.add(new BasicNameValuePair("strBoid", closeApprovement.getStrBoid()));
        params.add(new BasicNameValuePair("iProcInstID", closeApprovement.getiProcInstID()+""));
        params.add(new BasicNameValuePair("iProcInstIDSpecified", closeApprovement.isiProcInstIDSpecified()+""));
        params.add(new BasicNameValuePair("strProcessInstanceResult", closeApprovement.getStrProcessInstanceResult()));
        params.add(new BasicNameValuePair("strComment", closeApprovement.getStrComment()));
        params.add(new BasicNameValuePair("dtTime", getDateString(closeApprovement.getDtTime())));
        params.add(new BasicNameValuePair("dtTimeSpecified", closeApprovement.isDtTimeSpecified()+""));
        params.add(new BasicNameValuePair("msg",getParameterMsgToString(closeApprovement.getMsg())));
        return doHttpPost(httpclient, httpPost, params);
    }

    /**
     * 请求PHP端的Http服务，执行审批
     * @param doApprovement
     * @return
     */
    public String doAuditHttpPostTransferToPHP(AuditApprovementBO doApprovement) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesUtil.getParkHttpServerURL()+"/audit");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("strBsid", doApprovement.getStrBsid()));
        params.add(new BasicNameValuePair("strBoid", doApprovement.getStrBoid()));
        params.add(new BasicNameValuePair("iProcInstID", doApprovement.getiProcInstID()+""));
        params.add(new BasicNameValuePair("iProcInstIDSpecified", doApprovement.isiProcInstIDSpecified()+""));
        params.add(new BasicNameValuePair("strStepName", doApprovement.getStrStepName()));
        params.add(new BasicNameValuePair("strApprover", doApprovement.getStrApprover()));
        params.add(new BasicNameValuePair("strAction", doApprovement.getStrAction()));
        params.add(new BasicNameValuePair("strComment", doApprovement.getStrComment()));
        params.add(new BasicNameValuePair("dtTime", getDateString(doApprovement.getDtTime())));
        params.add(new BasicNameValuePair("dtTimeSpecified", doApprovement.isDtTimeSpecified()+""));
        params.add(new BasicNameValuePair("msg",getParameterMsgToString(doApprovement.getMsg())));
        return doHttpPost(httpclient, httpPost, params);
    }

    /**
     * 请求PHP端的Http服务，执行审批
     * @param strBSID
     * @param strBOID
     * @return
     */

    public String doGetInfoHttpPostTransferToPHP(String strBSID, String strBOID) {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(PropertiesUtil.getParkHttpServerURL()+"/getInfo");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("strBsid", strBSID));
        params.add(new BasicNameValuePair("strBoid", strBOID));
        return doHttpPost(httpclient, httpPost, params);
    }

    private String doHttpPost(CloseableHttpClient httpclient, HttpPost httpPost, List<NameValuePair> params) {
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
                log.error("关闭Http请求客户端出现异常");
            }
        }
        return "";
    }

    private String getDateString(Date dtTime) {
        if (dtTime != null){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date date=new java.util.Date();
            return sdf.format(date);
        }
        return "";
    }


    public static void main(String[] args) {
        String filePath = "/home/testuser/upload/test.txt";
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            List<String> records = new ArrayList<String>();
            reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null){
                records.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
