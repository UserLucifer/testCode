package core.java8.lambda;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.*;

/**
 * @author: Liu Yan
 * @create: 2021-12-31 11:18
 **/
public class LambdaE3 {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "18:00", 18, 9999.99),
            new Employee(102, "12:30", 59, 6666.66),
            new Employee(103, "7:30", 28, 3333.33),
            new Employee(104, "14:00", 8, 7777.77),
            new Employee(105, "1:00", 38, 5555.55)
    );
    List<Employee> emps2 = Arrays.asList(
            new Employee(101, "9", 18, 9999.99),
            new Employee(102, "24", 59, 6666.66),
            new Employee(103, "53", 28, 3333.33),
            new Employee(104, "23", 8, 7777.77),
            new Employee(105, "555", 38, 5555.55),
            new Employee(105, "9", 38, 5555.55)
    );


    @Test
    public void t1() {

        //调用Collections.sort()方法，比较一个集合内（先按年龄比，年龄相同按姓名比，使用Lambda
        //作为参数传递

        Collections.sort(emps,(e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                // 正序
                return Integer.compare(e1.getAge(), e2.getAge());
                //倒序
                //return -Integer.compare(e1.getAge(), e2.getAge());
            }
//            if(e1.getName().compareTo(e2.getName()) < 0){
//               return e1.getName().compareTo(e2.getName());
//            }else {
//                return -e1.getName().compareTo(e2.getName());
//            }
//            //return e1.getName().compareTo(e2.getName());
        });

        emps.forEach(System.out::println);
    }


    @Test
    public void t3() {
//        emps.sort((o1,o2)->{
//            if (o1.getName().compareTo(o2.getName()) == 0) {
//                return -1;
//            }
//            return o1.getName().compareTo(o2.getName());
//        });
//        emps.forEach(System.out::println);
        System.out.println("+++===");
//        emps2.sort(Comparator.comparing(Employee::getName));

        emps2.sort((o1, o2) -> {
            if (o1.getName().compareTo(o2.getName()) < 0) {
                return -1;
            }else {
                return o1.getName().compareTo(o2.getName());
            }

        });
        emps2.forEach(System.out::println);

    }


}
