package basic.library.string;

/**
 * 是一个可变字符序列的String类，StringBuffer是线程安全的,StringBuilder没有实现线程安全功能
 */
public class TestStringBuffer {
    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder();//追加字符串
        sb.append("java");// sb = "java";
        System.out.println("最开始=="+sb);
        //插入
        sb.insert(0,"hel1o ");//sb="hello java"
        System.out.println("插入hello=="+sb);
        //替换
        sb.replace(5,6,",");// sb="hello, java"
        System.out.println("替换=="+sb);
        //删除
        sb.delete(5,6);//sb="hellojava"
        System.out.println("删除=="+sb);
        //反转
        sb.reverse();//sb-"avajo1leh"
        System.out.println("反转=="+sb);
        System.out.println("长度=="+sb.length());//输出9
        System. out.println("容量=="+sb.capacity());//输出16
        //改变StringBuilder的长度，将只保留前面部分
        sb.setLength(5);//sb="avajo"
        System.out.println("改变长度"+sb);

    }
}
