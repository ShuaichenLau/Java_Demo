



设计模式

hashMap 根据键的hashCode值存储数据,大多情况下可以直接定位到它的值。因此具有很快的访问速度。
    （数组+链表+红黑树）
    hashMap最多只允许一条记录为null，允许多条记录的值为null。
    hashMap非线程安全，如果需要满足线程安全可以用collections的synchronizedMap方法使HashMap具有线程安全的能力
    或者使用JUC中的ConcurrentHashMap 分段锁。
hashMap 1.7 和1.8的区别
    1.7查找根据hash值能快速定位数组的具体下标。但是之后的话需要顺着链表一个个比较hashcode才能找到我们需要的，时间复杂度取决于链表的长度为O(n)。
    1.8中当链表中的元素超过8个以后，会将链表转换为红黑树，在这些位置进行查找的时候可以降低时间复杂度为O(logN)


volatile关键字(变量可见性 禁止重排序)
    volatile变量不会被缓存在寄存器或者对其它处理器不可见的地方,因此在读取volatile类型的变量时总会返回最新写入的值。
    volatile比sychronized更轻量级的同步锁==>访问volatile变量不会执行加锁操作,因此也不会执行线程阻塞,因此volatile变量是一种比synchronized关键字更轻量级的同步机制
    适合一个变量被多个线程共享，线程直接给这个变量赋值。

ThreadLocal（线程的一个属性）线程本地变量 线程本地存储
    提供线程内的局部变量，这种变量在线程的生命周期内起作用，减少同一个线程内多个函数或者组件之间一些公共变量传递的复杂度



JVM内存模型 GC优化
    分代概念 根据对象的声明周期长短,把堆内存分为3个代: 年轻代 老年代 永久代。根据不同代的特点使用不同的GC收集算法，来提高吞吐量
    年轻代：大部分对象都是朝生夕死。所以这里收集器都会用复制算法
        复制算法的优点是只访问活跃对象，缺点是复制成本高，因为内存资源比较有限。但是复制算法只访问活跃对象，对那些大比例的死对象视而不见，可以充分发挥遍历空间成本低的优点。
        年轻代分为 Eden区  S0 S1区 当Eden区内存不足的时候 就会触发MinorGC,对新生代进行一次GC回收。
        MinorGC的过程（复制->清空->互换）
        Eden区 S0区 复制到S1区 同时年龄+1 如果S1区内存不足了就放到老年代,然后清空eden S0区中的对象,最后S1区和S0区互换,原来S1区成为下一次GC的S0区。
        老年代 存放生命周期比较长的对象 采用标记清除算法，但是会产生内存碎片，为了减少内存损耗，一般需要进行合并或者标记出来方便下次直接分配。当老年代内存不足的时候就会抛出OOM（out of memory）异常
        永久代 指的是内存的永久保存区域。主要保存的是class和Meta（元数据）的信息，Class在被加载的时候会被放入永久区域，和存放实例的区域不同，GC不会在主程序运行期对永久代进行清理，所以也导致了永久生区域随着class的增多而胀满，最终抛出OOM异常
    引用计数法：循环引用的问题
    可达性分析算法==> 根搜索算法：GC Roots（1.VM栈的引用 2.方法区中的静态引用 3.JNI中的引用）
    不可达对象不等价于可回收对象,不可达对象要变成可回收对象至少要经过两次标记过程。两次标记后仍然是可回收对象，则将面临回收。
    8:1:1 Eden S0 S1 新生代分配比例
    默认情况下年龄到达15的对象会被移动到老年代中
        每次GC收集发现大批对象已死，只有少量存活，采用标记复制算法
        如果对象存活率高，没有额外空间对它进行分配担保，就采用“标记-清理” OR “标记-整理”算法来进行回收。不进行内存复制，直接腾出空闲内存。
        CMS 基于标记清除算法
        G1  基于标记整理算法

线程的生命周期
    新建 就绪 运行 阻塞 死亡

start()方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码
run()方法当作普通方法的方式调用，程序还是要顺序执行，还是要等待run方法体执行完毕后才可继续执行下面的代码


JUC 分段锁应用 以及 Java集合
JUC 分段锁
    减少锁持有时间  只用在有线程安全要求的程序上加锁
    减小锁粒度  将大对象(可能被很多线程访问)，拆成小对象，大大增加并行度，降低锁竞争。降低了锁的竞争，偏向锁轻量级锁成功率才会提高。 CouncurrentHashMap.class
JUC 锁分离
    读写锁ReadWriteLock 根据功能进行分离成读锁和写锁，读读不互斥 读写互斥 写写互斥 保证线程安全提高性能。比如LinkedBlockingQueue从头部取出，从尾部放数据。
    锁粗化
    锁消除


tomcat优化
    conf 存放tomcat的配置 server.xml web.xml
    lib  存放tomcat和application的jar包
    webapps 存放运行tomcat里的application
    bin 存放在windows linux平台的脚本文件
    logs 存放tomcat执行时的日志
    work 存放jsp编译产生的class文件


zk+dubbo

SpringBoot+SpringCloud

SpringMVC的请求流程

Spring的特性 介绍
    Spring非侵入式,典型的,Spring应用中的对象不依赖于Spring的特定类
    Spring通过控制反转IOC的技术促进低耦合，应用了IOC，一个对象依赖的其他对象会通过被动的方式传递进来，而不是这个对象自己创建或者查找依赖对象
    Spring支持面向切面变成，并且把应用业务逻辑和系统服务分开
    Spring包含并管理应用对象的配置和生命周期，是一个容器。可以配置每个bean如何被创建--基于一个可配置原型，你的bean可以创建一个单独的实例或者每次需要时都生成一个新的实例，以及它们如何相互关联。
    Spring可以将简单的组件配置、组合成为复杂的应用
    Spring中应用对象被声明式地组合，典型的是在一个xml文件里
    Spirng也提供了很多基础功能（事务管理、持久化框架集成等），将应用逻辑的开发留给开发者。

Spring的IOC AOP
    通过一个配置文件来描述bean及bean之间的依赖关系，利用Java语言的反射功能实例化Bean并建立Bean之间的依赖关系。
    SpringIOC容器在完成这些底层工作的基础上，还提供了Bean实例缓存，声明周期管理，Bean实例代理，事件发布，资源装载等高级服务。

Spring AOP的核心概念
    1.切面：类是对物体特征的抽象，切面就是对横切关注点的抽象
    2.横切关注点：对哪些方法进行拦截，拦截后怎么处理，这些关注点称之为横切关注点
    3.连接点：被拦截到的点，因为Spring只支持方法类型的连接点，所以在Spring中连接点指的是被拦截到的方法，实际上连接点还可以是字段或者构造器
    4.切入点：对连接点进行拦截的定义
    5.通知：指拦截到连接点之后要执行的代码，通知分为前置、后置、异常、最终、环绕通知5类
    6.目标对象：代理的目标对象
    7.织入（weave）：将切面应用到目标对象并且导致代理对象创建的过程
    8.引入（introduction）：在不修改代码的前提下，引入可以在运行期为类动态地添加一些方法或字段。
Spring AOP的两种代理方式：
    JDKProxy和Cglin
        默认的策略是如果目标类是接口，则使用JDK动态代理结束，否则使用Cglib来生成代理。
Spring AOP的应用场景
    1.Authentication 权限
    2.Caching 缓存
    3.Context passing 内容传递
    4.Error handling 错误处理
    5.Lazy loading 懒加载
    6.Debugging 调试
    7.Logging, tracing, profiling and monitorting 记录跟踪 优化 校准
    8.Performance potimization 性能优化
    9.Persistence 持久化
    10.Resource pooling 资源池
    11.Synchronization 同步
    12.Transactions 事务

SpringMVC的流程


Spring的循环依赖


MySQL索引 Innodb存储引擎特性 buffer pool页

Redis MQ Kafka MongoDB

ElasticSearch

SpringBoot的启动流程


