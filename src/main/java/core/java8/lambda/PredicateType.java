package core.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author: Liu Yan
 * @create: 2022-01-05 14:16
 **/
public class PredicateType {

    @Test
    public void t1() {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("ssd");
        strings.add("sss23");
        strings.add("w4ewe");
        strings.add("5r23");
        strings.add("234");
        strings.add("21343435r");

        //调用过滤方法，过滤元素大于3的元素放入集合中！
        List<String> strings1 = filterStr(strings, s -> s.length() > 3);
        strings1.forEach(System.out::println);


    }

    //需求 满足条件的字符串，放入集合中
    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        ArrayList<String> strings = new ArrayList<>();
        for (String s: list) {
            if (predicate.test(s)) {
                strings.add(s);
            }
        }
        return strings;
    }




}
