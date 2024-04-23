package com.study.core;

import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;

public class Application14 {
    public static void main(String[] args) {
        BeanFactory bf = SpringApplication.run(Application14.class, args);
        MyClass141 b = bf.getBean(MyClass142.class).getField();
    }
}

@Component
class MyClass141 {
}

@Component
@Getter
class MyClass142 {
    public MyClass141 field;

    @Autowired
    public void setField(MyClass141 field) {
        this.field = field;
    }
}