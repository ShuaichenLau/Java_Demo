package com.alice.service;


import com.alice.entity.Student;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IStudent {

    PageInfo<Student> findAll(int pageIndex, int pageSize);

    int insertStudent(Student student);

}
