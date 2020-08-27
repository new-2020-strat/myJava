package basic.books.library.date;

import java.time.*;

/**
    Java 8新增的日期、时间包,Java 8专门新增了一个java.time包，该包下包含了如下常用的类。
 1.Clock:该类用于获取指定时区的当前日期、时间。该类可取代System类的currentTimeMillis()
    方法，而且提供了更多方法来获取当前日期、时间。该类提供了大量静态方法来获取Clock对象。
 2.Duration:该类代表持续时间。该类可以非常方便地获取一段时间。
 3.Instant:代表一个具体的时刻，可以精确到纳秒。该类提供了静态的now(方法来获取当前时刻，
    也提供了静态的now(Clock clock)方法来获取clock对应的时刻。除此之外，它还提供了一系列
 4.minusXxx()方法在当前时刻基础上减去一段时间，也提供了plusXxx()方法在当前时刻基础上加
    上一段时间。
 5.LocalDate:该类代表不带时区的日期，例如2007-12-03。该类提供了静态的now()方法来获取
 当前日期，也提供了静态的now(Clock clock)方法来获取clock对应的日期。除此之外，它还提
 供了minusXxx()方法在当前年份基础上减去几年、几月、几周或几日等，也提供了plusXxx()
 方法在当前年份基础上加上几年、几月、几周或几日等。
 LocalTime:该类代表不带时区的时间，例如10:15:30。该类提供了静态的now()方法来获取当
 前时间，也提供了静态的now(Clock clock)方法来获取clock对应的时间。除此之外，它还提供
 了minusXxx()方法在当前年份基础上减去几小时、几分、几秒等，也提供了plusXxx()方法在当
 前年份基础上加上几小时、几分、几秒等。
 LocalDateTime:该类代表不带时区的日期、时间，例如2007-12-03T10:15:30。该类提供了静态
 的now()方法来获取当前日期、.时间，也提供了静态的now(Clock clock)方法来获取clock对应
 的日期、时间。除此之外，它还提供了minusXxx()方法在当前年份基础上减去几年、几月、几
 日、几小时、几分、几秒等，也提供了plusXxx()方法在当前年份基础上加上几年、几月、几日、
 几小时、几分、几秒等。
 MonthDay:该类仅代表月日，例如--04-12。该类提供了静态的now()方法来获取当前月日，也
 提供了静态的now(Clock clock)方法来获取clock对应的月日。
 Year:该类仅代表年，例如2014。该类提供了静态的now()方法来获取当前年份，也提供了静
 态的now(Clock clock)方法来获取clock对应的年份。除此之外，它还提供了minusYears()方法
 在当前年份基础上减去几年，也提供了plusYears()方法在当前年份基础上加上几年。
 YearMonth:该类仅代表年月，例如2014-04。该类提供了静态的now()方法来获取当前年月，
 也提供了静态的now(Clock clock)方法来获取clock对应的年月。除此之外，它还提供了
 minusXxx()方法在当前年月基础上减去几年、几月，也提供了plusXxx()方法在当前年月基础上
 加上几年、几月。
 ZonedDateTime:该类代表一个时区化的日期、时间。
 Zoneld:该类代表一个时区。
 DayOfWeek:这是一个枚举类，定义了周日到周六的枚举值。
 Month:这也是一个枚举类，定义了一月到十二月的枚举值。
 */
public class TestTimePackage {
    public static void main(String[] args) {
        //-下面是关于Clock的用法----
        //获取当前Clock
        Clock clock = Clock.systemUTC();
        //通过Clock获取当前时刻
        System.out.println("当前时刻为=="+clock.instant());
        //获取clock对应的毫秒数，与System.currentTimeMillis()输出相同
        System.out.println("当前时间毫秒数=="+clock.millis());
        System.out.println(System.currentTimeMillis());
        //-----下面是关于 Duration 的用法-----
        Duration d= Duration.ofSeconds(6000);
        System.out.println("6000秒相当于"+d.toMinutes()+"分");
        System.out.println("6000秒相当于" +d.toHours() +"小时");
        System.out.println("6000秒相当于"+d.toDays()+"天");
        //在clock基础上增加6000秒，返回新的Clock
        Clock clock2 = Clock.offset(clock,d);
        //可以看到clock2与clock1相差1小时40分
        System.out.println("当前时刻加6000秒为:"+clock2.instant());
        //-----下面是关于 Instant的用法-----
        //获取当前时间
        Instant instant = Instant.now();
        System.out.println("instant当前时间=="+instant);
        // instant添加6000秒（即100分钟），返回新的Instant
        Instant instant2 = instant.plusSeconds(6000);
        System.out.println("instant添加100秒=="+instant2);
        //根据字符串解析Instant对象
        Instant instant3= Instant.parse ("2020-08-19T10:12:46.342z");
        System.out.println("根据字符串解析Instant对象=="+instant3);
        //在instant3的基础上添加5小时4分钟
        Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println("instant3的基础上添加5小时4分钟:"+instant4);
        //获取instant4的5天以前的时刻
        Instant instant5=instant4.minus (Duration.ofDays(5));
        System.out.println("instant4的5天以前的时刻:"+instant5);
        //-----下面是关于LocalDate的用法-
        LocalDate localDate= LocalDate.now();
        System.out.println("当前日期："+localDate);
        //获得2020年的第146天
        localDate= LocalDate.ofYearDay(2020,146);
        System.out.println("2020年的第146天="+localDate);//2020-05-26
        //设置为2020年5月21日
        localDate = LocalDate.of (2020, Month.MAY,21);
        System.out.println("设置为2020年5月21日:"+localDate); // 2020-05-21
        //-----下面是关于LocalTime 的用法-----
        //获取当前时间
        LocalTime localTime= LocalTime.now();
        System.out.println("当前时间："+localTime);
        //设置为22点33分
        localTime= LocalTime.of(22, 33);
        System.out.println("设置为22点33分:"+localTime);//22:33
        //返回一天中的第5503秒
        localTime= LocalTime.ofSecondOfDay(5503);
        System.out.println("返回一天中的第5503秒:"+localTime); //01:31:43
        // -----下面是关于localDateTime 的用法-—--一
        //获取当前日期、时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("获取当前日期、时间:"+localDateTime);
        //当前日期、时间加上25小时3分钟
        LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println("当前日期、时间的25小时3分之后:"+future);
        // ----—下面是关于Year.YearMonth、MonthDay的用法示例-----
        Year year= Year.now();//获取当前的年份
        System.out.println("当前年份:"+year);//输出当前年份
        year = year.plusYears (5); //当前年份再加5年
        System.out.println("当前年份再过5年:"+year);
        //根据指定月份获取YearMonth
        YearMonth ym=year.atMonth(10);
        //当前年月再加5年、减3个月
        ym =ym.plusYears(5).minusMonths(3);
        System.out.println("year年10月再加5年、减3个月:"+ym);
        MonthDay md=MonthDay.now();
        System.out.println("当前月日:" +md);//输出--XX-XX，代表几月几日
        //设置为5月23日
        MonthDay md2 = md.with(Month.MAY).withDayOfMonth(23);
        System.out.println("5月23日为:"+md2);//输出--05-23
    }
}
