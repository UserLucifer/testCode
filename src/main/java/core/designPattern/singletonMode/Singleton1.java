package core.designPattern.singletonMode;

/**
 * @author: Liu Yan
 * @create: 2022-01-13 17:47
 **/
public class Singleton1 {
    public static void main(String[] args) {

        Sing instance = Sing.getInstance();
        Sing instance1 = Sing.getInstance();
        System.out.println(instance1==instance);

    }

}

/**
 * 饿汉式（静态变量)
 */
class Sing {

    /**
     * 构造器私有化
     */
    private Sing () {

    }

    /**
     * 内部创建对象实例
     */
    private static final  Sing instance = new Sing();

    /**
     * 提供一个公共的静态方法，调用方法可以获得此对象
     * @return Sing.class
     */
    public static Sing getInstance() {
        return instance;
    }

}