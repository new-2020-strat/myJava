package basic.library.random;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 ThreadLocalRandom类的用法与Random类的用法基本相似，它提供了一个静态的current()方法来
 获取ThreadLocalRandom对象，获取该对象之后即可调用各种nextXxx()方法来获取伪随机数了。
 ThreadLocalRandom与Random都比Math的random()方法提供了更多的方式来生成各种伪随机数，
 可以生成浮点类型的伪随机数，也可以生成整数类型的伪随机数，还可以指定生成随机数的范围。
 */
public class TestRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        //生成boolean的随机数值
        System.out.println("rand.nextBoolean():" +rand.nextBoolean());
        //生成byte[]数组元素随机值
        byte[] buffer = new byte[16];
        rand.nextBytes(buffer);
        System.out.println (Arrays.toString(buffer));
        //生成0.0～1.0之间的伪随机 double数
        System.out.println("rand.nextDouble():" +rand.nextDouble());
        //生成O.0~1.0之间的伪随机f1oat数
        System.out.println("rand. nextFloatO:" +rand.nextFloat());
        //生成平均值是0.0，标准差是1.0的伪高斯数
        System. out.println("rand.nextGaussian(): " +rand.nextGaussian());
        //生成一个处于int整数取值范围的伪随机整数
        System.out.println("rand.nextInt():"+ rand.nextInt());
        //生成0~26之间的伪随机整数
        System.out.println("rand.nextInt(26):" +rand.nextInt (26));
        //生成一个处于long整数取值范围的伪随机整数
        System.out.println("rand.nextLong():" +rand.nextLong());

        /**
         当两个Random对象种子相同时，它们会产生相同的数
         字序列。值得指出的，当使用默认的种子构造Random对象时，它们属于同一个种子。
         */
        Random r1 = new Random (50);
        System.out.println("第一个种子为50的Random对象");
        System.out.println("r1.nextBoolean():\t"+ r1.nextBoolean());
        System.out.println("r1.nextInt():\t\t" +r1.nextInt());
        System.out.println("r1.nextDouble():\t"+r1.nextDouble());
        System.out.println("r1.nextGaussian():\t"+ r1.nextGaussian());
        System.out.println("---------------------------");
        Random r2 = new Random(50);
        System.out.println("第二个种子为50的Random对象");
        System.out.println("r2.nextBoolean():\t" + r2.nextBoolean ());
        System.out.println("r2.nextInt():\t\t" + r2.nextInt());
        System.out.println("r2.nextDouble():\t"+r2.nextDouble());
        System.out.println("r2.nextGaussian():\t" + r2.nextGaussian());
        System.out.println("---------------------------");
        Random r3 = new Random(100);
        System.out.println("种子为100的 Random对象");
        System.out.println("r3.nextBoolean():\t"+r3.nextBoolean());
        System.out.println("r3.nextInt():\t\t" +r3.nextInt());
        System.out.println("r3.nextDouble():\t" +r3.nextDouble());
        System.out.println("r3.nextGaussian():\t"+r3.nextGaussian());

        /**为了避免两个Random对象产生相同的数字序列,通常推荐使用当前时间作为Random对象的种子，*/
        Random rand1 = new Random (System.currentTimeMillis());
        /**在多线程环境下使用ThreadLocalRandom的方式与使用Random基本类似，如下程序片段示范了
         ThreadLocalRandom的用法。*/
        ThreadLocalRandom rand2 = ThreadLocalRandom.current();
        //生成一个4~20之间的伪随机整数
        int val1 = rand2.nextInt(4,20);
        //生成一个2.0~10.0之间的伪随机浮点数
        double val2 = rand2.nextDouble(2.0,10.0);



    }
}
