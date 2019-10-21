package com.alice01;

/* @Auther: liyipeng
 * @Date: 2019/10/21 11:37
 * @Description:
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>类名: TestAtoMatic</p>
 * <p>描述:TODO</p>
 * <p>创建人: liyp</p>
 * <p>创建时间: 2019/10/21 11:37</p>
 * <p>@version 2.0  </p>
 * <p>修改内容: ......</p>
 * <p>修改说明: ......</p>
 * <p>修改时间: ......</p>
 * <p>修改人: ......</p>
 * <p>每次修改，请增加上述修改信息说明</>
 */
public class TestAtoMatic {

    public static void main(String[] args) throws Exception {
        //证明AtomaticInteger不是原子性
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //上面创建十个核心线程的线程池
        for (int i = 0; i < 10; i++) {
            AddOneNumber runnable = new AddOneNumber(atomicInteger, countDownLatch);
            executorService.submit(runnable);
        }
        countDownLatch.await();
        System.out.println(atomicInteger);
    }

}

class AddOneNumber implements Runnable {

    private AtomicInteger atomicInteger;
    private CountDownLatch countDownLatch;

    public AddOneNumber(AtomicInteger atomicInteger, CountDownLatch countDownLatch) {
        this.atomicInteger = atomicInteger;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            System.out.println("加1前的值" + atomicInteger.incrementAndGet() + "+++++最新值" + atomicInteger);
        }
        countDownLatch.countDown();
    }
}