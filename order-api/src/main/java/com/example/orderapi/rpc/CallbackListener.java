package com.example.orderapi.rpc;

import java.io.Serializable;

public interface CallbackListener extends Serializable {
    void changed(String msg);
}