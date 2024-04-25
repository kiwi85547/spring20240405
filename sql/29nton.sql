# n to n : 다 대 다 관계
use mydb1;
CREATE TABLE board
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    title   VARCHAR(20),
    content VARCHAR(20)
);
CREATE TABLE member
(
    id    INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(20),
    info  VARCHAR(20)
);

# 다대다 관계의 테이블의 중간테이블 생성
# 공식임. 외워서 쓰기
# 두 테이블의 PK
# foreign key 제약사항 바로 줘도 됨
# PK는 의미없는 id를 만들어도 되고, 두 테이블을 엮어서 PK로 만들어도 됨
CREATE TABLE board_like
(
    board_id  INT REFERENCES board (id),
    member_id INT REFERENCES member (id),
    PRIMARY KEY (board_id, member_id)
);
DROP TABLE board;
DROP TABLE board_like;
DROP TABLE member;