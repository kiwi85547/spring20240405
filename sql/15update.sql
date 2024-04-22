use w3schools;

# UPDATE 테이블명
# SET 컬럼명 = 바꿀값, 컬럼명 = 바꿀값,,,
# WHERE 레코드의 조건

# 주의!!! : UPDATE 전에 같은 WHERE로 SELECT 꼭 해보기!!!

SELECT *
FROM Customers
WHERE CustomerID = 10;

UPDATE Customers
SET CustomerName = 'IRON MAN'
WHERE CustomerID = 10;

UPDATE Customers
SET ContactName = 'Tony Stark'
WHERE CustomerID = 10;

UPDATE Customers
SET Address    = 'Stark Tower',
    City       = '맨하탄',
    PostalCode = '123'
WHERE CustomerID = 10;

SELECT *
FROM Customers
WHERE Country = '영국';

UPDATE Customers
SET Country = '영국'
WHERE Country = 'UK';

SELECT *
FROM Products;
UPDATE Products
SET Price=Price * 2
WHERE ProductID = 1;

UPDATE Products
SET Price=Price * 3
WHERE CategoryID = 2;