use w3schools;

# GROUP BY : 집계함수(avg,sum,count,min,max)를 그룹별로 결과를 냄
# 카테고리 이름을 알고 싶으면 서브쿼리를 넣어서 알 수 있다
SELECT CategoryID, COUNT(ProductID)
FROM Products
GROUP BY CategoryID;

SELECT c.CategoryID, c.CategoryName, COUNT(ProductID) AS '상품별 갯수'
FROM Products p
         JOIN Categories c ON c.CategoryID = p.CategoryID
GROUP BY c.CategoryID;

# 특정 기간동안 1등 매출을 올린 직원 뽑기
SELECT e.EmployeeID, SUM(od.Quantity * p.Price) 매출액
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
         JOIN Employees e ON e.EmployeeID = o.EmployeeID
WHERE OrderDate BETWEEN '1997-01-01' AND '1997-12-31'
GROUP BY e.EmployeeID
ORDER BY 매출액 DESC;

# 1997년 7월 기준 고객별 소비금액을 금액이 높은 순서로 조회
SELECT c.CustomerID, c.CustomerName, SUM(od.Quantity * p.Price) 소비금액
FROM Orders o
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
         JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY c.CustomerID
ORDER BY 소비금액 DESC
LIMIT 5;

SELECT SUM(od.Quantity * p.Price) 소비금액
FROM Orders o
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY o.CustomerID
ORDER BY 소비금액 DESC
LIMIT 5;

SELECT CustomerId, COUNT(CustomerID)
FROM Orders
GROUP BY CustomerID
ORDER BY COUNT(CustomerID) DESC;

# 고객별, 상품별 주문량
SELECT CustomerName, o.CustomerID, p.ProductID, p.ProductName, SUM(Quantity) AS 상품주문수
FROM OrderDetails od
         JOIN Orders o ON o.OrderID = od.OrderID
         JOIN Customers c ON c.CustomerID = o.CustomerID
         JOIN Products p ON p.ProductID = od.ProductID
GROUP BY o.CustomerID, ProductID
ORDER BY CustomerID, 상품주문수 DESC;

# 국가별, 상품별 판매 갯수 조회(국가(asc),상품판매수(desc)순 정렬)
SELECT c.Country, p.ProductName, SUM(Quantity) 상품판매수
FROM Products p
         JOIN OrderDetails od ON od.ProductID = p.ProductID
         JOIN Orders o ON o.OrderID = od.OrderID
         JOIN Customers c ON c.CustomerID = o.CustomerID
GROUP BY c.Country, p.ProductName # 대분류, 소분류 순
ORDER BY c.Country, 상품판매수 DESC;

# 상품별, 국가별 주문수량
SELECT p.ProductName, c.Country, SUM(Quantity) 상품판매수
FROM Products p
         JOIN OrderDetails od ON od.ProductID = p.ProductID
         JOIN Orders o ON o.OrderID = od.OrderID
         JOIN Customers c ON c.CustomerID = o.CustomerID
GROUP BY p.ProductName, c.Country
ORDER BY p.ProductName, c.Country, 상품판매수 DESC;

SELECT *
FROM OrderDetails
ORDER BY Quantity DESC;

# todo : 해당월의 고객별 구매금액 조회(구매금액이 높은 순)
SELECT c.CustomerID, c.CustomerName, SUM(od.Quantity * p.Price) OrderPrice
FROM Products p
         JOIN OrderDetails od ON od.ProductID = p.ProductID
         JOIN Orders o ON o.OrderID = od.OrderID
         JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE o.OrderDate BETWEEN '1997-04-01' AND '1997-04-31'
GROUP BY c.CustomerID
ORDER BY OrderPrice DESC;