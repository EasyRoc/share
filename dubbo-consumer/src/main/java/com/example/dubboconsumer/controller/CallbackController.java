package com.example.dubboconsumer.controller;


import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.CallbackListener;
import com.example.orderapi.rpc.CallbackService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class CallbackController {

    @Reference(version = "1.0.0",cache = "lru")
    private CallbackService callbackService;

    @GetMapping("callbackTest")
    public RpcResult callbackTest() {
        callbackService.addListener("foo.bar", new CallbackListener(){
            public void changed(String msg) {
                System.out.println("callback1:" + msg);
            }
        });
        return RpcResult.success();
    }
}
