package basic.books.library.regular;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.Locale;
import static java.text.DateFormat.FULL;
import static java.text.DateFormat.MEDIUM;
import static java.util.TimeZone.LONG;
import static java.util.TimeZone.SHORT;

/**
 与NumberFormat 相似的是，DateFormat也是一个抽象类，它也提供了如下几个类方法用于获取
 DateFormat对象。
 getDatelInstance():返回一个日期格式器，它格式化后的字符串只有日期，没有时间。该方法可
 以传入多个参数，用于指定日期样式和Locale等参数;如果不指定这些参数，则使用默认参数。
 getTimeInstance():返回一个时间格式器，它格式化后的字符串只有时间，没有日期。该方法可
 以传入多个参数，用于指定时间样式和Locale等参数;如果不指定这些参数，则使用默认参数。
 getDateTimeInstance():返回一个日期、时间格式器，它格式化后的字符串既有日期，也有时间。
 该方法可以传入多个参数，用于指定日期样式、时间样式和Locale等参数;如果不指定这些参
 数，则使用默认参数。
 */
public class TestDateFormat {
    public static void main(String[] args) {
        //需要被格式化的时间
        Date dt =new Date();
        //创建两个Locale，分别代表中国、美国
        Locale[] locales ={Locale.CHINA,Locale.US};
        DateFormat[] df = new DateFormat[16];
        //为上面两个Locale创建16个DateFormat对象
        for (int i=0 ;i<locales.length; i++) {
            df[i * 8] = DateFormat.getDateInstance(SHORT, locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(MEDIUM, locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(LONG, locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(FULL, locales[i]);
            df[i * 8 + 4] = DateFormat.getTimeInstance(SHORT, locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(MEDIUM, locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(LONG, locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(FULL, locales[i]);
        }
        for (int i=0;i< locales.length; i++){
            String tip =i ==0 ?"----中国日期格式----":"----美国日期格式----" ;
            System.out.println(tip);
            System.out.println("SHORT格式的日期格式:"+df[i*8].format(dt));
            System.out.println("MEDIUM格式的日期格式:"+df[i*8+1].format (dt));
            System.out.println("LONG格式的日期格式:" + df[i*8+2].format (dt));
            System.out.println("FULL格式的日期格式:"+df[i*8+3].format(dt));
            System.out.println("SHORT格式的时间格式:"+df[i*8+4].format(dt));
            System.out.println("MEDIUM格式的时间格式:"+df[i*8+5].format(dt));
            System.out.println ("LONG格式的时间格式:"+df[i*8+6].format(dt));
            System.out.println("FULL格式的时间格式:"+df[i*8+7].format(dt));
        }

        /**
         *
         * 获得了DateFormat之后，还可以调用它
         * 的setLenient(boolean lenient)方法来设置该格
         * 式器是否采用严格语法。举例来说，如果采用
         * 不严格的日期语法（该方法的参数为true)，
         * 对于字符串"2004-2-31"将会转换成2004年3
         * 月2日;如果采用严格的日期语法，解析该字
         * 符串时将抛出异常。
         * DateFormat的parse()方法可以把一个字
         * 符串解析成Date对象，但它要求被解析的字
         * 符串必须符合日期字符串的要求，否则可能抛出ParseException异常*/
        String str1= "2020-12-12";
        String str2 = "2020年12月10日";
        try {
            //下面输出 Fri Dec 12 00:00:0o CST 2014
            System.out.println (DateFormat.getDateInstance().parse(str1));
            //下面输出wed Dec 10 00:00:00 CsT 2014
            System.out.println(DateFormat.getDateInstance (LONG).parse(str2));
            //下面抛出 ParseException异常
            System.out.println(DateFormat.getDateInstance ().parse(str2));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * 前面介绍的DateFormat的parse()方法可以把字符串解析成Date对象，但实际上DateFormat的parse()
         * 方法不够灵活——它要求被解析的字符串必须满足特定的格式!为了更好地格式化日期、解析日期字符
         * 串，Java提供了SimpleDateFormat类。
         * SimpleDateFormat是DateFormat的子类，正如它的名字所暗示的，它是“简单”的日期格式器。
         * 很多读者对“简单”的日期格式器不屑一顾，实际上SimpleDateFormat比 DateFormat更简单，功能更
         * 强大。
         * SimpleDateFormat可以非常灵活地格式化Date，也可以用于解析各种格式的日期字符串。创建
         * SimpleDateFormat对象时需要传入一个pattern字符串，这个pattern不是正则表达式，而是一个日期模
         * 板字符串。
         * */
        Date date = new Date();
        //创建一个SimpleDateFormat对象
        //SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年中第D天");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将d格式化成日期，输出:公元2014年中第101天
        String datestr =sdf1.format (date);
        System.out.println ("cyvvY年中第D天:"+datestr);
        //一个非常特殊的日期字符串
        String str ="14###三月##21";
        SimpleDateFormat sd2 =new SimpleDateFormat("y###MMM##d");
        //将日期字符串解析成日期，输出:Fri Mar 21 00:00:00 CST 2014
        try {
            System.out.println ("y###MMM##d:"+sd2.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /**
         * Java8新增的日期、时间API里不仅包括了Instant、LocalDate、LocalDateTime、LocalTime等代表
         * 日期、时间的类，而且在java.time.format包下提供了一个DateTimeFormatter格式器类，该类相当于前
         * 面介绍的DateFormat和 SimpleDateFormat的合体，功能非常强大。
         * 与DateFormat、SimpleDateFormat类似，DateTimeFormatter不仅可以将日期、时间对象格式化成字
         * 符串，也可以将特定格式的字符串解析成日期、时间对象。
         * 为了使用DateTimeFormatter进行格式化或解析，必须先获取DateTimeFormatter对象，获取
         * DateTimeFormatter对象有如下三种常见的方式。
         * 直接使用静态常量创建DateTimeFormatter格式器。DateTimeFormatter类中包含了大量形如
         * ISO_LOCAL_DATE、ISO_LOCAL_TIME、ISO_LOCAL_DATE_TIME等静态常量，这些静态常
         * 量本身就是DateTimeFormatter实例。
         * 使用代表不同风格的枚举值来创建DateTimeFormatter格式器。在 FormatStyle枚举类中定义了
         * FULL、LONG、MEDIUM、SHORT四个枚举值，它们代表日期、时间的不同风格。
         * 根据模式字符串来创建DateTimeFormatter格式器。类似于SimpleDateFormat，可以采用模式字
         * 符串来创建DateTimeFormatter，如果需要了解DateTimeFormatter支持哪些模式字符串，则需要
         * 参考该类的API文档。
         *
         *
         * 使用DateTimeFormatter将日期、时间（LocalDate、LocalDateTime、LocalTime等实例）格式化为
         * 字符串，可通过如下两种方式。
         * 调用DateTimeFormatter的format(TemporalAccessor temporal)方法执行格式化，其中 LocalDate、
         * LocalDateTime、LocalTime等类都是TemporalAccessor接口的实现类。
         * 调用LocalDate、LocalDateTime、LocalTime等日期、时间对象的format(DateTimeFormatter
         * formatter)方法执行格式化。
         * 上面两种方式的功能相同，用法也基本相似，如下程序示范了使用DateTimeFormatter 来格式化日
         * 期、时间。*/
        DateTimeFormatter[] formatters =new DateTimeFormatter[]{
            //直接使用常量创建DateTimeFormatter格式器
            DateTimeFormatter.ISO_LOCAL_DATE,
            DateTimeFormatter.ISO_LOCAL_TIME,
            DateTimeFormatter.ISO_LOCAL_DATE_TIME,
            //使用本地化的不同风格来创建DateTimeFormatter格式器
            DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL,FormatStyle.MEDIUM),
            DateTimeFormatter.ofLocalizedTime(FormatStyle.LONG),
            //根据模式字符串来创建DateTimeFormatter格式器
            DateTimeFormatter.ofPattern("Gyyyy%%MMM%%dd HH:mm:ss")
        };
        LocalDateTime ldt = LocalDateTime.now();
        //依次使用不同的格式器对LocalDateTime进行格式化
        for(int i=0; i <formatters.length ; i++){
            //下面两行代码的作用相同
            System.out.println(ldt.format(formatters[i]));
            System.out.println(formatters[i].format(ldt));
        }
        /**
         * 为了使用DateTimeFormatter将指定格式的字符串解析成日期、时间对象（LocalDate ,
         * LocalDateTime、LocaTime等实例)，可通过日期、时间对象提供的parse(CharSequence text,
         * DateTimeFormatter formatter)方法进行解析。*/
        //定义一个任意格式的日期、时间字符串
        String str11 = "2014--04--12 01时06分09秒";
        //根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter fomatter1 = DateTimeFormatter.ofPattern("yyyy--MM--dd HH时mm分ss秒");
        //执行解析
        LocalDateTime dt1 = LocalDateTime.parse(str11,fomatter1);
        System.out.println("格式化后的时间1："+dt1);//输出 2014-04-12T01;06:09
        //---下面代码再次解析另一个字符串-—-
        String str22 = "2014$$$四月$$$13 20小时";
        DateTimeFormatter fomatter2 =DateTimeFormatter.ofPattern("yyyy$$$MMM$$$dd HH小时");
        LocalDateTime dt2= LocalDateTime.parse(str22,fomatter2);
        System.out.println("格式化后的时间2："+dt2);//输出 2014-04-13T20:00

    }
}
