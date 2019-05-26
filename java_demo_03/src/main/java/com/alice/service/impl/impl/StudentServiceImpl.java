package com.alice.service.impl.impl;

import com.alice.dao.StudentDao;
import com.alice.entity.StudentEntity;
import com.alice.service.impl.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    private final static Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);


    @Override
    public List<StudentEntity> findByAll() {
        return Lists.newArrayList();
    }

}
