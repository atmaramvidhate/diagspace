package com.diagknowlogy.spring.model;

import java.util.Date;

public class Feedback {
	    Who     feedbackProvided;
		String	description;
		String	detailedDescription;
		float		rating;

		public Who getFeedbackProvided() {
			return feedbackProvided;
		}
		public void setFeedbackProvided(Who feedbackProvided) {
			this.feedbackProvided = feedbackProvided;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getDetailedDescription() {
			return detailedDescription;
		}
		public void setDetailedDescription(String detailedDescription) {
			this.detailedDescription = detailedDescription;
		}
		public float getRating() {
			return rating;
		}
		public void setRating(float rating) {
			this.rating = rating;
		}
		
}
