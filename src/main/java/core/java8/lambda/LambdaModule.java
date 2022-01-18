package core.java8.lambda;

import core.java8.lambda.entity.Employee;
import core.java8.lambda.service.MyFilter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Liu Yan
 * @create: 2021-12-17 16:27
 **/
public class LambdaModule {


    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    public static void main(String[] args) {


//        // 找出年龄大于20岁的员工
//        List<Employee> age = getAge(emps, new MyFilterImpl());
//        for (Employee e: age) {
//            System.out.println(e);
//        }


    }

    // 策略设计模式
    //方法一：创建接口，并且实现接口，方法把接口传进去，调用者必须写接口的实现类，调用方法
    public static List<Employee> getAge(List<Employee> employees, MyFilter<Employee> mp) {
        ArrayList<Employee> objects = new ArrayList<>();

        for (Employee e : employees) {
            if (mp.test(e)) {
                objects.add(e);
            }
        }

        return objects;

    }

    @Test
    public void  test5() {

        List<Employee> age = getAge(emps, new MyFilter<Employee>() {
            @Override
            public Boolean test(Employee employee) {
                return employee.getAge()>20;
            }
        });
        System.out.println(age.toString());

    }

    // Lambda方式
    @Test
    public void test6() {

        List<Employee> age = getAge(emps, employee -> employee.getAge() > 20);
        age.forEach(System.out::println);

    }


}
