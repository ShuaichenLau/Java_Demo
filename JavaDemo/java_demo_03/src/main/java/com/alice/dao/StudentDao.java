package com.alice.dao;

import com.alice.entity.StudentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import groovy.util.logging.Commons;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
@Commons
@Resource
public interface StudentDao extends BaseMapper<StudentEntity> {

    final static Logger logger = LoggerFactory.getLogger(StudentDao.class);

    @Override
    default Integer insert(StudentEntity studentEntity) {
        return null;
    }

    @Override
    default Integer insertAllColumn(StudentEntity studentEntity) {
        return null;
    }

    @Override
    default Integer deleteById(Serializable serializable) {
        return null;
    }

    @Override
    default Integer deleteByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    default Integer delete(com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default Integer deleteBatchIds(Collection<? extends Serializable> collection) {
        return null;
    }

    @Override
    default Integer updateById(StudentEntity studentEntity) {
        return null;
    }


    @Override
    default Integer updateAllColumnById(StudentEntity studentEntity) {
        return null;
    }

    @Override
    default Integer update(StudentEntity studentEntity, com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default Integer updateForSet(String s, com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default StudentEntity selectById(Serializable id) {
        return null;
    }

    @Override
    default List<StudentEntity> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    @Override
    default List<StudentEntity> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    @Override
    default StudentEntity selectOne(StudentEntity studentEntity) {
        return null;
    }

    @Override
    default Integer selectCount(com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default List<StudentEntity> selectList(com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default List<Map<String, Object>> selectMaps(com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default List<Object> selectObjs(com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default List<StudentEntity> selectPage(RowBounds rowBounds, com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }

    @Override
    default List<Map<String, Object>> selectMapsPage(RowBounds rowBounds, com.baomidou.mybatisplus.mapper.Wrapper<StudentEntity> wrapper) {
        return null;
    }
}
