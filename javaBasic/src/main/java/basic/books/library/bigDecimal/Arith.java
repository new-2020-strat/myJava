package basic.books.library.bigDecimal;

import java.math.BigDecimal;

/**
 如果程序中要求对double浮点数进行加、减、乘、除基本运算，则需要先将double类型数值包装
 成BigDecimal对象，调用BigDecimal对象的方法执行运算后再将结果转换成double型变量。这是比较
 烦琐的过程，可以考虑以BigDecimal为基础定义一个Arith工具类，该工具类代码如下。
 */
public class Arith {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;
    //构造器私有，让这个类不能实例化
    private Arith(){}
    //提供精确的加法运算
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1=BigDecimal.valueOf (v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.add (BigDecimal.valueOf(b2.doubleValue()));
    }
    //提供精确的减法运算
    public static double sub(double v1,double v2){
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.subtract(b2).doubleValue();
    }
    //提供精确的乘法运算
    public static double mul (double v1,double v2){
        BigDecimal b1= BigDecimal.valueOf(v1);
        BigDecimal b2=BigDecimal.valueOf(v2);
        return b1.multiply (b2).doubleValue();
    }
    //提供（相对）精确的除法运算，当发生除个尽的情况时
    //精确到小数点以后10位的数字四舍五入
    public static double div(double v1,double v2) {
        BigDecimal b1 = BigDecimal.valueOf(v1);
        BigDecimal b2 = BigDecimal.valueOf(v2);
        return b1.divide(b2, DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("O.05 +0.01=" +Arith.add (0.05 ,0.01));
        System.out.println("1.0-0.42=" + Arith.sub (1.0, 0.42));
        System.out.println("4.015*100=" + Arith.mul(4.015 , 100));
        System.out.println("123.3/100=" +Arith.div(123.3 ,100));
    }
}