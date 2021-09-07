package com.arminzheng.observer.pojo;

/**
 * @author Armin Zheng
 * @since 2021-09-04
 */
public class Person {
    private String name;
    public String sex;
    public Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
