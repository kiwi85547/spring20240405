package com.study.Controller;

import com.study.service.Service04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main37")
@RequiredArgsConstructor
public class Controller37 {
    private final Service04 service;

    @GetMapping("sub1")
    public void method() {
        service.action1();
    }

    @GetMapping("sub4")
    public void method4() {
        service.action4();
    }

    @GetMapping("sub5")
    public void method5() {
        service.action5();
    }

    @GetMapping("sub6")
    public void method6(
            @RequestParam(value = "q", defaultValue = "") String keyword) {
        service.action6(keyword);
    }

    @GetMapping("sub7")
    public void method7() {
        service.action7();
    }
}