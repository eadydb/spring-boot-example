package com.eadydb.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by eadydb on 17-5-4.
 */
@SpringBootApplication
@MapperScan(basePackages = "com.eadydb.boot.mapper")
public class BootSecurityKaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootSecurityKaptchaApplication.class, args);
    }
}
