package com.ligoo.facade;

/**
 * @Author: Administrator
 * @Date: 2018/12/7 10:16:19
 * @Description:
 */
public class PersonFacade implements Person{
    private Person person = null;

    public PersonFacade(Person person) {
        this.person = person;
    }

    @Override
    public void eating() {
        this.person.eating();
    }
}
