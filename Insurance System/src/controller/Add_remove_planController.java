package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import dao.Connector;
import dao.daoPlans;
import dao.daoReviewClaim;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class Add_remove_planController {
	
	AnchorPane root;
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView planTable;

	
	@FXML
	private TextField txtplanName;
	
	@FXML
	private TextField txtplanID;
	
	@FXML
	private TextArea txtplanDesc;
	
	@FXML
	private TextField txtplanStatus;
	
	@FXML
	private TextField txtplanAmt;
	
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;
	
	@SuppressWarnings("unused")
	private Connector con;
	
	
	public void AddNewPlan(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/AddNewPlan.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
	}
	
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public void planTable(){
		
		Connector connector = new Connector();
		
		data = FXCollections.observableArrayList();
		//data.clear();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = null;
		
		planTable.getItems().clear();
		
	         try {
	        	 connection = connector.getConnection();
				statement = connection.createStatement();
				
			//	String SQL = "SELECT * from AS_Plan";
				String SQL = "SELECT planID, planname, plandescription, planstatus, planamount from AS_Plan";
				
				 rs = statement.executeQuery(SQL);
				
				  
					 planTable.getColumns().clear(); 
				   
		            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
		                //We are using non property style for making dynamic table
		                final int j = i;                
		                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
		                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
		                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
		                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
		                    }                    
		                });
		               //planTable.getItems().clear();
		                planTable.getColumns().addAll(col); 
		                //System.out.println("Column ["+i+"] created ");
		            }

		            data.clear();
		            while(rs.next()){
		                //Iterate Row
		                ObservableList<String> row = FXCollections.observableArrayList();
		                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
		                    //Iterate Column
		                    row.add(rs.getString(i));
		                }
		               // System.out.println("Row detail-> " + row );
		                data.add(row);

		            }
				
		            
		            
		            
		            planTable.setOnMousePressed(new EventHandler<MouseEvent>() {
		    		    public void handle(MouseEvent event) {
		    		        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
		    		        	String selectedRow =  planTable.getSelectionModel().getSelectedItem().toString();
		    	        	
		    		        	String[] values = selectedRow.split(",");
		    		        	
		    		        	txtplanID.setText(values[0].substring(1));
		    		        	txtplanName.setText(values[1]);
		    		        	txtplanDesc.setText(values[2]);
		    		        	txtplanStatus.setText(values[3]);
		    		        	txtplanAmt.setText(values[4].substring(0,values[4].length()-1));
		    		        }
		    		    }
		    		});
		    		
				 
				 //FINALLY ADDED TO TableView		            
		            planTable.setItems(data);
	
	         } catch (Exception e) {
	        	 // TODO Auto-generated catch block
	        	 e.printStackTrace();
	         }	

}
	public void deActivate(ActionEvent event){
		
		String planID = txtplanID.getText();
		daoPlans dao = new daoPlans();
		dao.updatePlanStatus(Integer.parseInt(planID));
		
	}
	
	public void Back(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		
	}
	
	

}
