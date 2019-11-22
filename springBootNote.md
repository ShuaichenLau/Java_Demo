1.什么是SpringBoot框架
    SpringBoot是一个快速整合第三方框架,简化xml,完全采用注解化.
    内置http服务器(jetty和tomcat undertow) 最终是以Java应用程序执行的.

    重点:快速整合第三方框架  内置http服务器

SpringBoot  快速开发框架,快速整合三方框架(maven子父依赖关系)
SpringCloud 微服务框架 rpc远程框架调用
SpringCloud 底层依赖于SpringBoot实现微服务接口
(SpringBoot Web组件集成SpringMVC框架),采用SpringMVC书写接口

微服务==>http接口 服务治理 注册中心 客户端调用 网关 断路器...

    注解在什么时候产生?Spring3.0以上(提供注解)
    SpringMVC内置注解加载整个SpringMVC容器
    
    Java语言操作SpringMVC配置初始化
    使用Java代码编写SpringMVC配置初始化
    Java语言创建tomcat 加载class


Logback是log4j框架的作者开发的新一代日志框架，它效率更高、能够适应诸多的运行环境，同时天然支持SLF4J。
默认情况下，Spring Boot会用Logback来记录日志，并用INFO级别输出到控制台。在运行应用程序和其他例子时，你应该已经看到很多INFO级别的日志了。


分析SpringBoot分析原理


SpringMVC的请求流程
    ⑴ 用户发送请求至前端控制器DispatcherServlet
    ⑵ DispatcherServlet收到请求调用HandlerMapping处理器映射器。
    ⑶ 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet。
    ⑷ DispatcherServlet通过HandlerAdapter处理器适配器调用处理器
    ⑸ 执行处理器(Controller，也叫后端控制器)。
    ⑹ Controller执行完成返回ModelAndView
    ⑺ HandlerAdapter将controller执行结果ModelAndView返回给DispatcherServlet
    ⑻ DispatcherServlet将ModelAndView传给ViewReslover视图解析器
    ⑼ ViewReslover解析后返回具体View
    ⑽ DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）。
    ⑾ DispatcherServlet响应用户。


DNS解析IP过程
    1.浏览器会检查缓存中有没有这个域名对应的解析过的IP地址.如果缓存中有,这个解析过程就会结束.
        浏览器缓存域名也是有限制的,不仅浏览器缓存大小有限制的,而且缓存的时间也有限制,通常情况下为几分钟到几小时不等.
        域名被缓存的时间限制可以通过TTL属性来设置.这个缓存时间太长和太短都不好.
        如果域名解析的IP发生了变化,会导致被客户端缓存的域名无法解析到变化后的IP地址,以致于该域名不能正常解析
        如果设置时间太短,会导致用户每次访问网站都要重新解析一次域名.
    2.如果用户浏览器缓存中没有数据,浏览器会查找操作系统缓存中是否有这个域名对应的DNS解析结果.
        其实操作系统也有域名解析的过程,windows中有hosts文件来设置,linux中在/etc/hosts文件来设置.(域名劫持)
    3.如果本地无法解析时,就要用到配置的DNS服务器地址了,这个DNS服务器地址一般都会缓存域名解析结果,当然缓存时间也是受到域名的失效时间来控制的.大约80%的域名解析请求到这里就会结束了.LDNS 本地区域域名服务器
    4.如果LDNS本地区域域名服务器没有命中,则直接到Root Server域名服务器请求解析.
    5.Root Server 根域名解析服务器返回本地域名服务器一个所查询的主域名服务器(gTLD Server)地址.gTLD是国际顶级域名服务器,如.com、.cn、.org等.
    6.本地域名服务器LDNS再向上一步返回的gTLD服务器发送请求
    7.接受请求的gTLD服务器查找并返回此域名对应的Name Server域名服务器的地址，这个Name Server通常就是用户注册的域名服务器，例如用户在某个域名服务提供商申请的域名，那么这个域名解析任务就由这个域名提供商的服务器来完成
    8.Name Server域名服务器会查询存储的域名和IP映射关系表,在正常的情况下根据域名查到目标IP地址.连同一个TTL值返回给DNS域名服务器
    9.返回该域名对应的IP和TTL值 LDNS会缓存这个域名和IP的对应关系.缓存时间由TTL值来控制.
    10.把解析的结果返回给用户,用户根据TTL值缓存在本地系统缓存中,域名解析过程结束
    
    