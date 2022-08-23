package com.example.dubboprovider.impl;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.MultiVersionService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "2.0.0", interfaceClass = MultiVersionService.class)
public class MultiVersion2ServiceImpl implements MultiVersionService {
    @Override
    public RpcResult<String> versionTest() {
        return RpcResult.success("002");
    }
}
