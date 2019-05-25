package com.alice.main;

import com.alice.service.impl.StudentServiceImpl;
import com.alice.spring.ext.ExtClassPathXmlApplicationContext;

/**
 * SpringIOC 注解版本 注入方式
 */
public class Test {

    public static void main(String[] args) throws Exception {
        // 1.在使用注解版本事务的时候,第一步要做扫包
        // 2.使用Java的反射机制扫包,获取当前包下所有的类
        // 3.使用Java的反射机制进行初始化

        ExtClassPathXmlApplicationContext extClassPathXmlApplicationContext = new ExtClassPathXmlApplicationContext("com.alice.service.impl");
        StudentServiceImpl studentServiceImpl = (StudentServiceImpl)extClassPathXmlApplicationContext.getBean("studentServiceImpl");
        System.out.println(studentServiceImpl.toString());

    }

}
