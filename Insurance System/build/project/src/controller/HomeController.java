
package controller;

import dao.daoModelClaim;
import dao.daoPolicy;
import dao.daoPolicyHolder;
import dao.daoReviewClaim;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class HomeController{
	
	
	AnchorPane root;
	

	
	public void ReviewClaim(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/ReviewClaim.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		AdminMain.stage.setTitle("REVIEW CLAIM");
		
		
		
	}

	public void Reports(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Reports.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		AdminMain.stage.setTitle("REPORTS");
	}
	
	public void Add_remove_plans(ActionEvent event) throws Exception{		
		root = (AnchorPane)FXMLLoader.load(getClass().getResource("/views/Add_remove_plans.fxml"));
		Scene scene = new Scene(root);
		AdminMain.stage.setScene(scene);
		AdminMain.stage.setTitle("ADD/REMOVE PLANS");
		
		
	}
	
	public void Signout(ActionEvent event) throws Exception{		
		
		System.exit(0);
	}
	
	
	
}