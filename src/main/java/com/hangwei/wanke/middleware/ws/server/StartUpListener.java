package com.hangwei.wanke.middleware.ws.server;

import com.hangwei.wanke.middleware.common.PropertiesUtil;
import com.hangwei.wanke.middleware.service.ApprovementImpl;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.xml.ws.Endpoint;

/**
 * Created by Sam on 8/29/17.
 */
public class StartUpListener extends CXFNonSpringServlet {

    private static Logger log = LoggerFactory.getLogger(StartUpListener.class);


    @Override
    public void loadBus(ServletConfig servletConfig) throws ServletException {
        super.loadBus(servletConfig);
        log.info("web service start");
        Approvement implementor = new ApprovementImpl();
        String address = PropertiesUtil.getWebserviceURL();
        log.debug("published web service address：{}",address);
        Endpoint.publish(address, implementor);
        log.info("web service started");

    }
}
