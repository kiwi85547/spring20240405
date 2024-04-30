package com.study.mapper;

import com.study.domain.MyBean254Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Mapper08 {

    @Select("""
            <script>
            SELECT * FROM Employees
            <if test="lastName!=null">   
            WHERE LastName='abc'
            </if>
            </script>
            """)
    List<MyBean254Employees> query1();

    void query2(MyBean254Employees e);

    @Select("""

            """)
    Object query3(MyBean254Employees e);

    @Select("""
            <script>
            SELECT * FROM my_table
            <if test='firstName!=null'>
            WHERE FirstName='null아님'</if>
            <if test='firstName==null'>
            WHERE FirstName='null임'</if>
            <if test="firstName=='kim'">
            WHERE FirstName='kim임'</if>
            <if test='firstName=="lee"'>
            WHERE FirstName='lee임'</if>
            </script>
            """)
    Object query4(MyBean254Employees e);

    @Select("""
            <script>
            SELECT * FROM my_table
            <trim prefix="WHERE" prefixOverrides="OR">
            <if test="lastName!=null">
            OR LastName=#{lastName}
            </if>
            </trim>
            </script>
            """)
    Object query5(MyBean254Employees e);

    @Select("""
            <script>
            <bind name="patternKeyword" value='"%" + keyword + "%"' />
            SELECT * FROM Employees
            WHERE notes LIKE #{patternKeyword}
            </script>
            """)
    List<MyBean254Employees> query6(String keyword);

    @Select("""
                        <script>
            <![CDATA[
            SELECT * FROM Products
                        WHERE Price &lt; 5
            ]]>            
            </script>            
            """)
    void query7();
}
