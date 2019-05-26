package com.alice.spring.ext;

import com.alice.spring.extannotation.ExtResource;
import com.alice.spring.extannotation.ExtService;
import com.alice.utils.ClassUtil;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 依赖注入注解原理
 */
public class ExtClassPathXmlApplicationContextAttriAssign {

    private String packageName;

    private ConcurrentHashMap<String, Object> beans = null;

    //扫包范围
    public ExtClassPathXmlApplicationContextAttriAssign(String packageName) throws Exception {
        // 初始化
        this.packageName = packageName;
    }

    //初始化调试
    public void initEntryField() throws Exception {
        // 遍历所有的bean容器对象
        Set<Map.Entry<String, Object>> entries = beans.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            // 判断属性上面是否有加注解
            Object obj = entry.getValue();
            attriAssign(obj);
        }
    }

    // 3.使用Java的反射机制初始化
    public Object getBean(String beanId) throws Exception {

        List<Class> classExisAnnotation = findClassExisAnnotation();

        if(classExisAnnotation == null || classExisAnnotation.isEmpty()){
            throw new Exception("没有需要初始化的Bean");
        }
        beans = initInstance(classExisAnnotation);
        if(beans == null || beans.isEmpty()){
            throw new Exception("初始化bean为空");
        }
        Object o = beans.get(beanId);
        attriAssign(o);
        return o;
    }

    //初始化对象
    protected ConcurrentHashMap<String, Object>  initInstance(List<Class> listClassesAnnotation) throws Exception {
        ConcurrentHashMap<String, Object> stringObjectConcurrentHashMap = new ConcurrentHashMap<String, Object>();
        for (Class aClass : listClassesAnnotation) {
            Object newInstance = aClass.newInstance();
            String beanId = ClassUtil.toLowerCaseFirstOne(aClass.getSimpleName());
            stringObjectConcurrentHashMap.put(beanId,newInstance);
        }

        return stringObjectConcurrentHashMap;
    }

    protected List<Class> findClassExisAnnotation() throws Exception {

        if(StringUtils.isEmpty(packageName)){
            throw new Exception("扫包地址不能为弄");
        }
        List<Class<?>> classes = ClassUtil.getClasses(packageName);
        List<Class> exisClassByPackageName = Lists.newArrayList();

        for (Class<?> aClass : classes) {
            ExtService declaredAnnotation = (ExtService)aClass.getDeclaredAnnotation(ExtService.class);
            if (declaredAnnotation != null){
                exisClassByPackageName.add(aClass);
                continue;
            }
        }

        return exisClassByPackageName;
    }


    //  依赖注入注解原理
    public void attriAssign(Object obj) throws Exception {
        //  使用反射机制 获取当前类的所有属性
        Class<?> classInfo = obj.getClass();
        Field[] declaredFields = classInfo.getDeclaredFields();
        //  判断当前类是否有存在这个注解
        for (Field field : declaredFields) {
            ExtResource annotation = field.getAnnotation(ExtResource.class);
            if(annotation != null){
                String beanId = field.getName();
                Object bean = getBean(beanId);
                if (bean != null){
                    //  默认使用属性名称 查找bean容器对象  1.参数 当前对象 2.参数给属性赋值
                    field.setAccessible(true);  //允许访问私有属性
                    field.set(obj,bean);
                }
            }
        }

    }


}
