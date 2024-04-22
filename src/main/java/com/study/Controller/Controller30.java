package com.study.Controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import com.study.mapper.Mapper01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("main30")
public class Controller30 {
    @Autowired
    private DataSource dataSource;

    // Inversion of Control(IOC) 직접 만들기 않고..
    @Autowired
    private Mapper01 mapper;
    // 직접 만든 객체(dependency)
//    private Mapper01 mapper = new Mapper01();

    @GetMapping("sub1")
    public void method1(Integer id, Model model) throws Exception {
        MyBean254Customer c = mapper.getCustomerByID(id);
        model.addAttribute("customer", c);
    }

    @PostMapping("sub1/update")
    public String update1(MyBean254Customer customer, RedirectAttributes rttr) throws SQLException {
        String sql = """
                UPDATE Customers 
                SET CustomerName=?,
                    ContactName=?,
                    Address=?,
                    City=?,
                    PostalCode=?,
                    Country=?
                WHERE CustomerID=?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        try (conn; pstmt) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getContactName());
            pstmt.setString(3, customer.getAddress());
            pstmt.setString(4, customer.getCity());
            pstmt.setString(5, customer.getCountry());
            pstmt.setString(6, customer.getPostalCode());
            pstmt.setInt(7, customer.getId());

            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", customer.getId() + "번 고객 정보가 업데이트 되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "수정되지 않았습니다.");
            }
        }
        // addFlashAttribute는 모델에 들어감
        rttr.addFlashAttribute("id", customer.getId());
        return "redirect:/main30/sub1";
    }

    // todo : 직원 조회 및 수정
    @GetMapping("sub2")
    public void method2(String id, MyBean254Employees e, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                                    
                        SELECT * FROM Employees WHERE EmployeeId = ?
                       
                    """;
            Connection conn = dataSource.
                    getConnection();
            PreparedStatement pstmt = conn.
                    prepareStatement(sql);
            pstmt.setString(1, id);
            ResultSet
                    rs = pstmt.executeQuery();
            try (conn; pstmt; rs) {
                if (rs.next()) {
                    e.
                            setEmployeeID(rs.getString(1));
                    e.setLastName(rs.getString(2));
                    e.setFirstName(rs.getString(3));
                    e.setBirthDate(rs.getDate(4));
                    e.setPhoto(rs.getString(5));
                    e.setNotes(rs.getString(6));

                    model.addAttribute("employee", e);
                }
            }
        }
    }


    @PostMapping("sub2/update")
    public String update2(RedirectAttributes rttr, MyBean254Employees e) throws SQLException {
        String sql = """
                UPDATE Employees 
                SET LastName=?,
                    FirstName=?,
                    BirthDate=?,
                    Photo=?,
                    Notes=?
                WHERE EmployeeId=?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        try (conn; pstmt) {
            pstmt.setString(1, e.getLastName());
            pstmt.setString(2, e.getFirstName());
            pstmt.setDate(3, e.getBirthDate());
            pstmt.setString(4, e.getPhoto());
            pstmt.setString(5, e.getNotes());
            pstmt.setString(6, e.getEmployeeID());

            int rowCount = pstmt.executeUpdate();

            if (rowCount > 0) {
                // 모델에 붙음
                rttr.addFlashAttribute("message", e.getEmployeeID() + "번 직원 정보가 업데이트되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "수정되지 않았습니다.");
            }
        }
        // 쿼리스트링에 붙음
        rttr.addAttribute("id", e.getEmployeeID());
        return "redirect:/main30/sub2";
    }
}

