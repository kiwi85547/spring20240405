use w3schools;

# 조건을 만족하지 않으면 TRUE
SELECT * FROM Employees WHERE BirthDate >= '1960-01-01';
SELECT * FROM Employees WHERE NOT BirthDate >= '1960-01-01';

SELECT * FROM Customers WHERE Country NOT IN ('France','UK','Spain') ORDER BY Country;

SELECT * FROM Products WHERE NOT Price BETWEEN 100 AND 200 ORDER BY Price;

# 여러 조건 사용시 괄호 잘 사용하기
SELECT * FROM Products WHERE (NOT CategoryID=1) AND Price>50 ORDER BY CategoryID,Price;

SELECT * FROM Orders WHERE NOT OrderDate BETWEEN '1997-01-01' AND '1997-12-31';

# todo : 국가가 UK,USA가 아닌 공급자 조회
SELECT * FROM Suppliers WHERE NOT Country IN('UK','USA');
SELECT * FROM Suppliers WHERE Country <> 'UK' AND Country <> 'USA';

