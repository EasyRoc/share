package com.example.dubboconsumer.controller;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.OrderDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderConsumerController {

    @Reference(version = "1.0.1", check = false, retries = 4)
    OrderDubboService orderDubboService;

    @GetMapping("getOrder")
    public RpcResult getOrder() {
        return orderDubboService.getOrder();
    }

    @GetMapping("retries")
    public RpcResult retries(@RequestParam Integer value) throws Exception {
        return orderDubboService.retries(value);
    }
}
