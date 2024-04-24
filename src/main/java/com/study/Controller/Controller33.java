package com.study.Controller;

import com.study.domain.MyBean331;
import com.study.domain.MyBean332;
import com.study.domain.MyBean333;
import com.study.mapper.Mapper04;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("main33")
@RequiredArgsConstructor
public class Controller33 {
    private final Mapper04 mapper;

    @GetMapping("sub1")
    public void method1() {
        List<MyBean331> obj = mapper.select1();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub2")
    public void method2() {
        List<MyBean332> obj = mapper.select2();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub3")
    public void method3() {
        List<MyBean333> obj = mapper.select3();
        obj.forEach(System.out::println);
    }

    @GetMapping("sub4")
    public void method4() {
        mapper.insert1("hello world", "12345", "224.33", "2015-07-18", "2015-12-18 13:30:00");
    }

    @GetMapping("sub5")
    public void method5() {
        String strVal = "hello mybatis";
        Integer intVal = 2323;
        Double doubleVal = 3.14;
        LocalDate dateVal = LocalDate.parse("1990-09-25");
        LocalDateTime dateTimeVal = LocalDateTime.parse("2015-12-18T13:30:00");
        mapper.insert2(strVal, intVal, doubleVal, dateVal, dateTimeVal);
    }

    // todo : 6번째 메소드 만들어서 my_table10에 레코드 추가하기
    @GetMapping("sub6")
    public void method6() {
        String title = "가갸거겨";
        String name = "조화영";
        Integer age = 33;
        Double price = 11.234;
        LocalDate published = LocalDate.parse("2018-11-24");
        LocalDateTime inserted = LocalDateTime.parse("2015-12-18T13:45:01");
        mapper.insert3(title, name, age, price, published, inserted);
    }

    @GetMapping("sub7")
    public void method7() {
        MyBean332 obj = new MyBean332();
        obj.setStringCol("hi💕");
        obj.setIntCol(5050);
        obj.setDateCol(LocalDate.parse("2015-07-08"));
        obj.setDateTimeCol(LocalDateTime.parse("2018-11-24T11:00:00"));
        obj.setDecCol(3.141592);

        mapper.insert4(obj);
    }

    @GetMapping("sub8")
    public void method8() {
        MyBean333 obj = new MyBean333();
        mapper.insert5("책", "이름", 11, 2461.24, "1111-02-01", "2135-02-05T11:22:33");
    }

    @GetMapping("sub9")
    public void select9(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
    }

    @PostMapping("sub9")
    public String insert9(String str,
                          String intValue,
                          String realValue,
                          String dateValue,
                          String dateTimeValue) {
        mapper.insert1(str, intValue, realValue, dateValue, dateTimeValue);
        return "redirect:/main33/sub9";
    }

    @GetMapping("sub10")
    public String select10(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
        return "main33/sub9";
    }

    @PostMapping("sub10")
    public String insert10(String str,
                           Integer intValue,
                           Double realValue,
                           LocalDate dateValue,
                           LocalDateTime dateTimeValue) {
        mapper.insert2(str, intValue, realValue, dateValue, dateTimeValue);
        return "redirect:/main33/sub10";
    }

    @GetMapping("sub11")
    public String select11(Model model) {
        List<MyBean332> list = mapper.select2();
        model.addAttribute("datas", list);
        return "main33/sub11";
    }

    @PostMapping("sub11")
    public String insert11(MyBean332 data) {
        System.out.println("data = " + data);
        mapper.insert4(data);
        return "redirect:/main33/sub11";
    }

    // todo : 아래 두 개의 메소드를 잘 수정해서
    //  my_table10 레코드 조회 및 입력 로직 완성
    @GetMapping("sub12")
    public void select12(Model model) {
        model.addAttribute("datas", mapper.select3());
    }

    @PostMapping("sub12")
    public String insert12(MyBean333 data) {
        mapper.insert6(data);
        return "redirect:/main33/sub12";
    }
}
