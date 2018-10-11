/* 
Program to establish CRUD operations in the  database for the user to login
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: daoLogin.java
Date:11/23/2017
   
 */
package dao;

//packages for the database connection and for handling the exceptions
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Users;

/*	Class which is used to peform CRUD operations in the  database for the user to login
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */

public class daoLogin {

	/*
	 * Method used to find the user by user name Programmer :Sadaa Sree
	 * Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */

	public Users findByUsername(String username, String userRole) throws SQLException {
		// String policyID = null;
		Users user = null;
		Connection connection = Connector.getConnection();
		connection.setAutoCommit(false);

		// sql statement to select the user given user name
		String itsql = "SELECT * FROM AS_Users WHERE UserRole ='" + userRole + "' AND UserName='" + username + "' ";
		PreparedStatement statementID = null;
		ResultSet resultSet = null;
		try {

			statementID = connection.prepareStatement(itsql);
			resultSet = statementID.executeQuery();
			while (resultSet.next()) {

				user = new Users(resultSet.getString("UserName"), resultSet.getString("password")

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
	}
}