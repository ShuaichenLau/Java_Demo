package com.alice.service.impl.impl;

import com.alice.entity.StudentEntity;
import com.alice.service.impl.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/application.yaml", "classpath:application-activiti.yaml" })
@ComponentScan
public class StudentServiceImplTest {

    @Autowired
    public StudentService studentService;

    @Test
    public void test() {

        studentService = new StudentServiceImpl();

        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(10);
        studentEntity.setName("alice");
        studentEntity.setAddress("beijing");
        studentEntity.setAge(11);
        studentEntity.setSchool("Peking University");
        studentEntity.setSex(0);
        System.out.println(studentService);


        List<StudentEntity> byAll = studentService.findByAll();

//        boolean b = studentService.insert(studentEntity);

        StudentEntity studentEntity1 = studentService.selectById(10);
        System.out.println(studentEntity1);

    }

}