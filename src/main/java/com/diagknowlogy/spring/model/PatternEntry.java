package com.diagknowlogy.spring.model;

import java.util.List;

public class PatternEntry {
		int					patternId;
		String  			patternText;
		int					count;
		List<LogEntry> 		logEntries;
		
		public int getPatternId() {
			return patternId;
		}
		public void setPatternId(int patternId) {
			this.patternId = patternId;
		}
		public String getPatternText() {
			return patternText;
		}
		public void setPatternText(String patternText) {
			this.patternText = patternText;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
}
