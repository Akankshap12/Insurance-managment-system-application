/* 
Program to establish CRUD operations in the  database for the users to add policy,purchase policy and view policy details
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: daoPolicy.java

Date:11/23/2017
   
 */

//packages for the database connection and for handling the exceptions
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Plans;

/*	Class which is used to perform CRUD operations in the  database for the users to add policy,purchase policy and view policy details
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class daoPolicy {
	/*
	 * Method used to create the policy table Programmer :Sadaa Sree Ravichandar
	 * Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void createTable() {
		try {
			String sql = "CREATE TABLE IF NOT EXISTS AS_Policy(PolicyID INTEGER(10) NOT NULL AUTO_INCREMENT,PlanID INTEGER(30),PlanName VARCHAR(30),PolicyHolderID INTEGER(30),PolicyStatus VARCHAR(30),PolicyAmount DOUBLE (20,2),PolicyPremium DOUBLE (20,2),StartDate DATE,Enddate DATE,PRIMARY KEY(PolicyID))AUTO_INCREMENT=2000";
			Connection connection = Connector.getConnection();
			Statement statement = connection.createStatement();
			statement.execute(sql);

			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Method used to insert the policy details into the policy table Programmer
	 * :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void insertsPolicyDetails(Integer PlanID, Integer PolicyHolderID, String Status, String PlanName,
			Double PolicyAmount, Double PolicyPremium) throws SQLException {
		Integer planIDN = PlanID;
		Integer PolicyHolderIDN = PolicyHolderID;
		String StatusN = Status;
		String PlanNameN = PlanName;
		Double PolicyAmountN = PolicyAmount;
		Double PolicyPremiumN = PolicyPremium;

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = Connector.getConnection();
			connection.setAutoCommit(false);
			// sql query to insert the records in the table
			String sql = "INSERT INTO AS_Policy(PlanID,PlanName,PolicyHolderID,PolicyStatus,PolicyAmount,PolicyPremium,StartDate,EndDate) VALUES (?,?,?,?,?,?,date(sysdate()),date(DATE_ADD(SYSDATE(),INTERVAL 1 YEAR)))";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, planIDN);
			statement.setString(2, PlanNameN);
			statement.setInt(3, PolicyHolderIDN);
			statement.setString(4, StatusN);
			statement.setDouble(5, PolicyAmountN); // should be plan coverage
													// amount make sure you
													// change
			statement.setDouble(6, PolicyPremiumN);
			statement.execute(); // insert remaining records
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/*
	 * Method used to get the policy ID from the policy table Programmer :Sadaa
	 * Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public String getPolicyID() throws SQLException {

		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);
		String itsql = "SELECT PolicyID FROM AS_Policy ORDER BY PolicyID DESC LIMIT 1";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		String policyID = null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {

				int policyDBID = resultSet.getInt("PolicyID");
				policyID = String.valueOf(policyDBID);
			}

		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				statementID.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return policyID;
	}

	/*
	 * Method used to get the policy details given policy id from the policy
	 * table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public List<Plans> getPolicyDetails(Integer policyID) throws SQLException {

		Connection connection = Connector.getConnection();
		PreparedStatement statement = null;
		// PreparedStatement statementID = null;
		ResultSet resultSet = null;
		// ResultSet resultSetIDS = null;
		ArrayList<Plans> planDetails = new ArrayList<Plans>();
		try {

			Integer policyIDIN = policyID;
			//
			String sql = "SELECT PlanID,PlanName,PolicyStatus,PolicyAmount,PolicyPremium,StartDate,EndDate FROM AS_Policy WHERE (PolicyID ='"
					+ policyIDIN + "')";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Plans plan = new Plans();
				plan.setPlanID(resultSet.getInt("PlanID"));
				plan.setPlanName(resultSet.getString("PlanName"));
				plan.setPlanStatus(resultSet.getString("PolicyStatus"));
				plan.setPlanAmount(resultSet.getDouble("PolicyAmount"));
				plan.setPlanPremium(resultSet.getDouble("PolicyPremium"));
				plan.setStartDate(resultSet.getDate("StartDate"));
				plan.setEndDate(resultSet.getDate("EndDate"));

				planDetails.add(plan);

			}

		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return planDetails;
	}
/*
	
	 * Method used to check whether a policy already exists for the policy
	 * holder Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 
	public String verifyPolicyExists(String policyHolderID) throws SQLException {

		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);
		String itsql = "SELECT PolicyID FROM AS_Policy WHERE PolicyHolderID='" + policyHolderID + "' ";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		String policyID = null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			if (resultSet.next()) {

				int policyDBID = resultSet.getInt("PolicyID");
				policyID = String.valueOf(policyDBID);
			} else {
				policyID = null;
			}

		} finally {

			try {
				resultSet.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				statementID.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}

			try {
				connection.commit();
				connection.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return policyID;
	}
*/
}
