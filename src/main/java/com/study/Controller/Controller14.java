package com.study.Controller;

import com.study.domain.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @RequestMapping("sub1")
    public void sub1(Model model){
        MyBean141 o1 = new MyBean141("신촌","한국",33,"흥민");
        MyBean142 o2 = new MyBean142();
        o2.setName("강인");
        o2.setId("19");
        o2.setAge(23);

        model.addAttribute("player1",o1);
        model.addAttribute("player2",o2);
    }

    @RequestMapping("sub2")
    public void sub2(Model model){
        MyBean142 o1 = new MyBean142();
        o1.setName("김민재");
        MyBean142 o2 = new MyBean142();
        o2.setName("이정후");

        // attribbute명은
        // 클래스명을 lowerCamelCase로 변경된 이름으로 결정
        // myBean142
        // 좋은 습관은 이름을 직접 작성하는 것
        model.addAttribute(o1); //myBean
        model.addAttribute(List.of(o1,o2)); //myBean142List
    }

    @RequestMapping("sub3")
    public void sub3(@ModelAttribute("player1") MyBean142 o1){
        o1.setName("오타니");
    }

    @RequestMapping("sub4")
    public String sub4(@ModelAttribute MyBean142 o1){
        o1.setName("김민재");
        return "main14/sub3";
    }

    @RequestMapping("sub5")
    public String sub5(MyBean142 o1){ // 이렇게 써도 ModelAttribute
        o1.setName("유재석");
        return "main14/sub3";
    }

    @RequestMapping("sub6")
    public void sub6(MyBean142 o1){
        o1.setName("카리나");

        // todo:sub6.jsp 작성해서 "카리나" 출력
    }

    @RequestMapping("sub7")
    public String sub7(MyBean143 o1){
        o1.setAddress("신촌");
        o1.setId("skyblue");
        o1.setAge(20);
        return "/main14/sub6";
    }

    // /main14/sub8?city=london&address=ny
    @RequestMapping("sub8")
    public void sub8(MyBean144 o1){
        System.out.println(o1);
    }

    @RequestMapping("sub9")
    public void sub9(String name,
                     Integer age,
                     String address,
                     Model model) {
        MyBean145 o1 = new MyBean145();
        o1.setName(name);
        o1.setAddress(address);
        o1.setAge(age);

        model.addAttribute("myBean145", o1);
    }

    @RequestMapping("sub10")
    public String sub10(MyBean144 o1){
        return "main14/sub9";
    }

    // RequestParameter에 city=서울&country=신촌&price=5000
    @RequestMapping("sub11")
    public void sub11(MyBean146 o1){
    }

    // /main14/sub12?car=tesla&price=2000&model=k5&country=us
    // 쿼리스트링을 붙임
    @RequestMapping("sub12")
    public void sub12(
            Integer price, //@RequestParam
            String car, //@RequestParam
            MyBean147 o1, //@ModelAttribute
            MyBean146 o2 //@ModelAttribute
            ){
        System.out.println("price = " + price);
        System.out.println("car = " + car);
        System.out.println(o1);
        System.out.println(o2);
    }

}
