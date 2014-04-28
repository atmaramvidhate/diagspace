package com.diagknowlogy.spring.model;

public class Alert {
		long alertId;
		String alertNumber;
		String alertDesc;
		
		public Alert(long alertId, String alertNumber, String alertDesc) {
			super();
			this.alertId = alertId;
			this.alertNumber = alertNumber;
			this.alertDesc = alertDesc;
		}
		public long getAlertId() {
			return alertId;
		}
		public void setAlertId(long alertId) {
			this.alertId = alertId;
		}
		public String getAlertNumber() {
			return alertNumber;
		}
		public void setAlertNumber(String alertNumber) {
			this.alertNumber = alertNumber;
		}
		public String getAlertDesc() {
			return alertDesc;
		}
		public void setAlertDesc(String alertDesc) {
			this.alertDesc = alertDesc;
		}
}
