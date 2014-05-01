package com.diagknowlogy.spring.model;

import java.util.Date;

public class Who {
	Date   	date;
	long	id;
	String  name;
	
	public Who() {
		super();
	}
	public Who(Date date, long id, String name) {
		super();
		this.date = date;
		this.id = id;
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
