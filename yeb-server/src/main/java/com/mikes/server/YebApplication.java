package com.mikes.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mikes
 * @date 2021/7/21 12:51
 * @param 
 * @return 
 */
@SpringBootApplication
@MapperScan("com.mikes.server.mapper")
public class YebApplication {
    public static void main(String[] args){
        SpringApplication.run(YebApplication.class,args);
    }
}
