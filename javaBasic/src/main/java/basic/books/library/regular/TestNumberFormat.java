package basic.books.library.regular;

import java.text.NumberFormat;
import java.util.Locale;

/**
 NumberFormat和DateFormat都包含了format(和
 parse()方法，其中format)用于将数值、日期格式化成字符
 串，parse()用于将字符串解析成数值、日期。
 NumberFormat也是一个抽象基类，所以无法通过它的
 构造器来创建NumberFormat对象，它提供了如下几个类方法来得到NumberFormat对象。
 getCurrencyInstance():返回默认Locale的货币格式器。也可以在调用该方法时传入指定的
 Locale，则获取指定Locale的货币格式器。
 getIntegerInstance():返回默认Locale的整数格式器。也可以在调用该方法时传入指定的Locale，
 则获取指定Locale的整数格式器。
 getNumberInstance():返回默认Locale的通用数值格式器。也可以在调用该方法时传入指定的
 Locale，则获取指定Locale的通用数值格式器。
 getPercentInstance():返回默认Locale的百分数格式器。也可以在调用该方法时传入指定的
 Locale，则获取指定Locale的百分数格式器。
 一旦取得了NumberFormat对象后，就可以调用它的format()方法来格式化数值，包括整数和浮点
 数。如下例子程序示范了NumberFormat的三种数字格式化器的用法。
 */
public class TestNumberFormat {

    public static void main(String[] args) {
        //需要被格式化的数字
        double db = 1234000.567;
        //创建四个Locale，分别代表中国、日本、德国、美国
        Locale[] locales = {Locale.CHINA, Locale.JAPAN, Locale.GERMAN, Locale.US};
        NumberFormat[] nf = new NumberFormat[12];
        //为上面四个 Locale创建12个 NumberFormat对象
        //每个Locale分别有通用数值格式器、百分数格式器、货币格式器
        for (int i = 0; i < locales.length; i++) {
            nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
            nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
            nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
        }
        for (int i=0; i < locales.length;i++){
        String tip=i==0 ? "--—-中国的格式----" :
                i== 1 ? "----日本的格式--—-" :
                i == 2 ? "--—-德国的格式----" : "—---美国的格式--—-";
        System.out.println(tip);
        System.out.println("通用数值格式:" + nf[i * 3].format(db));
        System.out.println("百分比数值格式:" + nf[i * 3 + 1].format(db));
        System.out.println("货币数值格式:" + nf[i * 3 + 2].format(db));
        }
    }
}

