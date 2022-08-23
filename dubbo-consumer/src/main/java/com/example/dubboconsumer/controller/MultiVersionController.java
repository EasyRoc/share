package com.example.dubboconsumer.controller;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.MultiVersionService;
import com.example.orderapi.rpc.OrderDubboService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.service.EchoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/version")
public class MultiVersionController {

    @Reference(version = "1.0.0", check = false)
    private MultiVersionService multiVersionService1;

    @Reference(version = "2.0.0", check = false)
    private MultiVersionService multiVersionService2;

    @Reference(version = "1.0.1", check = false)
    private OrderDubboService orderDubboService;

    /**
     * 多版本1测试
     * @return
     */
    @GetMapping("testVersion1")
    public RpcResult testVersion1() {
        RpcResult result = multiVersionService1.versionTest();
        return result;
    }

    /**
     * 多版本2测试
     * @return
     */
    @GetMapping("testVersion2")
    public RpcResult testVersion2() {
        return multiVersionService2.versionTest();
    }

    /**
     * dubbo上下文的测试
     * @return
     */
    @GetMapping("testRpcContent")
    public RpcResult testRpcContent(){
        RpcContext.getContext().setAttachment("client","消费端向服务端传递的参数");
        orderDubboService.getRpcContent();
        return RpcResult.success(RpcContext.getServerContext().getAttachment("provider"));
    }



    /**
     * 回声测试
     * @return
     */
    @GetMapping("echoes")
    public RpcResult echoesTest(){
        EchoService echoService = (EchoService) multiVersionService1;
        return RpcResult.success(echoService.$echo("OK"));
    }


}
