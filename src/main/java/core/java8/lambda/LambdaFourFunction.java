package core.java8.lambda;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author: Liu Yan
 * @create: 2021-12-31 17:33
 **/
public class LambdaFourFunction {

//java8内置四大函数，就不用自己写接口了。只需要定义方法就可以，然后再调用

    /**
     * 消费接口
     *  Comsumer<T> :
     *      void accept(T t);
     *
     *  供给接口
     *  Supplier<T>:
     *      T get();
     *
     *  函数型接口<T,R>
     *      R apply(T)
     *
     */
    //先创建一个方法，供其他人调用
    public void happy(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    @Test
    public void t1 () {
        //调用方法，实现我们的逻辑
        happy(100,(money)-> System.out.println("我实现了Happy的方法啦,消费了:"+money));

    }

    /**
     * 供给接口
     *
     * Supplier<T>
     */
    // 产生指定个数的整数，并放入集合中
    public List<Integer> getNumberList(int num, Supplier<Integer> supplier) {
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            integers.add(integer);
        }
        return integers;
    }

    @Test
    public void t3() {
        List<Integer> numberList = getNumberList(10, () -> 10);
        numberList.forEach(System.out::println);
        PrintStream out = System.out;
        out.println();

    }



    @Test
    public void t4() {
        String msgA = "Hello ";
        String msgB = "World ";
        System.out.println(
                getString(()-> msgA+ msgB)
        );

    }

    // 获取一个泛型参数指定类型的对象数据
    private static String getString(Supplier<String> supplier){
        return supplier.get();
    }


    /**
     * 供给型接口
     *  求元素最大值
     *
     */
    @Test
    public void t5() {

        List<Integer> integers = Arrays.asList(100, 200, 300, 400, 500, 700);

        int numberMax  =  getInteger(
                ()->{
                    Integer max = integers.get(0); // 100
                        for ( Integer i : integers) {
                            if (max < i) {
                                max = i;
                            }
                        }
                        return max;
                    }
                );
        System.out.println("最大的数值是："+numberMax);

    }

    private static Integer getInteger(Supplier<Integer> integerSupplier) {
        return  integerSupplier.get();
    }


    @Test
    public void t6A() {

        Consumer<String> stringConsumer = System.out::println;
        stringConsumer.accept("传入的参数");

        Supplier<Integer> supplier = ()-> 1;
        Integer integer = supplier.get();
        System.out.println(integer);
    }


}
