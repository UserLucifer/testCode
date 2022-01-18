package core.java8.stream;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Liu Yan
 * @create: 2022-01-07 15:43
 **/
public class TestApiSoted {


    /**
     排序
        sorted() -> 不加参数自然排序
        sorted() ->  定制排序

     */
    List<Integer> integers = Arrays.asList(24,535,3232,223,55,66);

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(104, "赵8", 8, 7777.77),
            new Employee(105, "田9", 38, 5555.55),
            new Employee(106, "田924", 38, 5555.55),
            new Employee(107, "田923", 38, 5555.55),
            new Employee(108, "田921", 38, 5555.55),
            new Employee(111, "田9", 38, 5555.55),
            new Employee(111, "田9", 38, 5555.55)
    );

    @Test
    public void t1() {
        integers.stream().sorted().forEach(System.out::print);



        //定制排序
        //需求：按年龄排序，如果相等就按照姓名排序
        emps.stream().sorted((e1, e2) ->{
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        }).forEach(System.out::println);



    }


}
