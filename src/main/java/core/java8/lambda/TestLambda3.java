package core.java8.lambda;

import core.java8.lambda.service.MyFilter2;
import core.java8.lambda.service.MyFunction2;
import org.junit.Test;

/**
 * @author: Liu Yan
 * @create: 2021-12-31 14:27
 **/
public class TestLambda3 {


    @Test
    public void  t1 () {

        String ss = getFunction("ss", String::toLowerCase); // 一个参数，并且有返回值，可以使用Lambda的引用方式调用方法！
        // 使用lambda的引用调用方法的条件 ：1.无返回值 2.有参数，有返回值，但是只有一行代码
        System.out.println(ss);
        //调用方法，传入参数，并对接口的抽象方法做实现！
        String function = getFunction("\t\t\t ss ", (str1) -> str1.trim());
        System.out.println(function);

        //字符串截取
        String utasfsaf = getFunction("utasfsaf", (st1) -> st1.substring(1, 4));
        System.out.println(utasfsaf);

    }

    // 提供的方法,供调用者使用
    public String getFunction(String s1, MyFilter2 myFilter2) {
        return myFilter2.getValue(s1);
    }

    // 1.先定义函数式接口，
    // 2.写方法，把接口当参数串进去
    // 3.调用方法，把参数串进去，并实现它的抽象方法
    // 注意！！！  写好的方法是供我们调用者使用的！,有了方法的实现，我们才能使用Lambda对我们的参数做处理

    //对两个Long处理
    public void op(Long L1, Long L2, MyFunction2<Long,Long> myFunction2) {
        System.out.println(myFunction2.getMethod(L1,L2));
    }

    @Test
    public void t2() {
        op(299L,300L,(x,y)-> x+y);
    }

}
