package com.smart.sso.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @FileName: Application
 * @Author: longer 199429
 * @Date: 2019-08-06 10:39
 * @Description: ${DESCRIPTION}
 */
@SpringBootApplication
@MapperScan("com.smart.**.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
