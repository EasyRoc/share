package com.example.orderapi.rpc;

public interface CallbackService {

    void addListener(String key, CallbackListener listener);

}
