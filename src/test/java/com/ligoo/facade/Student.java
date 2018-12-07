package com.ligoo.facade;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 10:10:46
 * @Description:
 */
public class Student implements Person {
    @Override
    public void eating() {
        System.out.println("student eat food in school.");
    }

    public void study(){
        System.out.println("I think it's hard to study.");
    }
}
