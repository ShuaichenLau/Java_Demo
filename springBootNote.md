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

