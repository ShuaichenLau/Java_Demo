package com.alice.service.impl;

import com.alice.service.Hose;
import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * 静态代理
 * @author liusc
 */
public class ProxyDemo implements Hose {
    private XiaoMing xiaoMing;

    public ProxyDemo(XiaoMing xiaoMing) {
        this.xiaoMing = xiaoMing;
    }


    @Override
    public void main() {
        System.out.println("com.alice.service.impl.ProxyDemo.main ==> 1111111111111");
        xiaoMing.main();
        System.out.println("com.alice.service.impl.ProxyDemo.main ==> 2222222222222");
    }

    public static void main(String[] args) {
        ProxyDemo proxyDemo = new ProxyDemo(new XiaoMing());
        proxyDemo.main();
    }
}
