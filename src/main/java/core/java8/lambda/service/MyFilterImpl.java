package core.java8.lambda.service;

import core.java8.lambda.entity.Employee;

/**
 * @author: Liu Yan
 * @create: 2021-12-29 14:47
 **/
public class MyFilterImpl implements MyFilter<Employee>{

    @Override
    public Boolean test(Employee employee) {
        return employee.getAge() > 20;
    }
}
