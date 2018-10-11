package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import dao.Connector;
import dao.daoReviewClaim;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class ReportsController {
	
	AnchorPane root;
	
	@FXML
	private PieChart piechart;
	
	@FXML
	private Label status;
	
	@FXML
	private Label pievalue;
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private ObservableList<ObservableList> data;
	private Connector con;
		
	
	@SuppressWarnings({ "unused", "static-access" })
	public void Report(){
		
		con=new Connector();
		Connection connection = null;
		Statement statement = null;
		daoReviewClaim daoQ= new daoReviewClaim();
		int approvedCount = 0, rejectedCount = 0, pendingCount = 0; 
		
		try {
			connection = con.getConnection();	
			
			ResultSet rs= daoQ.getResultSet();
		
	         while(rs.next()) {
	        	 String status = rs.getString("claim_status");
	        	 if(status.equalsIgnoreCase("PENDING")) {
	        		 pendingCount++;
	        	 } else if(status.equalsIgnoreCase("REJECTED")) {
	        		 rejectedCount++;
	        	 } else if(status.equalsIgnoreCase("APPROVED")) {
	        		 approvedCount++;
	        	 }				
	         }
	        
			 
			 ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
					 
					 new PieChart.Data("APPROVED",approvedCount ),
					 new PieChart.Data("REJECTED",rejectedCount ),
					 new PieChart.Data("PENDING",pendingCount )
					 );
			 
			 piechart.setData(pieChartData );
			 piechart.setStartAngle(90);
			 
			 
				 	 
			 } catch (Exception exx) {
		System.out.println("Error while fetching result set.");
		exx.printStackTrace();
		
		} 

	}	
	
	
	public void mouseClickEvent(MouseEvent event){
		
		for(final PieChart.Data data : piechart.getData()){
			 data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
				 
				@Override
				public void handle(MouseEvent e) {
					// TODO Auto-generated method stub
					status.setText(String.valueOf(data.getPieValue()));
						
				}
				 		 
			 });	
	}	
		
	}	
	
	 public void Back(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		
	}
	
	
}
	


