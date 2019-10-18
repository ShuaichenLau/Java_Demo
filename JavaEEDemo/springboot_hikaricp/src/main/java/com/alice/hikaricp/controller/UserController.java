package com.alice.hikaricp.controller;

import com.alice.hikaricp.entity.User;
import com.alice.hikaricp.service.IUserService;
import com.alice.hikaricp.utils.RandomValueUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

import static com.alice.hikaricp.utils.RandomValueUtil.getTelephone;

/**
 * user Controller
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 添加user 随机生成一个user
     * @return
     */
    @ResponseBody
    @RequestMapping("/add")
    public String insertUser() {
        User user = new User();
        user.setUserName(RandomValueUtil.getChineseName());
        user.setPassword(UUID.randomUUID().toString().replaceAll("-", ""));
        user.setPhone(getTelephone());

        userService.insertUser(user);
        return user.toString();
    }

    /**
     * 显示所有user
     * @param model
     * @return
     */
    @RequestMapping("/showAllUser")
    public String getAllUserList(Model model) {
        List<User> byAllUser = userService.getByAllUser();
        model.addAttribute("logName","liusc");
        model.addAttribute("userList",byAllUser);
        return "user/showAllUser";
    }


}
