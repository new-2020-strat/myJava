package basic.library.date;

import java.util.Date;

/**
 Java原本提供了Date和Calendar用于处理日期、时间的类，包括创建日期、时间对象，获取系统
 当前日期、时间等操作。但Date不仅无法实现国际化，而且它对不同属性也使用了前后矛盾的偏移量，
 比如月份与小时都是从О开始的，月份中的天数则是从1开始的，年又是从 1900开始的，而
 java.util.Calendar则显得过于复杂，从下面介绍中会看到传统Java对日期、时间处理的不足。Java8吸
 取了Joda-Time库（一个被广泛使用的日期、时间库）的经验，提供了一套全新的日期时间库。
 Date():生成一个代表当前日期时间的Date对象。该构造器在底层调用System.currentTimeMillis()
    获得long整数作为日期参数。
 Date(long date):根据指定的long型整数来生成一个Date对象。该构造器的参数表示创建的Date
    对象和GMT 1970年1月1日00:00:00之间的时间差，以毫秒作为计时单位。
 与Date构造器相同的是，Date对象的大部分方法也Deprecated了，剩下为数不多的几个方法。
 boolean after(Date when):测试该日期是否在指定日期when之后。
 boolean before(Date when):测试该日期是否在指定日期when之前。
 long getTime():返回该时间对应的long型整数，即从GMT 1970-01-01 00:00:00到该Date对象
    之间的时间差，以毫秒作为计时单位。
 void setTime(long time):设置该Date对象的时间。
 */
public class TestDate {
    public static void main(String[] args) {
        Date d1 = new Date();
        //获取当前时间之后100ms的时间
        Date d2 = new Date(System.currentTimeMillis() +100);
        System.out.println (d2);
        System.out.println(d1.compareTo (d2));
        System.out.println(d1.before(d2));
        /**
         总体来说，Date是一个设计相当糟糕的类，因此Java官方推荐尽量少用Date的构造器和方法。如
         果需要对日期、时间进行加减运算，或获取指定时间的年、月、日、时、分、秒信息，可使用Calendar
         工具类。
         */
    }


















}
