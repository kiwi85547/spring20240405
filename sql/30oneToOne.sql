use mydb1;

# 1 대 1 관계 테이블(흔치 않음)
# salary를 employee테이블에 넣어놓고 싶지 않아서 따로 뺌
CREATE TABLE employee
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    name    VARCHAR(10),
    address VARCHAR(10)
);
CREATE TABLE employee_salary
(
    employee_id INT PRIMARY KEY REFERENCES employee (id),
    salary      INT
);
