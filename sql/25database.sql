# 사용할 데이터베이스(스키마) 선택하기
use w3schools;

SHOW tables;

# 새 데이터베이스 만들기
CREATE DATABASE mydb1;
use mydb1;
SHOW tables;
CREATE TABLE my_table11
(
    name VARCHAR(5)
);

# todo : mydb2 데이터베이스 만들고 옮겨서 새 테이블 하나 만들기
CREATE DATABASE mydb2;
USE mydb2;
CREATE TABLE test1
(
    col VARCHAR(10)
);
SHOW tables;

SELECT *
FROM w3schools.my_table23;

# 데이터베이스 삭제(매우 주의!!)
DROP DATABASE mydb2;
DROP DATABASE mydb1;
