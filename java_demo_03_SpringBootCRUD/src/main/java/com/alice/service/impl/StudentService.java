package com.alice.service.impl;


import com.alice.entity.StudentEntity;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface StudentService extends IService<StudentEntity> {


    List<StudentEntity> findByAll();
}
