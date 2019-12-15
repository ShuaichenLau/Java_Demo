package com.alice.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;

@Service
public class OrderService {


    public boolean addOrder(){
        System.out.println("正在操作DB .......");

        return true;
    }

}
