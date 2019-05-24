package com.alice;

import com.alice.entity.User;
import com.alice.service.Uservice;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Hello001 {

    public static void main(String[] args) {
        int i = 0;
        System.out.println(++i);
        System.out.println(++i);

//        System.out.println(System.currentTimeMillis());
//        System.out.println(true == false);

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Uservice userService = (Uservice)classPathXmlApplicationContext.getBean("userService");
        User user = new User();
        user.setId(1);
        user.setName("alice");
        user.setAddress("beijing");
        user.setAge(20);
        userService.insertUser(user);

    }
}
