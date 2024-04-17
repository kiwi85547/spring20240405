use w3schools;
# WHERE 솎아낼 레코드 조건
SELECT CustomerName,City,Country FROM Customers WHERE Country='Germany';
SELECT CustomerName,City,Country FROM Customers WHERE City='Berlin';
SELECT CustomerName,City,Country FROM Customers;
# 컬럼명 비교연산자 값
# 값에 '' 로 감싸기(하지만, 수형식(number type)은 생략해도 됨)
SELECT * FROM Customers WHERE CustomerID = 1; # 권장
SELECT * FROM Customers WHERE CustomerID = '1';

# 비교연산자 : 같다 =, 작다 <, 작거나 같다 <=, 크거나 같다 >=, 크다 >
# 같지 않다 !=, <> (문법이 시스템마다 다름)
SELECT * FROM Customers WHERE CustomerID=3;
SELECT * FROM Customers WHERE CustomerID<3;
SELECT * FROM Customers WHERE CustomerID<=3;
SELECT * FROM Customers WHERE CustomerID>89;
SELECT * FROM Customers WHERE CustomerID>=89;
SELECT * FROM Customers WHERE CustomerID<>1;
SELECT * FROM Customers WHERE CustomerID!=1;

# 문자열 형식(대소문자 구분 없음)
SELECT * FROM Customers WHERE CustomerName > 's';
SELECT * FROM Customers WHERE CustomerName > 'S';
SELECT * FROM Customers WHERE CustomerName > 'Godos Cod';

# 날짜 형식
SELECT * FROM Employees WHERE BirthDate > '1968-01-01';

# todo :
SELECT * FROM Suppliers WHERE Country='USA';
SELECT * FROM Employees WHERE LastName='Fuller';
SELECT * FROM Products WHERE CategoryID=3;
SELECT * FROM Products WHERE Price >=20.0;
SELECT * FROM Orders WHERE OrderDate<'1997-01-01';
