package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("main5")
public class Controller05 {

    // /main5/sub1?city=London
    @RequestMapping("sub1")
    public void method1(@RequestParam("city") String param) {
        System.out.println(param + " 검색 로직 실행");
    }

    // /main5/sub2?address=sinchon
    // /main5/sub2?address=gangnam
    // /main5/sub2?address=hongdae

    // "~로 가는 경로 탐색"
//    @RequestMapping("sub2")
//    public void method2(WebRequest request) {
//        String address = request.getParameter("address");
//        System.out.println(address + "로 가는 경로 탐색");
//    }

    @RequestMapping("sub2")
    public void method3(@RequestParam("address") String param) {
        System.out.println(param + "로 가는 경로 탐색");
    }

    @RequestMapping("sub3")
    public void method4(@RequestParam("age") Integer param) {
        if (param < 18) {
            System.out.println("청소년 관련 정보 출력");
        } else if (param < 35) {
            System.out.println("청년 관련 정보 출력");
        } else {
            System.out.println("성인 관련 정보 출력");
        }
    }

    @RequestMapping("sub4")
    public void method5(@RequestParam("height") Double param) {
        if (param < 145.0) {
            System.out.println("작은 키");
        } else if (param < 190.0) {
            System.out.println("중간 키");
        } else {
            System.out.println("큰 키");
        }
    }

}
