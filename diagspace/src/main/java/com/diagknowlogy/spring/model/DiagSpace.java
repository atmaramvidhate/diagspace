package com.diagknowlogy.spring.model;

import java.util.HashMap;
import java.util.List;

public class DiagSpace {
	ProblemInfo 						problemInfo;
	HashMap<Integer, ProblemSymptom> 	pinnedSympotoms;
	HashMap<Integer, MatchedProblem> 	matchedProblems;
	List<TierIndex>						tierIndexes;

	public DiagSpace() {
		// TODO Auto-generated constructor stub

	}

	/**
	 * @return
	 */
	public ProblemInfo getProblemInfo() {
		return problemInfo;
	}

	public void setProblemInfo(ProblemInfo problemInfo) {
		this.problemInfo = problemInfo;
	}

	public HashMap<Integer, ProblemSymptom> getPinnedSympotoms() {
		return pinnedSympotoms;
	}

	public void setPinnedSympotoms(
			HashMap<Integer, ProblemSymptom> pinnedSympotoms) {
		this.pinnedSympotoms = pinnedSympotoms;
	}

	public HashMap<Integer, MatchedProblem> getMatchedProblems() {
		return matchedProblems;
	}

	public void setMatchedProblems(HashMap<Integer, MatchedProblem> matchedProblems) {
		this.matchedProblems = matchedProblems;
	}

}
