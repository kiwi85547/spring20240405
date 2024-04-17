use w3schools;

# and 여러 조건 만족
# or 하나의 조건만 만족

SELECT * FROM Products WHERE ProductName LIKE 'a%'
                          or ProductName LIKE '%l';

SELECT * FROM Products WHERE CategoryID = 1
                          OR CategoryID = 3
                          OR CategoryID = 5;

SELECT * FROM Products WHERE CategoryID = 1
                         AND ProductName LIKE 'c%'
                         AND Price < 20;

# WHERE 의 조건을 () 사용해서 우선순위 결정
# AND 논리곱 OR 논리합
# 논리곱이 먼저 실행됨
SELECT * FROM Products WHERE CategoryID = 1
                         AND (ProductName LIKE 'c%'
                         OR Price < 20);

# todo : 국가 UK나 USA에 있는 고객들 조회
SELECT * FROM Customers WHERE Country = 'UK' OR Country ='USA';
# todo : 도시가 Madrid나 London에 있는 고객들 조회
SELECT * FROM Customers WHERE City = 'Madrid' OR City='London';
# todo : 1997년 5월에 주문한 주문(Orders)들
SELECT * FROM Orders WHERE OrderDate LIKE '1997-05-__';
SELECT * FROM Orders WHERE OrderDate >= '1997-05-01'
                        AND OrderDate < '1997-06-01';

# 키워드가 customerName, contactName 에 있는 고객들 조회
SELECT * FROM Customers WHERE CustomerName LIKE '%be%'
                           OR ContactName LIKE '%be';
