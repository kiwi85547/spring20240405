package com.study.Controller;

import com.study.domain.MyBean254Customer;
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
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(@RequestParam(defaultValue = "1") Integer page, Model model) throws SQLException {
        int offset = (page - 1) * 10;
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerID
                LIMIT ?,10
                """;
        var list = new ArrayList<MyBean254Customer>();

        Connection conn = dataSource.getConnection();

        // 페이지 정보 산출
        // 총 레코드 수 조회
        String countSql = "SELECT COUNT(*) FROM Customers";
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0;
        try (rs1; stmt;) {
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }

        // 마지막 페이지 번호
        int lastPageNumber = (total - 1) / 10 + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);

        // 페이지 링크의 begin, end 산출
        int endPageNumber = (((page - 1) / 10) + 1) * 10;
        int beginPageNumber = endPageNumber - 9;

        // endPageNumber 가 최종페이지를 넘을 순 없다.
        endPageNumber = Math.min(endPageNumber, lastPageNumber);

        model.addAttribute("endPageNumber", endPageNumber);
        model.addAttribute("beginPageNumber", beginPageNumber);

        // 다음 버튼 클릭 시 이동해야 하는 페이지 nextPageNumber 산출
        int nextPageNumber = beginPageNumber + 10;
        if (nextPageNumber <= lastPageNumber) {
            model.addAttribute("nextPageNumber", nextPageNumber);
        }

        // 이전 버튼 클릭 시 이동해야 하는 페이지 prevPageNumber 산출
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) {
            model.addAttribute("prevPageNumber", prevPageNumber);
        }

        // 현재 페이지
        model.addAttribute("currentPage", page);

        // 고객 레코드 조회
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offset);
        ResultSet rs = pstmt.executeQuery();
        try (conn; pstmt; rs) {
            while (rs.next()) {
                MyBean254Customer customer = new MyBean254Customer();
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setContactName(rs.getString(3));
                customer.setAddress(rs.getString(4));
                customer.setCity(rs.getString(5));
                customer.setCountry(rs.getString(6));
                customer.setPostalCode(rs.getString(7));
                list.add(customer);
            }
            model.addAttribute("customerList", list);
        }
        return "main27/sub1";
    }

    // todo : 직원 테이블 조회 (paging 처리)
    //  메소드와 jsp 작성
    @GetMapping("sub2")
    public void method2(@RequestParam(defaultValue = "1") Integer page, Model model) throws SQLException {
        int offset = (page - 1) * 10;
        String sql = "SELECT * FROM Employees ORDER BY EmployeeID LIMIT ?,10";
        var list = new ArrayList<MyBean254Employees>();

        Connection conn = dataSource.getConnection();

        // 페이지 정보 산출
        // 총 레코드 수 조회
        String countSql = "SELECT COUNT(*) FROM Employees";
        Statement stmt = conn.createStatement();
        ResultSet rs1 = stmt.executeQuery(countSql);
        int total = 0;
        try (rs1; stmt;) {
            if (rs1.next()) {
                total = rs1.getInt(1);
            }
        }

        // 마지막 페이지 번호
        int lastPageNumber = ((total - 1) / 10) + 1;
        model.addAttribute("lastPageNumber", lastPageNumber);

        // 페이지 링크의 begin,end 산출
        int endPageNumber = (((page - 1) / 10) + 1) * 10;
        int beginPageNumber = endPageNumber - 9;

        // endPageNumber 가 최종페이지를 넘을 수 없다.
        // *Math.min(int a, int b)
        // 반환값 : the smaller of a and b
        endPageNumber = Math.min(endPageNumber, lastPageNumber);
        // endPageNumber, beginPageNumber 모델에 담기
        model.addAttribute("endPageNumber", endPageNumber);
        model.addAttribute("beginPageNumber", beginPageNumber);

        // 다음 버튼 클릭 시 이동해야 하는 페이지 nextPageNumber 산출
        int nextPageNumber = beginPageNumber + 10;
        if (nextPageNumber <= lastPageNumber) {
            model.addAttribute("beginPageNumber", beginPageNumber);
        }

        // 이전 버튼 클릭 시 이동해야 하는 페이지 prevPageNumber 산출
        int prevPageNumber = beginPageNumber - 10;
        if (prevPageNumber >= 1) {
            model.addAttribute("prevPageNumber", prevPageNumber);
        }

        // 현재 페이지
        model.addAttribute("currentPage", page);

        // 고객 레코드 조회

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, offset);
        ResultSet rs = pstmt.executeQuery();
        try (conn; pstmt; rs) {
            while (rs.next()) {
                MyBean254Employees employee = new MyBean254Employees();
                employee.setEmployeeID(rs.getString(1));
                employee.setLastName(rs.getString(2));
                employee.setFirstName(rs.getString(3));
                employee.setBirthDate(rs.getDate(4));
                employee.setPhoto(rs.getString(5));
                employee.setNotes(rs.getString(6));
                list.add(employee);
            }
            model.addAttribute("employees", list);
        }
    }
}
