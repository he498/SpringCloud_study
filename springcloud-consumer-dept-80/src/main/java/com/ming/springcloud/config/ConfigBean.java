package com.ming.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.css.CSSImportRule;

@Configuration
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule 轮询（默认使用这个）
    //RandomRule 随机
    //AvailabilityFilteringRule : 会先过滤掉访问故障的服务，对剩下的进行轮询
    //RetryRule 会按照轮询获取服务，如果服务获取失败，则会在指定的时间内进行重试
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }


}
