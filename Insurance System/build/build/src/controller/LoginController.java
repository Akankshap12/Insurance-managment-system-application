/* 
Program which acts a controller to perform READ operation to validate the user (ADMIN,HOSPITAL) credentials
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: LoginController.java
Date:11/23/2017
   
 */

//packages required to perform READ operation for validation
package controller;

import java.sql.SQLException;
import java.util.Optional;
import dao.daoLogin;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Users;
import views.Hospitalview;

/*	Class which acts a controller to perform READ operation to validate the user(ADMIN,HOSPITAL)S credentials
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */

public class LoginController {
	@SuppressWarnings("unused")
	private int attempt = 1;

	/*
	 * Method to perform validation on user (ADMIN,HOSPITAL) credentials
	 * 
	 * @Programmer : Sadaa Sree Ravichandar Date : 11/23/2017
	 * 
	 */
	public void userLogin(String users, TextField textUN, TextField textPW, Label error, int attempt,
			Alert attemptAlert, Alert alertField,Stage primaryStage) {

		Users user;
		String username = textUN.getText();
		String password = textPW.getText();
		Hospitalview view = new Hospitalview();
		AdminMain admin= new AdminMain();

		if (username == null || username.trim().equals("")) {
			error.setText("Username Cannot be empty or spaces");
			return;
		}

		// when the user password is empty
		if (password == null || password.trim().equals("")) {
			error.setText("Password Cannot be empty or spaces");
			return;
		}

		// validating whether the user exists
		try {
			daoLogin login = new daoLogin();

			user = login.findByUsername(username, users);

			if (user == null) {
				error.setText("Username cannot be found");
				return;
			}

			// validating whether the user name and password exists
			if ((user.getPassword().equals(password.trim()))) {
				error.setVisible(false);
				Optional<ButtonType> result = alertField.showAndWait();
				if (result.get() != ButtonType.OK) {
					return;
				}

				if (users.equals("Admin")) {
					admin.start(primaryStage);
				} else if (users.equals("Hospital")) {
			
				view.start(primaryStage);
				}
			}

			// failed login attempts for the user
			if (!(user.getPassword().equals(password.trim()))) {
				if (attempt != 0) {

					error.setText(
							"Username and Password don't match !! " + " You are left with " + attempt + " attempts");

				}
				if (attempt == 0) {
					error.setText("You have exceeded the maximum number of attempts");
					attemptAlert.showAndWait();
					System.exit(0);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
