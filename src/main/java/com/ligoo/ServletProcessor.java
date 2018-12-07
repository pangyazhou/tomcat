package com.ligoo;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author: Administrator
 * @Date: 2018/12/6 10:40:40
 * @Description: servlet处理器
 */
public class ServletProcessor {
   /**
    * description: servlet处理方法
    * author: Administrator
    * date: 2018/12/6 10:51
    *
    * @param:
    * @return:
    */
    public void process(Request request, Response response){
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader classLoader = null;
        try {
            File classpath = new File(Constants.WEB_ROOT);
            URL url = null;
            url = classpath.toURI().toURL();
            classLoader = new URLClassLoader(new URL[]{url});
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class clazz = null;

        try {
            clazz = classLoader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Servlet servlet = null;
        RequestFacade requestFacade = new RequestFacade(request);
        ResponseFacade responseFacade = new ResponseFacade(response);
        try {
            servlet = (Servlet) clazz.newInstance();
            servlet.service((ServletRequest) requestFacade,(ServletResponse) responseFacade);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
