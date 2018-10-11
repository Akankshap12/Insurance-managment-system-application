/* 
Program to establish CRUD operations in the  database for the policy holder to add,view his personal details and update his policy records
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: daoPolicyHolder.java

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

import model.PolicyHolder;
import model.Users;

/*	Class which is used to perform CRUD operations in the  database for the policy holder to add,view his personal details and update his policy records
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class daoPolicyHolder {

/*	s
	 * Method used to find the user by username from the policy holder table
	 * Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 
	public Users findByUsername(String username) throws SQLException {
		Users user = null;
		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);

		// sql statement to get the user name list from the policy holder table
		String itsql = "SELECT * FROM AS_PolicyHolder WHERE UserName='" + username + "' ";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {

				user = new Users(resultSet.getString("UserName"), resultSet.getString("Password")

				);
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
		return user;
	}*/

	/*
	 * Method used to create the policy holder table Programmer :Sadaa Sree
	 * Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void createTable() {
		try {

			// sql statement to create the policy holder table
			String sql = "CREATE TABLE IF NOT EXISTS AS_PolicyHolder (PolicyHolderID INTEGER(10) NOT NULL AUTO_INCREMENT,UserName VARCHAR(30),Password VARCHAR(30),FirstName VARCHAR(30) NOT NULL,LastName VARCHAR(30) NOT NULL,DOB DATE,Contact INTEGER(15),Gender VARCHAR(10),JoinDate DATE,State VARCHAR(30), AddressLineOne VARCHAR(50),AddressLineTwo VARCHAR(50),City VARCHAR(30),ZipCode INTEGER(10),Email VARCHAR(30),Country VARCHAR(50),PRIMARY KEY(PolicyHolderID))AUTO_INCREMENT=1000";
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
	 * Method to get the list of user names that exists in the policy holder
	 * table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */

	public List<Users> getUsernames() throws SQLException {

		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);
		// sql statement to select the username from the policy holder table
		String itsql = "SELECT UserName FROM AS_PolicyHolder";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		String uName = null;
		ArrayList<Users> users = new ArrayList<Users>();
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {
				Users user = new Users(uName, uName);
				user.setUsername(resultSet.getString("UserName"));
				users.add(user);

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
		return users;
	}

	/*
	 * Method to get the policy holder ID from the policy holder table
	 * Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public String getResultSet() throws SQLException {

		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);

		// sql query to select the policy holder ID from the policy holder table
		String itsql = "SELECT PolicyHolderID FROM AS_PolicyHolder ORDER BY PolicyHolderID DESC LIMIT 1";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		String policyID = null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {

				int policyDBID = resultSet.getInt("PolicyHolderID");
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
	 * Method to get the policy holder personal records from the policy holder
	 * table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public List<PolicyHolder> getPolicyHolderDetails(String policyUN, String policyPW) throws SQLException {

		Connection connection = Connector.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ArrayList<PolicyHolder> policyRecords = new ArrayList<PolicyHolder>();
		try {

			// sql query to get the policy holder details when a user name and
			// password is given
			String sql = "SELECT * FROM AS_PolicyHolder WHERE (UserName ='" + policyUN + "' AND Password ='" + policyPW + "')";
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				PolicyHolder policyrecord = new PolicyHolder(policyUN, policyPW);
				policyrecord.setPolicyHolderID(resultSet.getInt("PolicyHolderID"));
				policyrecord.setFirstName(resultSet.getString("FirstName"));
				policyrecord.setLastName(resultSet.getString("LastName"));
				policyrecord.setDateOfBirth(resultSet.getDate("DOB"));
				policyrecord.setContactNumber(resultSet.getInt("Contact"));
				policyrecord.setGender(resultSet.getString("Gender"));
				policyrecord.setJoinDate(resultSet.getDate("JoinDate"));
				policyrecord.setAddressLineOne(resultSet.getString("AddressLineOne"));
				policyrecord.setAddressLineTwo(resultSet.getString("AddressLineTwo"));
				policyrecord.setCity(resultSet.getString("City"));
				policyrecord.setZip(resultSet.getInt("ZipCode"));
				policyrecord.setEmail(resultSet.getString("Email"));
				policyrecord.setState(resultSet.getString("State"));
				policyrecord.setCountry(resultSet.getString("Country"));
				policyRecords.add(policyrecord);

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
		return policyRecords;
	}

	/*
	 * Method to insert the policy holder personal records to the policy holder
	 * table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void insertsPHDetails(String policyUN, String policyPW, String policyFN, String policyLN, String policyDOB,
			String policyContact, String policyGender, String policyJoinDate, String policyState,
			String policyAddressOne, String policyAddressTwo, String policyCity, String policyZip, String policyEmail,
			String policyCountry) throws SQLException {

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = Connector.getConnection();
			connection.setAutoCommit(false);

			// sql query to insert the policy holder records into the policy
			// holder table
			String sql = "INSERT INTO AS_PolicyHolder (UserName,Password,FirstName,LastName,DOB,Contact,Gender,JoinDate,State,AddressLineOne,AddressLineTwo,City,ZipCode,Email,Country) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, policyUN);
			statement.setString(2, policyPW);
			statement.setString(3, policyFN);
			statement.setString(4, policyLN);
			statement.setString(5, policyDOB);
			statement.setString(6, policyContact);
			statement.setString(7, policyGender);
			statement.setString(8, policyJoinDate);
			statement.setString(9, policyState);
			statement.setString(10, policyAddressOne);
			statement.setString(11, policyAddressTwo);
			statement.setString(12, policyCity);
			statement.setString(13, policyZip);
			statement.setString(14, policyEmail);
			statement.setString(15, policyCountry);
			statement.execute();
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
	 * Method to update the policy holder personal records in the policy holder
	 * table when the policy holder edits his/her information Programmer :Sadaa
	 * Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void updatePHDetails(String policyUN, String policyPW, String policyFN, String policyLN, String policyDOB,
			String policyContact, String policyGender, String policyJoinDate, String policyState,
			String policyAddressOne, String policyAddressTwo, String policyCity, String policyZip, String policyEmail,
			String policyCountry) throws SQLException {
		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = Connector.getConnection();
			connection.setAutoCommit(false);
			// sql query to update the policy holder personal records that
			// exists in the policy hodler table
			String sql = "UPDATE AS_PolicyHolder SET FirstName=?,LastName=?,DOB='" + policyDOB
					+ "',Contact=?,Gender=?,JoinDate=?,State=?,AddressLineOne=?,AddressLineTwo=?,City=?,ZipCode=?,Email=?,Country=? WHERE (UserName='"
					+ policyUN + "' AND Password ='" + policyPW + "')";
			statement = connection.prepareStatement(sql);
			statement.setString(1, policyFN);
			statement.setString(2, policyLN);
			statement.setString(3, policyContact);
			statement.setString(4, policyGender);
			statement.setString(5, policyJoinDate);
			statement.setString(6, policyState);
			statement.setString(7, policyAddressOne);
			statement.setString(8, policyAddressTwo);
			statement.setString(9, policyCity);
			statement.setString(10, policyZip);
			statement.setString(11, policyEmail);
			statement.setString(12, policyCountry);

			statement.execute();
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
	 * Method to get the claim status for the policy holder
	 * Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public String getClaimStatus(String policyID) throws SQLException {
		System.out.println("sada");
		System.out.println(policyID);

		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);

		// sql query to select the policy holder ID from the policy holder table
		String itsql = "SELECT claim_status FROM AS_Claims WHERE policy_id ='"+policyID+"'";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		String claimStatus =null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {

			claimStatus = resultSet.getString("claim_status");
			
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
		return claimStatus;
	}

}
