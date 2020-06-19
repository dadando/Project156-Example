/*
create table bid_board(
    num number primary key,
    id varchar2(20),
    subject varchar2(50),
    start_price number,
    now_price number,
    end_price number,
    readcount number,
    boarddate date);
*/
package com.spring.bid.board;

import java.sql.Date;

public class BoardVO {
	private int num;
	private String id;
	private String subject;
	private int start_price;
	private int now_price;
	private int end_price;
	private int readcount;
	private Date boarddate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getStart_price() {
		return start_price;
	}
	public void setStart_price(int start_price) {
		this.start_price = start_price;
	}
	public int getNow_price() {
		return now_price;
	}
	public void setNow_price(int now_price) {
		this.now_price = now_price;
	}
	public int getEnd_price() {
		return end_price;
	}
	public void setEnd_price(int end_price) {
		this.end_price = end_price;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public Date getBoarddate() {
		return boarddate;
	}
	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
