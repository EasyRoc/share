package com.example.orderapi.domain;

import java.io.Serializable;

public class BaseDomain implements Serializable {

    private String content;

    public BaseDomain(String content) {
        this.content = content;
    }

    public BaseDomain() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
