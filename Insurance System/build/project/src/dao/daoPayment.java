/* 
Program to establish CRUD operations in the  database for the policy holder to make the premium payment
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: daoPayment.java

Date:11/23/2017
   
 */

package dao;

//packages for the database connection and for handling the exceptions
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/*	Class which is used to perform CRUD operations in the  database for the policy holder to make the premium payment
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class daoPayment {
	
	/*
	 * Method used to create the payment table Programmer :Sadaa Sree
	 * Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void createTable() {
		try {
			
			//sql statement to create the payment table in the database
			String sql = "CREATE TABLE IF NOT EXISTS AS_Payment (PaymentID INTEGER(10) NOT NULL AUTO_INCREMENT,PolicyHolderID INTEGER(10),PolicyID INTEGER(10),PaymentAmount DOUBLE(30,2) NOT NULL,PaymentDate DATE,PaymentStatus VARCHAR(40) NOT NULL,PRIMARY KEY(PaymentID))AUTO_INCREMENT=5000";
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
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Method used to insert policy id,policy holder id and the premium amount into the payment table 
	 * Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void inserts(String psceneshID, String psceneID, String pscenesAmount, String date) throws SQLException {
		String PaymentStat = "Paid";
		String doubleAmount = pscenesAmount;
		double premiumDAmount = Double.parseDouble(doubleAmount);

		String phid = psceneshID;
		int PoHoID = Integer.parseInt(phid);

		String pid = psceneID;
		int PoID = Integer.parseInt(pid);

		String paymentD = date;
		// sql query to insert the records in the table

		Connection connection = null;
		PreparedStatement statement = null;

		try {

			connection = Connector.getConnection();
			connection.setAutoCommit(false);
			
			//sql statement to insert the policy id ,policy holder id and the premium amount into the payment table
			String sql = "INSERT INTO AS_Payment(PolicyHolderID, PolicyID, PaymentAmount,PaymentDate,PaymentStatus) VALUES (?, ?, ?,?,'"
					+ PaymentStat + "')";
			statement = connection.prepareStatement(sql);

			statement.setInt(1, PoHoID);
			statement.setInt(2, PoID);
			statement.setDouble(3, premiumDAmount);
			statement.setString(4, paymentD);

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

}
