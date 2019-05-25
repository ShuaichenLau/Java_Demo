package com.alice.service.impl;

import com.alice.service.StudentService;
import org.thymeleaf.util.DateUtils;

import java.util.Date;

public class IStudentServiceImpl implements StudentService {
    public IStudentServiceImpl() {
        System.out.println("com.alice.service.impl.IStudentServiceImpl  " + new Date().toString());
    }

    @Override
    public boolean InsertStudent() {
        return false;
    }
}
