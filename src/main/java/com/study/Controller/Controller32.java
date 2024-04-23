package com.study.Controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import com.study.mapper.Mapper02;
import com.study.mapper.Mapper03;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("main32")
public class Controller32 {

    private final Mapper03 mapper;
    private final Mapper02 mapper02;

    @RequestMapping("sub1")
    public void method1() {
        int rowCount = mapper.deleteOneCustomer();
        System.out.println(rowCount + "명 고객 삭제됨");
    }

    // /main32/sub2?cid=5
    // cid는 파라미터로 받는 값
    @RequestMapping("sub2")
    public void method2(Integer cid) {
        int rowCount = mapper.deleteOneCustomerById(cid);
        System.out.println(rowCount + "명 고객 삭제됨");
    }

    // todo : /main32/sub3?eid=2
    //  2번 직원 삭제하는 메소드와 mapper에 메소드 작성하기
    @RequestMapping("sub3")
    public void method3(Integer eid) {
        int rowCount = mapper.deleteOneEmployeeById(eid);
        System.out.println(rowCount + "명 고객 삭제됨");
    }

    // insert는 보통 post방식이지만 생략하느라고 get방식으로 쓰고 있음
    // /main32/sub4?name=흥민&contactName=캡틴&city=런던&country=한국&address=토트넘
    @GetMapping("sub4")
    public void method4(MyBean254Customer customer) {
        int count = mapper.insertCustomer(customer);
        System.out.println("count = " + count);
    }

    // /main32/sub5?lastName=송&firstName=강&notes=잘생김
    // form이 있는 view로 포워딩
    @GetMapping("sub5")
    public void method5(MyBean254Employees employees) {
        int count = mapper.insertEmployee(employees);
        System.out.println("count = " + count + "명 추가되었습니다.");
    }

    //update. 모두 조회 후 업데이트
    @GetMapping("sub6")
    public void method6(@RequestParam(value = "id", required = false) String eid, Model model) {
        if (eid != null) {
            MyBean254Employees e = mapper02.selectOneEmployee2(eid);
            model.addAttribute("employee", e);
        }
    }

    @PostMapping("sub6/update")
    public String method7(MyBean254Employees employee, RedirectAttributes rttr) {
        // 비즈니스 로직 실행 부분
        int i = mapper.updateEmployee(employee);

        if (i > 0) {
            rttr.addFlashAttribute("message", "수정되었습니다.");
        } else {
            rttr.addFlashAttribute("message", "입력되지 않았습니다.");
        }
        // redirect할 때 /main32/sub6에 붙는 id
        rttr.addAttribute("id", employee.getEmployeeID());
        return "redirect:/main32/sub6";
    }


}
