package dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.claim;


public class daoModelClaim {

	controller.Firstlogin f = new controller.Firstlogin();

	Connector connector = new Connector();

	
	@SuppressWarnings("static-access")
	public void createTable() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;

		try {
			connection = connector.getConnection();

			// Creating statement
			statement = connection.createStatement();
			try {

				String CreateClaimQuery = "CREATE table if not exists AS_Claims("
						+ "claim_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT," 
						+ "CLAIM_DT DATE NOT NULL,"
						+ "claim_visit_dt date not null," 
						+ "CLAIM_DESC	VARCHAR(500) NOT NULL,"
						+ "CLAIM_AMT DOUBLE(10,2)	NOT NULL," 
						+ "POLICY_ID INTEGER NOT NULL,"
						+ "claim_status VARCHAR(10),"
						+ "CONSTRAINT PRIMARY KEY (CLAIM_ID),"
						+ "CONSTRAINT FOREIGN KEY (POLICY_ID) REFERENCES AS_POLICY(PolicyID))AUTO_INCREMENT=3000;";
				
				statement.executeUpdate(CreateClaimQuery);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error while creating table");
			e.printStackTrace();

		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				System.out.println("Error while closing statement/connection");
			}
		}
	}

	@SuppressWarnings({ "unused", "static-access" })
	public void insertClaim(int policy_id, String claim_desc, double claim_amt, Date claim_visit_dt, Date claim_dt,String claim_status) {

		int Policy_id = policy_id;
		String Claim_desc = claim_desc;
		double Claim_amt = claim_amt;
		Date Claim_visit_dt = claim_visit_dt;
		Date Claim_dt = claim_dt;
		String claim_status1= claim_status;

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = connector.getConnection();

			String InsertClaimQuery = "insert into AS_Claims (policy_id, claim_desc, claim_amt, claim_visit_dt, claim_dt, claim_status)"
					+ "values (?,?,?,?,date(sysdate()),'PENDING');";
			preparedStatement = connection.prepareStatement(InsertClaimQuery);

			preparedStatement.setInt(1, Policy_id);
			preparedStatement.setString(2, Claim_desc);
			preparedStatement.setDouble(3, Claim_amt);
			preparedStatement.setDate(4, Claim_visit_dt);
			preparedStatement.execute();
			
			
			ObservableList<claim> data1 = FXCollections.observableArrayList(new ArrayList<>());
			System.out.println("Arraylist data");
			for (int i=0;i<data1.size();i++){
				System.out.println("value: "+data1.get(i).getpolicyID());
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {

					preparedStatement.close();
				}
			} catch (SQLException e) {
				System.out.println("Error while closing connection/preparedStatement");
				e.printStackTrace();
			}
		}

	}
	
	@SuppressWarnings({ "unused", "static-access" })
	public ResultSet getResultSet() {
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		List<claim> claimList = new ArrayList<>();
		
		try {
			connection = connector.getConnection();
			statement = connection.createStatement();

			
			String sqlQuery = "SELECT claim_ID,policy_id, UPPER(claim_desc) as claim_desc, claim_amt, claim_visit_dt, claim_dt,claim_status from AS_Claims order by claim_dt desc;";
			
			rs = statement.executeQuery(sqlQuery);
			
			
			
		} catch (Exception e) {
			System.out.println("Error while fetching from table ");
			e.printStackTrace();

		}
		return rs;
		
		
	}
	


}
