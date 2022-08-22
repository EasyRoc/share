package com.example.orderapi.rpc;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;

public interface OrderDubboService {
    RpcResult<OrderDomain> getOrder();
}
