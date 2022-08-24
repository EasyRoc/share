package com.example.dubboprovider.impl;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.OrderDubboService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

import java.util.Random;


@Service(version = "1.0.1")
public class OrderDubboServiceImpl implements OrderDubboService {

    @Override
    public RpcResult<OrderDomain> getOrder() {
        return RpcResult.success(new OrderDomain("1", "10086"));
    }

    @Override
    public RpcResult<OrderDomain> getRpcContent() {
        System.out.println(RpcContext.getContext().getAttachment("client"));
        RpcContext.getServerContext().setAttachment("provider", "服务端向消费端返回的参数");
        return RpcResult.success();
    }

    @Override
    public RpcResult<OrderDomain> retries(Integer value) throws Exception {
        System.out.println("测试重试次数");
        Thread.sleep(5000);
        return RpcResult.success();

    }
}
