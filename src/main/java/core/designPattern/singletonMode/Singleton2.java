package core.designPattern.singletonMode;

/**
 * @author: Liu Yan
 * @create: 2022-01-13 17:47
 **/
public class Singleton2 {


    public static void main(String[] args) {

        Sing2 instance = Sing2.getInstance();
        Sing2 instance1 = Sing2.getInstance();
        System.out.println(instance1==instance1); //true

    }


}
// 饿汉式（静态代码快）
class Sing2 {

    //.私有化
    private Sing2 () {

    }

    //类内部创建对象
    private static Sing2 instance;

    static { //静态代码完成对象的创建
        instance = new Sing2();
    }

    //调用方法会获取到这个对象
    public static Sing2 getInstance() {
        return instance;
    }



}

