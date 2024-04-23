package com.study.mapper;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import com.study.domain.MyBean256Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper02 {
    @Select("SELECT NOW()")
    // 추상메소드
    public String selectNow();

    // 조회 결과의 컬럼명과
    // 리턴타입의 객체 프로퍼티명이 같으면
    // 값을 바인딩 해줌
    @Select("""
            SELECT ContactName,Address,City,Country
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean254Customer selectOneCustomer();

    @Select("""
            SELECT *
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean254Customer selectOneCustomer2();

    @Select("""
            SELECT  CustomerID   id,
                    CustomerName name,
                    ContactName,
                    Address,
                    City,
                    Country,
                    PostalCode
            FROM Customers
            WHERE CustomerID = 1
            """)
    MyBean254Customer selectOneCustomer3();

    @Select("""
            SELECT *
            FROM Employees
            WHERE EmployeeID = 1
            """)
    MyBean254Employees selectOneEmployee1();

    @Select("""
            SELECT *
            FROM Employees
            WHERE EmployeeID = #{EmployeeID}
            """)
    MyBean254Employees selectOneEmployee2(String employeeID);

    @Select("""
            SELECT CustomerID   id,
                    CustomerName name,
                    ContactName,
                    Address,
                    City,
                    Country,
                    PostalCode
            FROM Customers
            WHERE CustomerID = #{id}
            """)
    MyBean254Customer selectOneCustomer4(Integer id);

    @Select("""            
            SELECT CustomerID   id,
                    CustomerName name,
                    ContactName,
                    Address,
                    City,
                    Country,
                    PostalCode
            FROM Customers
            """)
    List<MyBean254Customer> selectAllCustomer1();

    @Select("""
            SELECT *
            FROM Employees
            ORDER BY BirthDate DESC;
            """)
    List<MyBean254Employees> selectAllEmployee();

    // #{파라미터명}
    @Select("""
                        SELECT CustomerID   id,
                    CustomerName name,
                    ContactName,
                    Address,
                    City,
                    Country,
                    PostalCode
                        FROM Customers
                        WHERE Country = #{country1}
                           OR Country = #{country2}
            ORDER BY Country;
                        """)
    // 사용자로부터 받는 리퀘스트 파라미터
    List<MyBean254Customer> selectCustomersByCountry(String country1, String country2);

    @Select("""
            SELECT ProductID id,
                ProductName name,
                SupplierID,
                CategoryID,
                Unit,
                Price
            FROM Products
            WHERE Price BETWEEN #{from} AND #{to}
            ORDER BY Price
            """)
    List<MyBean256Product> selectProductsByPriceBetween(Double from, Double to);
}
