package com.msc.usermicroserv;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@MapperScan(basePackages = "com.msc.usermicroserv.dao.mapper")
public class UserMicroservApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserMicroservApplication.class, args);
    }

}
