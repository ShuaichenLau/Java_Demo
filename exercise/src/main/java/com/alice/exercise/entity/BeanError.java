package com.alice.exercise.entity;

/**
 * 死递归
 * java.lang.StackOverflowError
 */
class BeanError{
    public BeanError(){
        new BeanError();
        System.out.println("aa");
    }
}