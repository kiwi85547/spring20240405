use w3schools;

# UNIQUE : 다른 레코드의 컬럼 값이 중복되지 않음
CREATE TABLE my_table15
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);
INSERT INTO my_table15
    (col1, col2)
VALUES ('abc', 'def');
SELECT *
FROM my_table15;
INSERT INTO my_table15
    (col1, col2)
VALUES ('qwe', 'qwe');
INSERT INTO my_table15
    (col1, col2)
VALUES ('abc', 'abc');
INSERT INTO my_table15
    (col1, col2)
VALUES ('abc', 'def');
DESC my_table15;
INSERT INTO my_table15
    (col1)
VALUES ('abc');

CREATE TABLE my_table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE,
    col3 VARCHAR(10) NOT NULL UNIQUE
);
INSERT INTO my_table16
    (col1, col2, col3)
VALUES ('abc', 'def', 'ghi');

INSERT INTO my_table16
    (col1, col2, col3)
VALUES ('abc', 'def1', 'ghi1');

INSERT INTO my_table16
    (col1, col3)
VALUES ('abc', 'def');
INSERT INTO my_table16
    (col3)
VALUES ('abc');
SELECT *
FROM my_table16;
DESC my_table16;
