package basic.books.enumClass.enumEntity;

/**
 * 枚举类是一个特殊的java类，编译后会生成一个class文件
 * enum关键字和interface，class等关键字类似
 */
public enum SeasonEnum {
    /**
     * 在第一行中列出四个枚举实例
     */
    SPRING("green","春天"),SUNMMER("hot","夏天"),FALL("yellow","秋天"),WINTER("cold","冬天");
    private final String desc;
    private final String name;

    SeasonEnum(String desc,String name) {
        this.desc = desc;
        this.name = name;
    }

    /*public void setDesc(String desc) {
        switch (this){
            case SPRING:
                if(desc.equals("green")){
                    this.desc = desc;
                }else{
                    System.out.println("参数错误");
                }
                break;
            case SUNMMER:
                if(desc.equals("hot")){
                    this.desc = desc;
                }else{
                    System.out.println("参数错误");
                }
                break;
            case FALL:
                if(desc.equals("yellow")){
                    this.desc = desc;
                }else{
                    System.out.println("参数错误");
                }
                break;
            case WINTER:
                if(desc.equals("cold")){
                    this.desc = desc;
                }else{
                    System.out.println("参数错误");
                }
                break;
        }
    }*/

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }
}
class TestEnum{
    public void judge(SeasonEnum seasonEnum){
        switch (seasonEnum){
            case SPRING:
                System.out.println("春天");
                break;
            case  SUNMMER:
                System.out.println("夏天");
                break;
            case FALL:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
            default:
                System.out.println("异常");

        }

    }
    public static void main(String[] args) {
        /**
         * 枚举类有个values()方法，可以遍历枚举类的实例
         */
        for (SeasonEnum s:SeasonEnum.values()){
            System.out.println(s);
        }
        /**
         * 使用枚举类的实例时，可以用SeasonEnum.Spring访问
         */
        new TestEnum().judge(SeasonEnum.SPRING);
        /**
         * 使用方法给desc属性赋值
         */
        SeasonEnum se = SeasonEnum.valueOf("SPRING");
        //se.setDesc("green");
        System.out.println(se+"="+se.getDesc());

        /**
         * 使用构造器给属性赋值
         */
        System.out.println("desc=="+se.getDesc());

    }

}
