package com.alice;

import com.alice.datasources.DynamicDataSourceConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Import;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,org.activiti.spring.boot.SecurityAutoConfiguration.class, SecurityAutoConfiguration.class})
@Import({DynamicDataSourceConfig.class})
public class Bootstrap {

    public static void main(String[] args) {

    }
}
