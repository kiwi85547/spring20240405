create database mydb2;

use mydb2;

create table table12
(
    number int
);

INSERT INTO table12 (number)
VALUES (3),
       (4),
       (5),
       (null);

INSERT INTO table12 (number)
VALUES (null);

SELECT *
FROM table12;

# null값을 0으로 변환해서 보여줌
SELECT IFNULL(number, 0)
FROM table12;

SELECT AVG(IFNULL(number, 0))
FROM table12;

# 5
SELECT COUNT(IFNULL(number, 0))
FROM table12;

# 3
SELECT COUNT(number)
FROM table12;