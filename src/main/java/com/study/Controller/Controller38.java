package com.study.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controller38 {
    @GetMapping("/login")
    public String login() {
        // return null, void 모두 가능.
        // return "/login" 안됨.
        return "login";
    }

    @GetMapping("/path1")
    // 로그인 했을 때, 하지 않았을 때...
    // https://docs.spring.io/spring-security/reference/5.8/servlet/authorization/expression-based.html
    @PreAuthorize("isAuthenticated()")
    public void path1() {
        System.out.println("Controller38.path1");
    }

    @GetMapping("/path2")
    @PreAuthorize("hasAuthority('user')")
    public void path2() {
        System.out.println("유저 권한이면 실행 가능");
    }

    @GetMapping("/path3")
    @PreAuthorize("hasAuthority('admin')")
    public void path3() {
        System.out.println("admin 권한이면 실행 가능");
    }

    @GetMapping("/path4")
    public void path4() {
    }
}
