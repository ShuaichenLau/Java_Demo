package com.alice.main;

import com.alice.service.StudentService;
import com.alice.xml.spring.ClassPathXmlApplicationContext;

/**
 * 2019年5月25日14:08:42
 * 测试xml注入方式的ioc
 */
public class TestIocXml {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        StudentService studentService = (StudentService)classPathXmlApplicationContext.getBean("studentService");
        System.out.println(studentService);
    }
}
