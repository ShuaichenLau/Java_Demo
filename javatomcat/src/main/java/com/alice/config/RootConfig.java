package com.alice.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 根配置
 * @author liusc
 * 2019-11-21 15:15:40
 */
@Configuration
@ComponentScan(basePackages = {"com.alice"})
public class RootConfig {
}
