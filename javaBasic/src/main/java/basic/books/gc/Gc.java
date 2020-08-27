package basic.books.gc;

import org.junit.Test;

/**
 1.对象与垃圾回收
     1.1 垃圾回收机制只会回收堆内存，不回收物理资源(如数据库连接，网络IO等)
     1.2 程序无法精确控制垃圾回收的运行，垃圾回收会在适当的时候运行，当一个对象永久失去引用时
        系统会在合适的时间回收该对象所占有的内存
     1.3 在运行垃圾回收之前，系统总会先调用finalize()方法，该方法可能让该对象重新复活(让一个引用变量重新引用该对象)
        从而实现垃圾回收的取消机制
2.对象在内存中的状态
    2.1 可达状态：对象被创建，且被引用变量引用
    2.2 可恢复状态：对象没有被引用变量引用，垃圾回收执行前调用finalize()方法可能有被新的引用变量引用
    2.3 不可达状态：对象与所有引用变量的关联被切断，且调用finalize()也没有成为可达状态，此时系统真正回收
        该对象所占有的堆内存
 3.强制垃圾回收
    3.1 强制垃圾回收只是通知系统进行垃圾回收，但系统是否进行垃圾回收依然不确定
    3.2 强制垃圾回收有如下两种方式：
        3.2.1 调用System的静态方法gc(),System.gc()
        3.2.2 调用Runtime的实例方法gc(),Runtime.getRuntime.gc()
 4.finalize()方法
    4.1 永远不要调用finalize()方法，它是交给垃圾回收机制调用的
    4.2 finalize()方法何时被调用，是否被调用具有不确定性，不可当做必执行的方法
    4.3 当jvm执行finalize()方法时，有可能将该对象或者系统的其他对象变成可达状态
    4.4 当jvm执行finalize()方法抛出异常时，垃圾回收机制不会报告异常，程序继续执行
 */
public class Gc {
    @Test//测试内存的三种状态
    public void testMemoryStatus(){
        String str = "qilvbin";//str所引用的"qilvbin"对象处于可达状态
        str = "qlb";//"qilvbin"对象处于可恢复状态
    }

    @Test//测试强制垃圾回收
    public void testGc(){
        for (int i=0;i<4;i++){
            new Gc();
            //System.gc();
            Runtime.getRuntime().gc();//与System.gc()相同
        }

    }
    @Override//重写finalize()
    protected void finalize() throws Throwable {
        System.out.println("系统正在垃圾回收！！");
    }
}
