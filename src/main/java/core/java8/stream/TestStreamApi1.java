package core.java8.stream;

import core.java8.lambda.entity.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author: Liu Yan
 * @create: 2022-01-06 14:42
 **/
public class TestStreamApi1 {

    /**
     * Stream三个操作
     * 1，创建Stream (数据源）
     * 2. 中间操作
     * 3. 终止操作 （获取结果)
     *
     */

    @Test
    public void t1 () {
        //创建流的方式

        //1
        ArrayList<String> strings = new ArrayList<>();
        Stream<String> stream = strings.stream();

        //2
        Employee[] employee = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employee);

        //3
        Stream<String> xx = Stream.of("xx", "xx", "xx");
    }

}
