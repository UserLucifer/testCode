package core.java8.stream;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: Liu Yan
 * @create: 2022-01-07 16:43
 **/
public class TestApiCollect {

    /**
     收集:
        collect-把流转换成其他的形式。
     */
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
        //获取一个带有String的流，转换成setOrList
        List<String> collect = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        collect.forEach(System.out::print);
        String s = collect.toString();
        System.out.println(s);

        //分组
        Map<String, List<Employee>> collect1 =
                emps.stream().collect(Collectors.groupingBy(Employee::getName));
        System.out.println(collect1);
    }



}
