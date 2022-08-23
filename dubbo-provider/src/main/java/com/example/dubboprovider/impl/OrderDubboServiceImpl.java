package com.example.dubboprovider.impl;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.OrderDubboService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;


@Service(version = "1.0.1")
public class OrderDubboServiceImpl implements OrderDubboService {
    
    @Override
    public RpcResult<OrderDomain> getOrder() {
        return RpcResult.success(new OrderDomain("1", "10086"));
    }

    @Override
    public RpcResult<OrderDomain> getRpcContent() {
        System.out.println(RpcContext.getContext().getAttachment("client"));
        RpcContext.getServerContext().setAttachment("provider","服务端向消费端返回的参数");
        return RpcResult.success();
    }
}
