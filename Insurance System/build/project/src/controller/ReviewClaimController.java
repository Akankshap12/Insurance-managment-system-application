package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import dao.Connector;
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
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class ReviewClaimController {
	
	AnchorPane root;
		
	
	@SuppressWarnings("rawtypes")
	@FXML
	private TableView claimReview;
	
	@FXML
	private TextField txtclaimID;
	
	@FXML
	private TextField txtpolicyID;
	@FXML
	private TextArea txtclaimDesc;
	@FXML
	private TextField txtclaimAmt;
	@FXML
	private TextField txtPh_fname;
	@FXML
	private TextField txtPh_DOB;
	@FXML
	private TextField txtclaim_date;
	@FXML
	private TextField txtStatus;
	
	//Observable list
	
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> data;
	private Connector con;
	

	

	
	@SuppressWarnings({ "rawtypes", "unchecked", "unused", "static-access" })
	public void loadTable(ActionEvent event){
		
		con=new Connector();
		Connection connection = null;
		Statement statement = null;
		daoReviewClaim daoQ= new daoReviewClaim();
		try {
			connection = con.getConnection();	
			//System.out.println("FLAG1");
			
			data=FXCollections.observableArrayList();
			
			ResultSet rs= daoQ.getResultSet();
			
			claimReview.getColumns().clear(); 
			 for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
	                //We are using non property style for making dynamic table
	                final int j = i;                
	                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
	                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
	                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
	                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
	                    }                    
	                });
	               
	                claimReview.getColumns().addAll(col); 
	               // System.out.println("Column ["+i+"] created ");
	            }


          
			 data.clear();
			while(rs.next()) {
				
				
				//Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                //System.out.println("Row [1] added "+row );
                data.add(row);
				
			}	
			
			
		}catch (Exception exx) {
			System.out.println("Error while fetching result set.");
			exx.printStackTrace();
			
		} 
		
	
		
	
		claimReview.setOnMousePressed(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent event) {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 1) {
		        	String selectedRow = claimReview.getSelectionModel().getSelectedItem().toString();
	        	
		        	String[] values = selectedRow.split(",");
		        	
		        	//System.out.println("value:"+ values[1]);
		        	txtclaimID.setText(values[0].substring(1));
		        	txtpolicyID.setText(values[1]);
		        	txtclaimDesc.setText(values[2]);
		        	txtclaimAmt.setText(values[3]);
		        	txtPh_fname.setText(values[4]);
		        	txtPh_DOB.setText(values[5]);
		        	txtclaim_date.setText(values[6]);
		        	txtStatus.setText(values[7]);
		        	
		        }
		    }
		});
		

		claimReview.setItems(data);		
		
		
	}


	public void delete(ActionEvent event){
		String claimID=	txtclaimID.getText();
		int selectedIndex=claimReview.getSelectionModel().getSelectedIndex();
		claimReview.getItems().remove(selectedIndex);
	      
		Connection connection = null;
		
		
		PreparedStatement preparedStatement = null;
		try {
			connection = Connector.getConnection();
			
	
				String sql="delete from AS_Claims where claim_id =?";
				preparedStatement = connection.prepareStatement(sql);
				
				 //preparedStatement.setInt(1,Integer.parseInt(txtclaimID.getText().substring(1)));
				preparedStatement.setInt(1,Integer.parseInt(claimID));
				 preparedStatement.execute();
				
		
	        }catch (Exception e) {
				System.out.println("Error while fetching from table ");
				e.printStackTrace();
	
	        }

		  
		}
		
	/*public void clear(){
		
		txtclaimID.clear();
		tfplanDesc.clear();
		tfplanAmt.clear();
		
	}*/	
		
	public void reject(ActionEvent event){
		String claimID=	txtclaimID.getText();
		
		daoReviewClaim dao = new daoReviewClaim ();
		dao.updateClaimStatus(Integer.parseInt(claimID));
		
	}
	
	
	public void approve(ActionEvent event){
		String claimID=	txtclaimID.getText();
		
		daoReviewClaim dao = new daoReviewClaim ();
		dao.updateClaimApprove(Integer.parseInt(claimID));
		
	}
	
	


	public void Back(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Home.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		
	}


}
