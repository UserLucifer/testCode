package core.java8.lambda;

import org.junit.Test;

import java.util.function.Function;

/**
 * @author: Liu Yan
 * @create: 2022-01-04 17:02
 **/
public class FunctionType {

    //Function<T,R> 传一个字符串，返回一个字符串

    @Test
    public void test1() {
        //获取方法对要传入的参数做处理！返回一个你需要的值！
        String s1 = strHandler("/t/t/t/t ", s -> s.substring(1, 3));
        System.out.println(s1);
        String s1_1 = strHandler("蛮牛健康 ", String::trim);
        String s2 = strHandler("蛮牛健康 ", s-> s.trim());
        System.out.println(s1_1);

    }


    //需求 用于处理字符串
    public String strHandler(String str, Function<String,String > function) {
        return function.apply(str);
    }




}
