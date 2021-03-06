package com.alice.spring.ext;

import com.alice.spring.extannotation.ExtService;
import com.alice.utils.ClassUtil;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 手写SpringIOC注解版本
 * 2019年5月25日16:58:25
 */
public class ExtClassPathXmlApplicationContext {

    private String packageName;

    private ConcurrentHashMap<String, Class<?>> beans = null;

    //扫包范围
    public ExtClassPathXmlApplicationContext(String packageName) throws Exception {
        // 初始化
        this.packageName = packageName;
        beans = new ConcurrentHashMap<String, Class<?>>();
        initInstance();
    }

    // 3.使用Java的反射机制初始化
    public Object getBean(String beanId) throws Exception {
        if(StringUtils.isEmpty(beanId)){
            throw new Exception("beanId参数不能为null");
        }
        Class<?> classInfo = beans.get(beanId);
        return classInfo.newInstance();
    }

    /**
     * 初始化对象
     * @throws Exception
     */
    protected void initInstance() throws Exception {
        // 1.使用Java反射机制扫包 获取当前包下所有的类
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        // 2判断类上是否存在注入bean的注解
        ConcurrentHashMap<String, Class<?>> classExisAnnotation = findClassExisAnnotation(classes);
        if (classExisAnnotation == null || classExisAnnotation.isEmpty()){
            throw new Exception("该包下没有任何类加上注解");
        }
    }

    /**
     * 判断类是否有ExtService注解
     * @param classes
     * @return
     */
    protected ConcurrentHashMap<String, Class<?>> findClassExisAnnotation(List<Class<?>> classes) {
        // 判断类上是否存在注入bean注解
        for (Class<?> classInfo : classes) {
            // 判断类是否有注解
            ExtService annotation = classInfo.getAnnotation(ExtService.class);
            if (annotation != null) {
                // beanId 类名小写
                String className = classInfo.getSimpleName();
                beans.put(ClassUtil.toLowerCaseFirstOne(className),classInfo);
                continue;
            }

        }
        return beans;
    }


}
