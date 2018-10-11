package views; 

import controller.Firstlogin;
import dao.daoModelClaim;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Hospitalview extends Application {
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			daoModelClaim dao = new daoModelClaim();
			dao.createTable();
			primaryStage.setTitle("Hospital login");
			Firstlogin fl = new Firstlogin();
			VBox pane = fl.Hlogin();
			fl.addbutton(pane);
			
			GridPane pane1 =fl.Claim();
			fl.addUIControls(pane1);
			
			VBox pane2 =fl.tableview();
			
			
			// Declaring pane
			Scene scene = new Scene(pane,1000,800,Color.rgb(0, 0, 0));
			Scene claimScene = new Scene(pane1,1000,800);
			Scene viewTable = new Scene(new Group(),1015,700);
		    ((Group)viewTable.getRoot()).getChildren().add(pane2);	    	
			
			//image background
			
			Image img = new Image("file:hos.jpg");
			ImageView view = new ImageView(img);
			view.setX(-20);
			view.setY(-50);
			pane.getChildren().add(view);
			
			//Action on a button
			
			fl.createClaim.setOnAction(e->primaryStage.setScene(claimScene));
			fl.cancel.setOnAction(e->primaryStage.setScene(scene));
			//fl.btnView();
			fl.viewClaim.setOnAction(e-> primaryStage.setScene(viewTable));
			fl.btnView();
			
			fl.goBack.setOnAction(e-> primaryStage.setScene(scene));
			fl.signOut.setOnAction(e->primaryStage.close());
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
