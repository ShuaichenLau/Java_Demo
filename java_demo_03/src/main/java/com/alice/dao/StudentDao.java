package com.alice.dao;

import com.alice.entity.StudentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import groovy.util.logging.Commons;
import org.apache.ibatis.annotations.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

@Mapper
@Commons
@Resource
public interface StudentDao extends BaseMapper<StudentEntity> {

    final static Logger logger = LoggerFactory.getLogger(StudentDao.class);




}
