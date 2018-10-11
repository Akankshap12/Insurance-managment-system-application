/* 
Program which acts a controller to start the insurance application and navigate the user to his/her respective page
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: MainController.java
Date:11/23/2017
   
 */

//packages required to start the application
package controller;

import javafx.application.Application;
import views.Login;

/*	Class which acts a controller to start the insurance application and navigate the user to his/her respective page
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class MainController {

	public static void main(String[] args) {
		Application.launch(Login.class, args);

	}

}
