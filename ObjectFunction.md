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

rabbitMQ 高级消息队列协议.用于在分布式系统中存储转发消息,在易用性/扩展性/高可用性等方面表现不俗.比如rabbitMQ的一些特性:
    1.可靠性,RabbitMQ使用一些机制来保证可靠性,如持久化,传输确认,发布确认.
    2.灵活的路由:在消息队列之前,使用Exchange来路由消息.对于典型的路由功能,RabbitMQ已经提供了一些内置Exchange来实现.针对更复杂的路由功能,可以将多个Exchange绑定在一起,也通过插件机制实现自己的Exchange.
    3.消息集群:多个rabbitMQ可以组成集群,形成一个逻辑Broker.
    4.高可用:队列可以在集群中的机器进行镜像,使得在部分节点出问题的情况下仍然可用.
    5.多种协议:rabbitMQ支持多种消息队列协议,比如STOMP MQTT
    6.多语言客户端:支持Java .Net Ruby等等.
    7.管理界面:提供易用的管理界面,使得用户可以监控和管理消息Broker
    8.跟踪机制:如果消息发生异常,rabbitMQ提供消息跟踪机制,使用者可以发生了什么.
    9.插件机制:rabbitMQ提供了许多插件,来从多方面进行扩展,也可以编写自己的插件.


1.Spring事务分类
    1.1声明事务
    1.2编程事务
    

2.Spring事务原理
    AOP技术环绕通知进行拦截
    使用Spring事务注意事项 不能用try 因为要将异常抛出给外层.