package com.diagknowlogy.spring.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class MatchedProblem extends ProblemInfo implements Serializable {

	private static final long serialVersionUID = -1397511629L;
	
	String						confidenceLevel;
	ProgressLevel				progressLevel;
	boolean						acceptRejectFlag;

	public String getConfidenceLevel() {
		return confidenceLevel;
	}
	public void setConfidenceLevel(String confidenceLevel) {
		this.confidenceLevel = confidenceLevel;
	}
	public ProgressLevel getProgressLevel() {
		return progressLevel;
	}
	public void setProgressLevel(ProgressLevel progressLevel) {
		this.progressLevel = progressLevel;
	}
}
