package com.keshe.luntan.entity;

import java.io.Serializable;

public class Paging implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int totalpage;
	private int currentpage;
	private int numbers;
	private int order;
	private Object pojo;
	
	public Paging() {
		super();
	}

	
	public Paging(int totalpage, int currentpage, int numbers, int order, Object pojo) {
		super();
		this.totalpage = totalpage;
		this.currentpage = currentpage;
		this.numbers = numbers;
		this.order = order;
		this.pojo = pojo;
	}

	
	@Override
	public String toString() {
		return "paging [totalpage=" + totalpage + ", currentpage=" + currentpage + ", numbers=" + numbers + ", order="
				+ order + ", entity=" + pojo + "]";
	}


	public int getOrder() {
		return order;
	}


	public void setOrder(int order) {
		this.order = order;
	}


	public int getTotalpage() {
		return totalpage;
	}

	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public int getNumbers() {
		return numbers;
	}

	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}

	public Object getPojo() {
		return pojo;
	}

	public void setPojo(Object pojo) {
		this.pojo = pojo;
	}
}
