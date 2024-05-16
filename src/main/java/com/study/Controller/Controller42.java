package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/main42")
public class Controller42 {
    @PostMapping("sub1")
    public void sub1(@RequestBody Map<String, Object> map) {
        System.out.println("map = " + map);
    }
}
