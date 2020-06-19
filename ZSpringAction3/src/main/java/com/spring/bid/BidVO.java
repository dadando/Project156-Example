/*
create table table_bid(
    cno number primary key,
    bidno number not null,
    bno number not null,
    now_price number not null,
    writer varchar2(20));
*/

package com.spring.bid;

public class BidVO {
	private int cno;
	private int bidno;
	private int bno;
	private int now_price;
	private String writer;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getNow_price() {
		return now_price;
	}
	public void setNow_price(int now_price) {
		this.now_price = now_price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getBidno() {
		return bidno;
	}
	public void setBidno(int bidno) {
		this.bidno = bidno;
	}
	
}
