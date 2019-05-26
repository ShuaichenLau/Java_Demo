package com.alice;

import java.util.concurrent.ConcurrentHashMap;

/**
 *  2019年5月26日18:12:46
 *
 *
 * 1、  首先用户发送请求——>DispatcherServlet，前端控制器收到请求后自己不进行处理，而是委托给其他的解析器进行处理，作为统一访问点，进行全局的流程控制；
 *
 * 2、  DispatcherServlet——>HandlerMapping，HandlerMapping 将会把请求映射为 HandlerExecutionChain 对象（包含一个 Handler 处理器（页面控制器）对象、多个 HandlerInterceptor 拦截器）对象，通过这种策略模式，很容易添加新的映射策略；
 *
 * 3、  DispatcherServlet——>HandlerAdapter，HandlerAdapter 将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用，从而很容易支持很多类型的处理器；
 *
 * 4、  HandlerAdapter——>处理器功能处理方法的调用，HandlerAdapter 将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理；并返回一个 ModelAndView 对象（包含模型数据、逻辑视图名）；
 *
 * 5、  ModelAndView 的逻辑视图名——> ViewResolver， ViewResolver 将把逻辑视图名解析为具体的 View，通过这种策略模式，很容易更换其他视图技术；
 *
 * 6、  View——>渲染，View 会根据传进来的 Model 模型数据进行渲染，此处的 Model 实际是一个 Map 数据结构，因此很容易支持其他视图技术；
 *
 * 7、  返回控制权给 DispatcherServlet，由 DispatcherServlet 返回响应给用户，到此一个流程结束。
 * ---------------------
 * 作者：chestnut_lan
 * 来源：CSDN
 * 原文：https://blog.csdn.net/zhaolijing2012/article/details/41596803
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 *
 * 1、  DispatcherServlet 在 web.xml 中的部署描述，从而拦截请求到 Spring Web MVC
 *
 * 2、  HandlerMapping 的配置，从而将请求映射到处理器
 *
 * 3、  HandlerAdapter 的配置，从而支持多种类型的处理器
 *
 * 4、  ViewResolver 的配置，从而将逻辑视图名解析为具体视图技术
 *
 * 5、  处理器（页面控制器）的配置，从而进行功能处理 
 * ---------------------
 * 作者：chestnut_lan
 * 来源：CSDN
 * 原文：https://blog.csdn.net/zhaolijing2012/article/details/41596803
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 *
 *
 *  手写SpringMVC原理分析
 *
 *  1.创建前端控制器 ExtDispatcherServlet拦截所有请求
 *  SpringMVC 基于Servlet实现
 *
 *  2.  初始化操作重写servlet init方法
 *  2.1 将扫包范围所有的类,注入到SpringMVC容器里面, 存放在Map集合中key为默认类名小写 ,value对象
 *  2.2 将URL映射和方法进行关联
 *  2.2.1   判断类上是否有注解 使用Java反射机制循环遍历方法,判断方法上是否存在注解 进行封装url和方法对应存入集合中
 *
 *  3.  处理请求 重写get方法 和post方法
 *      3.1获取请求url,从urlBeans集合获取实例对象,获取成功实例对象后,调用urlMethods集合获取方法名称 使用反射机制执行
 *
 *
 *
 */
public class TestMVC {




}
