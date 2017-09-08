package com.hangwei.wanke.middleware.http;

import com.hangwei.wanke.middleware.common.AuditApprovementBO;
import com.hangwei.wanke.middleware.common.CloseApprovementBO;
import com.hangwei.wanke.middleware.common.Constant;
import com.hangwei.wanke.middleware.common.CreateApprovementBO;
import com.hangwei.wanke.middleware.enums.ServiceErrorEnum;
import com.hangwei.wanke.middleware.enums.ServiceNameEnum;
import com.hangwei.wanke.middleware.service.TransferService;
import com.hangwei.wanke.middleware.ws.server.K2Message;
import org.apache.commons.lang.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 统一一个servlet接收请求，来自PHP端过来的Http请求
 * 在这个类中区分到底是哪个服务
 *
 * Created by Sam on 8/30/17.
 */

public class ApprovementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        String serviceName = req.getParameter("serviceName");
        if(StringUtils.isNotEmpty(serviceName)){
            if(serviceName.equals(ServiceNameEnum.CREATE.getName())){


            }else if(serviceName.equals(ServiceNameEnum.AUDIT.getName())){

            }else if(serviceName.equals(ServiceNameEnum.CLOSE.getName())){

            }else{
                returnError(resp,ServiceErrorEnum.NOT_FIND_SERVICE_NAME);
            }
        }else{
            returnError(resp,ServiceErrorEnum.NO_SERVICE_NAME);
        }
    }

    private K2Message[] getMsgArray(String parameter) {
        return null;
    }

    private void returnError(HttpServletResponse resp, ServiceErrorEnum serviceError) throws IOException {
        PrintWriter out  = resp.getWriter();
        out.write(serviceError.toJson());
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
