package com.jjang051.model;

public class Criterion {
	private int pageNum;
	private int amout;
	public Criterion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Criterion(int pageNum, int amout) {
		super();
		this.pageNum = pageNum;
		this.amout = amout;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmout() {
		return amout;
	}
	public void setAmout(int amout) {
		this.amout = amout;
	}
}
