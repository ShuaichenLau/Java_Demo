package com.alice.beanCache;

import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SpringBeanCache {

    public final static Object NULL_OBJECT = null;

    /**
     * 一级缓存 完成初始化的单例对象的cache（一级缓存）
     */
    private final Map singletonObjects = new ConcurrentHashMap(256);

    /**
     * 三级缓存 进入实例化阶段的单例对象工厂的cache （三级缓存）
     */
    private final Map singletonFactories = new HashMap(16);

    /**
     * 二级缓存 完成实例化但是尚未初始化的，提前暴光的单例对象的Cache （二级缓存）
     */
    private final Map earlySingletonObjects = new HashMap(16);

    private final List registeredSingletons = new ArrayList();


    protected Object getSingleton(String beanName, boolean allowEarlyReference) {
        Object singletonObject = this.singletonObjects.get(beanName);
        //isSingletonCurrentlyInCreation()判断当前单例bean是否正在创建中
        if (singletonObject == null && isSingletonCurrentlyInCreation(beanName)) {
            synchronized (this.singletonObjects) {
                singletonObject = this.earlySingletonObjects.get(beanName);
                //allowEarlyReference 是否允许从singletonFactories中通过getObject拿到对象
                if (singletonObject == null && allowEarlyReference) {
                    ObjectFactory<?> singletonFactory = (ObjectFactory)this.singletonFactories.get(beanName);
                    if (singletonFactory != null) {
                        singletonObject = singletonFactory.getObject();
                        //从singletonFactories中移除，并放入earlySingletonObjects中。
                        //其实也就是从三级缓存移动到了二级缓存
                        this.earlySingletonObjects.put(beanName, singletonObject);
                        this.singletonFactories.remove(beanName);
                    }
                }
            }
        }
        return (singletonObject != NULL_OBJECT ? singletonObject : null);
    }

    /**
     * isSingletonCurrentlyInCreation()判断当前单例bean是否正在创建中
     * @param beanName
     * @return
     */
    private boolean isSingletonCurrentlyInCreation(String beanName){
        return true;
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        Assert.notNull(singletonFactory, "Singleton factory must not be null");
        synchronized (this.singletonObjects) {
            if (!this.singletonObjects.containsKey(beanName)) {
                this.singletonFactories.put(beanName, singletonFactory);
                this.earlySingletonObjects.remove(beanName);
                this.registeredSingletons.add(beanName);
            }
        }
    }

}
