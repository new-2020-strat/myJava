package basic.library.regular;

import java.util.Locale;
import java.util.ResourceBundle;

/**Java程序的国际化思路是将程序中的标签、提示等信
 息放在资源文件中，程序需要支持哪些国家、语言环境，
 就对应提供相应的资源文件。资源文件是key-value对，
 每个资源文件中的key是不变的，但 value则随不同的国
 家、语言而改变。图7.7显示了Java程序国际化的思路。
 * */
public class I18N {
    /**
     Java程序的国际化主要通过如下三个类完成。
     java.util.ResourceBundle:用于加载国家、语言资
     源包。
     java.util.Locale:用于封装特定的国家/区域、语言
     环境。
     java.text.MessageFormat:用于格式化带占位符的字
     符串。
     Java程序的国际化主要通过如下三个类完成。
     java.util.ResourceBundle:用于加载国家、语言资
     源包。
     java.util.Locale:用于封装特定的国家/区域、语言
     环境。
     java.text.MessageFormat:用于格式化带占位符的字
     符串。
     * */
    public static void main(String[] args) {
        //返回 Java所支持的全部国家和语言的数组
        Locale[] localeList = Locale.getAvailableLocales();
        //遍历数组的每个元素，依次获取所支持的国家和语言
        for (int i=0;i<localeList.length; i++){
        //输出所支持的国家和语言
        System.out.println(localeList[i].getDisplayCountry()
            +"="+ localeList[i].getCountry()+" "
            +localeList[i].getDisplayLanguage()
            +"="+ localeList[i].getLanguage());
        }

        //取得系统默认的国家/语言环境
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        //根据指定的国家/语言环境加载资源文件
        ResourceBundle bundle =ResourceBundle.getBundle ( "mess",myLocale);
        //打印从资源文件中取得的消息
        System.out.println(bundle.getString("hello"));

    }

}
