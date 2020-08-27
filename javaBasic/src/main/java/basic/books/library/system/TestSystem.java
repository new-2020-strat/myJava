package basic.books.library.system;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * 操作系统环境变量使用java的native声明方法，类似于abstract抽象方法。只有签名没有实现
 * 让c语言实现用native修饰的方法
 */
public class TestSystem {
    public static void main(String[] args) throws IOException {
        //获取系统所有的环境变量
        Map<String,String> env = System.getenv();
        //遍历出所有的环境变量
        for (String name:env.keySet()){
            System.out.println(name+"--->"+env.get(name));
        }
        //获取指定变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        //获取所有的系统属性
        Properties properties = System.getProperties();
        //将所有的系统属性保存到properties.txt文件中
        properties.store(new FileOutputStream("D:\\myapp\\myJava\\javaBasic\\src\\main\\java\\basic\\library\\properties.txt"),"System properties");
        //输出特定系统属性
        System.out.println("os.name=="+System.getProperty("os.name"));

        /**
         * 获取当前时间,返回值为long类型
         * System.currentTimeMillis():单位为毫秒
         * System.nanoTime():纳秒做单位，有的操作系统不支持
         */
        System.out.println(System.currentTimeMillis());
        System.out.println(System.nanoTime());

        /**
         * System.identityHashCode()获取该对象的hashcode值
         * 这个还hashcode值可以确定对象的唯一，因为该hashcode值是根据对象地址计算得到
         */
        String test = new String("qilvbin");
        System.out.println("test hashcode =="+System.identityHashCode(test));
    }
}
