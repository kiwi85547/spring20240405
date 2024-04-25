# Normalization : 정규화(정규형)

# First Normal form : (1NF, 제1 정규화)
# 각 행을 유일하게 구분하는 컬럼이 존재한다.
# Primary Key(PK)
# 모든 데이터는 원자적으로 저장된다.
# 같은 형식의 데이터를 저장하는 여러 ㅋ
# 한 컬럼에 여러 값이 저장되지 않는다.

# Second Normal form : (2NF, 제2 정규화)
# Thrid Normal form : (3NF, 제3 정규화)

CREATE DATABASE mydb1;
use mydb1;

# 가장 좋은 PK는 의미없는 int로 자동 증가
CREATE TABLE customer
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    email        VARCHAR(300),
    name         VARCHAR(100),
    phone_number VARCHAR(100),
    address      VARCHAR(200),
    ssn          VARCHAR(13)
);
DROP TABLE customer;
DROP TABLE phone_number;

INSERT INTO customer(id, email, name, phone_number, address, ssn)
VALUES (1, '', '', '', '', '');
INSERT INTO customer(id, email, name, phone_number, address, ssn)
VALUES (4, 'a4@naver.com', '', '', '', '');
INSERT INTO customer(email, name, phone_number, address, ssn)
VALUES ('a@naver.com', '', '', '', '');
SELECT *
FROM customer;

CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(10),
    last_name  VARCHAR(10)
);

# FOREIGN KEY : 외래키 제약사항
CREATE TABLE phone_number
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    customer_id  INT,
    phone_number VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);
INSERT INTO customer(first_name, last_name)
VALUES ('son', 'hm'),
       ('lee', 'ki');
# primary키에 없기 때문에 에러
INSERT INTO phone_number(customer_id, phone_number)
VALUES (1, '13234');
SELECT *
FROM customer;
SELECT *
FROM phone_number;
DESC phone_number;