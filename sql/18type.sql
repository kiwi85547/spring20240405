use w3schools;

# 문자열
# VARCHAR(길이)
CREATE TABLE my_table3
(
    name  varchar(3),
    title varchar(50),
    notes varchar(1000)
);
DESC my_table3;
INSERT INTO my_table3
    (name, title, notes)
VALUES ('이강인', '축구선수', '파리생제르망');
INSERT INTO my_table3
    (name, title, notes)
VALUES ('네이마르', '축구선수', '사우디');
SELECT *
FROM my_table3;

# todo : my_table4
#  책 제목, 책 내용, 저자
#  테이블 만들고, 데이터 추가, 조회

CREATE TABLE my_table4
(
    title    varchar(30),
    contents varchar(3000),
    author   varchar(10)
);
DESC my_table4;
INSERT INTO my_table4
    (title, contents, author)
VALUES ('나는 아픈건 딱 질색이니까',
        '오늘도 아침엔 입에 빵을 물고 똑같이 하루를 시작하고, 온종일 한 손엔 아이스 아메리카노
피곤해 죽겠네',
        '(여자)아이들');
UPDATE my_table4
SET contents='오늘도 아침엔 입에 빵을 물고 똑같이 하루를 시작하고, '
    '온종일 한 손엔 아이스 아메리카노 피곤해 죽겠네'
WHERE author = '(여자)아이들';
INSERT INTO my_table4
    (title, contents, author)
VALUES ('첫 만남은 계획대로 되지 않아',
        '첫 만남은 너무 어려워
        계획대로 되는 게 없어서
        첫 만남은 너무 어려워
        내 이름은 말야',
        '투어스');
SELECT *
FROM my_table4;

# 수
# 정수 INT
# 실수 DECIMAL,DEC
CREATE TABLE my_table5
(
    age    INT,
    height DEC(10, 4)
    # 총 길이 10, 소수점 이하 길이 4
);
DESC my_table5;
INSERT INTO my_table5
    (age, height)
VALUES (20, 170.34);
INSERT INTO my_table5
    (age, height)
VALUES (18, 176.34119);
SELECT *
FROM my_table5;

# todo : 새 테이블 my_table6
#  한 개의 정수 타입, 한 개의 실수 타입 컬럼
CREATE TABLE my_table6
(
    paper  INT,
    length DEC(7, 3)
);
INSERT INTO my_table6
    (paper, length)
VALUES (180, 4455.4456);
SELECT *
FROM my_table6;

# 날짜시간
# DATE : 날짜(YYYY-MM-DD)
# DATETIME : 날짜시간(YYYY-MM-DD HH:MM:SS)

CREATE TABLE my_table7
(
    col1 date,
    col2 datetime
);
desc my_table7;
INSERT INTO my_table7
    (col1, col2)
VALUES ('2024-01-30', '2024-04-24 11:30:22');
SELECT *
FROM my_table7;

# todo : my_table8
CREATE TABLE my_table8
(
    date      date,
    date_time datetime
);
INSERT INTO my_table8
    (date, date_time)
VALUES ('1990-09-25', '2024-04-24 11:33:55');
SELECT *
FROM my_table8;

CREATE TABLE my_table9
(
    string_col   varchar(300),
    int_col      INT,
    dec_col      DEC(10, 2),
    date_col     date,
    datetime_col datetime
);
INSERT INTO my_table9
    (string_col, int_col, dec_col, date_col, datetime_col)
VALUES ('영어', '95', '10.334', '0000-01-01', '1053-11-23 21:44:35');
SELECT *
FROM my_table9;
desc my_table9;

CREATE TABLE my_table10
(
    title     varchar(30),
    name      varchar(30),
    age       INT(30),
    price     DEC(10, 3),
    published DATE,
    inserted  DATETIME
);
INSERT INTO my_table10
    (title, name, age, price, published, inserted)
VALUES ('이것이 자바다', '신용권', 40, 28000.153, '2001-11-12', '1555-05-06 20:00:00'),
       ('스프링부트', '홍길동', 50, 15040.0, '2041-11-12', '1875-05-04 12:31:00');
SELECT *
FROM my_table10;
DELETE
FROM my_table10
WHERE title is null;
UPDATE my_table10
SET title='인지심리학',
    name='40',
    price=38000,
    published='2010-06-24',
    inserted='2013-12-16T05:31:13'
WHERE title = '제목';
