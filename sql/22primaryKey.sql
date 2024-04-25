use w3schools;

#Primary Key : NOT NULL UNIQUE
CREATE TABLE my_table17
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) PRIMARY KEY
);

INSERT INTO my_table17
    (col1, col2)
VALUES ('abc', 'def');

INSERT INTO my_table17
    (col2)
VALUES ('abc');

SELECT *
FROM my_table17;
desc my_table17;

# 여러 컬럼 조합으로 PRIMARY KEY 제약사항을 줄 수 있음
CREATE TABLE my_table21
(
    col1 INT,
    col2 INT,
    col3 INT,
    PRIMARY KEY (col1, col2)
);
DESC my_table21;
INSERT INTO my_table21
    (col1, col2, col3)
VALUES ('12', '12', '55555');

INSERT INTO my_table21
    (col1, col2, col3)
VALUES ('12', '123', '55555');

CREATE TABLE my_table22
(
    col1 INT PRIMARY KEY,
    col2 VARCHAR(10),
    col3 VARCHAR(10)
);
INSERT INTO my_table22
    (col1, col2, col3)
VALUES (5, 'a0', 'b0');
SELECT *
FROM my_table22;

