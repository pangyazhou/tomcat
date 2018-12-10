package com.ligoo.startup;

import com.ligoo.connector.http.HttpConnector;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 11:02:30
 * @Description: Tomcat启动类
 */
public class Bootstrap {
    public static void main(String[] args){
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}
