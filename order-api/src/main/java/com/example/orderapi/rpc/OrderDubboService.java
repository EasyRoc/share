package com.example.orderapi.rpc;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;

public interface OrderDubboService {

    /**
     * 获取订单信息
     * @return
     */
    RpcResult<OrderDomain> getOrder();

    /**
     * 上下文信息
     * @return
     */
    RpcResult<OrderDomain> getRpcContent();

    /**
     * 测试重试次数
     * @return
     */
    RpcResult<OrderDomain> retries(Integer value) throws Exception;
}
