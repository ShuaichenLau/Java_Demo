package com.alice;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author scliuk
 * 2020-3-2 20:37:19
 */
public abstract class ZookeeperAbstractLock implements Extlock {

    public final static String zkAddress = "127.0.0.1:2181";

    public final static String lockPath = "/lock_liusc";

    public ZkClient zkClient = new ZkClient(zkAddress);

    protected CountDownLatch countDownLatch = new CountDownLatch(1);

//    private static ZkClient getZkclient() {
//        if (zkClient == null) {
//            return zkClient = new ZkClient(zkAddress);
//        }
//        return zkClient;
//    }


    @Override
    public void lock() {

        //连接zk 在zk上创建一个/lock节点 节点类型为临时节点
        //节点创建之后,直接执行业务逻辑 如果节点创建失败,进行等待

        if (tryLock()) {
            System.out.println("获取到锁....  完成业务......");
        } else {
            waitLock();
            lock();
        }


    }

    //如果节点创建失败,进行等待 使用事件通知监听改节点是否被删除 如果被删除的话重新进入获取锁的资源
    abstract void waitLock();

    //获取锁的资源,如果能够获取锁成功返回true 失败返回false
    abstract boolean tryLock();

    //释放锁
    @Override
    public void unlock() {
        if (zkClient != null) {
            System.out.println("释放锁......");
            zkClient.close();
        }

    }
}
