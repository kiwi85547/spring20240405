package com.study.mapper;

import com.study.domain.MyBean254Customer;
import org.springframework.stereotype.Component;

import java.sql.*;

//스프링빈
@Component
public class Mapper01 {
    public MyBean254Customer getCustomerByID(Integer id) throws SQLException {
        // connection
        // preparedStatement
        // resultSet
        // 객체 만들고
        // 리턴
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId=?
                       
                    """;
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/customers", "root", "1234");
            PreparedStatement pstmt = conn.
                    prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet
                    rs = pstmt.
                    executeQuery();

            try (pstmt; rs; conn) {
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

                    return data;
                }
            }
        }
        return null;
    }
}
