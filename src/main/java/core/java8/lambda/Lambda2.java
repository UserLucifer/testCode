package core.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

import static java.lang.System.out;

/**
 * @author: Liu Yan
 * @create: 2021-12-29 15:11
 **/

// 基础语法 新操作符 -> （箭头操作符，labmda操作符）
// 左侧：Lambda 表达式的参数列表 （对应接口中抽象方法的参数列表）
// 右侧 Lambda 表达式执行的功能  （1.对接口的实现 2.需要对抽象方法实现的功能）
//
// 函数式接口  （接口中只有一个抽象方法的接口） @FunctionalInterface 修饰的接口为函数式接口，接口内只能有一个抽象方法
//           语法格式一 ：无参数，无返回值
//                       () -> Sout("")
//           语法格式二： 有一个参数，无返回值
//                       (x) -> Sout("")  也可以不写 （）
//           语法格式三： 有两个以上的参数，并且Lambda有多条语句，有返回值
//                       Comparator<Integer> com = (x,y) -> {
//                          out.println("函数式接口");
//                          return Integer.compare(x,y);
//                       };
//           语法格式四： 有两个以上的参数，Lambda只有一条语句，有返回值
//                       Comparator<Integer> c = (x,y)-> Integer.compare(x,y);
//                       Comparator<Integer> c = Integer::compare;
//

public class Lambda2 {

    // 语法1 没有参数没有返回值
    @Test
    public void l1() {
        // 匿名内部类
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                out.println("已经做好了逻辑处理！！，只需要调用我就可以了");
            }
        };
        runnable.run();
        // lambda方法
        Runnable r = () -> {
            out.println("无参数");
        };
        r.run();

        Runnable r12 = () -> out.println("无参数12");
        r12.run();

    }

    // 语法2  只有一个参数没有返回值  有三种写法
    @Test
    public void l2() {
        // 使用此方法之前，已经对此方法做了逻辑处理，
        // 方法是干嘛的？方法就是做好了处理等着被调用的。所以用的时候只需要传进去参数就可以了。
        Consumer<String> c = System.out::println;
        Consumer<Integer> c1 = System.out::println;
        Consumer<Boolean> c2 = (x) -> System.out.println(x);
        Consumer<Boolean> c3 = x -> System.out.println(x);
        c.accept("String");
        c1.accept(111);
        c2.accept(false);
        c3.accept(true);
        out.println(c);
        out.println(c1);
        out.println(c2);
        out.println(c3);
    }
    // 两个参数以上，有返回值，且内部有多行
    @Test
    public void l3() {

        Comparator<Integer> com = (x,y) -> {
            out.println("函数式接口");
            return Integer.compare(x,y);
        };

        int compare = com.compare(2, 4);
        out.println(compare);
        out.println();
    }
    //两个参数以上，有返回值，且内部有一行
    @Test
    public void l5() {
        Comparator<Integer> c = (x,y)-> Integer.compare(x,y);
        //Comparator<Integer> c = Integer::compare;
        int compare = c.compare(2,3);
        out.println(compare);
    }


}
