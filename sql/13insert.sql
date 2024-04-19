use w3schools;

# INSERT INTO 테이블명(컬럼명..)
# VALUES (데이터들..)

SELECT * FROM Employees ORDER BY EmployeeID DESC;
SELECT * FROM Customers ORDER BY CustomerID DESC;

DESC Employees;
DESC Customers;

INSERT INTO Employees(LastName) VALUES ('ironman');
INSERT INTO Employees (FirstName) VALUES ('tony');

# null : 값이 없음
INSERT INTO Employees(LastName, FirstName, BirthDate, Photo, Notes) VALUES ('Captain','steve','1990-01-01','pic1','america') ;

INSERT INTO Employees(FirstName,LastName) VALUES ('Natasha','widow');

# todo : 새 고객을 2개 입력하세요.
INSERT INTO Customers(CustomerName,Country) VALUES ('Kim','Korea');
INSERT INTO Customers(CustomerName,City) VALUES ('Jeong','Seoul');

