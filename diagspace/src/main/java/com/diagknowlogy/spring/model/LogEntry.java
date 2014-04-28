package com.diagknowlogy.spring.model;

import java.util.Date;

public class LogEntry {
	public static enum entryType  
		{ ANOMALY, PATTERN};
	Date 		date;
	String 		text;
	String		relevance;
	String		tier;
	String		host;
	int			patternId;
	
	public LogEntry() {
		super();
	}
	
	public LogEntry(Date date, String text, String relevance, String tier,
			String host) {
		super();
		this.date = date;
		this.text = text;
		this.relevance = relevance;
		this.tier = tier;
		this.host = host;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public String getTier() {
		return tier;
	}
	public void setTier(String tier) {
		this.tier = tier;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	
}
