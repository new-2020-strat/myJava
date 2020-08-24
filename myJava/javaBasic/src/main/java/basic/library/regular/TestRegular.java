package basic.library.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 正则表达式是一个强大的字符串处理工具，可以对字符串进行查找、提取、分割、替换等操作。String
 类里也提供了如下几个特殊的方法。
 1.boolean matches(String regex):判断该字符串是否匹配指定的正则表达式。
 2.String replaceAll(String regex，String replacement):将该字符串中所有匹配regex的子串替换成replacement。
 3.String replaceFirst(String regex,String replacement):将该字符串中第一个匹配regex的子串替换成replacement。
 4.String[] split(String regex):以regex作为分隔符，把该字符串分割成多个子串。
 上面这些特殊的方法都依赖于Java提供的正则表达式支持，除此之外，Java还提供了Pattern和
 Matcher两个类专门用于提供正则表达式支持。
 */
public class TestRegular {
    /**
     一旦在程序中定义了正则表达式，就可以使用Pattern和Matcher来使用正则表达式。
     Pattern对象是正则表达式编译后在内存中的表示形式，因此，正则表达式字符串必须先被编译为
     Pattern对象，然后再利用该Pattern对象创建对应的Matcher对象。执行匹配所涉及的状态保留在Matcher
     对象中，多个Matcher对象可共享同一个Pattern对象。
     * */
    public static void main(String[] args) {
        //将一个字符串编译成Pattern对象
        Pattern pattern = Pattern.compile("a*b");
        //使用Pattern对象创建Matcher对象
        Matcher matcher = pattern.matcher("aaaaaaaaab");
        boolean matches = matcher.matches();
        System.out.println("matches==" + matches);

        //正则表达式一次性使用
        boolean boo = Pattern.matches("a*b", "aaab");
        System.out.println("boo==" + boo);

        /** Matcher类提供了如下几个常用方法。
         find(:返回目标字符串中是否包含与Pattern匹配的子串。
         group():返回上一次与Pattern匹配的子串。
         start():返回上一次与Pattern 匹配的子串在目标字符串中的开始位置。
         end():返回上一次与Pattern 匹配的子串在目标字符串中的结束位置加1。
         lookingAt():返回目标字符串前面部分与 Pattern是否匹配。
         matches():返回整个目标字符串与Pattern是否匹配。
         reset()，将现有的Matcher对象应用于一个新的字符序列。
         */
        //利用正则表达式抓取电话号码13X和15X
        String str = "aaaaaasa13514143352.sasdsadbcsnb15803698562idisduisd13512569875";
        Matcher ma = Pattern.compile("((13\\d)|(15\\d))\\d{8}").matcher(str);
        while (ma.find()) {
            System.out.println(ma.group());
        }
        /**find()方法还可以传入一个int类型的参数，带int参数的find()方法将从该int索引处向下搜索。
         start()和end()方法主要用于确定子串在目标字符串中的位置，如下程序所示。*/
        String regStr = "qilvbin is a good man";
        System.out.println("目标字符串是：" + regStr);
        Matcher m = Pattern.compile("\\w+").matcher(regStr);
        while (m.find()) {
            System.out.println(m.group() + "的起始位置：" + m.start() + ",其结束为止：" + m.end());
        }
        /**matches()和lookingAt()方法有点相似，只是matches()方法要求整个字符串和Pattern完全匹配时才
         返回true，而lookingAt()只要字符串以Pattern开头就会返回true。reset()方法可将现有的Matcher对象
         应用于新的字符序列*/
        String[] mails = {
                "kongyeeku@163.com",
                "kongyeeku@gmail.com",
                "ligangecrazyit.org",
                "wawacabc.xx"
        };
        String mailRegEx = "\\w{3,20}@\\w+\\.(com|org|cnInet|gov)";
        Pattern mailPattern = Pattern.compile(mailRegEx);
        Matcher mat = null;
        for (String mail : mails) {
            if (mat == null) {
                matcher = mailPattern.matcher(mail);
            } else {
                matcher.reset(mail);
            }
            String result = mail + (matcher.matches() ? "是" : "不是") + "一个有效的邮件地址!";
            System.out.println(result);
        }
        /**
         利用正则表达式对目标字符串进行分割、查找、替换等操作
         */
        String[] msgs = {
                "Java has regular expressions in 1.4",
                "regular expressions now expressing in Java",
                "Java repressesoracular expressions"
        };
        Pattern p = Pattern.compile("re\\w*");
        Matcher matcher1 = null;
        for (int i = 0; i < msgs.length; i++) {
            if (matcher1 == null) {
                matcher1 = p.matcher(msgs[i]);
            } else {
                matcher1.reset(msgs[i]);
            }
            System.out.println(matcher1.replaceAll("哈哈"));
        }
    }
}
