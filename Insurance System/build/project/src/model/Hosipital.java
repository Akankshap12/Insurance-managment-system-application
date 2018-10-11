/* 
Program which acts as a model of the user hospital with its getters and setters
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: Hospital.java
Date:11/23/2017
   
 */

package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.Connector;
import dao.daoModelClaim;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

/*a class called Hospital.java which need to perform operations on medical reports and claims.
 * This class is a subclass of the Main class Users.java 
 * Programmer : Sadaa Sree Ravichandar
 * Date		  :09/24/2017
 * */
//public class Hospital {

	//constructor which extends the users class variables and methods and implements the method from the interface HospitalClaims
	public class Hosipital extends Users implements HospitalClaims {
		
		public Hosipital(String username, String password) {
			super(username, password);
		}

		Integer hopsitalID;
		String hospitalName, hospitalAddress;

		public Integer getHopsitalID() {
			return hopsitalID;
		}

		public void setHopsitalID(Integer hopsitalID) {
			this.hopsitalID = hopsitalID;
		}


		

		@Override
		public ObservableList<claim> createObservableList() {
			
			// TODO Auto-generated method stub
			
			//final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			
			List<claim> claimList = new ArrayList<>();
			daoModelClaim daoclm = new daoModelClaim();
			Connection connection = null;
			Statement statement = null;
			ResultSet rs = daoclm.getResultSet();
			Connector connector = new Connector();
					
			try {
				connection = connector.getConnection();			

				daoclm.createTable();
				System.out.println("Table created");
				 claim clm;
			
			while(rs.next()) {
				clm = new claim(rs.getInt("claim_id"), rs.getInt("policy_id"), rs.getDate("claim_dt").toLocalDate() , rs.getString("claim_status"), rs.getDouble("claim_amt"), rs.getString("claim_desc"));				
				claimList.add(clm);
				
			}		
			
			/*for (int i=0; i< claimList.size(); i++) {
				System.out.println("claim data: "+ claimList.get(i).getclaimAmount());
			}*/
				
			} catch (Exception exx) {
				System.out.println("Error while fetching result set.");
				exx.printStackTrace();
				
			} finally {			
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {					
						statement.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException ex) {
					
					System.out.println("Error while closing connection/preparedStatement");
					ex.printStackTrace();
				}
			} 
			
	       
			ObservableList<claim> data = FXCollections.observableArrayList(claimList);
			return data;  
				
			
		}

		@Override
		public VBox tableview() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void btnView() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void viewClaim() {
			// TODO Auto-generated method stub
			
		}

		

}
