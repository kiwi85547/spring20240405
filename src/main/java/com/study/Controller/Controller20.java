package com.study.Controller;

import com.study.domain.MyBean201;
import com.study.domain.MyBean202;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {
    @RequestMapping("sub1")
    public void sub1(){
    }
    @RequestMapping("sub2")
    public void sub2(){
    }
    @RequestMapping("sub3")
    public void sub3(){}
    @RequestMapping("sub4")
    public void sub4(){}
    @RequestMapping("sub5")
    public void sub5(String player, Model model){
        // 1. 요청 분석/가공
        // 2. 비즈니스 로직 처리
        // 3. 결과를 모델에 담고
        model.addAttribute("result",player+"검색 결과");
        // 4. 뷰로 forward(뷰 이름 리턴)
    }
    @RequestMapping("sub6")
    public void sub6(String address, String type, Model model){
        model.addAttribute("res",address+"의 "+type+" 검색 결과");
    }
    @RequestMapping("sub7")
    public void sub7(String name,
                     Integer age,
                     String birth,
                     String address,
                     String hobby,
                     Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        model.addAttribute("result", Map.of("name",name,"age",age,"birth",birth));
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birth = " + birth);
        System.out.println("address = " + address);
        System.out.println("hobby = " + hobby);
    }
    @RequestMapping("sub8")
//    set 메소드 활용해서 .. 땡땡.. 12시25분 설명
//    ModelAttribute의 프로퍼티에 바인딩됨
    public void sub8(@ModelAttribute MyBean201 data){
//        @ModelAttribute 생략 가능
//        주석을 안쓰면 request param이나 , ModelAttribute 로 간주
        System.out.println(data);
    }
    @RequestMapping("sub9")
    public void sub9(){
        //todo:sub9.jsp 만들고
        // city,address,title,content
        // 의 요청 파라미터 입력받고 전송
        // form 요소 작성
        // 전송 위치 : /main20/sub10
    }

    // /main20/sub10 요청 경로에서 일하는 메소드 작성
    // city,address,title,content 의 요청 파라미터가
    // MyBean202 객체의 property로 바인딩 되도록 코드 작성
    @RequestMapping("sub10")
    public void sub10(@ModelAttribute("data") MyBean202 obj){

        System.out.println("obj = " + obj);
    }
    @RequestMapping("sub11")
    public void sub11(){
    }
    @RequestMapping("sub12")
    public void sub12(String type,
                      String content,
                      String city){
        System.out.println("type = " + type);
        System.out.println("content = " + content);
        System.out.println("city = " + city);
    }
    @RequestMapping("sub13")
    public void sub13(String city){
        System.out.println("city = " + city);
    }
    @RequestMapping("sub14")
    public void sub14(@RequestParam("foods") String[] foods){
//    public void sub14(String[] foods){
        // RequestParam 생략가능
        System.out.println(Arrays.toString(foods));
    }
    // todo : sub11.jsp에 form 요소 작성
    //  submit 클릭 시 /main20/sub15로 전송
    //  type,phone,book 요청 파라미터 전송
    //  type : select&option 요소로
    //  phone : radio button으로
    //  book : checkbox
    @RequestMapping("sub15")
    public void sub15(String type,
                      String phone,
                      String[] book){
        System.out.println("type = " + type);
        System.out.println("phone = " + phone);
        System.out.println("book = " + Arrays.toString(book));
    }
    @RequestMapping("sub16")
    public void sub16(){}
    @RequestMapping("sub17")
    public void sub17(String id, String password, String describe){
        System.out.println("id = " + id);
        System.out.println("password = " + password);
        System.out.println("describe = " + describe);
    }
    @RequestMapping("sub18")
    public void sub18(String name, String city, String address,
                      Model model){
        model.addAttribute("name",name);
        model.addAttribute("city",city);
        model.addAttribute("address",address);
    }
}
