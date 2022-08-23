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

    @Autowired
    private ReferenceConfig<GenericService> referenceConfig;

    @GetMapping("genericTest")
    public RpcResult getOrder() {
        GenericService genericService = referenceConfig.get();
        //方法名；参数类型；参数值
        Object result = genericService.$invoke("genericCall", new String[]{}, new Object[]{});
        return RpcResult.success(result);
    }
}
