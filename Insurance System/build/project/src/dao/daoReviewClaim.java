package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class daoReviewClaim {
	
	

	Connector connector = new Connector();

     //Query to select all claim to display in review claim page
	
	public ResultSet getResultSet() {
		Connection connection = null;
		Statement statement = null;
		ResultSet revClaimRS = null;
		
		try {
			connection = Connector.getConnection();
			statement = connection.createStatement();
			
			
			String sqlQuery = "select a.claim_id, a.policy_id, a.claim_desc, a.claim_amt, b.FirstName,b.LastName,a.claim_dt,"
							 +" a.claim_status , a.claim_visit_dt "
							 +" from AS_Claims a, AS_PolicyHolder b, AS_Policy c "
							 +" where a.policy_id=c.PolicyID and b.PolicyHolderID=c.PolicyHolderID "
							 +" order by a.claim_status desc, a.claim_id desc;";
			
			
			revClaimRS = statement.executeQuery(sqlQuery);
			
			
			
		} catch (Exception e) {
			System.out.println("Error while fetching from table ");
			e.printStackTrace();

		}
		return revClaimRS;
		
		
	}
	
	
	@SuppressWarnings("static-access")
	public void deleteQuery(int claim_id){
		
		Connection connection = null;
		Statement statement = null;
		@SuppressWarnings("unused")
		ResultSet rs = null;
		@SuppressWarnings("unused")
		int Claim_id=claim_id;
		try {
			connection = connector.getConnection();
			statement = connection.createStatement();
		
				String sql="delete from AS_Claims where claim_id =?";
				((PreparedStatement) statement).setInt(1,claim_id);
				rs=statement.executeQuery(sql);
				
		
	        }catch (Exception e) {
				System.out.println("Error while fetching from table ");
				e.printStackTrace();
	
	        }
		
		
	
	}
	
	
	//Query to update status of pending claim to reject	
	public void updateClaimStatus(int claim_id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		
		int Claim_id=claim_id;

		try {
			connection = Connector.getConnection();

			PreparedStatement preparedStatement = null;
			try {

				String UpdateClaimStatusQuery = "update AS_Claims set claim_status=? where CLAIM_ID=?;";
				preparedStatement = connection.prepareStatement(UpdateClaimStatusQuery);		

				preparedStatement.setString(1, "REJECTED");
				preparedStatement.setInt(2, Claim_id);
				preparedStatement.execute();
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error while updating Claim Status");
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
	
	
	//Query to update status of pending claim to approve/decline  	
		public void updateClaimApprove(int claim_id) {
			// TODO Auto-generated method stub
			Connection connection = null;
			Statement statement = null;
			
			int Claim_id=claim_id;

			try {
				connection = Connector.getConnection();

				PreparedStatement preparedStatement = null;
				try {

					String UpdateClaimStatusQuery = "update AS_Claims set claim_status=? where CLAIM_ID=?;";
					preparedStatement = connection.prepareStatement(UpdateClaimStatusQuery);		

					preparedStatement.setString(1, "APPROVED");
					preparedStatement.setInt(2, Claim_id);
					preparedStatement.execute();
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} catch (Exception e) {
				System.out.println("Error while updating Claim Status");
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
	
	
}
	
	
	
	
	
	
	
	
	


