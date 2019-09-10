package com.alice.hikaricp.dao;

import com.alice.hikaricp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserDao {

    int insert(User record);

    void deleteUserById(@Param("userId") Integer userId);

    void updateUser(User userDomain);

    List<User> selectUsers();
}
