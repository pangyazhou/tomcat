package com.ligoo.util;

import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 10:38:01
 * @Description: 异常信息处理类
 */
public class StringManager {
    private ResourceBundle bundle;

    private StringManager(String packageName){
        String bundleName = packageName + ".LocalStrings";
        bundle = ResourceBundle.getBundle(bundleName);
    }

    public String getString(String key){
        if (key == null){
            String msg = "key is null";
            throw new NullPointerException(msg);
        }
        String str = null;
        try {
            str = bundle.getString(key);
        }catch (MissingResourceException mre){
            str = "Cannot find message associated with key '"+key+"'";
        }
        return str;
    }

    // --------------------------------------------------------------
    // STATIC SUPPORT METHODS
    // --------------------------------------------------------------
    // StringManager实例集合
    public static HashMap<String, Object> managers = new HashMap<>();
    /**
     * description: 获取类实例
     * author: Administrator
     * date: 2018/12/7 10:45
     *
     * @param: packageName 包名
     * @return: 类实例
     */
    public synchronized static StringManager getManager(String packageName){
        StringManager mgr = (StringManager) managers.get(packageName);
        if(mgr == null){
            mgr = new StringManager(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }
}
