/* 
Program which acts as model for the policy holder with its getters and setters for the  policy holder to perform various operations on his health insurance policy
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: PolicyHolder.java
Date:11/23/2017
   
 */

package model;

import java.util.Date;

/* class called PolicyHolder.java which extends the main class Users and  includes getters and setters to perform operation such as view plans,add personal info and make premium payment
 * Programmer : Sadaa Sree Ravichandar
 * Date		  :09/24/2017
 * */

public class PolicyHolder extends Users {

	public PolicyHolder(String username, String password) {
		super(username, password);
	}

	String addressLineOne, gender, PolicyName, addressLineTwo, state, country, city;
	Date dateOfBirth, joinDate;

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	Integer insuredID, policyHolderID, zip;

	public String getAddressLineOne() {
		return addressLineOne;
	}

	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}

	public String getAddressLineTwo() {
		return addressLineTwo;
	}

	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getInsuredID() {
		return insuredID;
	}

	public void setInsuredID(Integer insuredID) {
		this.insuredID = insuredID;
	}

	public Integer getPolicyHolderID() {
		return policyHolderID;
	}

	public void setPolicyHolderID(Integer policyHolderID) {
		this.policyHolderID = policyHolderID;
	}

	public String getPolicyName() {
		return PolicyName;
	}

	public void setPolicyName(String policyName) {
		PolicyName = policyName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
