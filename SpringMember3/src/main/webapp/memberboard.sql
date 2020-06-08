create table smember(
    id varchar2(15),
    PASSWORD VARCHAR2(10),
    NAME VARCHAR2(15), 
    AGE NUMBER,       
    GENDER VARCHAR2(5),  
    EMAIL VARCHAR2(30),
    primary key(id)
);

create table smemberboard(
    num number,
    id varchar2(20),
    subject varchar2(50),
    content varchar2(2000),
    re_ref number,
    re_lev number,
    re_seq number,
    readcount number,
    boarddate date,
    primary key(num)
);
desc smember;
select * from smember;
desc smemberboard;
select * from smemberboard;