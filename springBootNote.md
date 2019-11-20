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

分析SpringBoot分析原理


SpringMVC无配置文件,采用注解方式启动
步骤:
    a.加载Spring容器 加载DispatcherServlet