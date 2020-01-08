ArrayList 和 Vector 的区别。
    ArrayList在底层数组不够用时候会在原来的基础上扩展0.5倍,Vector是扩展1倍
    Vector是线程安全的,Arraylist是非线程安全.
    比如底层实现的add方法 remove方法 get方法 Vevtor都有synchronized关键字来保证线程安全,所以Vector在单线程环境效率要差.

说说 ArrayList,Vector, LinkedList 的存储性能和特性。
    ArrayList和Vector底层实现都是一样的,都是使用数据方式存储数据,它们允许直接按照序号索引元素,但是在update数组等需要内存操作,所以索引数据块而update慢
    LinkedList使用双向链表实现存储(将内存中零散的内存单元通过附加的引用关联起来,形成一个可以按序号索引的线性结构.但是这种链表存储方式与数组的连续存储方式相比,内存利用率更高),按序号索引数据需要进行前向或后向遍历,只需要记录本项的前后项即可,所以update比较快.
    Vector是线程安全,ArrayList和LinkedList是非线程安全,在多线程问题可以通过工具类Collections中的synchronizedList方法来实现线程安全.(装饰模式)
    
快速失败 (fail-fast) 和安全失败 (fail-safe) 的区别是什么？

hashMap 的数据结构。

hashMap 的工作原理是什么?

hashMap 什么时候进行扩容呢？

List、Map、Set 三个接口，存取元素时，各有什么特点？

Set 里的元素是不能重复的，那么用什么方法来区分重复与否呢? 是用 == 还是 equals()? 它们有何区别?

两个对象值相同 (x.equals(y) == true)，但却可有不同的 hash code，这句话对不对?

heap 和 stack 有什么区别。

Java 集合类框架的基本接口有哪些？

HashSet 和 TreeSet 有什么区别？

HashSet 的底层实现是什么?

LinkedHashMap 的实现原理?

为什么集合类没有实现 Cloneable 和 Serializable 接口？

什么是迭代器 (Iterator)？

Iterator 和 ListIterator 的区别是什么？

数组 (Array) 和列表 (ArrayList) 有什么区别？什么时候应该使用 Array 而不是 ArrayList？

Java 集合类框架的最佳实践有哪些？

Set 里的元素是不能重复的，那么用什么方法来区分重复与否呢？是用 == 还是 equals()？它们有何区别？

Comparable 和 Comparator 接口是干什么的？列出它们的区别

Collection 和 Collections 的区别。



JVM与调优21题

1.Java 类加载过程？
    加载,验证,准备,解析,初始化,使用,卸载.

2.描述一下 JVM 加载 Class 文件的原理机制?
    Java中所有的类,都需要由类加载器装载到JVM内存中才能运行.类加载器本身也是class类,而它的工作就是把class文件从硬盘读取到内存中.
    类装载方式有两种:隐式装载 显式装载
        1.隐式装载:程序在运行过程中当碰到通过new等方式生成对象,隐式调用类装载器加载对应的类到JVM中.
        2.显式装载:通过class.forName()等方法,显式加载需要的类
    隐式加载与显式加载的区别:两者本质是否一样?
        Java类的加载是动态的,并不会一次将所有的类全部加载后再运行,而是保证程序运行的基类完全加载到jvm中,至于其他类,则在需要的时候才会加载.(懒加载模式)为了节省内存开销.
    Java类加载器有三个,对应Java的三种类(Java中的类大致分为3种,系统类,扩展类,由程序员自定义的类)
        BoostrapLoader 负责加载系统类(指内置类)
            --ExtClassLoader 负责加载扩展类(就是继承类和实现类)
                --APPClassLoader  负载加载应用类(程序员自定义的类)
    三个加载器各自完成自己的工作,为了解决协调工作的问题,Java采用委托模型机制.  (双亲委托模型机制)
    委托模型机制的工作原理:当类加载器需要加载类的时候,先请示parent加载器在其搜索路径载入,如果找不到,才在自己的搜索路径搜索该类.采用加载器层次上自顶而下的搜索,因为加载器必须保证基类的加载.
    获取类加载器:
        ClassLoader loader = ClassName.class.getClassLoader();
        ClassLoader ParentLoader = loader.getParent();
    Java在逻辑上并不存在BootstrapLoader的实体,因为它是由c++实现,所以打印内容为null.
    a.装载:查找和导入class文件.
    b.连接:
        检查:检查载入的class文件数据的正确性
        准备:为类的静态变量分配存储空间
        解析:将符号引用转换成直接引用(可选步骤)
    c.初始化:初始化静态变量,静态代码块
        这样的过程在程序调用类的静态成员时会开始执行.所以静态main()才会成为一般程序的入口方法.类的构造器也会引发该动作.
        
3.Java 内存分配。

4.GC 是什么? 为什么要有 GC？

5.简述 Java 垃圾回收机制

6.如何判断一个对象是否存活？（或者 GC 对象的判定方法）

7.垃圾回收的优点和原理。并考虑 2 种回收机制

8.垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？

9.Java 中会存在内存泄漏吗，请简单描述

10.深拷贝和浅拷贝。

11.System.gc() 和 Runtime.gc() 会做什么事情？

12.finalize() 方法什么时候被调用？析构函数 (finalization) 的目的是什么？

13.如果对象的引用被置为 null，垃圾收集器是否会立即释放对象占用的内存？

14.什么是分布式垃圾回收（DGC）？它是如何工作的？

15.串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？

16.在 Java 中，对象什么时候可以被垃圾回收？

17.简述 Java 内存分配与回收策率以及 Minor GC 和 Major GC。

18.JVM 的永久代中会发生垃圾回收么？

19.Java 中垃圾收集的方法有哪些？

20.什么是类加载器，类加载器有哪些？

21.类加载器双亲委派模型机制？



并发编程28题



Synchronized 用过吗，其原理是什么？

你刚才提到获取对象的锁，这个“锁”到底是什么？如何确定对象的锁？

什么是可重入性，为什么说 Synchronized 是可重入锁？

JVM 对 Java 的原生锁做了哪些优化？

为什么说 Synchronized 是非公平锁？

什么是锁消除和锁粗化？

为什么说 Synchronized 是一个悲观锁？乐观锁的实现原理又是什么？什么是 CAS，它有什么特性？

乐观锁一定就是好的吗？

跟 Synchronized 相比，可重入锁 ReentrantLock 其实现原理有什么不同？

那么请谈谈 AQS 框架是怎么回事儿？

请尽可能详尽地对比下 Synchronized 和 ReentrantLock 的异同。

ReentrantLock 是如何实现可重入性的？

除了 ReetrantLock，你还接触过 JUC 中的哪些并发工具？

请谈谈 ReadWriteLock 和 StampedLock。

如何让 Java 的线程彼此同步？你了解过哪些同步器？请分别介绍下。

CyclicBarrier 和 CountDownLatch 看起来很相似，请对比下呢？

Java 线程池相关问题

Java 中的线程池是如何实现的？

创建线程池的几个核心构造参数？

线程池中的线程是怎么创建的？是一开始就随着线程池的启动创建好的吗？

既然提到可以通过配置不同参数创建出不同的线程池，那么 Java 中默认实现好的线程池又有哪些呢？请比较它们的异同

如何在 Java 线程池中提交线程？

什么是 Java 的内存模型，Java 中各个线程是怎么彼此看到对方的变量的？

请谈谈 volatile 有什么特点，为什么它能保证变量对所有线程的可见性？

既然 volatile 能够保证线程间的变量可见性，是不是就意味着基于 volatile 变量的运算就是并发安全的？

请对比下 volatile 对比 Synchronized 的异同。

请谈谈 ThreadLocal 是怎么解决并发安全的？

很多人都说要慎用 ThreadLocal，谈谈你的理解，使用 ThreadLocal 需要注意些什么？



spring 25题



什么是 Spring 框架？Spring 框架有哪些主要模块？

使用 Spring 框架能带来哪些好处？

什么是控制反转(IOC)？什么是依赖注入？

请解释下 Spring 框架中的 IoC？

BeanFactory 和 ApplicationContext 有什么区别？

Spring 有几种配置方式？

如何用基于 XML 配置的方式配置 Spring？

如何用基于 Java 配置的方式配置 Spring？

怎样用注解的方式配置 Spring？

请解释 Spring Bean 的生命周期？

Spring Bean 的作用域之间有什么区别？

什么是 Spring inner beans？

Spring 框架中的单例 Beans 是线程安全的么？

请举例说明如何在 Spring 中注入一个 Java Collection？

如何向 Spring Bean 中注入一个 Java.util.Properties？

请解释 Spring Bean 的自动装配？

请解释自动装配模式的区别？

如何开启基于注解的自动装配？

请举例解释@Required 注解？

请举例解释@Autowired 注解？

请举例说明@Qualifier 注解？

构造方法注入和设值注入有什么区别？

Spring 框架中有哪些不同类型的事件？

FileSystemResource 和 ClassPathResource 有何区别？

Spring 框架中都用到了哪些设计模式？



设计模式 10题



请列举出在 JDK 中几个常用的设计模式？

什么是设计模式？你是否在你的代码里面使用过任何设计模式？

Java 中什么叫单例设计模式？请用 Java 写出线程安全的单例模式

在 Java 中，什么叫观察者设计模式（observer design pattern）？

使用工厂模式最主要的好处是什么？在哪里使用？

举一个用 Java 实现的装饰模式(decorator design pattern)？它是作用于对象层次还是类层次？

在 Java 中，为什么不允许从静态方法中访问非静态变量？

设计一个 ATM 机，请说出你的设计思路？

在 Java 中，什么时候用重载，什么时候用重写？

举例说明什么情况下会更倾向于使用抽象类而不是接口



springboot 22题



什么是 Spring Boot？

Spring Boot 有哪些优点？

什么是 JavaConfig？

如何重新加载 Spring Boot 上的更改，而无需重新启动服务器？

Spring Boot 中的监视器是什么？

如何在 Spring Boot 中禁用 Actuator 端点安全性？

如何在自定义端口上运行 Spring Boot 应用程序？

什么是 YAML？

如何实现 Spring Boot 应用程序的安全性？

如何集成 Spring Boot 和 ActiveMQ？

如何使用 Spring Boot 实现分页和排序？

什么是 Swagger？你用 Spring Boot 实现了它吗？

什么是 Spring Profiles？

什么是 Spring Batch？

什么是 FreeMarker 模板？

如何使用 Spring Boot 实现异常处理？

您使用了哪些 starter maven 依赖项？

什么是 CSRF 攻击？

什么是 WebSockets？

什么是 AOP？

什么是 Apache Kafka？

我们如何监视所有 Spring Boot 微服务？



Netty10题



BIO、NIO和AIO的区别？

NIO的组成？

Netty的特点？

Netty的线程模型？

TCP 粘包/拆包的原因及解决方法？

了解哪几种序列化协议？

如何选择序列化协议？

Netty的零拷贝实现？

Netty的高性能表现在哪些方面？

NIOEventLoopGroup源码？



Redis 16题



什么是redis?

Reids的特点

Redis支持的数据类型

Redis是单进程单线程的

虚拟内存

Redis锁

读写分离模型

数据分片模型

Redis的回收策略

使用Redis有哪些好处？

redis相比memcached有哪些优势？

redis常见性能问题和解决方案

MySQL里有2000w数据，redis中只存20w的数据，如何保证redis中的数据都是热点数据

Memcache与Redis的区别都有哪些？

Redis 常见的性能问题都有哪些？如何解决？

Redis 最适合的场景