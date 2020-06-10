/*
create table smemberboard2(
    NUM number primary key,
    SUBJECT varchar2(20),
    CONTENT VARCHAR2(2000), 
    ORG_FILE VARCHAR2(50), 
    UP_FILE VARCHAR2(50),   
    RE_REF NUMBER,         
    RE_LEV NUMBER,         
    RE_SEQ NUMBER,         
    READCOUNT NUMBER,         
    BOARDDATE DATE         
);
*/

/*
create table table_comment(
    cno number not null primary key,
    bno number not null,
    content varchar2(2000) not null,
    writer varchar2(20) not null,
    reg_date date not null
); 
*/

package com.spring.mapper;

import java.util.HashMap;
import java.util.List;

import com.spring.mybatismb2.board.BoardVO;

public interface BoardMapper {
	public int getListCount();
	public List<BoardVO> getBoardList(HashMap<String, Integer> hashmap);
	public BoardVO getDetail(int num);
	public int boardInsert(BoardVO board); //원글 insert작업 수행
	public int boardReplyupdate(BoardVO board); //답글에 대한 re_seq update작업 수행
	public int boardReply(BoardVO board); //답글 insert작업 수행
	public int boardModify(BoardVO modifyboard);
	public int boardDelete(int num);
	public void setReadCountUpdate(int num);
	public int isBoardWriter(HashMap<String, String> hashmap);
}
