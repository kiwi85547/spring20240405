package com.study.Controller;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean256Product;
import com.study.domain.MyBean261Orders;
import com.study.domain.MyBean263Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

@Controller
@RequestMapping("main26")
public class Controller26 {
    @Autowired
    private DataSource dataSource;
    @GetMapping("sub1")
    public String sub1(String start, String end, Model model)throws Exception{
        // todo : 메소드 작성하세요
        //  between 활용

        String sql = "SELECT * FROM Orders WHERE OrderDate BETWEEN ? AND ?";


        var list = new ArrayList<MyBean261Orders>();
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, start);
        pstmt.setString(2, end);
        ResultSet rs = pstmt.executeQuery();

        try(conn;pstmt;rs){
            while(rs.next()){
                MyBean261Orders obj = new MyBean261Orders();
                obj.setOrderId(rs.getInt(1));
                obj.setCustomerId(rs.getInt(2));
                obj.setEmployeeId(rs.getInt(3));
                obj.setOrderDate(rs.getString(4));
                obj.setShipperId(rs.getInt(5));
                list.add(obj);
            }
        }
        model.addAttribute("prevStart",start);
        model.addAttribute("prevEnd",end);
        model.addAttribute("orderList",list);

        return "/main26/sub1OrderList";
    }
    @GetMapping("sub2")
    public String method2(String[] country, Model model) throws SQLException {
        Connection conn = dataSource.getConnection();

        if(country!=null&&country.length>0){
    //        선택하는 '?' 갯수만큼 sql문 추가
            String questionMarks = "";
            for (int i = 0; i < country.length; i++) {
                questionMarks  = questionMarks + "?";
                if (i != country.length - 1) {
                    questionMarks = questionMarks + ",";
                }
            }
            String customerSql = STR."""
                 SELECT * FROM Customers
                 WHERE Country IN (\{questionMarks})
                """;

            var customerList = new ArrayList<MyBean254Customer>();
            PreparedStatement pstmt = conn.prepareStatement(customerSql);
            for (int i = 0; i < country.length; i++) {
                pstmt.setString((i+1),country[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();
            try(pstmt;resultSet){

                while(resultSet.next()){
                    MyBean254Customer data = new MyBean254Customer();
                    data.setId(resultSet.getInt(1));
                    data.setName(resultSet.getString(2));
                    data.setContactName(resultSet.getString(3));
                    data.setAddress(resultSet.getString(4));
                    data.setCity(resultSet.getString(5));
                    data.setPostalCode(resultSet.getString(6));
                    data.setCountry(resultSet.getString(7));
                    customerList.add(data);
                }
                model.addAttribute("customerList",customerList);
            }
        }

        String sql = "SELECT DISTINCT Country FROM Customers";

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        var countryList = new ArrayList<String>();
        try(stmt;rs;conn) {
            while (rs.next()) {
                countryList.add(rs.getString(1));
            }
            model.addAttribute("countryList", countryList);
        }
        return "main26/sub2CustomerList";
    }

    // todo : 상품 조회 결과가 카테고리, 가격순으로 조회 되도록 코드 수정
    @GetMapping("sub3")
    public String method3(String[] categoryId, Model model) throws SQLException {
        Connection conn = dataSource.getConnection();

        String categorysql = "SELECT * FROM Categories";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(categorysql);
        var categoryList = new ArrayList<MyBean263Category>();
        try(stmt;rs) {
            while (rs.next()){
                MyBean263Category category = new MyBean263Category();
                category.setId(rs.getInt(1));
                category.setName(rs.getString(2));

                categoryList.add(category);
            }
            model.addAttribute("categoryList",categoryList);
        }

        if(categoryId!=null&&categoryId.length>0){
            String marks="";
            for (int i = 0; i < categoryId.length; i++) {
                marks+="?";
                if (i != categoryId.length - 1) {
                    marks = marks + ",";
                }
            }

            String sql = STR."""
                    SELECT * FROM Products WHERE CategoryID IN(\{marks}) ORDER BY CategoryID, Price
                          """;


            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < categoryId.length; i++) {
                pstmt.setString((i+1),categoryId[i]);
            }
//            pstmt.setString(1,categoryId[0]); // categoryId 값의 1과 같음
//            pstmt.setString(2,"2");
//            pstmt.setString(3,"3");

            ResultSet resultSet = pstmt.executeQuery();
            var list = new ArrayList<MyBean256Product>();
            try(pstmt;resultSet) {
                while(resultSet.next()){
                    MyBean256Product obj = new MyBean256Product();
                    obj.setId(resultSet.getInt(1));
                    obj.setName(resultSet.getString(2));
                    obj.setSupplierId(resultSet.getInt(3));
                    obj.setCategoryId(resultSet.getInt(4));
                    obj.setUnit(resultSet.getString(5));
                    obj.setPrice(resultSet.getDouble(6));
                    list.add(obj);
                }
                model.addAttribute("prevCategorySelect",categoryId);
                model.addAttribute("products",list);
            }

        }
        return "/main25/sub6ProductList";
    }
}
