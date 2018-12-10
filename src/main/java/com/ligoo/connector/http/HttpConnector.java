package com.ligoo.connector.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 11:02:47
 * @Description: Http连接器
 */
public class HttpConnector implements Runnable {
    private boolean stopped;
    private String scheme = "http";

    public String getScheme() {
        return scheme;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (!stopped){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                continue;
            }
            HttpProcessor processor = new HttpProcessor(this);
            processor.process(socket);
        }
    }

    /**
     * description: 连接器启动
     * author: Administrator
     * date: 2018/12/7 11:04
     *
     * @param:
     * @return:
     */
    public void start(){
        Thread thread = new Thread(this);
        thread.start();
    }
}
