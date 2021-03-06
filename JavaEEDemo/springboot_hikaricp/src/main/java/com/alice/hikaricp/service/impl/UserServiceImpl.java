package com.alice.hikaricp.service.impl;

import com.alice.hikaricp.dao.UserDao;
import com.alice.hikaricp.entity.User;
import com.alice.hikaricp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Transactional 不建议加在类上  否则有查询SQL 会被应用事务
 *
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public boolean insertUser(User user) {
        logger.info("com.alice.hikaricp.service.impl.UserServiceImpl.insertUser");
        int insertCount = userDao.insertUser(user);
        if (insertCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public int deleteUser(User user) {
        logger.info("com.alice.hikaricp.service.impl.UserServiceImpl.deleteUser");
        return userDao.deleteUserById(user.getUserId());
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        logger.info("com.alice.hikaricp.service.impl.UserServiceImpl.updateUser");
        userDao.updateUser(user);
        User userByUserId = userDao.getUserByUserId(user.getUserId());
        return userByUserId;
    }

    @Override
    public List<User> getByAllUser() {
        logger.info("com.alice.hikaricp.service.impl.UserServiceImpl.getByAllUser");
        List<User> users = userDao.selectUsers();
        return users;
    }

    @Override
    public User getByUserId(Integer userId) {
        logger.info("com.alice.hikaricp.service.impl.UserServiceImpl.getByUserId");
        User userByUserId = userDao.getUserByUserId(userId);
        return userByUserId;
    }
}
