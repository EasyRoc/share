package com.example.dubboprovider.impl;

import com.example.orderapi.rpc.CallbackListener;
import com.example.orderapi.rpc.CallbackService;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 参数回调
 */

@Service(version = "1.0.0",connections = 1,callbacks = 100,methods = {})
public class CallbackServiceImpl implements CallbackService {
     
    private final Map<String, CallbackListener> listeners = new ConcurrentHashMap<String, CallbackListener>();
  
    public CallbackServiceImpl() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while(true) {
                    try {
                        for(Map.Entry<String, CallbackListener> entry : listeners.entrySet()){
                           try {
                               entry.getValue().changed(getChanged(entry.getKey()));
                           } catch (Throwable t) {
                               listeners.remove(entry.getKey());
                           }
                        }
                        Thread.sleep(5000); // 定时触发变更通知
                    } catch (Throwable t) { // 防御容错
                        t.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
  
    public void addListener(String key, CallbackListener listener) {
        listeners.put(key, listener);
        listener.changed(getChanged(key)); // 发送变更通知
    }
     
    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}