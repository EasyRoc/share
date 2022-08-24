package com.example.dubboconsumer.controller;

import com.example.orderapi.result.RpcResult;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generic")
public class GenericCallController {

    @GetMapping("genericTest")
    public RpcResult getOrder() {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        reference.setApplication(new ApplicationConfig("order-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://47.97.69.18:2181"));
        reference.setInterface("com.example.orderapi.rpc.GenericCallService");
        reference.setVersion("1.0.0");
        reference.setGeneric(true);
        GenericService genericService = reference.get();
        //方法名；参数类型；参数值
        Object result = genericService.$invoke("genericCall", new String[]{}, new Object[]{});
        return RpcResult.success(result);
    }
}
