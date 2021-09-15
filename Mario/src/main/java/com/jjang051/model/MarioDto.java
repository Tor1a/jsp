package com.jjang051.model;

public class MarioDto {
	//속성 정의
	//게터 세터
	//생성자 두개 (default, 싹다)
	//toString
	//빨리 코드줘   현기증 난다 말이야...
	int no;
	String title;
	String contents;
	String bg;
	String link;
	String marioImg;
	String marioRealImg;
	
	
	
	public MarioDto() {
		super();
	}
	
	public MarioDto(int no, String title, String contents, String bg, String link, String marioImg,
			String marioRealImg) {
		super();
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.bg = bg;
		this.link = link;
		this.marioImg = marioImg;
		this.marioRealImg = marioRealImg;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getBg() {
		return bg;
	}
	public void setBg(String bg) {
		this.bg = bg;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getMarioImg() {
		return marioImg;
	}
	public void setMarioImg(String marioImg) {
		this.marioImg = marioImg;
	}
	public String getMarioRealImg() {
		return marioRealImg;
	}
	public void setMarioRealImg(String marioRealImg) {
		this.marioRealImg = marioRealImg;
	}

	@Override
	public String toString() {
		return "MarioDto [no=" + no + ", title=" + title + ", contents=" + contents + ", bg=" + bg + ", link=" + link
				+ ", marioImg=" + marioImg + ", marioRealImg=" + marioRealImg + "]";
	}
	
	//alt + shift + s
	
}
