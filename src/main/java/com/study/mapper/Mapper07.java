package com.study.mapper;

import com.study.domain.MyBean254Customer;
import com.study.domain.MyBean254Employees;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Mapper07 {
    @Insert("""
            INSERT INTO Employees
            (lastName, FirstName)
            VALUES (#{lastName},#{firstName})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "employeeID")
    int insert(MyBean254Employees e);

    @Insert("""
            INSERT INTO Customers
            (CustomerName, Country)
            VALUES (#{name},#{country})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert2(MyBean254Customer c);

    @Select("""
            <script>            
            SELECT * FROM my_table
            <if test = "employeeID">
            --어떤 코드#{employeeID}

            </if>
            </script>
                      """)
    Object query2(MyBean254Employees e);
}
