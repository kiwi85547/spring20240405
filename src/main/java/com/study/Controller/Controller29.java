package com.study.Controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Controller
@RequestMapping("main29")
public class Controller29 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void sub1(Integer id, Model model) throws SQLException {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId=?
                       
                    """;
            Connection conn = dataSource.
                    getConnection();
            PreparedStatement pstmt = conn.
                    prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet
                    rs = pstmt.
                    executeQuery();

            try (pstmt; rs) {
                if (rs.next()) {
                    MyBean254Customer data = new
                            MyBean254Customer();
                    data
                            .setId(rs.getInt(1));
                    data.setName(rs.getString(2));
                    data.setContactName(rs.getString(3));
                    data.setAddress(rs.getString(4));
                    data.setCity(rs.getString(5));
                    data.setPostalCode(rs.getString(6));
                    data.setCountry(rs.getString(7));

                    model.addAttribute("customer", data);
                }
            }

        }
    }

    @PostMapping("sub1/delete")
    public String method2(Integer id, RedirectAttributes rttr) throws SQLException {
        String sql = """
                DELETE FROM Customers
                WHERE CustomerId=?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        try (conn; pstmt) {
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", id + "번 고객이 삭제 되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "삭제되지 않았습니다.");
            }
        }
        return "redirect:/main29/sub1";

    }

    // todo : 직원 지우기
    @GetMapping("sub2")
    public void method3(@RequestParam(value = "id", required = false) String EmployeeId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM Employees WHERE EmployeeId=?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, EmployeeId);
        ResultSet rs = pstmt.executeQuery();
        try (conn; pstmt; rs) {
            if (rs.next()) {
                MyBean254Employees obj = new MyBean254Employees();
                obj.setEmployeeID(rs.getString(1));
                obj.setLastName(rs.getString(2));
                obj.setFirstName(rs.getString(3));
                // 자바빈에서 Date -> String으로 바꾸면 getString 가능
                obj.setBirthDate(rs.getDate(4));
                obj.setPhoto(rs.getString(5));
                obj.setNotes(rs.getString(6));

                model.addAttribute("employee", obj);
            }
        }
    }

    @PostMapping("sub2/delete")
    public String method4(@RequestParam(value = "id", required = false) String id, RedirectAttributes rttr) throws SQLException {
        String sql = """
                DELETE FROM Employees WHERE EmployeeId=?
                """;
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);

        try (conn; pstmt) {
            int rowCount = pstmt.executeUpdate();
            if (rowCount > 0) {
                rttr.addFlashAttribute("message", id + "번 직원이 삭제되었습니다.");
            } else {
                rttr.addFlashAttribute("message", "삭제되지 않았습니다.");
            }
        }

        return "redirect:/main29/sub2";
    }
}
