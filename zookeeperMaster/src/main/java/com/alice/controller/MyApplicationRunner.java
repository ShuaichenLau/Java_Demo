package com.alice.controller;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    public final String ADDRESS = "127.0.0.1:2181";
    public final String PATH = "/election";

    public ZkClient zkClient = new ZkClient(ADDRESS);

    @Value("${server.port}")
    public String ServerPort;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 项目启动的时候会在zk上创建一个相同的临时节点
        // 谁能够创建成功谁就是为主服务器
        // 使用服务监听节点是否被删除 如果接收到节点被删除的话 重新开始选择(重新开始创建节点)


        createEphemeral();
        zkClient.subscribeDataChanges(PATH, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println("开始重新选举策略...");
                createEphemeral();
            }
        });

    }

    private void createEphemeral() {
        try {
            zkClient.createEphemeral(PATH,ServerPort);
            System.out.println("ServerPort = = + -  " + ServerPort + ", 选举成功");
            ElectionMaster.isSurvival = true;
        } catch (RuntimeException e) {
            System.out.println("该节点已经存在");
            ElectionMaster.isSurvival = false;
        }
    }
}
