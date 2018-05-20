package com.alkaid.dtmp.sso.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@SpringBootApplication
@ComponentScan(basePackages = "com.alkaid.dtmp")
//@MapperScan(basePackages = {"com.alkaid.dtmp.sso.dao.mapper","com.alkaid.dtmp.sso.service.mapper"})
@MapperScan(basePackages = "com.alkaid.dtmp.sso.dao.mapper")
public class DtmpSsoServiceApplication {
    public static void main(String [] args) {
        SpringApplication.run(DtmpSsoServiceApplication.class, args);
    }
}
