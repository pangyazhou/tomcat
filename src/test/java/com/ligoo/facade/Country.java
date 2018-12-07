package com.ligoo.facade;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 10:13:04
 * @Description:
 */
public class Country {
    public void service(Person person){
        Student student = (Student) person;
        student.eating();
        student.study();
    }
}
