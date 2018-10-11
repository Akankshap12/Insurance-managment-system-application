/* 
Program to establish CRUD operations in the  database for the users to create plans,add plan,select respective plan and view plan details
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: daoPlans.java

Date:11/23/2017
   
 */

package dao;

//packages for the database connection and for handling the exceptions
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Plans;

/*	Class which is used to perform CRUD operations in the  database for the users to create plans,add plan,select respective plan and view plan details
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */

public class daoPlans {

	/*
	 * Method used to create the plan table Programmer :Sadaa Sree Ravichandar
	 * Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
/*	public void createTableS() {
		try {

			// sql query to create the plan table
			String sql = "CREATE TABLE IF NOT EXISTS AS_Plan (PlanID INTEGER(10) NOT NULL AUTO_INCREMENT,PlanName VARCHAR(30),PlanDesc VARCHAR(30),PlanPremium numeric(30) NOT NULL,PlanAmount numeric(30) NOT NULL,PRIMARY KEY(PlanID))AUTO_INCREMENT=2000;";
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
*/
	public void createTable() {
		
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			connection = Connector.getConnection();

			// Creating statement
			statement = connection.createStatement();
			try {

				String CreatePlanTableQuery = "CREATE table if not exists AS_Plan("
						+ "PlanID INTEGER UNIQUE NOT NULL AUTO_INCREMENT," 
						+ "PlanName  VARCHAR(200) NOT NULL,"
						+ "PlanDescription  VARCHAR(500) NOT NULL,"
						+ "PlanAmount DOUBLE(30,2)	NOT NULL," 
						+ "PlanPremium DOUBLE(30,2),"
						+ "PlanStatus VARCHAR(10) NOT NULL,"
						+ "CONSTRAINT PRIMARY KEY (PlanID))AUTO_INCREMENT=4000;";
				System.out.println("abcdd");
				statement.executeUpdate(CreatePlanTableQuery);
				System.out.println("abc");
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

	/*
	 * Method used to insert plan name,plan description,plan premium,plan amount
	 * into the plan table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public void inserts() throws SQLException {

		// sql query to insert the records in the table
		String sql = "INSERT INTO AS_Plan(PlanName, PlanDesc, PlanPremium,PlanAmount) VALUES (?, ?, ?,?)";

		Connection connection = null;

		// creating the statement object to perform the query
		PreparedStatement statement = null;

		try {
			connection = Connector.getConnection();

			statement = connection.prepareStatement(sql);

			statement.executeBatch(); // insert remaining records
		} finally {
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
	}

	/*
	 * Method used to get the plan name list from the plan table Programmer
	 * :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public List<Plans> getPlanName() throws Exception {

		// sql query to retrieve the records from the table
		String sql = "SELECT PlanName FROM AS_Plan";
		Connection connection = Connector.getConnection();

		// creating the statement object to perform the query
		PreparedStatement statement = null;

		// To process the result set creating a result set object
		ResultSet resultSet = null;

		// ArrayList to retrieve the plan objects
		ArrayList<Plans> planDetails = new ArrayList<Plans>();
		try {

			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Plans plan = new Plans();
				plan.setPlanName(resultSet.getString("PlanName"));
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
	 * Method used to get the details of the plan given plan name from the plan
	 * table Programmer :Sadaa Sree Ravichandar Date :11/23/2017
	 * 
	 * @Exception: SQLException
	 */
	public List<Plans> getPlanDetails(String planName) throws Exception {
		String pName = planName;
		System.out.println(pName);
		// sql query to retrieve the records from the table
		String sql = "SELECT PlanID,PlanDescription,PlanPremium,PlanAmount,PlanStatus FROM AS_Plan WHERE PlanName ='" + pName
				+ "'";
		Connection connection = Connector.getConnection();

		// creating the statement object to perform the query
		PreparedStatement statement = null;

		// To process the result set creating a result set object
		ResultSet resultSet = null;

		// ArrayList to retrieve the plan objects
		ArrayList<Plans> planDetails = new ArrayList<Plans>();
		try {

			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Plans plan = new Plans();
				plan.setPlanID(resultSet.getInt("PlanID"));
				plan.setPlanDescription(resultSet.getString("PlanDescription"));
				plan.setPlanPremium(resultSet.getDouble("PlanPremium"));
				plan.setPlanAmount(resultSet.getDouble("PlanAmount"));
				plan.setPlanStatus(resultSet.getString("PlanStatus"));
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
	

		
		public ResultSet getResultSet() {
			
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = null;
			
			try {
				connection = Connector.getConnection();
				statement = connection.createStatement();

				
				String sqlQuery = "select PlanName,PlanDescription,PlanStatus,PlanAmount from AS_Plan;";
				
				rs = statement.executeQuery(sqlQuery);
				
				
				
			} catch (Exception e) {
				System.out.println("Error while fetching from table ");
				e.printStackTrace();

			}
			return rs;
				
		}
		//Query to update status of plan to active or inactive  	
		public void updatePlanStatus(int planID) {
			// TODO Auto-generated method stub
			Connection connection = null;
			Statement statement = null;
			int PlanID=planID;
			
			

			try {
				connection = Connector.getConnection();

				PreparedStatement preparedStatement = null;
				try {

					String UpdatePlanStatusQuery = "update AS_Plan set PlanStatus='INACTIVE' where PlanID=?;";
					preparedStatement = connection.prepareStatement(UpdatePlanStatusQuery);		

					preparedStatement.setInt(1,PlanID);
					preparedStatement.execute();
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println("Error while updating Plan Status");
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
		
		
		
		
		public void insertPlan(String planName,String planDescription,double planAmount) {
			
		 String PlanName=planName;
		 String PlanDescription=planDescription;
		 double PlanAmount=planAmount;
			
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			try {
				connection = Connector.getConnection();

				String InsertClaimQuery = "insert into AS_Plan (PlanName, PlanDescription, PlanAmount,PlanStatus,PlanPremium)"
						+ " values (?,?,?,'Active',round(PlanAmount/12,2));";
				preparedStatement = connection.prepareStatement(InsertClaimQuery);

				preparedStatement.setString(1, PlanName);
				preparedStatement.setString(2, PlanDescription);
				preparedStatement.setDouble(3, PlanAmount);				
				preparedStatement.execute();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Error Adding new Plan");
				
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
		
	
		
		
		
		
		
}
