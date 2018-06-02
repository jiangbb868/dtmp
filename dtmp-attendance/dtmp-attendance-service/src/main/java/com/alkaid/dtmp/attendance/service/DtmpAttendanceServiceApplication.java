package com.alkaid.dtmp.attendance.service;

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
@MapperScan(basePackages = "com.alkaid.dtmp.attendance.dao.mapper")
public class DtmpAttendanceServiceApplication {
    public static void main(String [] args) {
        SpringApplication.run(DtmpAttendanceServiceApplication.class, args);
    }
}
