package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main3")
public class Controller03 {

    // 경로 : /main3/sub1
    @RequestMapping("sub1")
    public void sub1() {
        System.out.println("Controller03.sub1");
    }

    // 경로 : /main3/sub2
    @RequestMapping("sub2")
    public void sub2() {
        System.out.println("Controller03.sub2");
    }

    // 경로 : /main3/sub3
    // 파라미터 : name
    // /main3/sub3?name
    @RequestMapping(value = "sub3", params = "name")
    public void sub3() {
        System.out.println("Controller03.sub3");
    }

    // /main3/sub3?name&age
    @RequestMapping(value = "sub3", params = {"name", "age"})
    public void sub4() {
        System.out.println("Controller03.sub4");
    }

    // /main3/sub3?address&city
    // todo : method5 작성
    @RequestMapping(value = "sub3", params = {"address", "city"})
    public void sub5() {
        System.out.println("address,city");
    }

    // todo : 아래 메소드가 실행될 수 있는 경로 작성
    // /main3/sub3?country&city
    // /main3/sub3?city&country 위와 같음
    // /main3/sub3?country=korea&city=seoul
    @RequestMapping(value = "sub3", params = {"country", "city"})
    public void sub6() {
        System.out.println("country,city");
    }


}
