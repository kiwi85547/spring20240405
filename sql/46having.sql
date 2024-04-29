use w3schools;

# HAVING : 집계함수의 조건절
SELECT CategoryID, COUNT(ProductId) 상품수
FROM Products
GROUP BY CategoryID
HAVING 상품수 >= 10;

# 집계함수 결과에 대한 조건
# 다시 한번 확인 WHERE절 이상
SELECT *
FROM (SELECT CategoryID, COUNT(ProductID) FROM Products GROUP BY CategoryID) 상품수
WHERE '상품수' >= 10;

# 고객이 5명 이상 있는 국가들 조회
SELECT Country, COUNT(CustomerID)
FROM Customers
GROUP BY Country
HAVING Count(CustomerID) >= 5
ORDER BY COUNT(CustomerID) DESC;

# 97년 7월 상품 매출액(SUM(상품가격*갯수))이 10000달러 이상인 직원들 조회
SELECT e.EmployeeID, SUM(p.Price * od.Quantity) 매출액
FROM Employees e
         JOIN Orders o ON o.EmployeeID = e.EmployeeID
         JOIN OrderDetails od ON od.OrderID = o.OrderID
         JOIN Products p ON p.ProductID = od.ProductID
WHERE o.OrderDate BETWEEN '1997-07-01' AND '1997-07-31'
GROUP BY e.EmployeeID
HAVING 매출액 >= 10000
ORDER BY 매출액 DESC;

SELECT EmployeeID, COUNT(EmployeeID)
FROM Orders
GROUP BY EmployeeID;