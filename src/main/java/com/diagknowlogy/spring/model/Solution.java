package com.diagknowlogy.spring.model;

import java.util.HashMap;
import java.util.List;

public class Solution {
	int					solutionId;
	List<Feedback>  	feedbacks;
	List<String>		tags;                   // Tags to be added once the solution is accepted/rejected
	List<String>		reasons;				// Reasons provided when solution is accepted/rejected
}
