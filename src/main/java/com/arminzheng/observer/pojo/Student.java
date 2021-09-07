package com.arminzheng.observer.pojo;

import com.arminzheng.observer.infrastructure.annotation.FieldMap;

/**
 * @author Armin Zheng
 * @since 2021-09-04
 */
public class Student {
    @FieldMap(channel = "c1", value = "name")
    @FieldMap(channel = "c2", value = "sex")
    private String studentName;
    public String sex;
    public Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
