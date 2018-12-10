package com.ligoo;

import com.ligoo.connector.http.HttpRequest;
import com.ligoo.connector.http.HttpResponse;

import java.io.IOException;

/**
 * @Author: Administrator
 * @Date: 2018/12/6 10:40:29
 * @Description: 静态资源处理器
 */
public class StaticResourceProcessor {
    /**
     * description: 静态资源处理方法
     * author: Administrator
     * date: 2018/12/6 10:51
     *
     * @param:
     * @return:
     */
    public void process(HttpRequest request, HttpResponse response){
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
