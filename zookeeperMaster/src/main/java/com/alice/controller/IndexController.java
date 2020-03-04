package com.alice.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author scliuk
 * 2020-3-4 14:42:41
 */
@RestController
public class IndexController {

    // 项目启动的时候会在zk上创建一个相同的临时节点
    // 谁能够创建成功谁就是为主服务器
    // 使用服务监听节点是否被删除 如果接收到节点被删除的话 重新开始选择(重新开始创建节点)


    @Value("${server.port}")
    public String ServerPort;

    @RequestMapping("/getServerInfo")
    public String getServerInfo() {
        return "serverPort:" + ServerPort + (ElectionMaster.isSurvival ? "选举为主服务器" : "该服务器为从服务器");
    }

}
