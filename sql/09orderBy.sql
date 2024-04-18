use w3schools;

# order by : 조회 순서 결정
# order by 컬럼명
SELECT * FROM Products ORDER BY Price;

# ASC : 오름차순
SELECT * FROM Products ORDER BY Price ASC;

# DESC : 내림차순
SELECT * FROM Products ORDER BY Price DESC ;

# 여러 컬럼 기준
# CategoryID 안에서 Price를 오름차순으로 정렬
SELECT * FROM Products ORDER BY CategoryID,Price;

SELECT * FROM Products ORDER BY CategoryID, Price DESC ;

# 컬럼명 대신 컬럼 index
SELECT * FROM Products ORDER BY 3,1;

# SELECT에 명시한 컬럼명의 순서를 따라야 함
# ORDER BY CategoryID,Price 와 같음
SELECT Products.ProductName,Products.CategoryID,Products.Price FROM Products ORDER BY 2,3;

# todo : 나이가 많은 직원
SELECT * FROM Employees ORDER BY BirthDate;
SELECT * FROM Customers ORDER BY Country,City;
SELECT * FROM Suppliers ORDER BY 5;
SELECT * FROM Employees ORDER BY FirstName DESC ;

SELECT * FROM Products WHERE CategoryID IN(1,2) ORDER BY CategoryID;