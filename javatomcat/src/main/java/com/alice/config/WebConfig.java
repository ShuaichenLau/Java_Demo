package com.alice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * SpringMVC的配置中心
 * 2019-11-21 03:27:50
 * @EnableWebMvc 开启springmvc 功能<br>
 * @author scliuk
 */
@SuppressWarnings("deprecation")
@EnableWebMvc   //开启SpringMVC
@Configuration  //配置
@ComponentScan(basePackages = {"com.alice.controller"})
public class WebConfig extends WebMvcConfigurerAdapter {

    // springboot 整合jsp 最好是war
    // 需要配置视图转换器
    // 创建SpringMVC视图解析器
    //需要配置视图转换器
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        // 可以在JSP页面中通过${}访问beans
        viewResolver.setExposeContextBeansAsAttributes(true);
        return viewResolver;
    }
}
