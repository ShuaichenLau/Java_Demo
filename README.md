设计模式
    单例模式
        懒汉式加载
        饿汉式加载
        双检锁/双重校验锁
        登记式/静态内部类
        枚举
    工厂模式
        Spring容器的beanFactory

hashMap 根据键的hashCode值存储数据,大多情况下可以直接定位到它的值。因此具有很快的访问速度。
    （数组+链表+红黑树）
    hashMap最多只允许一条记录为null，允许多条记录的值为null。
    hashMap非线程安全，如果需要满足线程安全可以用collections的synchronizedMap方法使HashMap具有线程安全的能力
    或者使用JUC中的ConcurrentHashMap 分段锁。
hashMap 1.7和1.8的区别
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

关于tomcat优化总描述
    1.tomcat优化/各个文件夹作用
        conf 存放tomcat的配置 server.xml web.xml
        lib  存放tomcat和application的jar包
        webapps 存放运行tomcat里的application
        bin 存放在windows linux平台的脚本文件
        logs 存放tomcat执行时的日志
        work 存放jsp编译产生的class文件
    2.tomcat优化/使用compression来提高网页加载速度
        compression 打开压缩功能 
        compressionMinSize 启用压缩的输出内容大小，这里面默认为2KB 
        compressableMimeType 压缩类型 
        connectionTimeout 定义建立客户连接超时的时间. 如果为 -1, 表示不限制建立客户连接的时间
    3.tomcat的3种运行方式:
        BIO:默认的模式,同步阻塞模式,性能非常低下,没有经过任何优化处理和支持
        NIO:(new i/o)同步非阻塞模式,利用多路复用器来提高性能,Java nio是一个基于缓冲区、并能提供非阻塞I/O操作的Java API，因此nio也被看成是non-blocking I/O的缩写。它拥有比传统I/O操作(bio)更好的并发运行性能。
        APR:从操作系统级别来解决异步的IO问题,大幅度提高性能。
    4.tomcat执行器优化(使用线程池)
        在tomcat中每一个用户的请求都是一个线程,所以可以使用线程池来提高性能。开启并且使用配置：在Connector中指定使用共享线程池
        **Executor标签重要参数说明：**
            name：共享线程池的名字。这是Connector为了共享线程池要引用的名字，该名字必须唯一。默认值：None；
            namePrefix:在JVM上，每个运行线程都可以有一个name 字符串。这一属性为线程池中每个线程的name字符串设置了一个前缀，Tomcat将把线程号追加到这一前缀的后面。默认值：tomcat-exec-；
            maxThreads：该线程池可以容纳的最大线程数。默认值：200；
            maxIdleTime：在Tomcat关闭一个空闲线程之前，允许空闲线程持续的时间(以毫秒为单位)。只有当前活跃的线程数大于minSpareThread的值，才会关闭空闲线程。默认值：60000(一分钟)。
            threadPriority：线程的等级。默认是Thread.NORM_PRIORITY
        **Connector重要参数说明：**
            executor：表示使用该参数值对应的线程池；
            minProcessors：服务器启动时创建的处理请求的线程数；
            maxProcessors：最大可以创建的处理请求的线程数；
            maxThreads： Tomcat使用线程来处理接收的每个请求。这个值表示Tomcat可创建的最大的线程数。默认值150。
            acceptCount： 指定当所有可以使用的处理请求的线程数都被使用时，可以放到处理队列中的请求数，超过这个数的请求将不予处理。默认值10。
            minSpareThreads： Tomcat初始化时创建的线程数。默认值25。
            maxSpareThreads： 一旦创建的线程超过这个值，Tomcat就会关闭不再需要的socket线程。默认值75。
            enableLookups： 是否反查域名，默认值为true。为了提高处理能力，应设置为false
            connnectionTimeout： 网络连接超时，默认值60000，单位：毫秒。设置为0表示永不超时，这样设置有隐患的。通常可设置为30000毫秒。
            maxKeepAliveRequests： 保持请求数量，默认值100。 bufferSize： 输入流缓冲大小，默认值2048 bytes。
            compression： 压缩传输，取值on/off/force，默认值off。 其中和最大连接数相关的参数为maxThreads和acceptCount。如果要加大并发连接数，应同时加大这两个参数。
    5.tomcat禁用AJP连接器(在一般项目中使用Nginx+tomcat的架构)
        AJP（Apache JServer Protocol）
        AJPv13协议是面向包的。WEB服务器和Servlet容器通过TCP连接来交互；为了节省SOCKET创建的昂贵代价，WEB服务器会尝试维护一个永久TCP连接到servlet容器，并且在多个请求和响应周期过程会重用连接。
    6.JVM的优化


SpringBoot+SpringCloud
    快速整合第三方框架,简化XML配置完全采用注解化,内置Web服务器(jetty tomcat),帮助开发者完成快速开发。最终用Java应用程序的形式进行执行
    传统SSH SSM有些许缺点:比如要写很多xml配置文件,开发效率低,jar包冲突
    SpringBoot底层已经完成实现版本统一maven继承原理。

SpringCloud解决方案:
    1.SpringCloud注册中心
    2.客户端调用工具
    3.网关
    4.链路
    5.服务跟踪
    6.负载均衡
    7.分布式配置中心
    8.断路器
SpringBoot和SpringCloud之间的关系
    SpringCloud是一套微服务解决框架，在微服务领域通讯协议http+json格式
    SpringCloud依赖于SpringBoot框架,SpringCloud使用SpringMVC书写http协议接口.同时SpringCloud是一套完整的微服务解决框架

SpringBoot与SpringMVC的关系
    SpringBoot集成了SpringMVC web组件(集成关系) 整合SpringMVC框架

互联网项目:敏捷开发 分布式和微服务项目，rpc通讯协议接口都是http+json格式=rest格式
如果做微服务,需要SpringCloud整合SpringBoot,如果项目只是单纯使用SpringBoot不使用SpringCloud,这个项目不需要微服务.

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
        默认的策略是如果目标类是接口，则使用JDK动态代理接口，否则使用Cglib来生成代理。
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
    1.用户发送请求至前端控制器DispatcherServlet
    2.DispatcherServlet收到请求调用处理器映射器HandlerMapping。
    3.处理器映射器根据请求url找到具体的处理器，生成处理器执行链HandlerExecutionChain(包括处理器对象和处理器拦截器)一并返回给DispatcherServlet。
    4.DispatcherServlet根据处理器Handler获取处理器适配器HandlerAdapter执行HandlerAdapter处理一系列的操作，如：参数封装，数据格式转换，数据验证等操作
    5.执行处理器Handler(Controller，也叫页面控制器)。
    6.Handler执行完成返回ModelAndView
    7.HandlerAdapter将Handler执行结果ModelAndView返回到DispatcherServlet
    8.DispatcherServlet将ModelAndView传给ViewReslover视图解析器
    9.ViewReslover解析后返回具体View
    10.DispatcherServlet对View进行渲染视图（即将模型数据model填充至视图中）。
    11.DispatcherServlet响应用户。

SpringMVC组件说明
    1.DispatcherServlet：前端控制器。用户请求到达前端控制器，它就相当于mvc模式中的c，dispatcherServlet是整个流程控制的中心，由它调用其它组件处理用户的请求，dispatcherServlet的存在降低了组件之间的耦合性,系统扩展性提高。由框架实现
    2.HandlerMapping：处理器映射器。HandlerMapping负责根据用户请求的url找到Handler即处理器，springmvc提供了不同的映射器实现不同的映射方式，根据一定的规则去查找,例如：xml配置方式，实现接口方式，注解方式等。由框架实现
    3.Handler：处理器。Handler 是继DispatcherServlet前端控制器的后端控制器，在DispatcherServlet的控制下Handler对具体的用户请求进行处理。由于Handler涉及到具体的用户业务请求，所以一般情况需要程序员根据业务需求开发Handler。
    4.HandlAdapter：处理器适配器。通过HandlerAdapter对处理器进行执行，这是适配器模式的应用，通过扩展适配器可以对更多类型的处理器进行执行。由框架实现。
    5.ModelAndView是springmvc的封装对象，将model和view封装在一起。
    6.ViewResolver：视图解析器。ViewResolver负责将处理结果生成View视图，ViewResolver首先根据逻辑视图名解析成物理视图名即具体的页面地址，再生成View视图对象，最后对View进行渲染将处理结果通过页面展示给用户。
    7View:是springmvc的封装对象，是一个接口, springmvc框架提供了很多的View视图类型，包括：jspview，pdfview,jstlView、freemarkerView、pdfView等。一般情况下需要通过页面标签或页面模版技术将模型数据通过页面展示给用户，需要由程序员根据业务需求开发具体的页面。

Spring的循环依赖
    Spring对循环依赖的处理有3种
        1.构造器的循环依赖,这种依赖Spring是处理不了的,直接抛出BeanCurrentlylnCreationExecption异常;
        2.单例模式的setter循环,通过"三级缓存"处理循环依赖;
        3.非单例循环,无法处理;
    Spring单例对象初始化分为3个步骤
        1.createBeanInstance 实例化,调用对象的构造方法实例化对象;
        2.populateBean 填充属性,这一步主要是多bean的依赖属性填充;
        3.initializeBean 调用Spring的init方法;
    构造器循环依赖
        this.singletonsCurrentlylnCreation.add(beanName)将当前正要创建的bean记录在缓存中,Spring容器将每一个正在创建的bean标识放在一个"当前创建bean池";
        bean标识:在创建过程中将一直保持在这个池中,因此如果在创建bean的过程中发现自己已经在"当前创建bean池"里时,将抛出BeanCurrentlylnCreationException异常表示循环依赖,而对于创建完毕的bean将从"当前创建bean池"中清除掉。
    setter循环依赖
        Spring为了解决单例循环依赖的问题，使用了三级缓存。这三级缓存的作用==>
        /** Cache of singleton objects: bean name –> bean instance */
        private final Map singletonObjects = new ConcurrentHashMap(256);
            完成初始化的单例对象的cache(一级缓存)
        /** Cache of singleton factories: bean name –> ObjectFactory */
        private final Map> singletonFactories = new HashMap>(16);
            进入实例化截断的单例对象工厂的cache(三级缓存)
        /** Cache of early singleton objects: bean name –> bean instance */
        private final Map earlySingletonObjects = new HashMap(16);
            完成实例化但是尚未初始化的,提前曝光的单例对象的cache(二级缓存)
        我们在创建bean的时候,会首先从cache中获取这个bean,这个缓存就是singletonObjects。
        Spring解决循环依赖的诀窍就在于SingletonFactories这个三级缓存。这个cache类型就是ObjectFactory。
        让我们来分析一下“A的某个field或者setter依赖了B的实例对象，同时B的某个field或者setter依赖了A的实例对象”这种循环依赖的情况。A首先完成了初始化的第一步，并且将自己提前曝光到singletonFactories中，此时进行初始化的第二步，发现自己依赖对象B，此时就尝试去get(B)，发现B还没有被create，所以走create流程，B在初始化第一步的时候发现自己依赖了对象A，于是尝试get(A)，尝试一级缓存singletonObjects(肯定没有，因为A还没初始化完全)，尝试二级缓存earlySingletonObjects（也没有），尝试三级缓存singletonFactories，由于A通过ObjectFactory将自己提前曝光了，所以B能够通过ObjectFactory.getObject拿到A对象(虽然A还没有初始化完全，但是总比没有好呀)，B拿到A对象后顺利完成了初始化阶段1、2、3，完全初始化之后将自己放入到一级缓存singletonObjects中。此时返回A中，A此时能拿到B的对象顺利完成自己的初始化阶段2、3，最终A也完成了初始化，进去了一级缓存singletonObjects中，而且更加幸运的是，由于B拿到了A的对象引用，所以B现在hold住的A对象完成了初始化。
    https://juejin.im/post/5c98a7b4f265da60ee12e9b2


MySQL索引 Innodb存储引擎特性 buffer pool页
    事务并发 事务序列化 以及后来的事务MVCC 事务的特性 隔离级别

Redis RabbbitMQ Kafka MongoDB

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

ElasticSearch

SpringBoot的启动流程
    SpringApplication的构造过程
        1.从入口类的main方法调用SpringApplication的静态方法run，这个run()会构造一个SpringApplication的实例，然后再调用实例的run()方法表示启动SpringBoot。
        2.SpringApplication构造的时候内部会调用一个private方法initialize。
        3.ApplicationContextInitializer，应用程序初始化器，做一些初始化的工作。
        4.ApplicationListener，应用程序事件(ApplicationEvent)监听器。
            这里应用程序事件有：
                1.应用程序启动事件(ApplicationStartedEvent)，
                2.失败事件(ApplicationFailedEvent)，
                3.准备事件(ApplicationPreparedEvent)等。
            应用程序事件监听器跟监听事件是绑定的。比如：
                1.ConfigServerBootstrapApplicationListener只跟ApplicationEnvironmentPreparedEvent事件绑定；
                2.LiquibaseServiceLocatorApplicationListener只跟ApplicationStartedEvent事件绑定；
                3.LoggingApplicationListener跟所有事件绑定等等；
    SpringApplication的运行
        1.SpringApplicationRunListeners类和SpringApplicationRunListener类
            SpringApplicationRunListeners内部持有SpringApplicationRunListener集合和1个Log日志类。用于SpringApplicationRunListener监听器的批量执行。
            SpringApplicationRunListener用于监听SpringApplication的run方法执行
        2.定义的5个步骤
            1.started(run方法执行的时候立马执行；对应事件的类型是ApplicationStartedEvent)
            2.environmentPrepared(ApplicationContext创建之前并且环境信息准备好的时候调用；对应事件的类型是ApplicationEnvironmentPreparedEvent)
            3.contextPrepared(ApplicationContext创建好并且在source加载之前调用一次；没有具体的对应事件)
            4.contextLoaded(ApplicationContext创建并加载之后并在refresh之前调用；对应事件的类型是ApplicationPreparedEvent)
            5.finished(run方法结束之前调用；对应事件的类型是ApplicationReadyEvent或ApplicationFailedEvent)    
        3.SpringApplicationRunListener目前只有一个实现类EventPublishingRunListener，它把监听的过程封装成了SpringApplicationEvent事件并让内部属性(属性名multicaster)ApplicationEventMulticaster接口的实现类SimpleApplicationEventMulticaster广播出去,广播出去的事件对象会被SpringApplication中的listener事件处理。
        所以说SpringApplicationRUnListener和ApplicationListener之间的关系是通过ApplicationEventMulticaster广播出去的SpringApplicationEvent所联系起来的。

关于SQL优化
    1.首先是分两个方向 一个是硬件方向  另外一个是软件方向
    2.硬件方面是 就是一些性能的东西 决定性因素在于 网卡IO吞吐量. 比如硬盘 比如现在就有一些用SSD做缓存,用HDD做数据仓库 然后就是内存的数据交换速度 再往上就是CPU的执行速度.
    3.所以一般在这里的优势是在一定的性能情况,如何把SQL执行效率进行最大化
    4.然后在目前呢,就是索引的问题,如何充分利用数据库索引.保证查询效率的性能,主要呢就是避免存储引擎放弃使用索引而进行全表扫描 这样的话会引起查询效率问题.也可能会触发表级锁,行级锁.
    5.然后就是注意的情况就是避免索引字段设置 为空字段 聚合函数 计算操作 not <> !=  数据类型转换   查询模糊匹配 比如like 字符串%
    6.然后就是在写操作的 比如经常嵌套多级子查询的 适当的拆成几步 先生成一些临时表  再进行关联操作
    8.还有就是union all的语句 用union
    9.where 要尽量避免对索引字段进行计算 就是说 避免使用 in, not in, or 或者having  比如可以用exist 和 not exist 来代替in 和in not in
    10.可以使用表连接代替exist having用where代替  如果无法代替就分成两步处理
    11.不要以字符串声明数字,要以数字格式声明字符值  否则会使索引无效 产生全表扫描
    12.关于排序 避免使用耗费资源的操作  带有DISTINCT,UNION,MINUS,INTERSECT,ORDER BY的SQL语句会启动SQL引擎 执行，耗费资源的排序(SORT)功能. DISTINCT需要一次排序操作, 而其他的至少需要执行两次排序
    13.再深入一些就是关于表设计方面,一个好的表设计会提高表的性能.也利于后期表的扩展 比如一些字段的配置,分库分表 业务相关的字段频率较多的进行优化

1) 索引的作用？和它的优点缺点是什么？
    答：索引就一种特殊的查询表，数据库的搜索引擎可以利用它加速对数据的检索。 其缺点是它减慢了数据Insert或update的速度，同时也增加了数据库的尺寸大小。
2) 了解过常见的Web分页查询功能，在后台生成的 SQL 语句是怎样的么? 不同的数据库，分页查询的实现机制是一样的么？
    答：不同的数据库，分页查询的实现机制不一样, MySQL使用 Limit n,m 子句, Oracle使用ROWNUM虚拟列， SqlServer使用 ROW_NUMBER ()函数.
3) 列举SQL聚合函数: 
    答：SUM、AVG、COUNT、MAX 和 MIN
4) 分组查询： 知道 having 子句么？ 一般什么时候使用? 
    答：当需要加上过滤条件，过滤条件又是聚集函数那就要使用having
5) select语句中的子查询： 知道select语句中的查询么？
    答：子查询是用于返回将被用于在主查询作为条件的数据，以进一步限制要检索的数据。

redis存储类型
    1.String（字符串）
    2.List（列表）
    3.Hash（字典）
    4.Set（集合）
    5.Sorted Set（有序集合）

dubbo需要涉及到哪些技术?
	1.使用zk实现服务注册中心
	2.使用Netty实现Dubbo的客户端与服务端
	3.需要优化代码性能设计到多线程和设计模式
	4.传递对象需要设计序列化和反序列化
	5.Java反射和自定义注解技术


Java锁 公平锁 非公平锁 可重入锁 递归锁 自旋锁的理解?
非公平锁和公平锁
公平锁 是指多个线程按照申请锁的顺序来获取锁
非公平锁 是指多个线程获取锁的顺序并不是按照申请锁的顺序,有可能后申请的线程比先申请的线程优先获取锁.
    在高并发情况下,有可能造成优先级反转或者饥饿现象.

Lock  lock = new ReenrantLock（）；//可重入锁，默认为非公平锁，非公平锁的优点吞吐量比公平锁大，对于synchronized而言，也是一种非公平锁

可重入锁又名递归锁（ReenrantLock）
