package com.example.orderapi.rpc;


import com.example.orderapi.result.RpcResult;

public interface DirectConnectService {

    /**
     * 直连提供者
     * @return
     */
    RpcResult<String> directConnect();
}
