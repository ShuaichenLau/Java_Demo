package com.alice.springmvc.servlet;

import com.alice.spring.extannotation.ExtController;
import com.alice.spring.extannotation.ExtRequestMapping;
import com.alice.utils.ClassUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 *  2019年5月26日18:12:46
 *  自定义前端控制器
 * @author liusc
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
public class ExtDispathcherServlet extends HttpServlet {

    //springmvc容器对象 key 类名ID    value  对象
    private ConcurrentHashMap<String, Object> sppringmvcBeans = new ConcurrentHashMap<String, Object>();

    //springmvc容器对象 key 请求地址    value  类
    private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<String, Object>();

    //springmvc容器对象 key 请求地址    value  方法名称
    private ConcurrentHashMap<String, String> urlBMethods = new ConcurrentHashMap<String, String>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        //将对应路径的controller全部扫描出来
        List<Class<?>> classes = ClassUtil.getClasses("com.alice.controller");

        try {
            findClassMVCAnnotation(classes);
            handlerMapping();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
        System.out.println("com.alice.springmvc.servlet.ExtDispathcherServlet.doGet(HttpServletRequest, HttpServletResponse)");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  ##################处理请求##################
        //  1.获取请求url地址
        String requestURI = req.getRequestURI();
        if(requestURI.isEmpty()){
            return ;
        }
        //  2.从Map集合中获取控制对象
        Object obj = urlBeans.get(requestURI);
        if(obj == null){
            resp.getWriter().println("url not found 404");
            return ;
        }
        //  3.使用Url地址获取方法
        String methodName = urlBMethods.get(requestURI);
        if(methodName == null || methodName.isEmpty()){
            resp.getWriter().println("method not found 404");
            return ;
        }
        //  4.使用Java反射机制调用方法
        String resultPage = (String)methodInvoke(obj, methodName);
        resp.getWriter().println(resultPage);
        //  5.使用Java反射机制获取"方法返回结果'
        //  6.使用视图转换器渲染给页面展示

    }

    public Object methodInvoke(Object obj,String methodName){
        try {
            Class<?> classInfo = obj.getClass();
            Method method = classInfo.getMethod(methodName);
            Object result = method.invoke(obj);
            return result;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }





    //将扫包范围所有的类,注入到SpringMVC容器里面, 存放在Map集合中key为默认类名小写 ,value对象
    public void findClassMVCAnnotation(List<Class<?>> classes) throws IllegalAccessException, InstantiationException {
        for (Class<?> classInfo : classes) {
            ExtController declaredAnnotation = classInfo.getDeclaredAnnotation(ExtController.class);
            if(declaredAnnotation != null){
                String beanId = ClassUtil.toLowerCaseFirstOne(classInfo.getSimpleName());
                Object newInstance = ClassUtil.newInstance(classInfo);
                sppringmvcBeans.put(beanId,newInstance);
            }
        }
    }

    //将URL映射和方法进行关联  处理器映射器
    public void handlerMapping(){

        //  1.遍历SpringmvcBeans容器 判断类上属性是否有url映射注解
        //  2.遍历所有的方法上是否有url映射注解

        //  获取bean对象
        for (Map.Entry<String, Object> entry : sppringmvcBeans.entrySet()) {
            Object entryValue = entry.getValue();
            Class<?> entryValueClass = entryValue.getClass();
            ExtRequestMapping declaredAnnotation = entryValueClass.getDeclaredAnnotation(ExtRequestMapping.class);
            String baseUrl = "";

            if(declaredAnnotation != null){
                baseUrl = declaredAnnotation.value();
            }

            //  判断方法上是否加有url映射地址
            Method[] declaredMethods = entryValueClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
                ExtRequestMapping declaredAnnotation1 = declaredMethod.getDeclaredAnnotation(ExtRequestMapping.class);
                if(declaredAnnotation1 != null){
                    //  拼接方法url
                    String methodUrl = baseUrl + declaredAnnotation1.value();

                    //  SpringMVC 容器对象 key:请求地址, value:请求的类对象
                    urlBeans.put(methodUrl,entryValue);
                    // SpringMVC 容器对象 key:请求地址 value:方法名称
                    urlBMethods.put(methodUrl,declaredMethod.getName());

                }
            }


        }
    }

}
