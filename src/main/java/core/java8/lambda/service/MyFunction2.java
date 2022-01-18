package core.java8.lambda.service;

@FunctionalInterface
public interface MyFunction2<T,R> {

     R getMethod(T t1 , T t2);

}
