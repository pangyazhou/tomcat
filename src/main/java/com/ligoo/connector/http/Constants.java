package com.ligoo.connector.http;

import java.io.File;

/**
 * @Author: Administrator
 * @Date: 2018/12/6 10:42:35
 * @Description: 常量集
 */
public class Constants {
    //资源存放根目录
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    public static final String Package = "com.ligoo.connector.http";

    // 关闭命令
    public static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
}
