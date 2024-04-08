package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("main6")
public class Controller06 {

    @RequestMapping("sub1")
    public void method1(){
        System.out.println("Controller06.method1");
    }

    @RequestMapping("sub2")
    public void method2(@RequestParam(value="abc", required=true) String param1,
                        @RequestParam(value="qwe", required=false) Integer param2){
        System.out.println(param1);
        System.out.println(param2);
    }

    @RequestMapping("sub3")
    public void method3(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "age", required = false) Integer age){
        System.out.println(name+":"+age);
    }

    // /main6/sub4?name=손흥민&age=33
    @RequestMapping("sub4")
    public void method4(@RequestParam(required = false) String name,
                        @RequestParam(required = false) Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
    }

    @RequestMapping("sub5")
    public void method5(@RequestParam(required = false) String address,
                        @RequestParam(required = false) String city){
        System.out.println("address = " + address);
        System.out.println("city = " + city);
    }

    // /main6/sub6?address=강남
    @RequestMapping("sub6")
    public void method6(String address, //@RequestParam 생략 가능
                        String city){   //required는 false, true를 원하면 RequestParam을 적어야 함. 혹은 RequestMapping
        System.out.println("address = " + address);
        System.out.println("city = " + city);
    }

    // 메소드 아규먼트 타입이 기본타입(wrapper 포함), String (의 배열) 이면
    // @RequestParam으로 간주됨
    @RequestMapping("sub7")
    public void method7(String name, Integer age){
        System.out.println(name+" ="+age);
    }

    // /main6/sub8?name=흥민&address=런던&address=서울
    // /main6/sub8?name=흥민&address=런던
    // /main6/sub8?name=흥민
    // /main6/sub8
    @RequestMapping("sub8")
    public void method8(String name, String[] address){
        System.out.println("name = " + name);
        System.out.println("address = " + Arrays.toString(address));
    }

    @RequestMapping("sub9")
    public void method9(Integer[] age, String[] city){
        System.out.println("age = " + Arrays.toString(age));
        System.out.println("city = " + Arrays.toString(city));
    }
























































































}
