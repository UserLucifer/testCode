package core.java8.lambdaMethodReference;

import core.java8.lambda.entity.Employee;
import org.junit.Test;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author: Liu Yan
 * @create: 2022-01-05 15:30
 **/
public class MethodRef1 {

    /**
     *  方法引用：若Lambda 体中的方法已经实现，就可以使用方法引用
     *
     *  方法引用，是Lambda表达式的另一种表现形式
     *
     *  解释一下什么是方法已经实现：就是说你的这个参数传进去某个方法
     *  这个方法内部已经帮你完成了逻辑，并且是你想要的结果。这个就是
     *  方法的实现
     *
     *  比如说 : System.out.print("xxx") -> 可以写成 System.out::println,
     *   PrintStream out = System.out;
     *   out.println();
     *   System.out::println 这个是对象：：方法名.
     *
     *  语法格式分三种：
     *      1.对象：：实例方法名
     *      2. 类：：静态方法名
     *      3. 类：：实例方法名

     */

    @Test
    public void t1() {
        //方法引用  对象::方法名
        Consumer<String>  s1 = System.out::println;
        s1.accept("哈哈");

        Employee employee = new Employee();
        Supplier<String> supplier = employee::getName;
        String s = supplier.get();
        System.out.println(s);

        Supplier<Integer> supplier1 = employee::getAge;
        Integer integer = supplier1.get();
        System.out.println(integer);

    }

    @Test
    public void t2() {
        // 类::静态方法
        Comparator<Integer> comparator = Integer::compare;
        int compare = comparator.compare(2, 3);
        System.out.println(compare);

    }

    @Test
    public void t3() {
        // 类::方法名
        BiPredicate<String,String> biPredicate = String::equals;
        biPredicate.test("23","5");
    }

    @Test
    public void t4() {
        //构造器引用  创建对象
        Supplier<Employee> supplier = Employee::new;
        Employee employee = supplier.get();


        // 有一个默认参数的构造器创建对象
        Function<Integer, Employee> function = Employee::new;
        Employee apply = function.apply(232);
        System.out.println(apply);

        //创建数组 创建一个长度为三的数组
        Function<Integer,String[]> function1 = String[]::new;
        String[] apply1 = function1.apply(3);
        int length = apply1.length;
        System.out.println(length);

    }






}
