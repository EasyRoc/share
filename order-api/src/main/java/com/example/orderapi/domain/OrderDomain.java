package com.example.orderapi.domain;

import java.io.Serializable;

public class OrderDomain implements Serializable {

    private String orderId;

    private String orderName;

    public OrderDomain(String orderId, String orderName) {
        this.orderId = orderId;
        this.orderName = orderName;
    }

    public OrderDomain() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
}
