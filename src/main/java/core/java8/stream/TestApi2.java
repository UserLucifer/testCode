package core.java8.stream;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Liu Yan
 * @create: 2022-01-06 14:57
 **/
public class TestApi2 {

    /**
     * Stream三个操作
     *
     * 1.创建数据源
     * 2.中间操作
     * 3.终止操作（获取结果）
     * 注意：中间形成流水线，除非触发终止操作，否则中间的操作不会执行，终止操作时会一次性全部处理：这种模式叫：
     *  惰性求值
     *
     */

    //数据源
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

        //中间操作: 筛选 和 切片

        /**

         filter(Predicate P) Predicate断言型接口，用来做判断处理。Filter接收
         的是一个Lambda表达式，从流中排除元素（符合条件的元素）

         limit(int) 获取集合的前多少个操作

         skip(int) 跳过集合的前几个的操作

         distinct() 去重数据（需要重写HashCode和equals())

         * */
        //需求 判断集合中年龄等于8的员工，并打印输出
        for (Employee employee : emps) {
            if (employee.getAge() == 8) {
                System.out.println(employee);
            }
        }
        //Stream写法
        emps.stream().filter(employee -> employee.getAge()>8).forEach(System.out::println);
        List<Employee> collect = emps.stream().filter(employee -> employee.getAge() > 8).collect(Collectors.toList());

        System.out.println("--------------");



        //Stream流写法 Filter()中接收的是Lambda！终止操作是打印
        //内部迭代:迭代操作Stream ApI完成迭代

        //Filter()
        //需求：1.获取年龄等于8的对象，并且返回一个年龄等于8的新流的集合对象
        Stream<Employee> employeeStream = emps.stream().filter(employee -> employee.getAge() == 8);
        //2.将新的流打印
        employeeStream.forEach(System.out::println);

        System.out.println("--------------");

        //Limit() 选取集合的前几个元素
        //需求：1.获取年龄大于8的员工，并且取前两个员工
        Stream<Employee> limit = emps.stream().filter(employee -> employee.getAge() > 8).limit(2);
        //2.将新的流打印
        limit.forEach(System.out::println);

        System.out.println("----------------");

        //Skip() 跳过集合的前几个元素
        //需求：1.获取年龄大于1的员工，并且跳过前三个员工，从第三个员工开始打印输出
        emps.stream().filter(employee -> employee.getAge() > 1).skip(3).forEach(System.out::println);

        System.out.println("------------------");

        //distinct()去重
        //需求：1.去除姓名相同的员工，并且取前三个,最后并打印输出
        //distinct（）是比较两个对象的每一个值，如果都相同，那就排除掉
        emps.stream().distinct().forEach(System.out::println);

        System.out.println("--------------------");

        //需求：过滤调名称等于张三的人。
        emps.stream().filter(employee -> employee.getName()=="张三").forEach(System.out::println);
    }

}
