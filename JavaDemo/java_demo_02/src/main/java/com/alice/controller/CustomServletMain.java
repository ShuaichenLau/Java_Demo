package com.alice.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 代码配置tomcat
 */
@SpringBootApplication
public class CustomServletMain {


    @Component
    public static class CustomServletContainer implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

            configurableEmbeddedServletContainer.setPort(8888);
            configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
            configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CustomServletContainer.class,args);
    }

}
