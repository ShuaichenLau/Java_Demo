package com.alice.springmvc.servlet;

import com.alice.spring.extannotation.ExtController;
import com.alice.utils.ClassUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义前端控制器
 * 2019年5月26日23:24:45
 * @author liusc
 */
public class ExtDispathcherServlet extends HttpServlet {



    //springmvc容器对象 key 类名ID    value  对象
    private ConcurrentHashMap<String, Object> sppringmvcBeans = new ConcurrentHashMap<String, Object>();

    //springmvc容器对象 key 请求地址    value  类
    private ConcurrentHashMap<String, Object> urlBeans = new ConcurrentHashMap<String, Object>();

    //springmvc容器对象 key 请求地址    value  方法名称
    private ConcurrentHashMap<String, Object> urlBMethods = new ConcurrentHashMap<String, Object>();


    @Override
    public void init(ServletConfig config) throws ServletException {
        //将对应路径的controller全部扫描出来
        List<Class<?>> classes = ClassUtil.getClasses("com.alice.controller");

        try {
            findClassMVCAnnotation(classes);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    public void findClassMVCAnnotation(List<Class<?>> classes) throws IllegalAccessException, InstantiationException {

        for (Class<?> classInfo : classes) {
            ExtController declaredAnnotation = classInfo.getDeclaredAnnotation(ExtController.class);
            if(declaredAnnotation != null){
                String beanId = ClassUtil.toLowerCaseFirstOne(classInfo.getSimpleName());
                Object object = classInfo.newInstance();
                sppringmvcBeans.put(beanId,object);
            }

        }

    }
}
