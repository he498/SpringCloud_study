package com.ming.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


//Ribbon 和 Eureka整合后客户端可以直接调用不用担心IP地址和端口号
@SpringBootApplication(scanBasePackages = "com.ming.springcloud")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.ming.springcloud"})
public class FeignDeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
