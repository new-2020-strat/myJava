package basic.books.library.date;
import java.util.Calendar;
import java.util.Date;
/**
 * Calendar类是一个抽象类，所以不能使用构造器来创建Calendar对象。但它提供了几个静态
 * getInstance()方法来获取Calendar对象，这些方法根据TimeZone，Locale类来获取特定的Calendar，如
 * 果不指定TimeZone、Locale，则使用默认的TimeZone、Locale来创建Calendar。
 * Calendar和Date都是表示日期的工具类，他们之间可以自由转换
 * */
public class TestCalendar {
    public static void main(String[] args) {
        //创建一个默认的Calendar对象
        Calendar calendar = Calendar.getInstance();
        //从Calendar对象中取出 Date对象
        Date date = calendar.getTime();
        //通过 Date对象获得对应的Calendar对象
        //因为Calendar/Gregoriancalendar没有构造函数可以接收Date对象
        //所以必须先获得一个Calendar实例，然后调用其setTime()方法
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);

        //Calendar类提供了大量访问、修改日期时间的方法，常用方法如下。
        /**void add(int field,int amount):根据日历的规则，为给定的日历字段添加或减去指定的时间量。*/
        calendar.add(Calendar.YEAR,1);
        System.out.println("年加1=="+calendar.get(Calendar.YEAR));
        /**int get(int field):返回指定日历字段的值。月份是从0开始的*/
        System.out.println("获取当前月=="+calendar.get(Calendar.MONTH));
        /**int getActualMaximum(int field):返回指定日历字段可能拥有的最大值。例如月，最大值为11。*/
        System.out.println("当前日历字段可能的最大值=="+calendar.getActualMaximum(Calendar.MONTH));
        /**int getActualMinimum(int field):返回指定日历字段可能拥有的最小值。例如月，最小值为0。*/
        System.out.println("当前日历字段可能的最小值=="+calendar.getActualMinimum(Calendar.MONTH));
        /**void roll(int field,int amount):与add()方法类似，区别在于加上amount后超过了该字段所能表示的最大范围时，也不会向上一个字段进位。*/
        calendar.roll(Calendar.MONTH,-1);
        System.out.println("月份减1=="+calendar.get(Calendar.MONTH));
        /**void set(int field, int value):将给定的日历字段设置为给定值。*/
        calendar.set(Calendar.MONTH,9);
        System.out.println("给月份设定固定值9=="+calendar.get(Calendar.MONTH));
        //关闭容错性
        /**
         字段值超出了MONTH字段允许的范围。关键在于程序中粗体字代码行，Calendar提供了一个setLenient()
         用于设置它的容错性，Calendar默认支持较好的容错性，通过setLenient(false)可以关闭Calendar的容错
         性，让它进行严格的参数检查。
         */
        calendar.setLenient(false);
        calendar.set(Calendar.MONTH,13);
        System.out.println("给月份设定固定值13=="+calendar.get(Calendar.MONTH));
        /**void set(int year,int month, int date):设置Calendar对象的年、月、日三个字段的值。*/
        calendar.set(2021,10,1);
        System.out.println("设定指定日期=="+calendar.getTime());
        /**void set(int year,int month,int date, int hourOfDay,int minute, int second);:设置Calendar对象的年、
        月、日、时、分、秒6个字段的值。*/
        calendar.set(2022,11,25,12,43,59);
        System.out.println("设定指定日期=="+calendar.getTime());

        /**set()方法延迟修改的概念
         set(f,value)方法将日历字段f更改为 value，此外它还设置了一个内部成员变量，以指示日历字段f
         已经被更改。尽管日历字段f是立即更改的，但该Calendar所代表的时间却不会立即修改，直到下次
         调用get()、getTime()、getTimeInMillis()、add()或roll()时才会重新计算日历的时间。这被称为set()
         方法的延迟修改，采用延迟修改的优势是多次调用set()不会触发多次不必要的计算(需要计算出一个代
         表实际时间的long型整数)。
         */
    }
}
