package com.start.defineMybatis.tools.is;

import java.io.InputStream;

/**
 * 仿写mybatis中的Resource类
 * 使用类加载器读取配置文件的类
 */
public class Resources {
    /**
     * 根据传入的文件路径参数获得一个该文件的输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
