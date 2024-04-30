package com.study.service;

import com.study.domain.MyBean254Employees;
import com.study.mapper.Mapper08;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class Service04 {
    private final Mapper08 mapper;

    public void action1() {
        mapper.query1();
    }

    public void action2() {
        MyBean254Employees e = new MyBean254Employees();
        e.setLastName("흥민");
        mapper.query2(e);
    }

    public void action4() {
        MyBean254Employees e = new MyBean254Employees();
        e.setFirstName("kim");
//        e.setFirstName("lee");
        mapper.query4(e);
    }

    public void action5() {
        MyBean254Employees e = new MyBean254Employees();
        e.setLastName("son");
        mapper.query5(e);
    }

    public void action6(String keyword) {
//        service대신 mapper에서 bind를 이용해 작성할 수 있음
//        mapper.query6("%"+keyword+"%");
        List<MyBean254Employees> list = mapper.query6(keyword);
        list.forEach(System.out::println);
    }

    public void action7() {
        mapper.query7();
    }
}
