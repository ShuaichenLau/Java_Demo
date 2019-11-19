Object有哪些方法? 提供了11种方法 (被final修饰的方法不允许被重写)
    public final native Class<?> getClass()
        返回当前运行时对象的class对象
    public native int hashCode()
        返回对象的hash码,主要使用在hashMap,是通过该对象内部地址转换成一个整数来实现的.
        如果2个对象的equals方法相等，那么他们的hashCode值也必须相等，反之，如果2个对象hashCode值相等，但是equals不相等，这样会影响性能，所以还是建议2个方法都一起重写。
    public boolean equals(Object obj)
        比较两个对象是否相等,Object类默认实现,即比较两个对象的内存地址是否相等.
    protected native Object clone() throws CloneNotSupportedException
        创建并返回当前对象的一份拷贝.
    public String toString()
        Object对象的默认实现,即输出类的名字@实例的哈希码的16进制.
    public final native void notify()
        唤醒一个在此对象监视器上等待的线程(监视器相当于锁).如果所有的线程都在此对象上等待,那么只会选择一个线程.
    public final native void notifyAll()
        唤醒此对象监视器上等待的所有线程
    public final native void wait(long timeout) throws InterruptedException
        让当前线程等待直到另外一个线程调用对象的notify或者notifyAll方法,或者超过参数设置的timeout超时时间
    public final void wait(long timeout, int nanos) throws InterruptedException
        和wait(long timeout)方法一样,只不过多了一个nanos参数,这个参数表示额外时间(以毫秒为单位),所以超过的时间还需要加上nanos参数.
    public final void wait() throws InterruptedException
        该方法会一直等待,没有超时的概念.和唤醒notify一起使用.wait()方法阻塞当前线程,notify方法唤醒当前线程.
    protected void finalize() throws Throwable { }
        Object的默认实现是不进行任何操作.
        是实例被GC回收的时候触发的动作,就好比"死前的最后一波挣扎"




1.Spring事务分类
    1.1声明事务
    1.2编程事务
    

2.Spring事务原理
    AOP技术环绕通知进行拦截
    使用Spring事务注意事项 不能用try 因为要将异常抛出给外层.



多数据源
    1.假设公司分为两个数据库,一个数据库专门存放共同配置文件,一个数据库存放业务数据库

垂直拆分和水平拆分

垂直根据业务划分具体数据库
在一个项目中多个数据源(连接不同库)无限大.具体多少根据内存大小来决定
在一个项目多数据源如何划分: 分包名(业务) || 注解方式.


热部署原理:
    使用类加载器(ClassLoader重新读取字节码文件到jvm内存中)
如何纯手写一个热部署功能:
    1.监听class文件是否有发生改变 --版本号 或者 修改时间
    2.如果class文件发生改变的,就是用ClassLoader进行重新读取.

热部署是否可以用于生产环境?
    1.理论上可以(不推荐,不安全)
    2.本地上开发 eclipse idea 目的提高效率
热部署的应用场景
    提高程序本地开发运行的效率
    spring-boot-devtools

SpringBoot
    扫包优化
JVM参数调优--影响到整体运行吞吐量
调优策略:初始化堆内存与最大相同
默认Tomcat容器改为Undertow

什么是监控中心
    针对微服务服务器监控,服务器内存状态(堆内存,线程,日志管理等等),检测服务配置连接地址是否可用(模拟访问,懒加载)
    统计现在有多少个Bean(Spring容器中的bean),统计SpringMVC @RequestMapping(统计http接口)
    Actuator监控应用(没有界面,只有返回的json)
    AdminUI (SpringBootAdmin)  应用场景(生产环境 测试环境)

为什么要用SpringBoot监控中心
    可以使用http的各种请求来建管,审计,收集应用程序的运行情况.

默认下,监控中心有3个接口权限,在SpringBoot2.0以后,监控中心地址发生变化,在访问监控中心接口 前面加上/actuator.
在SpringBoot2.0以前 可以直接通过/beans来访问监控中心

SpringMVC线程单例 非线程安全
    必须要定义一个非静态成员变量时候，则通过注解@Scope(“prototype”)，将其设置为多例模式



redis持久化
RDB AOF同步的区别
    1.RDB属于全量同步(定时同步)
        同步效率高,但是会造成数据丢失
    2.AOF属于增量同步(实时同步)
        同步效率低,但是数据丢失可能性小,最多会丢失1秒的数据

redis 6种内存淘汰策略
redis数据放在内存中, 防止内存撑爆 会有淘汰策略
    内存的淘汰策略,如果内存空间用满,就会自动驱逐老的数据(最久不使用)