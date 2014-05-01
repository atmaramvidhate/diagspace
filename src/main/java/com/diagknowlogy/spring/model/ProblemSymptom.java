package com.diagknowlogy.spring.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class ProblemSymptom {
	String			symptom;
	String 			Description;
	String			intervalName;
	Date			intervalTime;
	Time			intervalDuration; // Default is system defined.
	// Probability is relevant for later
	SymptomStatus	symptomStatus;
	List<SymptomGraphPoint>	graphPoints;
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getIntervalName() {
		return intervalName;
	}
	public void setIntervalName(String intervalName) {
		this.intervalName = intervalName;
	}
	public Date getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(Date intervalTime) {
		this.intervalTime = intervalTime;
	}
	public Time getIntervalDuration() {
		return intervalDuration;
	}
	public void setIntervalDuration(Time intervalDuration) {
		this.intervalDuration = intervalDuration;
	}
	public SymptomStatus getSymptomStatus() {
		return symptomStatus;
	}
	public void setSymptomStatus(SymptomStatus symptomStatus) {
		this.symptomStatus = symptomStatus;
	}
	public List<SymptomGraphPoint> getGraphPoints() {
		return graphPoints;
	}
	public void setGraphPoints(List<SymptomGraphPoint> graphPoints) {
		this.graphPoints = graphPoints;
	}
}
