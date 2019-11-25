package com.alice.controller;

import com.alice.entity.Student;
import com.alice.service.impl.StudentImpl;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@RestController
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentImpl studentImpl;

    @RequestMapping("/insertStudent")
    public int insertStudent() {
        logger.info("com.alice.controller.StudentController.insertStudent");
        Student student = new Student();
        student.setName(UUID.randomUUID().toString().replaceAll("-", ""));
        student.setAge(new Random().nextInt(100));
        student.setAddress(Calendar.getInstance().getTime().toString());
        int insertStudent = studentImpl.insertStudent(student);
        return insertStudent;
    }

    @RequestMapping("/getStudentByPage")
    public PageInfo<Student> getStudentByPage() {
        logger.info("com.alice.controller.StudentController.getStudentByPage");
        PageInfo<Student> all = studentImpl.findAll(1, 10);
        return all;
    }
}
