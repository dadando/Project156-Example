create table smemberboard2(
    num number,
    id varchar2(20),
    subject varchar2(50),
    content varchar2(2000),
    org_file varchar2(50),
    up_file varchar2(50),
    re_ref number,
    re_lev number,
    re_seq number,
    readcount number,
    boarddate date,
    primary key(num)
);