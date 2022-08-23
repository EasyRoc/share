package com.example.dubboconsumer.controller;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.LruCacheService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lruCache")
public class LruCacheController {

    @Reference(version = "1.0.0",cache = "lru")
    private LruCacheService lruCacheService;

    @GetMapping("lruCacheTest")
    public RpcResult lruCacheTest() {
        return lruCacheService.getLruCache();
    }
}
