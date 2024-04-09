package com.study.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main12")
public class Controller12 {
    @RequestMapping("sub1")
    public void method1(Model model){
        model.addAttribute("age",15);
        model.addAttribute("products", List.of("Apple", "Banana"));

//        model.addAttribute("member", Map.of("country","Korea","age",30));
//        model.addAttribute("member", Map.of("country","Korea","age",15));
//        model.addAttribute("member", Map.of("country","US","age",30));
        model.addAttribute("member", Map.of("country","US","age",15));
    }

    @RequestMapping("sub2")
    public void method2(Model model){
        model.addAttribute("age",3);
//        model.addAttribute("age",13);
//        model.addAttribute("age",23);
//        model.addAttribute("age",33);
    }
    @RequestMapping("sub3")
    public void method3(Model model){
        model.addAttribute("dan",5);
    }
}
//@Controller public class Controller12{ @RequestMapping("main12/sub3")
//public void method(Model model){ model.addAttribute("dan",5);}}
