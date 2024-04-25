# 3NF

#1) 2NF이다.
#2) 키가 아닌 컬럼끼리 종속되면 안됨.

use mydb1;
drop table phone_number; #자식테이블 먼저 삭제하기
drop table customer;
drop table customer_benefit;
SELECT *
FROM customer;
SELECT *
FROM customer_benefit;
CREATE TABLE customer
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(3),
    last_name  VARCHAR(3),
    level      INT,
    FOREIGN KEY (level) REFERENCES customer_benefit (level)
);
CREATE TABLE customer_benefit
(
    level   INT PRIMARY KEY,
    benefit VARCHAR(100)
);

INSERT INTO customer(first_name, last_name, level)
VALUES ('son', 'hm', 1),
       ('lee', 'ki', 1),
       ('kim', 'hs', 2),
       ('lee', 'jh', 2),
       ('cap', 'ste', 3);

INSERT INTO customer_benefit(level, benefit)
VALUES (1, '무료배송'),
       (2, '할인'),
       (3, '라운지');