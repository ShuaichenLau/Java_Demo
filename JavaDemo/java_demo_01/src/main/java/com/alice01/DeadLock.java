package com.alice01;
/**
 * @Auther: liyipeng
 * @Date: 2019/10/21 13:59
 * @Description:
 */

/**
 * <p>类名: DeadLock</p>
 * <p>描述:TODO</p>
 * <p>创建人: liyp</p>
 * <p>创建时间: 2019/10/21 13:59</p>
 * <p>@version 2.0  </p>
 * <p>修改内容: ......</p>
 * <p>修改说明: ......</p>
 * <p>修改时间: ......</p>
 * <p>修改人: ......</p>
 * <p>每次修改，请增加上述修改信息说明</>
 */
public class DeadLock {

    private static String lock = "lock1";
    private static String lock2 = "lock2";

    public static void main(String[] args) throws Exception {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new DeadLock().A();
                } catch (Exception e) {

                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new DeadLock().B();
                } catch (Exception e) {

                }
            }
        });
        a.start();
        b.start();
        a.join();
        System.out.println("线程开始执行");
    }

    public void A() throws Exception {
        synchronized (lock) {
            System.out.println("执行A方法");
            System.out.println("休眠一秒调用B方法");
            Thread.sleep(1000);
            B();
        }
    }

    public void B() throws Exception {
        synchronized (lock2) {
            System.out.println("执行B方法");
            System.out.println("休眠一秒调用A方法");
            Thread.sleep(1000);
            A();
        }
    }
}
