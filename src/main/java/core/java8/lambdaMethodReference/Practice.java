package core.java8.lambdaMethodReference;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author: Liu Yan
 * @create: 2022-01-05 17:30
 **/
public class Practice {


    @Test
    public void t1() {

        List<Employee> emps = Arrays.asList(
                new Employee(101, "张三", 18, 9999.99),
                new Employee(102, "李四", 59, 6666.66),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵8", 8, 7777.77),
                new Employee(105, "田9", 38, 5555.55)
        );

        /**
         * 1.按年龄排序，如果年龄相等，按名称排序
         */
        emps.sort((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return Integer.compare(e1.getAge(), e2.getAge());
            }
        });

        emps.forEach(System.out::println);
    }

    /**
     *  2.将字符串转换成大写
     */
    @Test
    public void t2() {
        String s1 = getValue("lalalsfdw sfafjasf", String::toUpperCase);
        System.out.println(s1);
    }

    /**
     * 自己写的Lambda方法
     * @param s
     * @param function
     * @return
     */
    public String getValue(String s, Function<String,String> function) {
        return function.apply(s);
    }


    /**
     * 3.计算两个数的和，和乘积
     */
    @Test
    public void t5(){
        //计算乘积  传一个6，x就相当于一个变量被赋值了，然后拿着这个变量在->后做逻辑处理
        Integer number = getNumber(6, x -> x * x);
        //计算和
        Integer number1 = getNumber(17, x -> x + x);
        System.out.println(number);
        System.out.println(number1);


    }

    /**
     * //自己写的Lambda方法
     * @param num
     * @param function
     * @return
     */
    public Integer getNumber(Integer num,Function<Integer,Integer> function) {
        return function.apply(num);
    }



}
