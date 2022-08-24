package com.example.dubboprovider.impl;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.DirectConnectService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.0")
public class DirectConnectServiceImpl implements DirectConnectService {
    @Override
    public RpcResult<String> directConnect() {
        return RpcResult.success("直连测试");
    }
}
