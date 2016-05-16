-- 회원 정보를 표시한 테이블
create table member(
memid varchar2(30) primary key, --회원아이디
memname varchar2(100) not null, --회원이름
mempwd varhar2(30) not null --회원암호
)


-- 상품 정보를 표시한 테이블
create table goods(
gno   number  primary key,         -- 상품번호
brand varchar2(100) not null,      -- 상품명
price number        default 0,   -- 가격
maker varchar2(50),                -- 제조사
info  varchar2(4000),               -- 상품 정보
);


insert into goods (gno,brand, price, maker)
values(1, '오후에 마시는 마테차', 9000,'동글실업');
insert into goods (gno,brand, price, maker)
values(2,'usb 마우스', 12000,'삼성전자');
insert into goods (gno,brand, price, maker)
values(3,'java와 함께', 25000,'jaen');

select * from goods;


