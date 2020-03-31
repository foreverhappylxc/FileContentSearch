package com.fhlxc.filecontentsearch.backend;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.Properties;

/**
* @author Xingchao Long
* @date 2020年3月31日 下午2:54:52
* @classname ModifyProperties
* @description 修改指定的*.properties文件
*/

public class ModifyProperties {

    //properties文件的路径
    private String path = "";
    //操作属性的类
    private Properties properties = new Properties();
    
    public ModifyProperties(String path) throws UnsupportedEncodingException {
        this.path = URLDecoder.decode(this.getClass().getClassLoader().getResource("").toString(), "utf-8").split(":")[1] + "/" + path;
    }
    
    //初始化属性类
    public void init() throws IOException {
        InputStream inputStream = new FileInputStream(path);
        properties.load(inputStream);
        inputStream.close();
    }
    
    //通过键名返回值
    public String get(String key) {
        return properties.getProperty(key);
    }
    
    //添加或者修改某个属性
    public void update(String key, String value) throws IOException {
        properties.setProperty(key, value);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        properties.store(fileOutputStream, "");
        fileOutputStream.close();
    }
    
    //通过键名删除某个属性
    public void delete(String key) throws IOException {
        properties.remove(key);
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        properties.store(fileOutputStream, "");
        fileOutputStream.close();
    }
    
    //查看所有的属性
    public void list() {
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = properties.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
    
    public static void main(String ... args) throws IOException {
        ModifyProperties modifyProperties = new ModifyProperties("ui.properties");
        modifyProperties.init();
        modifyProperties.list();
    }
    
}
