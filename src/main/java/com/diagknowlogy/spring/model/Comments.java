package com.diagknowlogy.spring.model;

public class Comments {
	Who    identity;
	String operatorComments;
	public Comments() {
		super();
	}
	
	public Comments(Who identity, String operatorComments) {
		super();
		this.identity = identity;
		this.operatorComments = operatorComments;
	}
	public Who getIdentity() {
		return identity;
	}
	public void setIdentity(Who identity) {
		this.identity = identity;
	}
	public String getOperatorComments() {
		return operatorComments;
	}
	public void setOperatorComments(String operatorComments) {
		this.operatorComments = operatorComments;
	}
}
