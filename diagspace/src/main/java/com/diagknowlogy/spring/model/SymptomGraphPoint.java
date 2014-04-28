package com.diagknowlogy.spring.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

public class SymptomGraphPoint {
	Date	time;
	int 	value;
	
	public SymptomGraphPoint(Date time, int value) {
		super();
		this.time = time;
		this.value = value;
	}
	
	@JsonSerialize(using=DateSerializer.class)
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
