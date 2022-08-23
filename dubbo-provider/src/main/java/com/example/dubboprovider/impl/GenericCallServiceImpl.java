package com.example.dubboprovider.impl;

import com.example.orderapi.domain.BaseDomain;
import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.GenericCallService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0",interfaceClass = GenericCallService.class)
public class GenericCallServiceImpl implements GenericCallService {
    @Override
    public RpcResult<BaseDomain> genericCall() {
        return RpcResult.success(new BaseDomain("泛化调用"));
    }
}
