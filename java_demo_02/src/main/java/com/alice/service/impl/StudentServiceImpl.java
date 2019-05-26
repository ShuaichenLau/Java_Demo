package com.alice.service.impl;

import com.alice.entity.Student;
import com.alice.entity.User;
import com.alice.service.IStudentService;
import com.alice.service.IUserservice;
import com.alice.spring.extannotation.ExtResource;
import com.alice.spring.extannotation.ExtService;

import javax.annotation.Resource;

@ExtService
public class StudentServiceImpl implements IStudentService {

    /**
     * Connected to the target VM, address: '127.0.0.1:4685', transport: 'socket'
     * Exception in thread "main" java.lang.NullPointerException
     * 	at com.alice.service.impl.StudentServiceImpl.insert(StudentServiceImpl.java:20)
     * 	at com.alice.main.Test.main(Test.java:20)
     * Disconnected from the target VM, address: '127.0.0.1:4685', transport: 'socket'
     *
     *     @Resource
     *     private IUserservice userservice;
     *
     *     不是一个容器  不能找到 userservice
     */


    @ExtResource
    private IUserservice userservice;



    @Override
    public boolean insert(Student student) {
        return false;
    }

    @Override
    public void add(User user) {
        userservice.insert(user);
    }
}


