package com.carl.spring.hello.bean.wrapper;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.PropertyValue;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2016/8/31.
 */
public class CompanyTest {
    @Test
    public void testBw() throws Exception {
        BeanWrapper company = new BeanWrapperImpl(new Company());
// setting the company name..
        company.setPropertyValue("name", "Some Company Inc.");
// ... can also be done like this:
        PropertyValue value = new PropertyValue("name", "Some Company Inc.");
        company.setPropertyValue(value);

// ok, let's create the director and tie it to the company:
        BeanWrapper jim = new BeanWrapperImpl(new Employee());
        jim.setPropertyValue("name", "Jim Stravinsky");
        jim.setPropertyValue("salary", 234F);
        jim.setPropertyValue("factoryId", new Integer[] {2,4});
        Map<String, String> v = new HashMap<>();
        v.put("name","123123");

        jim.setPropertyValue("keySet", v);
        company.setPropertyValue("managingDirector", jim.getWrappedInstance());

// retrieving the salary of the managingDirector through the company
        String salary = (String) jim.getPropertyValue("keySet[name]");
        System.out.println(salary);
    }

}