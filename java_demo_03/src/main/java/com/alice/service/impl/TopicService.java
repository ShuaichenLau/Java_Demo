package com.alice.service.impl;

import com.alice.entity.TopicEntity;
import com.alice.service.TopicMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TopicService {

    @Autowired
    private TopicMapper topicMapper;

    public List<TopicEntity> list() {
//        return topicMapper.selectList(new QueryWrapper<>());
        return null;
    }

}
