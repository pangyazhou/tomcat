package com.ligoo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Administrator
 * @Date: 2018/12/3 17 23
 * @Description: tomcat程序入口
 */
public class HttpServer {

    // 是否接收到关闭命令
    private boolean shutdown = false;

    /**
     * author: Administrator
     * date: 2018/12/3 17:36
     * description: 程序入口
     * @param:
     * @return:
     */
    public static void main(String[] args){
        HttpServer server = new HttpServer();
        server.await();
    }

    /**
     * author: Administrator
     * date: 2018/12/3 17:33
     * description:
     * @param:
     * @return:
     */
    public void await(){
        ServerSocket serverSocket = null;
        int port = 8080;
        // 创建服务端Socket,监听8080端口
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown){
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                //创建request对象
                Request request = new Request(input);
                request.parse();
                //创建response对象
                Response response = new Response(output);
                response.setRequest(request);
                //判断请求是servlet还是静态资源
                if(request.getUri().startsWith("/servlet/")){
                    ServletProcessor processor = new ServletProcessor();
                    processor.process(request, response);
                }else {
                    StaticResourceProcessor processor = new StaticResourceProcessor();
                    processor.process(request, response);
                }
                socket.close();
                shutdown = request.getUri().equals(Constants.SHUTDOWN_COMMAND);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }
    }
}
