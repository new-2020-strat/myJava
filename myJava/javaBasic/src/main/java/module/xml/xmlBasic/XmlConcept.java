package module.xml.xmlBasic;

import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
1.概念： extensible Markup Language 可扩展标记语言
    可扩展——标签都是可自定义的<user></user><student></student>
2.功能
    2.1.以自定义标签方式作为配置文件使用,存储配置数据
    2.2.在网络中传输数据
3.xml和html的区别
    xml和properties配置文件竞争
    3.1 xml的标签都是自定义的，html标签都是预定义的
    3.2 xml的语法严格，xml语法松散
    3.3 xml是存储数据，而html是展示数据
4.w3c(万维网联盟)
5.语法
    5.1基本语法
        5.1.1 xml文件后裔都是.xml
        5.1.2 xml文件的第一行必须是文档声明
        5.1.3 xml中有且只有一个根标签
        5.1.4 标签中的属性必须使用单双引号引起来
        5.1.5 标签必须正确关闭
        5.1.6 xml标签名称区分大小写
    5.2 快速入门
        见user.xml文件
6.组成部分
    6.1 文档声明
        6.1.1 格式：<?xml 属性列表?>
        6.1.2 属性列表：
            6.1.2.1 version:版本号，必须的属性
            6.1.2.2 encoding:编码方式
            6.1.2.3 standalone：是否独立，取值：yes:不依赖其他文件；no依赖其他文件
    6.2 指令(了解，早期是用来做html的)
        <?xml-stylesheet types="text/css" href="name.css"?><!--导入css样式-->
    6.3 标签
        6.3.1 名称可以包含字母、数字以及其他的字符
        6.3.2 名称不能以数字或者标点符号开始
        6.3.3 名称不能以字母 xml（或者 XML、Xml 等等）开始
        6.3.4  名称不能包含空格
    6.4 属性
        id属性值唯一
    6.5 文本
        6.5.1 CDATA区:在该区域中的数据会被原样展示
        6.5.2 格式：<![CDATA[数据展示]]>

 7 xml的约束：规定xml稳当的书写规则,作为框架的使用者(见constraint包下的案例)
    7.1 能够在xml中引入约束文档
    7.2 能够简单的读懂约束文档
    7.3 约束文档的分类
        7.3.1 DTD：一种简单的约束技术
        7.3.2 Schema:一种复杂的约束技术
    7.4 DTD
        7.4.1 引入dtd文档到xml文档中
            7.4.1.1 内部dtd：约束规则定义在xml文档中
            7.4.1.2 外部dtd：约束规则定义在外部dtd文件中
                7.4.1.2.1 本地：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
                7.4.1.2.2 网络：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件位置URL">
    7.5 Schema
8.解析xml
    8.1 解析(读取)：将文档中的数据读取到内存中
    8.2 写入：将内存中的数据保存到xml文档中
    8.3 解析方式：在移动端用SAX，在服务端用DOM
        8.3.1 DOM：将标记语言文档一次性加载内存中，在内存中形成一个dom树
            8.3.1.1 优点：操作简单，可以对文档进行CRUD的所有操作
            8.3.1.2 缺点：占内存大
        8.3.2 SAX:逐行读取，基于事件驱动
            8.3.2.1 优点：不占内存
            8.3.2.1 缺点：只能读取，不能crud
 9.xml常见的解析器：
    9.1.JAXP：sun公司提供的解析器，支持dom和sax两种思想
    9.2 DOM4J：一款非常优秀的解析器
    9.3 jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，
              可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
    9.4 PULL:Android操作系统内置的解析器，sax方式
 */
public class XmlConcept {
    /**
     * jsoup快速入门
     *      1.导入jar
     *      2.获取document对象
     *      3.获取对应的标签element对象
     *      4.获取数据
     */
    public static void main(String[] args) throws IOException {
        /**
         * 1.Jsoup:工具类,可以解析xml文档，返回Document
         *      比较常用的重载方法
         *      1.1 parse(File in,charsetName):解析xml和html
         *      1.2 parse(String html):解析xml和html字符串
         *      1.3 parse(URL url,int timeoutMillis):通过网络路径指定html或者xml的文档对象
         * 2.Document:文档对象，代表内存中的dom树
         *      2.1 getElementByTag(String tagName):根据标签名称获取element对象集合
         *      2.2 getElementById(String id):根据ID属性获取唯一的element对象
         *      2.3 getElementByAttribute(String key):根据属性名回去对象集合
         *      2.4 getElementAttributeValue(String key,String value):根据对象的属性名和属性获取元素对象集合
         *
         * 3.Elements：元素Element对象的集合，可以当做是ArrayList<Element>来使用
         * 4.nodes：元素对象
         * 5.快捷的两种查询方式
         *      5.1 selector：selector选择器
         *          使用的方法：elements select(String cssQuery)
         *      5.2 Xpath：XPath即为XML路径语言（XML Path Language），它是一种用来确定XML文档中某部分位置的语言
         *                  需要额外导入jar包
         */
        //获取student_dtd.xml文件的path
        String path = "E:\\document\\java\\javaPython\\myJava\\javaBasic\\src\\main\\java\\module\\xml\\xmlBasic\\constraint\\student_dtd.xml";
        //String path = XmlConcept.class.getClassLoader().getResource("module\\xml\\xmlBasic\\constraint\\student_dtd.xml").getPath();
        //解析xml文档，加载文档进内存，获取document对象--->Document
        Document document = Jsoup.parse(new File(path),"utf-8");
        System.out.println("document=="+document);
        //获取元素对象 Element
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        //获取第一个name的Element对象
        Element element = elements.get(0);
        //获取数据
        String name = element.text();
        System.out.println("name="+name);

        //通过网络获取
        URL url = new URL("https://www.baidu.com");
        Document document1 = Jsoup.parse(url,10000);
        System.out.println(document1);
    }
    @Test
    public void testDocument() throws IOException {
        String path = "E:\\document\\java\\javaPython\\myJava\\javaBasic\\src\\main\\java\\module\\xml\\xmlBasic\\constraint\\student_dtd.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取所有的students对象
        Elements elements = document.getElementsByTag("student");
        System.out.println("elements="+elements );

        //获取属性number值为stu001的对象
        Elements elements1 = document.getElementsByAttributeValue("number","stu001");
        System.out.println("element1="+elements1);
    }
    @Test//
    public void testElement() throws IOException {
        String path = "E:\\document\\java\\javaPython\\myJava\\javaBasic\\src\\main\\java\\module\\xml\\xmlBasic\\constraint\\student_dtd.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //获取子标签
        Element element_student = document.getElementsByTag("student").get(0);
        Elements element_name = element_student.getElementsByTag("name");
        System.out.println(element_name);

        //获取student元素的number属性值
        String number = element_student.attr("number");
        System.out.println(number);

        //获取文本内容
        String text = element_name.text();
        String html = element_name.html();
        System.out.println(text);
        System.out.println(html);
    }

    @Test
    public void testQuery() throws IOException {
        String path = "E:\\document\\java\\javaPython\\myJava\\javaBasic\\src\\main\\java\\module\\xml\\xmlBasic\\constraint\\student_dtd.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据标签名称查询
        Elements name = document.select("name");//根据id查询"#id"
        System.out.println(name);
    }
    @Test
    public void testXPath() throws IOException {
        String path = "E:\\document\\java\\javaPython\\myJava\\javaBasic\\src\\main\\java\\module\\xml\\xmlBasic\\constraint\\student_dtd.xml";
        Document document = Jsoup.parse(new File(path), "utf-8");
        //根据Document创建JXdocument对象
        JXDocument jxDocument = new JXDocument(document);
        //结合Xpath语法查询
        List<JXNode> jxNodes = jxDocument.selN("//student");
        //遍历
        for (JXNode jxNode:jxNodes){
            System.out.println(jxNode);
        }
        System.out.println("_______________________________________________");
        //查询student标签下的name标签
        List<JXNode> jxNodes1 = jxDocument.selN("//student/name");
        for (JXNode jxNode:jxNodes1){
            System.out.println(jxNode);
        }
    }
}
