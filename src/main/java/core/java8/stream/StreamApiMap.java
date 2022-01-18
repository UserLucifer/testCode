package core.java8.stream;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Liu Yan
 * @create: 2022-01-07 13:53
 **/
public class StreamApiMap {

    /**
     映射:
        map:接收Lambda，将元素转换成其他的形式提取信息。接收一个函数为参数，这个函数会应用到每个元素，在映射成新的元素。






     */

    List<String> stringList = Arrays.asList("Stgring","ss","cc","dd");

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

    //需求：把集合的字符串转换成大写
    @Test
    public void t1 () {
        // Map接收的是一个Function函数，Function<T, R> 传进去一个参数，返回的是R
        Stream<String> stringStream = stringList.stream().map(String::toLowerCase);
        stringStream.forEach(System.out::println);


    }

    //获取员工的姓名
    @Test
    public void t2() {
        //Function接口<T,R> T是传进去的参数，R是你传进去的参数，做完了逻辑的处理，返回的数据类型！
        //里面的每个元素都会对应到一个方法！
        Stream<String> stringStream = emps.stream().map(Employee::getName);
        stringStream.forEach(System.out::println);

    }



}
