package basic.library.runtime;

import java.io.IOException;

/**
 * RunTime运行时对象，访问jvm相关信息，
 * 如处理器，内存
 */
public class TestRunTime {
    public static void main(String[] args) throws IOException {
        //获取Runtime对象
        Runtime runtime = Runtime.getRuntime();
        //获取处理器数量
        System.out.println("处理器数量=="+runtime.availableProcessors());
        //获取空闲内存
        System.out.println("空闲内存=="+runtime.freeMemory());
        //获取总内存
        System.out.println("总内存=="+runtime.totalMemory());
        //可用最大内存
        System.out.println("可用最大内存=="+runtime.maxMemory());

        //单独启动一个线程操作系统命令(打开记事本)
        runtime.exec("notepad.exe");
    }
}
