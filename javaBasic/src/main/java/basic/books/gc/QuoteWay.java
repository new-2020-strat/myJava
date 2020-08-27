package basic.books.gc;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 1.引用类型的四种方式
         1.1 强引用(StrongReference)；最常用的引用方式
         1.2 软引用(SoftWareReference)：
          软引用通过SoftWareReference类来实现，当一个对象只有软引用时，他有可能被垃圾回收机制回收对于只有软引用而言，
           当系统内存足够时不会被系统回收，程序也可以使用该对象，当系统内存不够时，系统可能回收，软引用通常用于对内存敏感的程序中
         1.3 弱引用(WeakReference)：
            通过WeakReference类实现，弱引用和软引用很像，但弱引用级别耕更低。对于只有弱引用的对象而言，当系统垃圾回收机制运行时，不管系统内存是否足够，总是会回收该对象的所占有的内存。
            并不是当一个对象只有弱引用时，它就立即被回收，正如那些失去引用的对象一样，必须等到系统垃圾回收机制运行时才会被回收
         1.4 虚引用(PhantomReference)：
            虚引用通过PhantomReference类实现，虚引用完全类似于没有引用，对对象本身没有多大的影响，对象甚至感觉不到虚引用的存在，如果一个对象只有虚引用时，那么和没有引用大致相同，
            虚引用主要用于跟踪对象被垃圾回收的状态，虚引用不能单独使用必须和引用队列(ReferenceQueue)联合使用
 2.软引用、弱引用、虚引用都包含一个get()方法，获取他们所引用的对象
 3.引用队列由java.lang.ref.ReferenceQueue类表示，用于保存被回收后对象的引用
 4.使用这些特殊的引用可以避免在程序执行期间将对象保留在内存中，使垃圾回收器随意释放对象，如果尽可能减小程序在其整个生命周期所占用的内存大小
    时，这些特殊的引用就很有用
 */
public class QuoteWay {
    @Test//测试弱引用
    public void testWeakReference(){
        //创建一个字符串对象
        String str = new String("qilvbin");
        //创建一个弱引用，让次弱引用引用到"qilvbin"字符串
        WeakReference wr = new WeakReference(str);
        //切断str与"qilvbin"字符串之间的引用
        str = null;
        //取出弱引用所引用的对象
        System.out.println(wr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        //再次取出弱引用所引用的对象
        System.out.println(wr.get());
    }

    @Test//测试虚引用，虚引用必须和引用队列联合使用
    public void testPhantomReference(){
        //创建一个字符串对象
        String str = new String("qilvbin");
        //创建一个引用队列
        ReferenceQueue rq = new ReferenceQueue();
        //创建一个虚引用，让该虚引用引用到"qilvbin"字符串
        PhantomReference pr = new PhantomReference(str,rq);
        //切断str和"qilvbin"字符换之间的引用
        str = null;
        //取出虚引用所引用的对象，并不能通过虚引用获取被引用的对象，所以输出null
        System.out.println(pr.get());
        //强制垃圾回收
        System.gc();
        System.runFinalization();
        //垃圾回收之后，虚引用将被放入引用队列中
        //取出引用队列中最先进入队列的引用与pr作比较
        System.out.println(rq.poll()==pr);
    }
}
