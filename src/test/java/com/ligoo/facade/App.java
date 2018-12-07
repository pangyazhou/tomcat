package com.ligoo.facade;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 10:14:07
 * @Description:
 */
public class App {
    public static void main(String[] args){
        Student student = new Student();
        Country country = new Country();
        //PersonFacade personFacade = new PersonFacade(student);
        country.service((Person) student);
    }
}
