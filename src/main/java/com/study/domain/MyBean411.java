package com.study.domain;

import lombok.Data;

@Data
public class MyBean411 {
    private String name;
    private Integer age;

    public String getDesc() {
        return "get메소드";
    }
}
