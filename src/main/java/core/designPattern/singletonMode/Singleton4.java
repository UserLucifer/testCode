package core.designPattern.singletonMode;

/**
 * @author: Liu Yan
 * @create: 2022-01-14 10:59
 **/
public class Singleton4 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance1 = Singleton.INSTANCE;
        // true,表示两个对象的地址都是一样的，表明他们是同一个对象。
        System.out.println(instance1==instance);
    }
}

/**
 * 枚举的方式实现单例   避免多线程同步的问题，还能防止反序列化重新创建对象的问题。
 */
enum Singleton {
    INSTANCE; //属性
    public void sayOk() {
        System.out.println("ok");
    }

}
