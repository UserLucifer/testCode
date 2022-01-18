package core.designPattern.singletonMode;

/**
 * @author: Liu Yan
 * @create: 2022-01-13 18:13
 **/
class Singleton3 {

}

//懒汉第一种写法 （存在安全问题） 线程不安全

/**
 * 创建单例步骤
 * 1.创建构造
 * 2.创建对象
 * 3.创造公共方法
 */
class Sing3{
    //实例
    private static Sing3 instance;

    //私有化
    private Sing3(){

    }

    //调用方法才会创建对象  问题：不安全
    public static Sing3 getInstance() {
        if (instance == null) {
            instance = new Sing3();
        }
        return instance;
    }
    //方法2: 线程安全  因为：加锁  缺陷：效率低
    public static synchronized Sing3 getInstance1() {
        if (instance == null) {
            instance = new Sing3();
        }
        return instance;
    }
    //方法3  多线程可能会产生多个实例，不能起到线程安全的作用
    public static  Sing3 getInstance2() {
        if (instance == null) {
            synchronized (Sing3.class) {
                instance = new Sing3();
            }
        }
        return instance;
    }


    private static volatile Sing3 instance2;

    /**
     * 双重检查是多线程中开发用到的，比如代码中，进行两次if(singleton==null)就能保证线程安全
     * 创建对象只执行一次，后面在访问时，判断if(singleton==null),直接Return对象，避免了反复方法同步
     *
     * 优点：线程安全，延迟加载，效率高
     */
    //方法4  双重检查,解决线程问题，又解决懒加载问题
    public static Sing3 getInstance3() {
        if (instance2 == null) {
            synchronized (Sing3.class) {
                if (instance2 == null) {
                    instance2 = new Sing3();
                }
            }
        }
        return instance2;
    }

    /**
     * 方法5：静态内部类
     *
     *
     * 这种方式采用类加载的机制保证实例化只有一个线程
     *
     * 静态内部类的方式在Sing3类被装载时并不会实例化，而需要时，调用getInstance4，才会
     * 装载SingInstance类，从而完成Sing3的实例化
     *
     * 类的静态属性只会在第一次加载类的时候初始化，Jvm帮助我们保证了线程的安全性，在类进行初始化
     * 的时候，别的线程无法进入
     *
     * 优点：避免了线程不安全，利用静态内部类的特点实现延时加载，效率高
     *
     */
    private static class SingInstance { //静态内部类
        private static final Sing3 INSTENCE = new Sing3();
    }

    //获取对象的公共方法
    public static synchronized Sing3 getInstance4() {
        return SingInstance.INSTENCE;
    }

}
