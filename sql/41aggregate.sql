# aggregate function : 집계함수
# 평균,합계,점수
# NULL은 집계시 제외됨

# COUNT : 갯수
SELECT COUNT(EmployeeID)
FROM Employees;

SELECT COUNT(Notes)
FROM Employees;

# 중복제거 count() 안에 distinct
SELECT COUNT(DISTINCT country)
FROM Customers;

SELECT MAX(Price)
FROM Products;

SELECT MIN(Price)
FROM Products;

SELECT SUM(Price)
FROM Products;

SELECT AVG(Price)
FROM Products;


