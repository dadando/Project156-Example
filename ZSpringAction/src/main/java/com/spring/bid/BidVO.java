package com.spring.bid;

public class BidVO {
	private int cno;
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
	
}
