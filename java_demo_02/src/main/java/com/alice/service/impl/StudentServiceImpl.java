package com.alice.service.impl;

import com.alice.entity.Student;
import com.alice.service.IStudentService;
import com.alice.spring.extannotation.ExtService;

@ExtService
public class StudentServiceImpl implements IStudentService {
    @Override
    public boolean insert(Student student) {
        return false;
    }
}
