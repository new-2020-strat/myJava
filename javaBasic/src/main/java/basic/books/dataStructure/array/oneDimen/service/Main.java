package basic.books.dataStructure.array.oneDimen.service;

import org.junit.Test;

/**
 * 1.数组也是一种类型(引用类型)，一个数组只能存储一种数据类型的数据，所以数组元素的数据类型是唯一的
 *
 */
public class Main {
    @Test/**测试数组的定义和初始化*/
    public void testInitArray(){
/**
 一.数组的定义：
     type[] arrayName(强烈推荐使用)：比如int[] intArray
     type arrayName[]    比如int intArray[]
 二.数组的初始化：
    1.静态初始化:使用静态初始化时，只能指定数组元素的初始值，不能指定数组长度
 */
        /**定义一个int类型数组的变量，变量名为intArr*/
        int[] intArr;
        intArr = new int[]{1,2,3};
        /**定义和初始化数组同时完成*/
        int[] intArr2 = {1,2,3};

        /**定义一个Object类型数组的变量，变量名为objArr,数组元素类型是所定义类型的子类
         * 所有类型都是Object的子类
         **/
        Object[] objArr;
        objArr = new Object[]{"qilvbin",1};
    /**
     2.动态初始化：只指定数组的长度，由系统为每个元素赋初始值，语法type[] arrName = new type[length];* */
        /**动态定义数组，定义和初始化同时完成*/
        int[] intArr3 = new int[5];
        /**动态定义数组，定义和初始化同时完成,数组元素类型是定义数组类型的子类*/
        Object[] objArr3 = new String[5];
        double[] a = new double[1];
        /**系统分配的元素初始值：
         整型：(byte,short,int和long)  0
         浮点型(float,double)          0.0
         字符型(char)                  '\u0000'
         布尔类型(boolean)             false
         引用类型(类，接口，数组)        null
         * */
/**
 三。使用数组：访问数据元素，修改，遍历数据元素
 * */
        for (int i=0;i<intArr3.length;i++){
            System.out.println(intArr3[i]);
        }
        /**foreach遍历数组*/
        for (int ele:intArr3){
            System.out.println(ele);
        }
    }

}
