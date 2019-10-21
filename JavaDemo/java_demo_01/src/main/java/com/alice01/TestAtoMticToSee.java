package com.alice01;
/**
 * @Auther: liyipeng
 * @Date: 2019/10/21 13:46
 * @Description:
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>类名: TestAtoMticToSee</p>
 * <p>描述:TODO</p>
 * <p>创建人: liyp</p>
 * <p>创建时间: 2019/10/21 13:46</p>
 * <p>@version 2.0  </p>
 * <p>修改内容: ......</p>
 * <p>修改说明: ......</p>
 * <p>修改时间: ......</p>
 * <p>修改人: ......</p>
 * <p>每次修改，请增加上述修改信息说明</>
 */
public class TestAtoMticToSee {
    public static void main(String[] args) throws Exception {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final AtomicInteger atomicInteger = new AtomicInteger();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInteger.incrementAndGet();
                System.out.println("thread1对atomicInteger加了1");
                try {
                    countDownLatch.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2读取了atomicInteger得值为" + atomicInteger);
                countDownLatch.countDown();
            }
        });
        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println("atomicInteger可见性测试");
    }
}
