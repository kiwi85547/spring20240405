package com.study.mapper;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface Mapper03 {

    @Delete("""
            DELETE FROM Customers 
            WHERE CustomerId=1
            """)
    int deleteOneCustomer();

    // i는 파라미터로 받는 변수가 아님
    // 내가 원하는대로 지정할 수 있음
    @Delete("""
            DELETE FROM Customers
            WHERE CustomerId=#{i}
            """)
    int deleteOneCustomerById(int i);

    @Delete("""
            DELETE FROM Employees
            WHERE EmployeeId=#{eid}
            """)
    int deleteOneEmployeeById(Integer eid);

    @Insert("""
            INSERT INTO Customers
            (CustomerName,ContactName,Address,City,PostalCode,Country)
            VALUES 
            (#{name},#{contactName},#{address},#{city},#{postalCode},#{country})
            """)
    int insertCustomer(MyBean254Customer customer);

    @Insert("""
            INSERT INTO Employees(LastName,FirstName,BirthDate,Photo,Notes)
            VALUES (#{lastName},#{firstName},#{birthDate},#{photo},#{notes})
            """)
    int insertEmployee(MyBean254Employees employees);

    @Update("""
            UPDATE Employees
            SET LastName=#{lastName},
                FirstName=#{firstName},
                Photo=#{photo},
                Notes=#{notes},
                BirthDate=#{birthDate}
                WHERE EmployeeId=#{employeeID}
            """)
    int updateEmployee(MyBean254Employees employee);
}
