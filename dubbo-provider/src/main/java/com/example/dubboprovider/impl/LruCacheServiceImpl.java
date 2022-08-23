package com.example.dubboprovider.impl;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.LruCacheService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class LruCacheServiceImpl implements LruCacheService {
    @Override
    public RpcResult<OrderDomain> getLruCache() {
        System.out.println("*******111******");
        return RpcResult.success(new OrderDomain("1","1"));
    }
}
