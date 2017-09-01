package com.hangwei.wanke.middleware.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * Created by Sam on 8/29/17.
 */
public class PropertiesUtil {

    private static Properties properties = null;

    private final static String propertiesFileName = "/server.properties";
    private final static String webServiceURL = "webservice.url";
    private final static String parkHttpServerURL = "park.http.server.url";

    private static Logger log = LoggerFactory.getLogger(PropertiesUtil.class);

    public static String getWebserviceURL(){
        if (properties==null) {
            synchronized (properties) {
                loadPropertiesFile();
            }
        }
        return properties.getProperty(webServiceURL);
    }

    public static String getParkHttpServerURL() {
        if (properties==null) {
            synchronized (properties) {
                loadPropertiesFile();
            }
        }
        return properties.getProperty(parkHttpServerURL);
    }

    public static void loadPropertiesFile(){
        properties = new Properties();
        InputStream in = null;
        try {
            in = PropertiesUtil.class.getResourceAsStream(propertiesFileName);
            if (in != null){
                properties.load(in);
                in.close();
            }else{
                log.warn("没有加载到配置文件{}",propertiesFileName);
            }
        } catch (FileNotFoundException e) {
            log.error("系统没有加载到配置文件-{}",propertiesFileName,e);
        } catch (IOException e) {
            log.error("配置文件读取异常",e);
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("系统没有加载到配置文件输入流关闭失败");
                }
            }
        }
    }
}
