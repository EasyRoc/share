package com.example.orderapi.rpc;

import com.example.orderapi.domain.OrderDomain;
import com.example.orderapi.result.RpcResult;

public interface LruCacheService {

    /**
     * 结果缓存
     * @return
     */
    RpcResult<OrderDomain> getLruCache();
}
