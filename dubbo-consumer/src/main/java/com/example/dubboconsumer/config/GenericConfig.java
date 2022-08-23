package com.example.dubboconsumer.config;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenericConfig {

    @Bean
    public ReferenceConfig<GenericService> setReferenceConfig(){
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(new ApplicationConfig("order-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://47.97.69.18:2181"));
        reference.setInterface("com.example.orderapi.rpc.GenericCallService");
        reference.setVersion("1.0.0");
        reference.setGeneric(true);
        return reference;
    }
}
