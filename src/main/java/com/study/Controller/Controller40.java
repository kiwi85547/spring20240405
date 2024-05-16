package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controller40 {
    @GetMapping("/api/someurl")
    public void method1() {
        System.out.println("Controller40.method1");
    }

    @PostMapping("/api/someurl")
    public void method2() {
        System.out.println("Controller40.method2");
    }

    @GetMapping("/api/someurl2")
    public void method3() {
        System.out.println("Controller40.method3");
    }

    @PostMapping("/api/someurl2")
    public void method4() {
        System.out.println("Controller40.method4");
    }

    @GetMapping("/api/someurl3")
    // @RequestParam ( )괄호 안과 이름이 같으면 @RequestParam()생략 가능
    // Integer id만 적어도 됨
    public void method5(@RequestParam("id") Integer id,
                        @RequestParam("name") String name
    ) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
    }

    @PostMapping("/api/someurl3")
    public void method6(Integer id, String name, String city) {
        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("city = " + city);
    }

    @GetMapping("/api/someurl4")
    public void method7(String title, String sound, String song) {
        System.out.println("title = " + title);
        System.out.println("sound = " + sound);
        System.out.println("song = " + song);
        System.out.println("Controller40.method7");
    }

    @PostMapping("/api/someurl4")
    public void method8(String book, String mouse, String monitor) {
        System.out.println("book = " + book);
        System.out.println("mouse = " + mouse);
        System.out.println("monitor = " + monitor);
    }
}
