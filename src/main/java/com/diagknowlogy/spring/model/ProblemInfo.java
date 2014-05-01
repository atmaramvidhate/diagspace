package com.diagknowlogy.spring.model;

import java.util.List;

public class ProblemInfo {
	long				problemId;
	String				problemNumber;
	String				problemDescription;
	String				hostName;
	String				priority;
	String				appComponent;
	List<KPI> 				kpis;
	List<ProblemSymptom> 	problemSymptoms;
	List<LogEntry> 			anomalies;
	List<PatternEntry>		patternEntries;
	ProblemStatus		problemStatus;
	Who					create;
	List<Who>			update;
	List<Who>			access;
	List<Who>			assigned;
	List<Comments>		operatorComments;
	List<Solution>		solutions;	
	String				rootCause;
	long				duplicateProblemId;  // only if this a duplicate problem
	
	public List<KPI> getKpis() {
		return kpis;
	}

	public void setKpis(List<KPI> kpis) {
		this.kpis = kpis;
	}

	public List<ProblemSymptom> getProblemSymptoms() {
		return problemSymptoms;
	}

	public void setProblemSymptoms(List<ProblemSymptom> problemSymptoms) {
		this.problemSymptoms = problemSymptoms;
	}

	public List<LogEntry> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(List<LogEntry> anomalies) {
		this.anomalies = anomalies;
	}

	public List<PatternEntry> getPatternEntries() {
		return patternEntries;
	}

	public void setPatternEntries(List<PatternEntry> patternEntries) {
		this.patternEntries = patternEntries;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public ProblemInfo() {
		super();
	}
	
	public ProblemInfo(long problemId, String problemNumber,
			long duplicateProblemId, ProblemStatus problemStatus,
			String problemDescription, String hostName, String priority,
			String appComponent, Who create, List<Who> update,
			List<Who> access, List<Who> assigned, List<Comments> operatorComments) {
		super();
		this.problemId = problemId;
		this.problemNumber = problemNumber;
		this.duplicateProblemId = duplicateProblemId;
		this.problemStatus = problemStatus;
		this.problemDescription = problemDescription;
		this.hostName = hostName;
		this.priority = priority;
		this.appComponent = appComponent;
		this.create = create;
		this.update = update;
		this.access = access;
		this.assigned = assigned;
		this.operatorComments = operatorComments;
	}
	public long getProblemId() {
		return problemId;
	}
	public void setProblemId(long problemId) {
		this.problemId = problemId;
	}
	public String getProblemNumber() {
		return problemNumber;
	}
	public void setProblemNumber(String problemNumber) {
		this.problemNumber = problemNumber;
	}
	public long getDuplicateProblemId() {
		return duplicateProblemId;
	}
	public void setDuplicateProblemId(long duplicateProblemId) {
		this.duplicateProblemId = duplicateProblemId;
	}
	public ProblemStatus getProblemStatus() {
		return problemStatus;
	}
	public void setProblemStatus(ProblemStatus problemStatus) {
		this.problemStatus = problemStatus;
	}
	public String getProblemDescription() {
		return problemDescription;
	}
	public void setProblemDescription(String problemDescription) {
		this.problemDescription = problemDescription;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getAppComponent() {
		return appComponent;
	}
	public void setAppComponent(String appComponent) {
		this.appComponent = appComponent;
	}
	public Who getCreate() {
		return create;
	}
	public void setCreate(Who create) {
		this.create = create;
	}
	public List<Who> getUpdate() {
		return update;
	}
	public void setUpdate(List<Who> update) {
		this.update = update;
	}
	public List<Who> getAccess() {
		return access;
	}
	public void setAccess(List<Who> access) {
		this.access = access;
	}
	public List<Who> getAssigned() {
		return assigned;
	}
	public void setAssigned(List<Who> assigned) {
		this.assigned = assigned;
	}
	public List<Comments> getOperatorComments() {
		return operatorComments;
	}
	public void setOperatorComments(List<Comments> operatorComments) {
		this.operatorComments = operatorComments;
	}
}
