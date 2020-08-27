package basic.books.library.bigDecimal;

import java.math.BigDecimal;

/**
 为了能精确表示、计算浮点数，Java提供了BigDecimal类，该类提供了大量的构造器用于创建
 BigDecimal对象，包括把所有的基本数值型变量转换成一个BigDecimal对象，也包括利用数字字符串、
 数字字符数组来创建BigDecimal对象。
 查看BigDecimal类的BigDecimal(double val)构造器的详细说明时，可以看到不推荐使用该构造器
 的说明，主要是因为使用该构造器时有一定的不可预知性。当程序使用new BigDecimal(0.1)来创建一个
 BigDecimal对象时，它的值并不是0.1，它实际上等于一个近似0.1的数。这是因为0.1无法准确地表
 示为double浮点数，所以传入BigDecimal构造器的值不会正好等于0.1（虽然表面上等于该值)。
 如果使用BigDecimal(String val)构造器的结果是可预知的-写入new BigDecimal("0.1")将创建一
 个 BigDecimal，它正好等于预期的0.1。因此通常建议优先使用基于String的构造器。
 如果必须使用double浮点数作为BigDecimal构造器的参数时，不要直接将该double浮点数作为构
 造器参数创建BigDecimal对象，而是应该通过BigDecimal.valueOf(double value)静态方法来创建
 BigDecimal对象。
 BigDecimal类提供了add()、subtract()、multiply()、divide()、pow()等方法对精确浮点数进行常规算
 术运算。下面程序示范了BigDecimal的基本运算。
 */
public class TeatBigDecimal {
    public static void main(String[] args) {
        BigDecimal f1 = new BigDecimal("0.05");
        BigDecimal f2 =BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);
        System.out.println("使用String作为BigDecimal构造器参数:");
        System.out.println("0.05 +0.01 ="+f1.add(f2));
        System.out.println("0.05 - 0.01 =" +f1.subtract (f2));
        System.out.println("0.05 *0.01 -" + f1.multiply(f2));
        System.out.println("0.05/0.01 ="+f1.divide(f2));
        System.out.println("使用double作为BigDecimal构造器参数:");
        System.out.println("0.05 +0.01-" + f3.add(f2));
        System.out.println("0.05- 0.01 ="+ f3.subtract(f2));
        System.out.println("0.05 * 0.01 -" +f3.multiply(f2));
        System.out.println("0.05/ 0.01 -" +f3.divide(f2));

    }
}
