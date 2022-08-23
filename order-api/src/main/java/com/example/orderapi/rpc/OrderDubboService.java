package com.example.orderapi.rpc;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;

public interface OrderDubboService {
    RpcResult<OrderDomain> getOrder();

    /**
     * 上下文信息
     * @return
     */
    RpcResult<OrderDomain> getRpcContent();
}
