package basic.books.dataStructure.type.basicType;

public class Integer_one {
    /**基本数据类型之整型
     * 整型有四种类型，分别是：
     * 1.byte：在内存里占8位，表示范围：-2^7(-128)~2^7-1(127)
     * 2.short：在内存里占16位，表示范围：(-2^15)~(2^15-1)
     * 3.int：在内存里占32位，表示范围：(-2^31)~(2^31-1)
     * 4：long：在内存里占64位，表示范围：(-2^63)~(2^63-1)
     */
    public static void main(String[] args) {
        byte bt = 56;//正确
        long lg = 9999999999L;//当超出int范围时加上L转long
        /**
         * 将一个较小的数据类型赋给较大的数据类型，只会当较小类型处理，只是把较小的数据值当做较大类型处理
         */
        /**进制表示
         * 二进制0B或者0b开头，八进制以0开头，八进制以0X或者0x开头
         */
    }
}
