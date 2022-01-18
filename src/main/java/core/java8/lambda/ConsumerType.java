package core.java8.lambda;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author: Liu Yan
 * @create: 2022-01-04 17:02
 **/
public class ConsumerType {

    @Test
    public void t1() {
        consumerInterface(100,x-> System.out.println("刘公子今晚消费了:"+ x +"元"));
        consumerInterface(200, System.out::println);
    }

    // 使用Lambda输出今晚的消费金额
    public void consumerInterface(Integer moner, Consumer<Integer> consumer) {
        consumer.accept(moner);
    }

}
