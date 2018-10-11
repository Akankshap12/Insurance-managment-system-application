/* 
Program which acts a controller to perform CRUD operation for the Policy Holder
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: PolicyHolderController.java
Date:11/23/2017
   
 */

//packages required to perform CRUD operation for the Policy Holder
package controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.daoPayment;
import dao.daoPlans;
import dao.daoPolicy;
import dao.daoPolicyHolder;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Plans;
import model.PolicyHolder;
import model.Users;

/* 
Class which acts a controller to perform CRUD operation for the Policy Holder
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: PolicyHolderController.java
Date:11/23/2017
   
 */
public class PolicyHolderController {

	private Users user;
	@SuppressWarnings("unused")
	private String euser;

	/*
	 * Method to validate the policy holder credentials and display his or her
	 * personal details.
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public Users phLogin(Label error, TextField tuserName, TextField tpassword, TextField tfirstName,
			TextField tpolicyHolderID, TextField tlastName, TextField tDOB, TextField tgender, TextField tcontact,
			TextField tjoindate, TextField tstate, TextField taddressLineOne, TextField taddressLineTwo,
			TextField tcity, TextField tzipcode, TextField temail, TextField tcountry) throws SQLException {

		String username = tuserName.getText();
		String password = tpassword.getText();

		// if the username is not found
		if (username == null || username.trim().equals("")) {
			error.setText("Username Cannot be empty or spaces");
		}

		// if the username is not found
		if (password == null || password.trim().equals("")) {
			error.setText("Password Cannot be empty or spaces");
		}

		// finding the user by given username
		daoPolicyHolder daoPolicyHolder = new daoPolicyHolder();
//		user = daoPolicyHolder.findByUsername(username);

		// if username cannot be found
		if (user == null) {
			error.setText("Username cannot be found");
		}

		// if username and password doesn't match
		if (user != null) {
		if (!(user.getPassword().equals(password.trim()))) {
			error.setText("Username and Password don't match");
		}
		}
		// if the user name and password matches retrieves all the personal
		// details of the policy holder and displays them
		if (user != null) {
		if ((user.getPassword().equals(password.trim()))) {
			ArrayList<PolicyHolder> policyRecords = new ArrayList<PolicyHolder>();
			String policyUN = tuserName.getText();
			String policyPW = tpassword.getText();
			policyRecords = (ArrayList<PolicyHolder>) daoPolicyHolder.getPolicyHolderDetails(policyUN, policyPW);

			for (PolicyHolder policyHolder : policyRecords) {
				int policyDBID = policyHolder.getPolicyHolderID();
				String policyID = String.valueOf(policyDBID);
				DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				Date dobd = policyHolder.getDateOfBirth();
				String dob = date.format(dobd);
				int pcontact = policyHolder.getContactNumber();
				String contactf = String.valueOf(pcontact);
				Date joind = policyHolder.getJoinDate();
				String joinDate = date.format(joind);
				int pzip = policyHolder.getZip();
				String zipCode = String.valueOf(pzip);

				// displaying the policy holder records after retrieval
				tfirstName.setText(policyHolder.getFirstName());
				tpolicyHolderID.setText(policyID);
				tlastName.setText(policyHolder.getLastName());
				tDOB.setText(dob);
				tgender.setText(policyHolder.getGender());
				tcontact.setText(contactf);
				tjoindate.setText(joinDate);
				tstate.setText(policyHolder.getState());
				taddressLineOne.setText(policyHolder.getAddressLineOne());
				taddressLineTwo.setText(policyHolder.getAddressLineTwo());
				tcity.setText(policyHolder.getCity());
				tzipcode.setText(zipCode);
				temail.setText(policyHolder.getEmail());
				tcountry.setText(policyHolder.getCountry());

			}
		}
		}
		return user;
	}

	/*
	 * Method to validate whether the username already exists when a new policy
	 * holder tries to register for a policy
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public List<Users> phgetUser() throws SQLException {

		daoPolicyHolder daoPolicyHolder = new daoPolicyHolder();
		ArrayList<Users> users = new ArrayList<Users>();

		// retrieving the username list and storing them in an array
		users = (ArrayList<Users>) daoPolicyHolder.getUsernames();
		return users;
	}

	/*
	 * Method to insert all the personal details entered by the new policy
	 * holder
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phaddPersonalDetails(String policyUN, String policyPW, String policyFN, String policyLN,
			String policyDOB, String policyContact, String policyGender, String policyJoinDate, String policyState,
			String policyAddressOne, String policyAddressTwo, String policyCity, String policyZip, String policyEmail,
			String policyCountry, java.awt.Label policyHolderText) {
		try {
			daoPolicyHolder policyHolder = new daoPolicyHolder();

			// creating a table to insert the policy holder personal details
			policyHolder.createTable();
			// inserting the policy holder records into the table
			policyHolder.insertsPHDetails(policyUN, policyPW, policyFN, policyLN, policyDOB, policyContact,
					policyGender, policyJoinDate, policyState, policyAddressOne, policyAddressTwo, policyCity,
					policyZip, policyEmail, policyCountry);
			String policyID = policyHolder.getResultSet();
			policyHolderText.setText(policyID);

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	/*
	 * Method to edit and update all the personal details entered by the
	 * existing policy holder
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phupdatePersonalInfo(String policyUN, String policyPW, String policyFN, String policyLN,
			String policyDOB, String policyContact, String policyGender, String policyJoinDate, String policyState,
			String policyAddressOne, String policyAddressTwo, String policyCity, String policyZip, String policyEmail,
			String policyCountry) {
		try {
			daoPolicyHolder policyHolder = new daoPolicyHolder();

			// creating table to insert policy holder records
			policyHolder.createTable();

			// updating the policy holder records after he edits and saves his
			// personal details
			policyHolder.updatePHDetails(policyUN, policyPW, policyFN, policyLN, policyDOB, policyContact, policyGender,
					policyJoinDate, policyState, policyAddressOne, policyAddressTwo, policyCity, policyZip, policyEmail,
					policyCountry);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method to view all the existing plan details when a policy holder tries
	 * to view them
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phviewPlan(Label tplanID, Label tplanDesc, Label tplanAmount, Label tplanPremium, Label tplanStatus,
			ComboBox<String> plansList) {
		String plan = (String) plansList.getValue();
		ArrayList<Plans> planDetails = new ArrayList<Plans>();

		// retrieving the plan list and displaying oplan information over to the
		// policy holder
		try {
			daoPlans daoPlan = new daoPlans();
			planDetails = (ArrayList<Plans>) daoPlan.getPlanDetails(plan);
			for (Plans plans : planDetails) {
				int planIDDB = plans.getPlanID();
				String planIDN = String.valueOf(planIDDB);
				double planA = plans.getPlanAmount();
				String planAmountN = String.format("%.2f", planA);
				Double planPremiumDB = plans.getPlanPremium();
				String planPremiumN = String.valueOf(planPremiumDB);

				// displaying the plan details after retrieving them from the
				// plan table
				tplanID.setText(planIDN);
				tplanDesc.setText(plans.getPlanDescription());
				tplanAmount.setText(planAmountN);
				tplanPremium.setText(planPremiumN);
				tplanStatus.setText(plans.getPlanStatus());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method for the policy holder to select a plan and add all the policy
	 * details
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phaddPolicyDetails(Label epolicyID, Label elpolicyID, Label eMessage, Label epolicyID2,
			Button ePolicyDetails, Button addPlan, Label selectPlan, ComboBox<String> plansList,
			TextField tpolicyHolderID) {

		// policy holder decides and selects a plan and add his policy details
		try {
			String phID = tpolicyHolderID.getText();
			daoPolicy daoPolicy = new daoPolicy();
//			String policyIDV = daoPolicy.verifyPolicyExists(phID);
//			if (policyIDV != null) {
//				epolicyID.setText(policyIDV);
//				elpolicyID.setVisible(true);
//				eMessage.setVisible(true);
//				epolicyID.setVisible(true);
//				ePolicyDetails.setVisible(true);
//				addPlan.setDisable(true);
//
//			} else {
				ArrayList<Plans> planDetails = new ArrayList<Plans>();

				daoPlans daoPlan = new daoPlans();

				planDetails = (ArrayList<Plans>) daoPlan.getPlanName();
				for (Plans plan : planDetails) {
					plansList.getItems().addAll(plan.getPlanName());
				}
				selectPlan.setVisible(true);
				plansList.setVisible(true);
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * Method for a new policy holder to view his current policy details
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phViewPolicyDetails(Label tnPlanID, Label tnPlanName, Label tnplanStatus, Label tnplanAmount,
			Label tnplanPremium, Label tnStartDate, Label tnEndDate, Label policyID) throws SQLException {
		String policyIDS = policyID.getText();
		int policyIDN = Integer.parseInt(policyIDS);

		ArrayList<Plans> planDetails = new ArrayList<Plans>();
		daoPolicy daoPolicy = new daoPolicy();

		// retrieves the existing plan/policy details in an array list and
		// displays it for the policy holder
		planDetails = (ArrayList<Plans>) daoPolicy.getPolicyDetails(policyIDN);

		for (Plans plan : planDetails) {
			int intPlanID = plan.getPlanID();
			String pLanIDDB = String.valueOf(intPlanID);
			double doublePlanAmount = plan.getPlanAmount();
			String planAmountDB = String.valueOf(doublePlanAmount);
			double doublePlanPremium = plan.getPlanPremium();
			String planPremiumDB = String.valueOf(doublePlanPremium);
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date startDateD = plan.getStartDate();
			String startDateDB = date.format(startDateD);
			Date endDateD = plan.getEndDate();
			String endDateDB = date.format(endDateD);

			// displaying the existing plan/policy details to the policy
			tnPlanID.setText(pLanIDDB);
			tnPlanName.setText(plan.getPlanName());
			tnplanStatus.setText(plan.getPlanStatus());
			tnplanAmount.setText(planAmountDB);
			tnplanPremium.setText(planPremiumDB);
			tnStartDate.setText(startDateDB);
			tnEndDate.setText(endDateDB);
		}
	}

	/*
	 * Method for the policy holder to select his plan and policy details and
	 * generate the unique Policy ID
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phGeneratePolicyID(int planIDN, int phIDN, String policyStatus, String planNameNDBID,

			double planAmountNDB, double planPremiumNDB, Label policyID) throws SQLException {
		daoPolicy daoPolicy = new daoPolicy();
		daoPolicy.createTable();

		// inserts the policy details into a table and generates a unique policy
		// ID
		daoPolicy.insertsPolicyDetails(planIDN, phIDN, policyStatus, planNameNDBID, planAmountNDB, planPremiumNDB);
		String policyIDN = daoPolicy.getPolicyID();
		policyID.setText(policyIDN);

	}

	/*
	 * Method for the policy holder to view his existing policy details
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phviewExistingPolicyDetails(Label eltnPlanID, Label eltnPlanName, Label eltnplanStatus,
			Label eltnplanAmount, Label eltnplanPremium, Label eltnStartDate, Label eltnEndDate, Label epolicyID)
			throws SQLException {

		String policyIDE = epolicyID.getText();
		int policyIDNE = Integer.parseInt(policyIDE);

		ArrayList<Plans> planDetails = new ArrayList<Plans>();
		daoPolicy daoPolicy = new daoPolicy();

		planDetails = (ArrayList<Plans>) daoPolicy.getPolicyDetails(policyIDNE);

		// retrieves the current plan/policy details in an array list and
		// displays it for the policy holder
		for (Plans plan : planDetails) {
			int intPlanID = plan.getPlanID();
			String pLanIDDB = String.valueOf(intPlanID);
			double doublePlanAmount = plan.getPlanAmount();
			String planAmountDB = String.valueOf(doublePlanAmount);
			double doublePlanPremium = plan.getPlanPremium();
			String planPremiumDB = String.valueOf(doublePlanPremium);
			DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date startDateD = plan.getStartDate();
			String startDateDB = date.format(startDateD);
			Date endDateD = plan.getEndDate();
			String endDateDB = date.format(endDateD);

			// displaying the current policy details for the policy holder
			eltnPlanID.setText(pLanIDDB);
			eltnPlanName.setText(plan.getPlanName());
			eltnplanStatus.setText(plan.getPlanStatus());
			eltnplanAmount.setText(planAmountDB);
			eltnplanPremium.setText(planPremiumDB);
			eltnStartDate.setText(startDateDB);
			eltnEndDate.setText(endDateDB);
		}

	}

	/*
	 * Method for a new policy holder or existing policy holder to make premium
	 * payment
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public void phmakePremiumPayment(String psceneshID, String psceneID, String pscenesAmount, String date) {
		try {
			dao.daoPayment daoPayment = new daoPayment();
			daoPayment.createTable();

			// after the policy holder make a payment the payment details are
			// inserted in to the payment table
			daoPayment.inserts(psceneshID, psceneID, pscenesAmount, date);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Method for a new policy holder or existing policy holder to view his
	 * claim status
	 * 
	 * Final Project;Programmer: Sadaa Sree Ravichandar, File Name:
	 * PolicyHolderController.java Date:11/23/2017
	 * 
	 */
	public String phviewClaimStatus(Label epolicyID) {
		daoPolicyHolder daoPolicyHolder = new daoPolicyHolder();
		String policyID =epolicyID.getText();
		String claimStatus =null;
		try {
			claimStatus=daoPolicyHolder.getClaimStatus(policyID);
			System.out.println(claimStatus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claimStatus;
	}

}
