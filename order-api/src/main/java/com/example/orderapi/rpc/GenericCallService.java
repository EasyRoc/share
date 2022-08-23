package com.example.orderapi.rpc;

import com.example.orderapi.domain.BaseDomain;
import com.example.orderapi.result.RpcResult;

/**
 * 泛化调用测试
 */
public interface GenericCallService {

    /**
     * 泛化调用
     * @return
     */
    RpcResult<BaseDomain> genericCall();
}
