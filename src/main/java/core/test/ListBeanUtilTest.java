package core.test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Liu Yan
 * @create: 2022-01-17 14:19
 **/
public class ListBeanUtilTest {
    public static void main(String[] args) {


        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("1");
        strings.add("1");
        List<String> strings1 = new ArrayList<>();

        Collections.copy(strings1,strings);
        strings1.forEach(System.out::println);

    }
}
