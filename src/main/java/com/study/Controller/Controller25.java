package com.study.Controller;

import com.study.domain.MyBean251;
import com.study.domain.MyBean252;
import com.study.domain.MyBean253;
import com.study.domain.MyBean254Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main25")
public class Controller25 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1(String searchName, Model model) throws SQLException {
        var list = new ArrayList<MyBean251>();
//        String sql =STR."""
//                    SELECT * FROM Employees WHERE LastName='\{searchName}'""";
        String sql = "SELECT * FROM Employees WHERE LastName='" + searchName + "'";

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        try (conn; stmt; rs) {
            while (rs.next()) {
                String id = rs.getString(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String birthDate = rs.getString(4);
                String photo = rs.getString(5);
                String notes = rs.getString(6);

                MyBean251 obj =
                        new MyBean251(id, lastName, firstName, birthDate, photo, notes);
                list.add(obj);
            }
        }
        model.addAttribute("employees", list);
    }

    @GetMapping("sub2")
    public void method2(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        //todo : name 요청 파라미터와 일치하는 상품명으로 상품(Product) 조회
        var list = new ArrayList<MyBean252>();
//        var list = new ArrayList<String>();
        String sql = "SELECT * FROM Products WHERE ProductName='" + search + "'";
//        String sql2 = "SELECT * FROM Products WHERE ProductName="' OR 1 = 1 #'";

        Connection conn = dataSource.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        try (conn; stmt; rs) {
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String unit = rs.getString(5);
                String price = rs.getString(6);
                MyBean252 obj = new MyBean252(id, name, unit, price);
                list.add(obj);
//                list.add(id);
//                list.add(name);
//                list.add(unit);
//                list.add(price);
            }
        }
        model.addAttribute("products", list);
    }

    @GetMapping("sub3")
    public void method3(String search, Model model) throws SQLException {
        String oldsql = STR."""
                SELECT * FROM Products WHERE ProductName='\{search}'

                """;
        String sql = """
                SELECT * FROM Products
                WHERE ProductName = ?
                """;

        var list = new ArrayList<MyBean252>();
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        // 첫번째 파라미터 : 물음표 위치
        // 두번째 파라미터 : 넣을 값
        pstmt.setString(1, search);

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            MyBean252 row = new MyBean252(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(5),
                    rs.getString(6));
            list.add(row);
        }
        model.addAttribute("products", list);
    }

    // todo : 고객 이름을 입력 받아서 고객 정보 조회
    //  sub4 메소드와 sub4.jsp 작성
    //  SELECT * FROM Customers WHERE CustomerName = ?
    @GetMapping("sub4")
    public void method4(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        String sql = "SELECT * FROM Customers WHERE CustomerName = ?";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, search);

        var list = new ArrayList<MyBean253>();
//        var list = new ArrayList<String>();

        ResultSet rs = pstmt.executeQuery();
        try (rs; pstmt; conn) {
            while (rs.next()) {
                MyBean253 myBean253 = new MyBean253(
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5));
                list.add(myBean253);
//                String name = rs.getString(2);
//                list.add(name);
//                obj.setid(id);
//                obj.setName(name);
//                list.add(obj);
            }
        }
        model.addAttribute("customers", list);
    }

    @GetMapping("sub5")
    public String method(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        String sql = """
                SELECT * FROM Customers
                WHERE CustomerName LIKE ?
                """;
        String keyword = "%" + search + "%";

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        var list = new ArrayList<MyBean253>();

        ResultSet rs = pstmt.executeQuery();
        try (rs; pstmt; conn) {
            while (rs.next()) {
                MyBean253 myBean253 = new MyBean253(
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5));
                list.add(myBean253);
            }
        }
        model.addAttribute("customers", list);

        return "/main25/sub4";
    }

    // todo : 상품명으로 상품들 조회 메소드 작성
    @GetMapping("sub6")
    public String method(String search, Model model, ArrayList<MyBean252> list) throws SQLException {
        String sql = """
                SELECT * FROM Products WHERE ProductName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        ResultSet rs = pstmt.executeQuery();
        try (conn; pstmt; rs) {
            while (rs.next()) {
//                MyBean252 myBean252 = new MyBean252(
//                        rs.getInt(1), rs.getString(2),
//                        rs.getString(5),rs.getString(6));
                MyBean252 bean = new MyBean252();
                bean.setId(1);
                bean.setName(rs.getString(2));
                bean.setUnit(rs.getString(3));
                bean.setPrice(rs.getString(4));
                list.add(bean);
            }
            model.addAttribute("products", list);
            model.addAttribute("prevSearch", search);
        }
        return "/main25/sub3";
    }

    @GetMapping("sub7")
    public String method7(String search, Model model) throws SQLException {
        var list = new ArrayList<MyBean253>();
        String sql = """              
                SELECT * FROM Customers 
                WHERE CustomerName LIKE ?
                OR ContactName LIKE ?
                """;
        String keyword = "%" + search + "%";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        pstmt.setString(2, keyword);
        ResultSet rs = pstmt.executeQuery();
        try (rs; pstmt; conn) {
            while (rs.next()) {
                MyBean253 myBean253 = new MyBean253(
                        rs.getString(2),
                        rs.getString(4),
                        rs.getString(5));
                list.add(myBean253);
            }
        }
        model.addAttribute("prevList", search);
        model.addAttribute("customers", list);
        return "/main25/sub4";
    }

    // todo : 조회 문자열이 last name 또는 first name에 포함된 직원들 조회 메소드 작성
    @GetMapping("sub8")
    public String method8(@RequestParam(value = "name", required = false) String search, Model model) throws SQLException {
        String sql = "SELECT * FROM Employees WHERE lastName LIKE ? OR FirstName LIKE ?";
        String keyword = "%" + search + "%";
        var list = new ArrayList<MyBean254Employees>();

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, keyword);
        pstmt.setString(2, keyword);
        ResultSet rs = pstmt.executeQuery();
        try (rs; pstmt; conn) {
            while (rs.next()) {
                MyBean254Employees obj = new MyBean254Employees();
                obj.setEmployeeID(rs.getString(1));
                obj.setLastName(rs.getString(2));
                obj.setFirstName(rs.getString(3));
                // 자바빈에서 Date -> String으로 바꾸면 getString 가능
                obj.setBirthDate(rs.getDate(4));
                obj.setPhoto(rs.getString(5));
                obj.setNotes(rs.getString(6));

                list.add(obj);
            }
        }
        model.addAttribute("employees", list);
        return "/main25/sub8Employees";
    }
}
