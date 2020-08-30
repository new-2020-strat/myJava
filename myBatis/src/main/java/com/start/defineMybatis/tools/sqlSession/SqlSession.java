package com.start.defineMybatis.tools.sqlSession;

/**
 * 自定义mybatis中与数据库交互的核心类
 * 他可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 根据传入的参数创建一个代理对象
     * @param daoInterfaceClass：dao接口的字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    /**
     * 释放资源
     */
    void close();

}
