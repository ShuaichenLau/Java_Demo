package com.alice;

import cn.hutool.json.JSONObject;
import org.I0Itec.zkclient.IZkDataListener;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

/**
 * @author scliuk
 * 2020-3-2 23:08:15
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {


    @Override
    void waitLock() {
        IZkDataListener izkDataListener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
            }
        };

        // 注册事件通知
        zkClient.subscribeDataChanges(lockPath, izkDataListener);
        if (zkClient.exists(lockPath)) {
            countDownLatch = new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //删除监听
        zkClient.unsubscribeDataChanges(lockPath, izkDataListener);

    }

    @Override
    boolean tryLock() {

        try {
            //创建失败抛异常
            User user = new User();
            user.setId(UUID.randomUUID().toString());
            user.setAge(20);
            user.setName("liusc");
            user.setAddress("beijing");
            JSONObject jsonObject = new JSONObject(user);

//            zkClient.createEphemeral(lockPath);
            zkClient.createEphemeral(lockPath,jsonObject.toString());
            return true;
        } catch (RuntimeException e) {
            //e.printStackTrace();
        }
        return false;
    }
}
