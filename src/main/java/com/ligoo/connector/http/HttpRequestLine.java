package com.ligoo.connector.http;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 11:47:56
 * @Description: http请求首行解析
 */
public class HttpRequestLine {
    // -------------------------------------------------------------- Constants
    public static final int INITIAL_METHOD_SIZE = 8;
    public static final int INITIAL_URI_SIZE = 64;
    public static final int INITIAL_PROTOCOL_SIZE = 8;
    public static final int MAX_METHOD_SIZE = 1024;
    public static final int MAX_URI_SIZE = 32768;
    public static final int MAX_PROTOCOL_SIZE = 1024;

    // ----------------------------------------------------------- Constructors
    public HttpRequestLine() {

        this(new char[INITIAL_METHOD_SIZE], 0, new char[INITIAL_URI_SIZE], 0,
                new char[INITIAL_PROTOCOL_SIZE], 0);

    }

    public HttpRequestLine(char[] method, int methodEnd,
                           char[] uri, int uriEnd,
                           char[] protocol, int protocolEnd) {
        this.method = method;
        this.methodEnd = methodEnd;
        this.uri = uri;
        this.uriEnd = uriEnd;
        this.protocol = protocol;
        this.protocolEnd = protocolEnd;

    }

    // ----------------------------------------------------- Instance Variables
    public char[] method;
    public int methodEnd;
    public char[] uri;
    public int uriEnd;
    public char[] protocol;
    public int protocolEnd;

    /**
     * description: 重置,复用对象
     * author: Administrator
     * date: 2018/12/7 11:49
     *
     * @param:
     * @return:
     */
    public void recycle(){
        methodEnd = 0;
        uriEnd = 0;
        protocolEnd = 0;
    }

    /**
     * description: 获取uri字符索引
     * author: Administrator
     * date: 2018/12/7 13:30
     *
     * @param:
     * @return:
     */
    public int indexOf(char c, int start){
        for (int i = start; i < uriEnd; i++){
            if(uri[i] == c)
                return i;
        }
        return  -1;
    }
    /**
     * description: 测试uri中是否包含指定长度字符序列
     * author: Administrator
     * date: 2018/12/7 13:33
     *
     * @param: buf[] 字符数组
     * @param end 字符数组大小
     * @return:
     */
    public int indexOf(char[] buf, int end){
        char firstChar = buf[0];
        int pos = 0;
        while (pos < uriEnd){
            pos = indexOf(firstChar, pos);
            if(pos == -1)
                return -1;
            if ((uriEnd - pos) < end){
                return -1;
            }
            for (int i = 0; i < end; i++){
                if(uri[i + pos] != buf[i])
                    break;
                if(i == (end - 1))
                    return pos;
            }
            pos++;
        }
        return  -1;
    }
    public int indexOf(String str){
        return indexOf(str.toCharArray(), str.length());
    }
    public int indexOf(char[] buf){
        return indexOf(buf, buf.length);
    }

}
