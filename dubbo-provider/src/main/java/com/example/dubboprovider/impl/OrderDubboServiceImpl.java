package com.example.dubboprovider.impl;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.OrderDubboService;
import org.apache.dubbo.config.annotation.Service;


@Service(version = "1.0.1")
public class OrderDubboServiceImpl implements OrderDubboService {
    
    @Override
    public RpcResult<OrderDomain> getOrder() {
        return RpcResult.success(new OrderDomain("1", "10086"));
    }
}
