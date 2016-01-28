--建表
CREATE TABLE books (
  bk_id number(10) ,
  bk_category varchar2(100),
  bk_title varchar2(100),
  bk_titlelang varchar2(100),
  bk_year number(5),
  bk_price number(10,2),
  bk_author varchar2(100),
  bk_logo varchar2(100)
);

--添加主键
alter table books add constraint pk_books primary key(bk_id);

--创建序列
create sequence seq_book start with 1 increment by 1 cache 10 nomaxvalue;

