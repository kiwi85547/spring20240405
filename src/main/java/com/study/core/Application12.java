package com.study.core;

import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Application12 {
    public static void main(String[] args) {
        BeanFactory bf = SpringApplication.run(Application12.class, args);
        MyClass122 bean = bf.getBean(MyClass122.class);
        MyClass121 field = bean.getField();
        System.out.println(field);
    }
}

@Component
class MyClass121 {
}

@Component
@Getter
//@RequiredArgsConstructor
class MyClass122 {
    private final MyClass121 field;

//    기본 생성자 있으면 안됨
//    public MyClass122(){}

    //    @Autowired 있는 것과 마찬가지
    MyClass122(MyClass121 field) {
        this.field = field;
    }
}

class A {
    final B b;

//    public A() {
//    }

    public A(B b) {
        this.b = b;
    }
}

class B {
}

class C {
    public static void main(String[] args) {
//        A a = new A(); // x

        A a1 = new A(new B()); // ok
    }
}