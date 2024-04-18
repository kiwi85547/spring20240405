package com.study.Controller;

import com.study.domain.MyBean254Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
@RequestMapping("main27")
public class Controller27 {
    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public String sub1(Integer page, Model model) throws SQLException {
        if(page==null)page=1;
        int offset = (page - 1) * 10;
        String sql = """
              SELECT *
              FROM Customers
              ORDER BY CustomerID
              LIMIT ?,10
              """;

        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,offset);
        ResultSet rs = pstmt.executeQuery();
        var list = new ArrayList<MyBean254Customer>();
        try(conn; pstmt; rs){
            while(rs.next()){
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
            model.addAttribute("customerList",list);
        }
        return "main27/sub1";
    }
}
