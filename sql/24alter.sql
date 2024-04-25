use w3schools;

#ALTER TABLE : 테이블 구조 변경

# 컬럼 추가
CREATE TABLE my_table23
(
    name VARCHAR(10),
    age  INT
);
INSERT INTO my_table23(name, age)
VALUES ('재후', 7);
ALTER TABLE my_table23
    ADD COLUMN address VARCHAR(10);
SELECT *
FROM my_table23;
DESC my_table23;

ALTER TABLE my_table23
    ADD COLUMN city VARCHAR(10);

# 컬럼 삭제(주의!!)
ALTER TABLE my_table23
    DROP address;
ALTER TABLE my_table23
    DROP COLUMN city;
# 컬럼 변경
# 이름,
ALTER TABLE my_table23 RENAME COLUMN address TO town;
# 자료형/제약사항 변경
ALTER TABLE my_table23
    MODIFY COLUMN town VARCHAR(20);

ALTER TABLE my_table23
    MODIFY name VARCHAR(30);

# 이미 age컬럼에 중복되어 있는 값이 있으면 unique 제약사항을 걸 수 없음
ALTER TABLE my_table23
    MODIFY COLUMN age INT UNIQUE;

DELETE
FROM my_table23
WHERE age = 7
  AND 10;

# UNIQUE 제약사항 삭제하기
SHOW index FROM my_table23;

ALTER TABLE my_table23
    DROP index age;

desc my_table23;

ALTER TABLE my_table23
    MODIFY COLUMN age INT NOT NULL;

ALTER TABLE my_table23
    MODIFY COLUMN name VARCHAR(20) DEFAULT 'guest';

ALTER TABLE my_table23
    ADD PRIMARY KEY (name);

ALTER TABLE my_table23
    DROP PRIMARY KEY;

ALTER TABLE my_table23
    MODIFY COLUMN age INT PRIMARY KEY;