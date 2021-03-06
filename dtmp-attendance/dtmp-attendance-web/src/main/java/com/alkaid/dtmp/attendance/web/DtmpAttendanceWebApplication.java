package com.alkaid.dtmp.attendance.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class DtmpAttendanceWebApplication {
    public static void main(String [] args) {
        SpringApplication.run(DtmpAttendanceWebApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/work/overtime/getList").allowedOrigins("http://localhost:9000");
                registry.addMapping("/work/overtime/get").allowedOrigins("http://localhost:9000");
                registry.addMapping("/work/overtime/delete").allowedOrigins("http://localhost:9000");
                registry.addMapping("/work/overtime/add").allowedOrigins("http://localhost:9000");
            }
        };
    }
}
