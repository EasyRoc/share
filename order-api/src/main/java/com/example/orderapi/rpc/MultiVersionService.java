package com.example.orderapi.rpc;

import com.example.orderapi.result.RpcResult;

/**
 * 多版本控制
 */
public interface MultiVersionService {

    /**
     * 多版本测试
     * @return
     */
    RpcResult<String> versionTest();
}
