package com.liang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liang.modules.sys.dao")
public class TestBlog01Application {

    public static void main(String[] args) {
        SpringApplication.run(TestBlog01Application.class, args);
    }
}
