/* 
Program to view the login page from which the users(ADMIN,HOSPITAL,POLICY HOLDER) can access their respective pages
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: Login.java
Date:11/23/2017
   
 */

//packages required to create a view for login page
package views;
import java.util.Optional;
import javax.swing.JFrame;
import controller.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/*	Class which is used to view the login page from which the users(ADMIN,HOSPITAL,POLICY HOLDER) can access their respective pages
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class Login extends Application {
	int attempt = 3;

	@Override

	// method which designs the login page
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();
			Scene scene = new Scene(root, 700, 700, Color.BEIGE);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// to set an image to the scene
			Rectangle rectangle = new Rectangle(260, 260);
			rectangle.setLayoutX(160);
			rectangle.setLayoutY(350);
			final String healthImage = "file:Login.jpg";
			Image health = new Image(healthImage);
			ImagePattern pattern = new ImagePattern(health);
			rectangle.setFill(pattern);

			// creating required labels,text fields,lists,alerts for the login
			// page
			Label userSelect, userName, password, error;
			TextField textUN;
			PasswordField textPW;
			final ComboBox<String> listUser = new ComboBox<String>();

			Alert alertField = new Alert(AlertType.CONFIRMATION);
			alertField.setTitle("Login Confirmation");
			alertField.setHeaderText(null);
			alertField.setContentText("Click OK to login");

			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Policy Registration Confirmation");
			alert.setHeaderText(null);
			alert.setContentText("Click OK to enter policy information");

			Alert eAlert = new Alert(AlertType.CONFIRMATION);
			eAlert.setTitle("Existing Policy Holder Confirmation");
			eAlert.setHeaderText(null);
			eAlert.setContentText("Enter Username and Password to view policy details");

			Alert attemptAlert = new Alert(AlertType.INFORMATION);
			attemptAlert.setTitle("Login Attempt Exceeded");
			attemptAlert.setHeaderText(null);
			attemptAlert.setContentText("You Have exceeded the maximum login attempts");

			listUser.getItems().addAll("Admin", "Hospital", "New Policy Holder", "Existing Policy Holder");
			textUN = new TextField();
			textPW = new PasswordField();

			Button login, registerButton, enterButton, exit, loginA;
			login = new Button("Login");
			exit = new Button("Exit");
			loginA = new Button("Login");
			registerButton = new Button(" Register to Purchase Policy");
			enterButton = new Button("Click to view policy details");
			userSelect = new Label();
			userName = new Label();
			password = new Label();
			error = new Label();

			userSelect.setText("Select User :");
			userName.setText("Username :");
			password.setText("Password :");

			// designing the font size for required labels,text
			// fields,lists,alerts
			userSelect.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			userName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			password.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			textUN.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			textPW.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			login.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			loginA.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			registerButton.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			enterButton.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));
			exit.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 15));

			// setting the location and size for required labels,text
			// fields,lists,alerts
			textUN.setPrefWidth(160);
			textPW.setPrefWidth(160);
			userSelect.setLayoutX(100);
			userSelect.setLayoutY(100);
			userName.setLayoutX(110);
			userName.setLayoutY(150);
			password.setLayoutX(111);
			password.setLayoutY(200);
			listUser.setLayoutX(200);
			listUser.setLayoutY(99);
			textUN.setLayoutX(202);
			textUN.setLayoutY(149);
			textPW.setLayoutX(203);
			textPW.setLayoutY(199);
			login.setLayoutX(250);
			login.setLayoutY(250);
			loginA.setLayoutX(250);
			loginA.setLayoutY(250);
			loginA.setVisible(false);
			error.setLayoutX(200);
			error.setLayoutY(300);
			error.setTextFill(Color.RED);
			exit.setLayoutX(500);
			exit.setLayoutY(600);
			registerButton.setLayoutX(400);
			registerButton.setLayoutY(97);
			registerButton.setPrefHeight(5);
			registerButton.setVisible(false);
			enterButton.setLayoutX(400);
			enterButton.setLayoutY(97);
			enterButton.setPrefHeight(5);
			enterButton.setVisible(false);

			// adding the labels textfields comboboxes to the scenes
			root.getChildren().add(userSelect);
			root.getChildren().add(userName);
			root.getChildren().add(password);
			root.getChildren().add(login);
			root.getChildren().add(textUN);
			root.getChildren().add(textPW);
			root.getChildren().add(listUser);
			root.getChildren().add(registerButton);
			root.getChildren().add(enterButton);
			root.getChildren().add(error);
			root.getChildren().add(exit);
			root.getChildren().add(loginA);
			root.getChildren().add(rectangle);

			primaryStage.setScene(scene);
			primaryStage.show();
			// method to take the user to the registration page when the user
			// needs to register for a new policy
			registerButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() != ButtonType.OK) {
						return;
					}
					PolicyHolder view = new PolicyHolder();
					view.setSize(1500, 1500);
					//Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
					//view.setSize(screensize.width,screensize.height);
					//view.pack();
					//JScrollPane pane = new JScrollPane(view);
					//pane.getVerticalScrollBar().setPreferredSize(new Dimension(35,0));
					view.setTitle("Policy Holder Register Form");
					view.setExtendedState(JFrame.MAXIMIZED_BOTH);
					//view.setUndecorated(true);
					view.setVisible(true);
					view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					((Stage) primaryStage.getScene().getWindow()).setIconified(true);
				}
			});

			// method to take the existing policy holder to the page where he
			// can view his records
			enterButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Optional<ButtonType> result = eAlert.showAndWait();
					if (result.get() != ButtonType.OK) {
						return;
					}
					PolicyHolderDetails phDetails = new PolicyHolderDetails();
					phDetails.initAndShowGUI();
					((Stage) primaryStage.getScene().getWindow()).setIconified(true);
				}
			});

			
			// when the user select his desired to prompted to do login or
			// register according to his role
			listUser.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					String user = (String) listUser.getValue();
					if (user.equals("New Policy Holder")) {
						error.setVisible(false);
						userName.setVisible(false);
						password.setVisible(false);
						textUN.setVisible(false);
						textPW.setVisible(false);
						login.setVisible(false);
						registerButton.setVisible(true);
						enterButton.setVisible(false);
						exit.setVisible(false);
					} else if (user.equals("Existing Policy Holder")) {
						error.setVisible(false);
						userName.setVisible(false);
						password.setVisible(false);
						textUN.setVisible(false);
						textPW.setVisible(false);
						login.setVisible(false);
						enterButton.setVisible(true);
						registerButton.setVisible(false);
						exit.setVisible(false);

					} else if (user.equals("Admin")) {
						textUN.clear();
						textPW.clear();
						userName.setVisible(true);
						password.setVisible(true);
						textUN.setVisible(true);
						textPW.setVisible(true);
						login.setVisible(true);
						enterButton.setVisible(false);
						registerButton.setVisible(false);

					} else if (user.equals("Hospital")) {
						textUN.clear();
						textPW.clear();
						userName.setVisible(true);
						password.setVisible(true);
						textUN.setVisible(true);
						textPW.setVisible(true);
						login.setVisible(true);
						enterButton.setVisible(false);
						registerButton.setVisible(false);
						

					}

				}
			});

			// method to validate the user credentials and take him this
			// respective page
			login.setOnAction(e -> {

				String user = (String) listUser.getValue();
				LoginController logincontroller = new LoginController();
				logincontroller.userLogin(user, textUN, textPW, error, attempt, attemptAlert, alertField,primaryStage);
				attempt--;

			});

			// method to exit from the login page
			exit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Platform.exit();

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
