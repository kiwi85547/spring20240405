use w3schools;

# 1행 1열 결과(scalar)
SELECT AVG(Price)
FROM Products;

SELECT *
FROM Products
WHERE Price >= (SELECT AVG(Price) FROM Products);

# todo : 1번 카테고리 상품의 평균가격보다 높은 2번 카테고리 상품명 조회
SELECT ProductName
FROM Products
WHERE Price >= (SELECT AVG(Price)
                FROM Products
                WHERE CategoryID = 1)
  AND CategoryID = 2;

# 여러행 1열 결과
SELECT CustomerID
FROM Customers
WHERE Country = 'Mexico';

SELECT *
FROM Orders
WHERE CustomerID IN (2, 3, 13, 58, 80);

# Mexico 고객이 주문한 건들 조회 (서브쿼리)
SELECT *
FROM Orders
WHERE CustomerID IN (SELECT CustomerID
                     FROM Customers
                     WHERE Country = 'Mexico');

# Mexico 고객이 주문한 건들 조회 (조인)
SELECT *
FROM Orders o
         JOIN Customers c ON c.CustomerID = o.CustomerID
WHERE Country = 'mexico';

# todo : 1번 카테고리 상품들이 주문된 날짜들 조회

SELECT ProductID
FROM Products
WHERE CategoryID = 1;

SELECT OrderID
FROM OrderDetails
WHERE ProductID IN (1, 2, 24);

SELECT OrderDate
FROM Orders
WHERE OrderID IN (10254, 10255);

SELECT DISTINCT OrderDate
FROM Orders
WHERE OrderID IN (SELECT OrderID
                  FROM OrderDetails
                  WHERE ProductID IN (SELECT ProductID
                                      FROM Products
                                      WHERE CategoryID = 1));

# 카테시안 곱이 이루어짐
SELECT o.OrderDate
FROM Orders o
         JOIN OrderDetails od ON o.OrderID = od.OrderID
         JOIN Products p ON od.ProductID = p.ProductID
WHERE p.ProductID = 1;

# 여러행 여러열 결과
SELECT City, Country
FROM Customers
WHERE CustomerID IN (1, 2);

# 적절한 예제는 아님
SELECT Customers.CustomerName
FROM Customers
WHERE (City, Country) IN (SELECT City, Country
                          FROM Customers
                          WHERE CustomerID IN (1, 2));

# 특정 조회 결과를 from절에 쓸 수 있다.
SELECT CustomerName, City
FROM (SELECT Customers.CustomerName, City
      FROM Customers) AS miniCustomers;

# 상관서브쿼리(속도가 느린편, 조인으로 해결할 수 있는지 생각해보아야함)
# 외부 쿼리의 값이 내부 쿼리에 사용될 때

# 각 고객의 주문 횟수
SELECT CustomerName,
       Country,
       (SELECT COUNT(OrderID) FROM Orders o WHERE o.CustomerID = c.CustomerID)
           AS COUNT
FROM Customers c;

SELECT COUNT(OrderID)
FROM Orders
WHERE CustomerID = 1;

# 상관서브쿼리 -> 조인으로 해결.
# OUTER JOIN은 주문을 안한 고객은 행에서 빠짐
# LEFT JOIN 을 하면 count 0도 들어감
SELECT CustomerName, Country, COUNT(OrderID)
FROM Customers c
         LEFT JOIN Orders o ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID;

# todo : 각 상품별 총 매출금액
# 내가 만든 것. 좀 이상... 다시 살펴보기
SELECT ProductName, SUM(Price * Quantity)
FROM Products p
         JOIN OrderDetails od ON p.ProductID = od.ProductID
GROUP BY ProductName;

SELECT ProductID,
       ProductName,
       (SELECT SUM(od.Quantity) FROM OrderDetails od WHERE p.ProductID = od.ProductID) * p.Price
FROM Products p;