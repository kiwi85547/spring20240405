package com.study.Controller;

import com.study.service.Service03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main36")
@RequiredArgsConstructor
public class Controller36 {
    private final Service03 service;

    @GetMapping("sub1")
    public void method1() {
        service.insertData();
    }

    @GetMapping("sub2")
    public void insertData2() {
        service.insertData2();
    }

}
