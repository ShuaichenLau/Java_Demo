package com.alice.exercise.component;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MapCache<K,V> {

    // 存放缓存
    public Map<K,V> map = new ConcurrentHashMap<K,V>();


    public void put(K k, V v){
        map.put(k,v);
    }


    public V get(K k){
        return map.get(k);
    }

    public void remove(K k){
        map.remove(k);
    }
}
