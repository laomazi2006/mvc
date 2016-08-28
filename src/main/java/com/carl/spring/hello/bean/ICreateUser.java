package com.carl.spring.hello.bean;

/**
 * Created by Carl on 2016/8/27.
 */
public interface ICreateUser {
    /**
     * 名字这样子啊
     * @return
     */
    String getName();

    default String getScope() {
        return "user";
    }

    default int getAge() {
        return 0;
    }
}
