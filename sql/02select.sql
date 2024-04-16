USE w3schools;

# 데이터 조회
# select * from 테이블명;
SELECT * FROM Customers;

SELECT * FROM Employees;

# todo : Suppliers 테이블 조회
SELECT * FROM Suppliers;

# 특정 컬럼만 조회
# select 컬럼명,컬럼명 from 테이블명
select SupplierName,City from Suppliers;

# 모든 컬럼 조회
# select * from 테이블명
select * from Customers;

# 테이블의 컬럼들 조회
DESCRIBE Customers;
DESC Customers;

# todo : Employees 테이블의 컬럼이 어떤 것들이 있는지 조회
# todo : Employees 테이블 조회(first name, last name)
DESCRIBE Employees;
SELECT FirstName, LastName from Employees;

select * from w3schools.Employees;

# SELECT 에 나열한 컬럼명의 순서대로 결과가 나옴
select BirthDate, FirstName, LastName FROM Employees;

# SQL 작성 시 관습 : 키워드는 대문자, 나머지는 소문자
select * from Employees; -- xxx
SELECT * FROM Employees; -- ok

