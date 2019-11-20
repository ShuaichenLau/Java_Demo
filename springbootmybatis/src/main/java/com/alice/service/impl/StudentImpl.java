package com.alice.service.impl;

import com.alice.entity.Student;
import com.alice.mapper.StudentMapper;
import com.alice.service.IStudent;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentImpl implements IStudent {

    private final Logger logger = LoggerFactory.getLogger(StudentImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageInfo<Student> findAll(int pageIndex, int pageSize) {
        logger.info("com.alice.service.impl.StudentImpl.findAll");
        List<Student> studentlist = Lists.newArrayList();
        PageHelper.startPage(pageIndex,pageSize);
        studentlist = studentMapper.findAll();
        PageInfo<Student> studentPageInfo = new PageInfo<Student>(studentlist);
        return studentPageInfo;
    }

    @Override
    public int insertStudent(Student student) {
        int insertCount = studentMapper.insert(student.getName(), student.getAge(), student.getAddress());
        return insertCount;
    }
}
