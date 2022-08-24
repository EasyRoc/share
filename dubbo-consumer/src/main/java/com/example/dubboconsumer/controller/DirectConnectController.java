package com.example.dubboconsumer.controller;

import com.example.orderapi.result.RpcResult;
import com.example.orderapi.rpc.DirectConnectService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/direct")
public class DirectConnectController {

    @Reference(version = "1.0.0",url = "dubbo://10.1.69.49:20880")
    private DirectConnectService directConnectService;

    @GetMapping("directConnect")
    public RpcResult directConnect() {
        return directConnectService.directConnect();
    }

}
