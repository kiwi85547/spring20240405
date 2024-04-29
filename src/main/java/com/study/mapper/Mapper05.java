package com.study.mapper;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper05 {

    //    한번만 쓸 예정이면 여기에..
    @Data
    static class EmployeeIncome {
        private Integer employeeID;
        private String lastName;
        private String firstName;
        private Double income;
    }

    @Select("""
             SELECT e.EmployeeID, e.LastName, e.FirstName,
             SUM(od.Quantity*p.Price) AS income
            FROM Orders o 
            JOIN Employees e ON o.EmployeeID = e.EmployeeID
            JOIN OrderDetails od ON o.OrderID = od.OrderID
            JOIN Products p ON od.ProductID = p.ProductID
            WHERE o.orderDate BETWEEN #{from} AND #{to}
            GROUP BY e.EmployeeID
            ORDER BY income DESC
            """
    )
    List<EmployeeIncome> selectIncomeList(String from, String to);

    //    todo : 해당월의 고객별 구매금액 조회(구매금액이 높은 순)
    @Data
    static class CustomerOrder {
        private Integer customerID;
        private String customerName;
        private Double orderPrice;
    }

    @Select("""
            SELECT c.customerID, c.CustomerName, SUM(od.Quantity * p.Price) orderPrice
            FROM Products p
                     JOIN OrderDetails od ON od.ProductID = p.ProductID
                     JOIN Orders o ON o.OrderID = od.OrderID
                     JOIN Customers c ON c.CustomerID = o.CustomerID
            WHERE o.OrderDate BETWEEN ${from} AND ${to}
            GROUP BY c.CustomerName
            ORDER BY orderPrice DESC
            """)
    List<CustomerOrder> selectCustomerOrderList(String from, String to);

}
