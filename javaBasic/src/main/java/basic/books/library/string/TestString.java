package basic.books.library.string;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

/**
 * String类是一个不可变类，
 */
public class TestString {
    /**
     * 主要的几个构造器：
     */
    public static void main(String[] args) {
        String str = "祁侣彬";//测试数据

        /**创建一个包含0个字符序列的String对象(并不是返回null)*/
        String str1 = new String();
        System.out.println(str1.equals(""));
        /**1使用指定字符集将Byte[]数据解码成一个新的String对象*/
        Charset charset = Charset.forName("utf-8");
        String str2 = new String(str.getBytes(), charset);
        System.out.println("str2==" + str2);
        /**2使用平台默认的字符集将指定的byte[]数组从offset索引开始，长度为length的子数组解码成一个新的String对象*/
        String str3 = new String(str.getBytes(), 0, 3);
        System.out.println("str3==" + str3);

        /**3使用指定字符集将指定的byte[]数组从offset索引开始，长度为length的子数组解码成一个新的String对象*/
        try {
            String str4 = new String(str.getBytes(), 0, 3, "utf-8");
            System.out.println("str4==" + str4);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**1使用指定字符集将Byte[]数据解码成一个新的String对象*/
        try {
            String str5 = new String(str.getBytes(), "utf-8");
            System.out.println("str5==" + str5);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**将指定的字符数组从offset开始，长度为count的字符元素连缀成一个新的字符串*/
        char[] chars = {'祁', '侣', '彬'};
        String str6 = new String(chars, 1, 2);
        System.out.println("str6==" + str6);
        /**String(String original):根据字符串直接量来创建一个String对象。也就是说，新创建的String对象是该参数字符串的副本*/
        System.out.println("str7==" + new String(str));
        /**String(StringBuffer buffer):根据StringBuffer对象来创建对应的String对象*/
        StringBuffer stringBuffer = new StringBuffer(str);
        String str8 = new String(stringBuffer);
        System.out.println("str8==" + str8);
        /**String(StringBuilder builder):根据StringBuilder对象来创建对应的String对象*/
        StringBuilder stringBuilder = new StringBuilder(str);
        String str9 = new String(stringBuilder);
        System.out.println("str9==" + str9);
        /**char charAt(int index):获取字符串中指定位置的字符。其中，参数index指的是字符串的序数，字符串的序数从О开始到length(-1。如下代码所示。*/
        System.out.println("str10==" + str.charAt(1));
        /**int compareTo(String anotherString):比较两个字符串的大小。如果两个字符串的字符序列相等，
         则返回0﹔不相等时，从两个字符串第0个字符开始比较，返回第一个不相等的字符差。另一
         种情况，较长字符串的前面部分恰巧是较短的字符串，则返回它们的长度差。*/
        System.out.println("str11==" + str.compareTo("祁侣彬彬"));
        /**String concat(String str):将该String对象与str连接在一起。与Java提供的字符串连接运算符“+”的功能相同。*/
        System.out.println("str12==" + str.concat("qilvbin"));
        /**boolean contentEquals(StringBuffer sb):将该String对象与StringBuffer对象sb进行比较，当它
         们包含的字符序列相同时返回true。*/
        StringBuffer sb = new StringBuffer("祁侣彬");
        System.out.println("str13==" + str.contentEquals(sb));
        /**static String copyValueOf(char[] data):将字符数组连缀成字符串，与String(char[]content)构造器
         的功能相同。*/
        char[] data = {'祁', '侣', '彬'};
        System.out.println("str14==" + String.copyValueOf(data));
        /**static String copyValueOf(char[] data, int offset,int count):将char数组的子数组中的元素连缀成字
         符串，与String(char[] value,int offset, int count)构造器的功能相同。*/
        System.out.println("str15==" + String.copyValueOf(data, 1, 2));
        /**boolean endsWith(String suffix):返回该String对象是否以suffix结尾。*/
        System.out.println("str16==" + str.endsWith("彬"));
        /**boolean equals(Object anObject):将该字符串与指定对象比较，如果二者包含的字符序列相等,
         则返回true;否则返回false*/
        System.out.println("str17==" + str.equals("祁侣彬"));
        /**boolean equals(Object anObject):将该字符串与指定对象比较，如果二者包含的字符序列相等，
         则返回true;否则返回false。*/
        System.out.println("str18==" + str.equalsIgnoreCase("祁侣彬"));
        /**byte[] getBytes():将该String对象转换成byte数组*/
        byte[] bytes = str.getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
        /**void getChars(int srcBegin,int srcEnd,char[]dst, int dstBegin):该方法将字符串中从srcBegin开始，
         到srcEnd结束的字符复制到dst字符数组中，其中 dstBegin为目标字符数组的起始复制位置*/
        char[] dst = {'l', ' ', 'l', 'o', 'v', 'e', ' ', 'q', 'l', 'b'};
        str.getChars(0, 3, dst, 7);
        System.out.println("str19==" + new String(dst));
        /**int indexOf(int ch):找出ch字符在该字符串中第一次出现的位置。*/
        System.out.println("str20==" + str.indexOf("彬"));
        /**int indexOf(int ch, int fromIndex):找出ch字符在该字符串中从fromIndex开始后第一次出现的位置。*/
        System.out.println("str21==" + str.indexOf("彬", 1));
        /**int indexOf(String str):找出str子字符串在该字符串中第一次出现的位置。*/
        System.out.println("str22==" + str.indexOf("侣彬"));
        /**int indexOf(String str, int fromIndex):找出 str子字符串在该字符串中从fromIndex开始后第一次
         出现的位置。*/
        System.out.println("str23==" + str.indexOf("侣彬", 0));
        /**int lastIndexOf(char ch):找出ch字符在该字符串中最后一次出现的位置。*/
        System.out.println("str24==" + str.lastIndexOf("彬"));
        /**int lastIndexOf(char ch, int fromIndex):找出ch字符在该字符串中从fromIndex开始后最后一次出
         现的位置。*/
        System.out.println("str25==" + str.lastIndexOf('彬', 2));
        /**int lastIndexOf(String str):找出str子字符串在该字符串中最后一次出现的位置。*/
        System.out.println("str26==" + str.lastIndexOf("侣彬"));
        /**int lastIndexOf(String str, int fromIndex):找出str子字符串在该字符串中从fromIndex开始后最后
         一次出现的位置。*/
        System.out.println("str27==" + str.lastIndexOf("侣彬", 0));
        /**int length():返回当前字符串长度。*/
        System.out.println("str28==" + str.length());
        /**String replace(char oldChar,char newChar):将字符串中的第一个oldChar替换成newChar。*/
        System.out.println("str20==" + str.replace('彬', '斌'));
        /**boolean starts With(String prefix):该String对象是否以prefix开始。*/
        System.out.println("str30==" + str.startsWith("祁"));
        /**boolean startsWith(String prefix, int toffset):该String对象从toffset位置算起，是否以prefix开始。*/
        System.out.println("str31==" + str.startsWith("侣", 1));
        /**String substring(int beginIndex):获取从beginIndex位置开始到结束的子字符串。*/
        System.out.println("str32==" + str.substring(1));
        /**String substring(int beginIndex, int endIndex):获取从beginIndex位置开始到endIndex位置的子字符串。*/
        System.out.println("str33==" + str.substring(0, 2));
        /**char[] toCharArray():将该String对象转换成char数组。*/
        char[] chars1 = str.toCharArray();
        for (char c : chars1) {
            System.out.println(c);
        }
        /**String toLowerCase(:将字符串转换成小写。*/
        str = "QILVBIN";
        System.out.println("str34==" + str.toLowerCase());
        /**String toUpperCase(:将字符串转换成大写。*/
        str = "qilvbin";
        System.out.println("str35==" + str.toUpperCase());
        /**static String valueOf(X x):一系列用于将基本类型值转换为String对象的方法。*/
        Float f = 123.467767f;
        System.out.println("str36==" + String.valueOf(f));

        /**STring使用正则表达式*/
        boolean matches = "kongyeeku@163.com".matches("\\w{3,20}@\\w+\\.(com|org|cnlnet|gov)");//返回true
        System.out.println("matches==" + matches);

        /**
         String类中也提供了replaceAll()、replaceFirst()、split()等方法,
         String类提供的正则表达式功能来进行替换和分割。
         */
        String[] msgs = {
                " Java has regular expressions in 1.4",
                " regular expressionsnow expressing in Java",
                "Javarepresses oracular expressions"
        };
        for (String msg : msgs) {
            System.out.println(msg.replaceFirst("re\\w*","哈哈"));
            System.out.println(Arrays.toString(msg.split(" ")));
        }
    }
}
