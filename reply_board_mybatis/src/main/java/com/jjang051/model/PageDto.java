package com.jjang051.model;

public class PageDto {
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int total;
	private Criterion criterion;
	public PageDto() {
		super();
	}
	
	
	
	
	public PageDto(int total, Criterion criterion) {
		super();
		this.total = total;
		this.criterion = criterion;
		
		this.endPage = (int) Math.ceil(criterion.getPageNum()/criterion.getAmout())*criterion.getAmout();
		this.startPage = this.endPage - criterion.getAmout()-1;
		int realEnd = (int) (Math.ceil(total/criterion.getAmout()));
		if(realEnd<this.endPage) {
			this.endPage = realEnd;
		}
		this.prev= this.startPage > 1;
		this.next = this.endPage < realEnd;
	}


	


	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criterion getCriterion() {
		return criterion;
	}
	public void setCriterion(Criterion criterion) {
		this.criterion = criterion;
	}
	
	
}	
