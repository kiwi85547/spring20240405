package com.study.Controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
@RequestMapping("main28")
public class Controller28 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1() {
    }

    @PostMapping("sub1")
    public String sub2(MyBean254Customer customer, RedirectAttributes rttr) throws SQLException {

        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (conn; pstmt) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getPostalCode());
            pstmt.setString(6, customer.getCountry());

            int rowCount = pstmt.executeUpdate();
            if (rowCount == 1) {
                rttr.addFlashAttribute("message", "새 고객이 등록되었습니다.");
            }
        }
        return "redirect:/main28/sub1";
    }

    // todo : 새 직원 입력하기
    @GetMapping("sub2")
    public void sub2() {
    }

    @PostMapping("sub2")
    public String sub2(MyBean254Employees employees, RedirectAttributes redirectAttributes) throws SQLException {
        String sql = """
                INSERT INTO Employees
                (LastName, FirstName, BirthDate, Photo, Notes) 
                VALUES (?,?,?,?,?) ;
                """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (conn; pstmt) {
            pstmt.setString(1, employees.getLastName());
            pstmt.setString(2, employees.getFirstName());
//            date 설정
            pstmt.setDate(3, employees.getBirthDate());
            // setString 가능
//            pstmt.setString(3, employees.getBirthDate());
            pstmt.setString(4, employees.getPhoto());
            pstmt.setString(5, employees.getNotes());

            int row = pstmt.executeUpdate();
            if (row == 1) {
                redirectAttributes.addFlashAttribute("message", "새 고객이 등록되었습니다.");
            } else {
                redirectAttributes.addFlashAttribute("message", "문제가 발생하였습니다.");
            }
        }
        // 마지막 요청이 get방식으로 바뀜
        return "redirect:/main28/sub2";
    }
}
