package controller;
import dao.daoPlans;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.AdminPlan;

public class AddNewPlanController {
	
	AnchorPane root;
	
	@SuppressWarnings("unused")
	private static AdminPlan plan;
	
	@FXML
	private TextField tfplanName;
	
	@FXML
	private TextArea tfplanDesc;
	
	@FXML
	private RadioButton active;
	
	@FXML
	private RadioButton pending;
	
	@FXML
	private TextField tfplanAmt;
	
	public void submit(){
		
		 String planName = tfplanName.getText();
		 String planDescription = tfplanDesc.getText();
			 Double planAmount =Double.parseDouble(tfplanAmt.getText());
			
		 
		try{ 
			
		
		 
		 
		 daoPlans plans = new daoPlans();
			
		 plans.createTable();
			

		 plans.insertPlan(planName,planDescription,planAmount);
		 clear();
		 
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	
	public void clear(){
		
		tfplanName.clear();
		tfplanDesc.clear();
		tfplanAmt.clear();
		
	}
	
	
	public void Cancel(ActionEvent event){
		
		clear();
	
		
	}
	
	public void Back(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Add_remove_plans.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		
	}
	

}
