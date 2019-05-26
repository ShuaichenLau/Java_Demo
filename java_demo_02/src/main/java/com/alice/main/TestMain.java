package com.alice.main;

import com.alice.entity.Student;
import com.alice.entity.User;
import com.alice.service.impl.StudentServiceImpl;
import com.alice.service.impl.UserServiceImpl;
import com.alice.spring.ext.ExtClassPathXmlApplicationContext;
import com.alice.spring.ext.ExtClassPathXmlApplicationContextAttriAssign;

/**
 * SpringIOC 注解版本 注入方式
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        // 1.在使用注解版本事务的时候,第一步要做扫包
        // 2.使用Java的反射机制扫包,获取当前包下所有的类
        // 3.使用Java的反射机制进行初始化

        ExtClassPathXmlApplicationContextAttriAssign extClassPathXmlApplicationContext = new ExtClassPathXmlApplicationContextAttriAssign("com.alice");
        UserServiceImpl userService = (UserServiceImpl) extClassPathXmlApplicationContext.getBean("userServiceImpl");


        User user = new User();

        user.setName("68754807@qq.com");
        user.setName("alice");
        user.setHappy(true);
        userService.insert(user);

        userService.insert(user);
        System.out.println(userService.toString());

    }

}
