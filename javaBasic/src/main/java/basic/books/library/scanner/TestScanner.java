package basic.books.library.scanner;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * java基础类库
 */
public class TestScanner {
    //使用Scanner获取键盘输入
    public static void main(String[] args) throws FileNotFoundException {
        /**System.in:创建标准键盘输入System.in
            new File():读文件输入
         * */
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("D:\\myapp\\myJava\\javaBasic\\src\\main\\java\\basic\\library\\testScanner.txt"));

        /**把回车作为分隔符,默认以空格进行分隔
            useDelimiter方法的参数是一个正则表达式
         */
        //scanner.useDelimiter("\n");
        /**scanner.hasNext():判断是否有下一个输入项
           scanner.hasNextLong():判断是否还有Long型整数
           scanner.nextLine():返回输入源中下一行的字符串
         */
        //不输入整型就会退出
        /*while(scanner.hasNextLong()){
            //输出输入项
            System.out.println("键盘输入的内容："+scanner.nextLong());
        }*/
        /*while(scanner.hasNext()){
            //输出输入项
            System.out.println("键盘输入的内容："+scanner.next());
        }*/
        while(scanner.hasNextLine()){
            //输出输入项
            System.out.println("键盘输入的内容："+scanner.nextLine());
        }
    }
}
