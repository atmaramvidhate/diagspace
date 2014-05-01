package com.diagknowlogy.spring.model;

import java.util.Date;
import java.util.List;

public class KPI {
	String 					kpiName;
	List<SymptomGraphPoint> listValues;
	List<Date>				violations;
	
	public KPI(String kpiName, List<SymptomGraphPoint> listValues,
			List<Date> violations) {
		super();
		this.kpiName = kpiName;
		this.listValues = listValues;
		this.violations = violations;
	}
	
	public List<SymptomGraphPoint> getListValues() {
		return listValues;
	}
	public void setListValues(List<SymptomGraphPoint> listValues) {
		this.listValues = listValues;
	}
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public List<Date> getViolations() {
		return violations;
	}
	public void setViolations(List<Date> violations) {
		this.violations = violations;
	}
}
