package com.shensu.pojo;

public class Data {
	
	private keyword keyword1;
	
	private keyword keyword2;
	
	private keyword keyword3;
	
	private keyword keyword4;
	
	private keyword keyword5;

	public keyword getKeyword1() {
		return keyword1;
	}

	public keyword getKeyword4() {
		return keyword4;
	}

	public void setKeyword4(keyword keyword4) {
		this.keyword4 = keyword4;
	}

	public keyword getKeyword5() {
		return keyword5;
	}

	public void setKeyword5(keyword keyword5) {
		this.keyword5 = keyword5;
	}

	public void setKeyword1(keyword keyword1) {
		this.keyword1 = keyword1;
	}

	public keyword getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(keyword keyword2) {
		this.keyword2 = keyword2;
	}

	public keyword getKeyword3() {
		return keyword3;
	}

	public void setKeyword3(keyword keyword3) {
		this.keyword3 = keyword3;
	}

	public Data(keyword keyword1, keyword keyword2, keyword keyword3) {
		super();
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
	}
	
	
	public Data(keyword keyword1, keyword keyword2, keyword keyword3, keyword keyword4, keyword keyword5) {
		super();
		this.keyword1 = keyword1;
		this.keyword2 = keyword2;
		this.keyword3 = keyword3;
		this.keyword4 = keyword4;
		this.keyword5 = keyword5;
	}
	
	
	

}
