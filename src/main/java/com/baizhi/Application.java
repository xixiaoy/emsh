package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.baizhi.dao")  //指定创建dao实现类对象
public class Application {
    public static void main(String[] args) {
        //通该主函数SpringBoot应用
        SpringApplication.run(Application.class,args);
    }
}
