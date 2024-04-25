use w3schools;
# DEFAULT : 값을 주지 않을 때의 기본값을 정의
CREATE TABLE my_table13
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) DEFAULT 'abc'
);
INSERT INTO my_table13(col1, col2)
values ('qwe', 'zcx');

INSERT INTO my_table13(col1, col2)
values ('qwe', NULL);

INSERT INTO my_table13(col2)
values ('zcx');
INSERT INTO my_table13(col1)
values ('zcx');
SELECT *
FROM my_table13;

CREATE TABLE my_table14
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) NOT NULL,
    col3 VARCHAR(10)          DEFAULT 'abc123',
    col4 VARCHAR(10) NOT NULL DEFAULT 'qwer'
);
DESC my_table14;
SELECT *
FROM my_table14;

INSERT INTO my_table14(col2, col4)
VALUES ('a', 'b');