package com.study.Controller;

import com.study.domain.MyBean241;
import com.study.domain.MyBean242;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
@RequestMapping("main24")
public class Controller24 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(Model model) throws Exception{
        ArrayList<MyBean241> list = new ArrayList<>();
        String sql = "SELECT FirstName, LastName FROM Employees";

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try(conn; stmt; rs){
            while(rs.next()) {
                MyBean241 bean = new MyBean241();
                bean.setFirstName(rs.getString(1));
                bean.setLastName(rs.getString(2));
                list.add(bean);
            }
        }
        model.addAttribute("employees",list);
    }

    @GetMapping("sub2")
    public void method2(@ModelAttribute("customers") ArrayList<MyBean242> list) throws Exception{
//        var list = new ArrayList<MyBean242>();
        String sql = "SELECT CustomerName, City, Country FROM Customers";
        // todo : 조회된 결과를 view에서 보여주기
        //  MyBean242(customerName,city,country) 클래스 만들기

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try(conn; stmt; rs){
            while(rs.next()) {
                MyBean242 bean = new MyBean242();
                bean.setCustomerName(rs.getString(1));
                bean.setCity(rs.getString(2));
                bean.setCountry(rs.getString(3));
                list.add(bean);
            }
        }
//        model.addAttribute("Customers",list);
    }

    // todo : 세번째 메소드를 만들어서
    //  고객이 있는 나라들을 중복없이 조회 후 jsp에서 출력
    @RequestMapping("sub3")
    public void method3(@ModelAttribute("countries") ArrayList<String> list) throws Exception{
        String sql = "SELECT DISTINCT Country FROM Customers";

        // 1. db와 연결
        Connection conn = dataSource.getConnection();
        // 2. 실행 준비
        Statement stmt = conn.createStatement();
        // 3. 쿼리 실행
        ResultSet rs = stmt.executeQuery(sql);
        // 4. 결과 가공
        // 5. 자원 닫기 - try-with-resources
        try(conn; stmt; rs){
            while (rs.next()){
                String name = rs.getString(1);
                list.add(name);
            }
        }
    }
}
