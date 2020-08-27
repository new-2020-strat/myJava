package basic.library.object;

import java.util.Objects;

/**
 * 所有类的基类，即是所有类的父类(所有类,数组,枚举)
 * 例如，Boolean equals(Object object):判断指定指定对象与该对象是否相等
 *      protected void finalize():当该系统中没有引用变量引用该对象时，系统就调用该方法清理该对象所占用的内存资源
 *      Class<?> getClass():返回该对象运行时类
 *      int hashCode():
 *      String toString():
 *
 *java7新增一个Objects工具类，用于操作object类
 */
public class TestObject {
    public static void main(String[] args) {
        Object object = new Object();
        //object类的常用方法
        System.out.println(object.equals("aaaa"));
    }

}
