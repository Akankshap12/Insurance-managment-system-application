/* 
Program to establish a database connection
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: Connector.java
Date:11/23/2017
   
 */

//packages for the database connection and for handling the exceptions
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*	Class which is used to establish the database connection.
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class Connector {

	/*
	 * static method used to establish the connection and return the connection
	 * Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public static Connection getConnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/sys?autoReconnect=true&useSSL=false";
		String user = "root";
		String password = "admin";
		String driver = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// creating a connection object to establish the connection to the
		// database
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

		// String
		// databaseURL="jdbc:mysql://www.papademas.net:3306/510labs?autoReconnect=true&useSSL=false";
		// Connection connection =null;
		// Properties property =new Properties();
		// property.put("user", "db510");
		// property.put("password","510");
		// try {
		// connection = DriverManager.getConnection(databaseURL, property);
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
		// return connection;

	}

}