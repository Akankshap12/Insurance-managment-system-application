/* 
Program which acts as a model for the health insurance plans with its getters and setters for the users Admin and policy holder to perform operations
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: Plans.java
Date:11/23/2017
   
 */
package model;

import java.util.Date;

/* class called Plans.java which includes getters and setters to perform operation such as add plans,delete plans and view plans
 * Programmer : Sadaa Sree Ravichandar
 * Date		  :09/24/2017
 * */
public class Plans {
	Integer planID;
	String planName, planDescription, planStatus;
	Double planAmount, planPremium;
	Date startDate, endDate;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public Integer getPlanID() {
		return planID;
	}

	public void setPlanID(Integer planID) {
		this.planID = planID;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Double getPlanAmount() {
		return planAmount;
	}

	public void setPlanAmount(Double planAmount) {
		this.planAmount = planAmount;
	}

	public Double getPlanPremium() {
		return planPremium;
	}

	public void setPlanPremium(Double planPremium) {
		this.planPremium = planPremium;
	}

}
