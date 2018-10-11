
/* 
Program to view the policy holder details page where he edits,view his profile information and purchase a policy and view existing policy deatils
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: PolicyHolderDetails.java
Date:11/23/2017
   
 */

//packages to view the policy holder records
package views;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import model.Users;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import controller.PolicyHolderController;
//this package is embed javafx in JFrame
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/*	Class which is used to view the policy holder details page where he edits,view his profile information and purchase a policy and view existing policy deatils
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class PolicyHolderDetails {

	PolicyHolderController phcontrol = new PolicyHolderController();

	// This method is invoked on the EDT thread
	public void initAndShowGUI() {

		JFrame frame = new JFrame("Policy Holder and Plan Details");
		final JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setSize(3500, 2000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		
		// add the panel to a JScrollPane
		JScrollPane jScrollPane = new JScrollPane(panel);
		// only a configuration to the jScrollPane...
		jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		// Then, add the jScrollPane to your frame
		frame.getContentPane().add(jScrollPane);

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFX(fxPanel);
			}
		});
	}

	// This method is invoked on the JavaFX thread
	public void initFX(JFXPanel fxPanel) {

		Scene scene = createScene();
		fxPanel.setScene(scene);
	}

	// method to create javafx scenes
	public Scene createScene() {
		// designing policy holder details page
		Group root = new Group();
		Scene scene = new Scene(root, Color.BURLYWOOD);

		// to set an image to the scene
		Rectangle rectangle = new Rectangle(500, 500);
		rectangle.setLayoutX(2300);
		rectangle.setLayoutY(1100);
		final String healthImage = "file:HealthInsurance.jpg";
		Image health = new Image(healthImage);
		ImagePattern pattern = new ImagePattern(health);
		rectangle.setFill(pattern);

		// required labels,button,text fields for the policy holder details page
		Button next, viewPolicyDetails, viewProfile, editButton, saveButton, submit, addPlan, generatePolicyID,
				viewClaim;

		Label eltnStartDate, eltnEndDate, eltnPlanID, eltnplanStatus, eltnplanAmount, eltnplanPremium, eltnPlanName,
				tnStartDate, tnEndDate, tnPlanID, tnplanStatus, tnplanAmount, tnplanPremium, tnPlanName, tplanStatus,
				tplanAmount, tplanID, tplanDesc, tplanPremium, elStartDate, elEndDate, elPlanID, elplanStatus,
				elplanAmount, elplanPremium, elPlanName, lStartDate, lEndDate, lPlanID, lplanStatus, lplanAmount,
				lplanPremium, lPlanName, policyID, planStatus, planAmount, planID, planDesc, planPremium, selectPlan,
				policyDetails, enterUN, enterPW, policyHolderDetails, policyHolderID, firstName, lastName, DOB, contact,
				gender, joindate, state, addressLineOne, addressLineTwo, city, zipcode, email, country, error,
				claimLabel, validateError, fnError, lnError, contactError, emailError, zipError, reqError, jdateError,viewClaimStatus;

		TextField tpolicyHolderID, tfirstName, tlastName, tDOB, tcontact, tgender, tjoindate, tstate, taddressLineOne,
				taddressLineTwo, tcity, tzipcode, temail, tcountry, tuserName;
		PasswordField tpassword;

		addPlan = new Button();
		viewPolicyDetails = new Button();
		next = new Button();
		viewClaim = new Button();
		generatePolicyID = new Button();
		final Button ePolicyDetails = new Button();
		viewProfile = new Button();
		editButton = new Button();
		saveButton = new Button();
		submit = new Button();
		selectPlan = new Label();
		policyHolderDetails = new Label();
		policyDetails = new Label();
		claimLabel = new Label();
		enterUN = new Label();
		tplanID = new Label();
		tplanDesc = new Label();
		tplanPremium = new Label();
		validateError = new Label();
		jdateError = new Label();

		fnError = new Label();
		lnError = new Label();
		contactError = new Label();
		emailError = new Label();
		zipError = new Label();
		reqError = new Label();
		tnStartDate = new Label();
		tnEndDate = new Label();
		tnPlanID = new Label();
		tnplanStatus = new Label();
		tnplanAmount = new Label();
		tnplanPremium = new Label();
		tnPlanName = new Label();
		viewClaimStatus= new Label();

		eltnStartDate = new Label();
		eltnEndDate = new Label();
		eltnPlanID = new Label();
		eltnplanStatus = new Label();
		eltnplanAmount = new Label();
		eltnplanPremium = new Label();
		eltnPlanName = new Label();

		lStartDate = new Label();
		lEndDate = new Label();
		lPlanID = new Label();
		lplanStatus = new Label();
		lplanAmount = new Label();
		lplanPremium = new Label();
		lPlanName = new Label();
		elStartDate = new Label();
		elEndDate = new Label();
		elPlanID = new Label();
		elplanStatus = new Label();
		elplanAmount = new Label();
		elplanPremium = new Label();
		elPlanName = new Label();
		final Label eMessage = new Label();

		tplanAmount = new Label();
		tplanStatus = new Label();
		planID = new Label();
		planDesc = new Label();
		planPremium = new Label();
		final ComboBox<String> plansList = new ComboBox<String>();
		planAmount = new Label();
		planStatus = new Label();
		policyID = new Label();
		Alert alertField = new Alert(AlertType.INFORMATION);
		alertField.setTitle("Edit Profile ");
		alertField.setHeaderText(null);
		alertField.setContentText("Edit your personal details");

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Update Profile ");
		alert.setHeaderText(null);
		alert.setContentText("Updating your personal details");

		Alert saveAlert = new Alert(AlertType.INFORMATION);
		saveAlert.setTitle("Saving Profile ");
		saveAlert.setHeaderText(null);
		saveAlert.setContentText("Saving your personal details");

		enterUN.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		enterUN.setText("Username :");
		enterPW = new Label();
		enterPW.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		enterPW.setText("Password :");
		policyHolderID = new Label();
		policyHolderID.setLayoutX(120);
		policyHolderID.setLayoutY(230);
		policyHolderID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		policyHolderID.setText("Insured ID");
		policyHolderID.setVisible(false);
		firstName = new Label();
		firstName.setLayoutX(120);
		firstName.setLayoutY(330);
		firstName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		firstName.setText("First Name");
		firstName.setVisible(false);
		lastName = new Label();
		lastName.setLayoutX(120);
		lastName.setLayoutY(430);
		lastName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lastName.setText("Last Name");
		lastName.setVisible(false);

		fnError.setLayoutX(800);
		fnError.setLayoutY(330);
		fnError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		fnError.setVisible(false);
		fnError.setTextFill(Color.RED);

		lnError.setLayoutX(800);
		lnError.setLayoutY(430);
		lnError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lnError.setVisible(false);
		lnError.setTextFill(Color.RED);

		DOB = new Label();
		DOB.setLayoutX(120);
		DOB.setLayoutY(530);
		DOB.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		DOB.setText("DOB (yyyy-mm-dd)");
		DOB.setVisible(false);
		contact = new Label();

		contact.setLayoutX(120);
		contact.setLayoutY(630);
		contact.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		contact.setText("Contact");
		contact.setVisible(false);

		validateError.setLayoutX(800);
		validateError.setLayoutY(530);
		validateError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		validateError.setVisible(false);
		validateError.setTextFill(Color.RED);

		contactError.setLayoutX(800);
		contactError.setLayoutY(630);
		contactError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		contactError.setVisible(false);
		contactError.setTextFill(Color.RED);

		gender = new Label();
		gender.setLayoutX(120);
		gender.setLayoutY(730);
		gender.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		gender.setText("Gender");
		gender.setVisible(false);

		joindate = new Label();
		joindate.setLayoutX(120);
		joindate.setLayoutY(830);
		joindate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		joindate.setText("Join Date");
		joindate.setVisible(false);

		jdateError.setLayoutX(800);
		jdateError.setLayoutY(830);
		jdateError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		jdateError.setVisible(false);
		jdateError.setTextFill(Color.RED);

		email = new Label();
		email.setLayoutX(120);
		email.setLayoutY(930);
		email.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		email.setText("Email");

		email.setVisible(false);
		emailError.setLayoutX(800);
		emailError.setLayoutY(930);
		emailError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		emailError.setVisible(false);
		emailError.setTextFill(Color.RED);

		addressLineOne = new Label();
		addressLineOne.setLayoutX(120);
		addressLineOne.setLayoutY(1030);
		addressLineOne.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		addressLineOne.setText("Address Line 1");
		addressLineOne.setVisible(false);

		addressLineTwo = new Label();
		addressLineTwo.setLayoutX(120);
		addressLineTwo.setLayoutY(1130);
		addressLineTwo.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		addressLineTwo.setText("Address Line 2");
		addressLineTwo.setVisible(false);

		city = new Label();
		city.setLayoutX(120);
		city.setLayoutY(1230);
		city.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		city.setText("City");
		city.setVisible(false);

		state = new Label();
		state.setLayoutX(120);
		state.setLayoutY(1330);
		state.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		state.setText("State");
		state.setVisible(false);

		zipcode = new Label();
		zipcode.setLayoutX(120);
		zipcode.setLayoutY(1430);
		zipcode.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		zipcode.setText("Zip Code");
		zipcode.setVisible(false);

		zipError.setLayoutX(800);
		zipError.setLayoutY(1430);
		zipError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		zipError.setVisible(false);
		zipError.setTextFill(Color.RED);

		country = new Label();
		country.setLayoutX(120);
		country.setLayoutY(1530);
		country.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		country.setText("Country");
		country.setVisible(false);

		reqError.setLayoutX(400);
		reqError.setLayoutY(1630);
		reqError.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		reqError.setVisible(false);
		reqError.setTextFill(Color.RED);

		tpolicyHolderID = new TextField();
		tpolicyHolderID.setVisible(false);
		tpolicyHolderID.setLayoutX(400);
		tpolicyHolderID.setLayoutY(220);
		tpolicyHolderID.setPrefSize(150, 10);

		error = new Label();
		error.setLayoutX(300);
		error.setLayoutY(300);
		error.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		error.setTextFill(Color.RED);

		tpolicyHolderID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tfirstName = new TextField();
		tfirstName.setLayoutX(400);
		tfirstName.setLayoutY(320);
		tfirstName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tfirstName.setVisible(false);
		tlastName = new TextField();
		tlastName.setLayoutX(400);
		tlastName.setLayoutY(420);
		tlastName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tlastName.setVisible(false);
		tDOB = new TextField();
		tDOB.setLayoutX(400);
		tDOB.setLayoutY(520);
		tDOB.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tDOB.setVisible(false);
		tcontact = new TextField();
		tcontact.setLayoutX(400);
		tcontact.setLayoutY(620);
		tcontact.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tcontact.setVisible(false);
		tgender = new TextField();
		tgender.setLayoutX(400);
		tgender.setLayoutY(720);
		tgender.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tgender.setVisible(false);
		tjoindate = new TextField();
		tjoindate.setLayoutX(400);
		tjoindate.setLayoutY(820);
		tjoindate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tjoindate.setVisible(false);
		temail = new TextField();
		temail.setLayoutX(400);
		temail.setLayoutY(920);
		temail.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		temail.setVisible(false);
		taddressLineOne = new TextField();
		taddressLineOne.setLayoutX(400);
		taddressLineOne.setLayoutY(1020);
		taddressLineOne.setPrefWidth(500);
		taddressLineOne.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		taddressLineOne.setVisible(false);
		taddressLineTwo = new TextField();
		taddressLineTwo.setLayoutX(400);
		taddressLineTwo.setLayoutY(1120);
		taddressLineTwo.setPrefWidth(500);
		taddressLineTwo.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		taddressLineTwo.setVisible(false);
		tcity = new TextField();
		tcity.setLayoutX(400);
		tcity.setLayoutY(1220);
		tcity.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tcity.setVisible(false);
		tstate = new TextField();
		tstate.setLayoutX(400);
		tstate.setLayoutY(1320);
		tstate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tstate.setVisible(false);

		tzipcode = new TextField();
		tzipcode.setLayoutX(400);
		tzipcode.setLayoutY(1420);
		tzipcode.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tzipcode.setVisible(false);

		tcountry = new TextField();
		tcountry.setLayoutX(400);
		tcountry.setLayoutY(1520);
		tcountry.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tcountry.setVisible(false);

		editButton.setText("Edit Profile");
		editButton.setLayoutX(150);
		editButton.setLayoutY(1720);
		editButton.setVisible(false);
		editButton.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		saveButton.setText("Save Profile");
		saveButton.setLayoutX(400);
		saveButton.setLayoutY(1720);
		saveButton.setDisable(true);
		saveButton.setVisible(false);
		saveButton.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));

		submit.setText("Submit");
		submit.setLayoutX(670);
		submit.setLayoutY(1720);
		submit.setDisable(true);
		submit.setVisible(false);
		submit.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));

		tuserName = new TextField();
		tpassword = new PasswordField();
		tuserName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tpassword.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tuserName.setLayoutX(120);
		tuserName.setLayoutY(132);
		tuserName.setPromptText("Enter User Name");
		tpassword.setLayoutX(500);
		tpassword.setLayoutY(132);
		tpassword.setPromptText("Enter Password");
		viewProfile.setLayoutX(900);
		viewProfile.setLayoutY(140);

		policyHolderDetails.setLayoutX(300);
		policyHolderDetails.setLayoutY(50);
		policyHolderDetails.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
		policyHolderDetails.setText("Policy Holder Details");
		policyDetails.setLayoutX(1400);
		policyDetails.setLayoutY(55);
		policyDetails.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
		policyDetails.setText("Plan/Policy Details");
		policyDetails.setVisible(false);

		claimLabel.setLayoutX(2250);
		claimLabel.setLayoutY(55);
		claimLabel.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
		claimLabel.setText("Claim Status");
		claimLabel.setVisible(false);

		viewClaim.setLayoutX(2200);
		viewClaim.setLayoutY(140);
		viewClaim.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		viewClaim.setText("View Claim Status");
		viewClaim.setVisible(false);
		
		viewClaimStatus.setLayoutX(2500);
		viewClaimStatus.setLayoutY(145);
		viewClaimStatus.setFont(Font.font("Amble CN", FontWeight.BOLD, 27));
		viewClaimStatus.setVisible(false);
		
		
		
		viewClaim.setLayoutX(2200);
		viewClaim.setLayoutY(140);
		viewClaim.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
	
		viewClaim.setVisible(false);

		viewProfile.setText("View Profile");
		viewProfile.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));

		addPlan.setLayoutX(1350);
		addPlan.setLayoutY(140);
		addPlan.setText("Add Plan");
		addPlan.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		addPlan.setVisible(false);

		final Label epolicyID = new Label();
		final Label elpolicyID = new Label();

		eMessage.setLayoutX(1600);
		eMessage.setLayoutY(145);
		eMessage.setText("Plan/Policy Already Exists");
		eMessage.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eMessage.setVisible(false);

		elpolicyID.setLayoutX(1300);
		elpolicyID.setLayoutY(240);
		elpolicyID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elpolicyID.setText("Your Policy ID :");
		elpolicyID.setVisible(false);

		ePolicyDetails.setLayoutX(1250);
		ePolicyDetails.setLayoutY(340);
		ePolicyDetails.setText("View Policy Details");
		ePolicyDetails.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));
		ePolicyDetails.setVisible(false);

		epolicyID.setLayoutX(1600);
		epolicyID.setLayoutY(240);
		epolicyID.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		epolicyID.setVisible(false);

		elPlanID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elPlanID.setLayoutX(1420);
		elPlanID.setLayoutY(450);
		elPlanID.setText("Plan ID :");
		elPlanID.setVisible(false);

		elPlanName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elPlanName.setLayoutX(1370);
		elPlanName.setLayoutY(550);
		elPlanName.setText("Plan Name :");
		elPlanName.setVisible(false);

		elplanStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elplanStatus.setLayoutX(1352);
		elplanStatus.setLayoutY(650);
		elplanStatus.setText("Policy Status :");
		elplanStatus.setVisible(false);

		elplanAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elplanAmount.setLayoutX(1312);
		elplanAmount.setLayoutY(750);
		elplanAmount.setText("Policy Coverage :");
		elplanAmount.setVisible(false);

		elplanPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elplanPremium.setLayoutX(1302);
		elplanPremium.setLayoutY(850);
		elplanPremium.setText("Policy Premium :");
		elplanPremium.setVisible(false);

		elStartDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elStartDate.setLayoutX(1380);
		elStartDate.setLayoutY(950);
		elStartDate.setText("Start Date :");
		elStartDate.setVisible(false);

		elEndDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		elEndDate.setLayoutX(1390);
		elEndDate.setLayoutY(1050);
		elEndDate.setText("End Date :");
		elEndDate.setVisible(false);

		eltnPlanID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnPlanID.setLayoutX(1600);
		eltnPlanID.setLayoutY(448);
		eltnPlanID.setVisible(false);

		eltnPlanName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnPlanName.setLayoutX(1600);
		eltnPlanName.setLayoutY(548);
		eltnPlanName.setVisible(false);

		eltnplanStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnplanStatus.setLayoutX(1600);
		eltnplanStatus.setLayoutY(648);
		eltnplanStatus.setVisible(false);

		eltnplanAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnplanAmount.setLayoutX(1600);
		eltnplanAmount.setLayoutY(748);
		eltnplanAmount.setVisible(false);

		eltnplanPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnplanPremium.setLayoutX(1600);
		eltnplanPremium.setLayoutY(848);
		eltnplanPremium.setVisible(false);

		eltnStartDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnStartDate.setLayoutX(1600);
		eltnStartDate.setLayoutY(948);
		eltnStartDate.setVisible(false);

		eltnEndDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		eltnEndDate.setLayoutX(1600);
		eltnEndDate.setLayoutY(1048);
		eltnEndDate.setVisible(false);
		/////

		selectPlan.setLayoutX(1600);
		selectPlan.setLayoutY(145);
		selectPlan.setText("Select Plan :");
		selectPlan.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		selectPlan.setVisible(false);

		plansList.setLayoutX(1800);
		plansList.setLayoutY(150);
		plansList.setVisible(false);
		// plansList.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 27));

		planID.setLayoutX(1420);
		planID.setLayoutY(245);
		planID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		planID.setText("Plan ID :");
		planID.setVisible(false);

		planDesc.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		planDesc.setLayoutX(1300);
		planDesc.setLayoutY(345);
		planDesc.setText("Plan Description :");
		planDesc.setVisible(false);

		planPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		planPremium.setLayoutX(1335);
		planPremium.setLayoutY(445);
		planPremium.setText("Plan Premium :");
		planPremium.setVisible(false);

		planAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		planAmount.setLayoutX(1330);
		planAmount.setLayoutY(545);
		planAmount.setText("Plan Coverage :");
		planAmount.setVisible(false);

		planStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		planStatus.setLayoutX(1370);
		planStatus.setLayoutY(645);
		planStatus.setText("Plan Status :");
		planStatus.setVisible(false);

		tplanID.setLayoutX(1600);
		tplanID.setLayoutY(244);
		tplanID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tplanID.setVisible(false);

		tplanDesc.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tplanDesc.setLayoutX(1600);
		tplanDesc.setLayoutY(344);
		tplanDesc.setVisible(false);

		tplanPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tplanPremium.setLayoutX(1600);
		tplanPremium.setLayoutY(444);
		tplanPremium.setVisible(false);

		tplanAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tplanAmount.setLayoutX(1600);
		tplanAmount.setLayoutY(544);
		tplanAmount.setVisible(false);

		tplanStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tplanStatus.setLayoutX(1600);
		tplanStatus.setLayoutY(644);
		tplanStatus.setVisible(false);

		generatePolicyID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		generatePolicyID.setText("Generate Policy ID");
		generatePolicyID.setLayoutX(1230);
		generatePolicyID.setLayoutY(750);
		generatePolicyID.setVisible(false);

		viewPolicyDetails.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		viewPolicyDetails.setText("View Policy Details");
		viewPolicyDetails.setLayoutX(1230);
		viewPolicyDetails.setLayoutY(860);
		viewPolicyDetails.setVisible(false);

		policyID.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
		policyID.setLayoutX(1600);
		policyID.setLayoutY(754);
		policyID.setVisible(false);

		lPlanID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lPlanID.setLayoutX(1420);
		lPlanID.setLayoutY(959);
		lPlanID.setText("Plan ID :");
		lPlanID.setVisible(false);

		lPlanName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lPlanName.setLayoutX(1370);
		lPlanName.setLayoutY(1059);
		lPlanName.setText("Plan Name :");
		lPlanName.setVisible(false);

		lplanStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lplanStatus.setLayoutX(1352);
		lplanStatus.setLayoutY(1159);
		lplanStatus.setText("Policy Status :");
		lplanStatus.setVisible(false);

		lplanAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lplanAmount.setLayoutX(1312);
		lplanAmount.setLayoutY(1259);
		lplanAmount.setText("Policy Coverage :");
		lplanAmount.setVisible(false);

		lplanPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lplanPremium.setLayoutX(1302);
		lplanPremium.setLayoutY(1359);
		lplanPremium.setText("Policy Premium :");
		lplanPremium.setVisible(false);

		lStartDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lStartDate.setLayoutX(1380);
		lStartDate.setLayoutY(1459);
		lStartDate.setText("Start Date :");
		lStartDate.setVisible(false);

		lEndDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		lEndDate.setLayoutX(1390);
		lEndDate.setLayoutY(1559);
		lEndDate.setText("End Date :");
		lEndDate.setVisible(false);

		tnPlanID.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnPlanID.setLayoutX(1600);
		tnPlanID.setLayoutY(960);
		tnPlanID.setVisible(false);

		tnPlanName.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnPlanName.setLayoutX(1600);
		tnPlanName.setLayoutY(1060);
		tnPlanName.setVisible(false);

		tnplanStatus.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnplanStatus.setLayoutX(1600);
		tnplanStatus.setLayoutY(1160);
		tnplanStatus.setVisible(false);

		tnplanAmount.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnplanAmount.setLayoutX(1600);
		tnplanAmount.setLayoutY(1260);
		tnplanAmount.setVisible(false);

		tnplanPremium.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnplanPremium.setLayoutX(1600);
		tnplanPremium.setLayoutY(1360);
		tnplanPremium.setVisible(false);

		tnStartDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnStartDate.setLayoutX(1600);
		tnStartDate.setLayoutY(1460);
		tnStartDate.setVisible(false);

		tnEndDate.setFont(Font.font("Amble CN", FontWeight.MEDIUM, 30));
		tnEndDate.setLayoutX(1600);
		tnEndDate.setLayoutY(1560);
		tnEndDate.setVisible(false);

		next.setText("Next");
		next.setLayoutX(2500);
		next.setLayoutY(1740);
		next.setVisible(false);
		next.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));

		root.getChildren().add(viewProfile);
		root.getChildren().add(planID);
		root.getChildren().add(validateError);
		root.getChildren().add(fnError);
		root.getChildren().add(lnError);
		root.getChildren().add(contactError);
		root.getChildren().add(emailError);
		root.getChildren().add(zipError);
		root.getChildren().add(jdateError);
		root.getChildren().add(viewClaim);
		root.getChildren().add(claimLabel);
		root.getChildren().add(tnPlanID);
		root.getChildren().add(tnPlanName);
		root.getChildren().add(tnplanStatus);
		root.getChildren().add(tnplanAmount);
		root.getChildren().add(tnplanPremium);
		root.getChildren().add(tnStartDate);
		root.getChildren().add(tnEndDate);
		root.getChildren().add(lPlanID);
		root.getChildren().add(lPlanName);
		root.getChildren().add(lplanStatus);
		root.getChildren().add(lplanAmount);
		root.getChildren().add(lplanPremium);
		root.getChildren().add(lStartDate);
		root.getChildren().add(lEndDate);
		root.getChildren().add(eltnPlanID);
		root.getChildren().add(eltnPlanName);
		root.getChildren().add(eltnplanStatus);
		root.getChildren().add(eltnplanAmount);
		root.getChildren().add(eltnplanPremium);
		root.getChildren().add(eltnStartDate);
		root.getChildren().add(eltnEndDate);
		root.getChildren().add(elPlanID);
		root.getChildren().add(elPlanName);
		root.getChildren().add(elplanStatus);
		root.getChildren().add(elplanAmount);
		root.getChildren().add(elplanPremium);
		root.getChildren().add(elStartDate);
		root.getChildren().add(elEndDate);
		root.getChildren().add(reqError);
		root.getChildren().add(policyID);
		root.getChildren().add(viewPolicyDetails);
		root.getChildren().add(generatePolicyID);
		root.getChildren().add(planStatus);
		root.getChildren().add(tplanStatus);
		root.getChildren().add(planDesc);
		root.getChildren().add(planPremium);
		root.getChildren().add(planAmount);
		root.getChildren().add(tplanID);
		root.getChildren().add(tplanDesc);
		root.getChildren().add(tplanPremium);
		root.getChildren().add(tplanAmount);
		root.getChildren().add(selectPlan);
		root.getChildren().add(addPlan);
		root.getChildren().add(plansList);
		root.getChildren().add(policyHolderDetails);
		root.getChildren().add(policyDetails);
		root.getChildren().add(policyHolderID);
		root.getChildren().add(firstName);
		root.getChildren().add(lastName);
		root.getChildren().add(DOB);
		root.getChildren().add(contact);
		root.getChildren().add(gender);
		root.getChildren().add(joindate);
		root.getChildren().add(state);
		root.getChildren().add(addressLineOne);
		root.getChildren().add(addressLineTwo);
		root.getChildren().add(city);
		root.getChildren().add(zipcode);
		root.getChildren().add(email);
		root.getChildren().add(country);
		root.getChildren().add(error);
		root.getChildren().add(tpolicyHolderID);
		root.getChildren().add(tfirstName);
		root.getChildren().add(tlastName);
		root.getChildren().add(tDOB);
		root.getChildren().add(tcontact);
		root.getChildren().add(tgender);
		root.getChildren().add(tjoindate);
		root.getChildren().add(tstate);
		root.getChildren().add(taddressLineOne);
		root.getChildren().add(taddressLineTwo);
		root.getChildren().add(tcity);
		root.getChildren().add(tzipcode);
		root.getChildren().add(temail);
		root.getChildren().add(tcountry);
		root.getChildren().add(editButton);
		root.getChildren().add(saveButton);
		root.getChildren().add(submit);
		root.getChildren().add(tuserName);
		root.getChildren().add(tpassword);
		root.getChildren().add(eMessage);
		root.getChildren().add(elpolicyID);
		root.getChildren().add(epolicyID);
		root.getChildren().add(ePolicyDetails);
		root.getChildren().add(next);
		root.getChildren().add(rectangle);
		root.getChildren().add(viewClaimStatus);

		// method to display existing policy details
		ePolicyDetails.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					phcontrol.phviewExistingPolicyDetails(eltnPlanID, eltnPlanName, eltnplanStatus, eltnplanAmount,
							eltnplanPremium, eltnStartDate, eltnEndDate, epolicyID);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				eltnPlanID.setVisible(true);
				eltnPlanName.setVisible(true);
				eltnplanStatus.setVisible(true);
				eltnplanAmount.setVisible(true);
				eltnplanPremium.setVisible(true);
				eltnStartDate.setVisible(true);
				eltnEndDate.setVisible(true);

				elPlanID.setVisible(true);
				elPlanName.setVisible(true);
				elplanStatus.setVisible(true);
				elplanAmount.setVisible(true);
				elplanPremium.setVisible(true);
				elStartDate.setVisible(true);
				elEndDate.setVisible(true);
				next.setVisible(true);
				viewClaim.setDisable(false);

			}
		});

		// method to display claim status
		viewClaim.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				viewClaimStatus.setVisible(true);
			String claimStatus=phcontrol.phviewClaimStatus(epolicyID);
			System.out.println(claimStatus);
			viewClaimStatus.setText(claimStatus);
				
			}
		});

		// method to display current policy details
		viewPolicyDetails.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					phcontrol.phViewPolicyDetails(tnPlanID, tnPlanName, tnplanStatus, tnplanAmount, tnplanPremium,
							tnStartDate, tnEndDate, policyID);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				tnPlanID.setVisible(true);
				tnPlanName.setVisible(true);
				tnplanStatus.setVisible(true);
				tnplanAmount.setVisible(true);
				tnplanPremium.setVisible(true);
				tnStartDate.setVisible(true);
				tnEndDate.setVisible(true);

				lPlanID.setVisible(true);
				lPlanName.setVisible(true);
				lplanStatus.setVisible(true);
				lplanAmount.setVisible(true);
				lplanPremium.setVisible(true);
				lStartDate.setVisible(true);
				lEndDate.setVisible(true);
				next.setVisible(true);

			}
		});

		// method to move to the payment pag eon clicking next button
		next.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String paymentPID = null, premAmount = null;
				if (addPlan.isDisabled()) {
					paymentPID = epolicyID.getText();
					premAmount = eltnplanAmount.getText();
				}
				if (generatePolicyID.isVisible()) {
					paymentPID = policyID.getText();
					premAmount = tnplanAmount.getText();

				}
				String paymentPHID = tpolicyHolderID.getText();
				Payment payment = new Payment();
				payment.paymentGUI(paymentPID, paymentPHID, premAmount);

			}
		});

		// method to generate a unique policy ID when the policy holder
		// purchases a policy
		generatePolicyID.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String phID = tpolicyHolderID.getText();
				int phIDN = Integer.parseInt(phID);
				String planID = tplanID.getText();
				int planIDN = Integer.parseInt(planID);
				String policyStatus = tplanStatus.getText();
				String planNameNDBID = (String) plansList.getValue();
				String planAmountI = tplanAmount.getText();
				double planAmountNDB = Double.parseDouble(planAmountI);
				String planPremiumI = tplanPremium.getText();
				double planPremiumNDB = Double.parseDouble(planPremiumI);

				try {
					phcontrol.phGeneratePolicyID(planIDN, phIDN, policyStatus, planNameNDBID, planAmountNDB,
							planPremiumNDB, policyID);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				policyID.setVisible(true);
				viewPolicyDetails.setVisible(true);
				addPlan.setDisable(true);

			}
		});

		// method to add a plan to his account if a plan doesn't exist
		addPlan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				phcontrol.phaddPolicyDetails(epolicyID, elpolicyID, eMessage, epolicyID, ePolicyDetails, addPlan,
						selectPlan, plansList, tpolicyHolderID);
			}

		});

		// method to select a plan and view its corresponding details
		plansList.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				phcontrol.phviewPlan(tplanID, tplanDesc, tplanAmount, tplanPremium, tplanStatus, plansList);
				planID.setVisible(true);
				planDesc.setVisible(true);
				planPremium.setVisible(true);
				planAmount.setVisible(true);
				planStatus.setVisible(true);
				tplanID.setVisible(true);
				tplanDesc.setVisible(true);
				tplanPremium.setVisible(true);
				tplanAmount.setVisible(true);
				tplanStatus.setVisible(true);
				generatePolicyID.setVisible(true);
			}
		});

		// method to edit the policy holder personal records on clicking the
		// edit button
		editButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				alertField.showAndWait();
				tfirstName.setEditable(true);
				tlastName.setEditable(true);
				tDOB.setEditable(true);
				tgender.setEditable(true);
				tcontact.setEditable(true);
				tjoindate.setEditable(true);
				tstate.setEditable(true);
				taddressLineOne.setEditable(true);
				taddressLineTwo.setEditable(true);
				tcity.setEditable(true);
				tzipcode.setEditable(true);
				temail.setEditable(true);
				saveButton.setDisable(false);

			}
		});

		// method to save the edited policy holder personal records and validate
		// his newly entered information
		saveButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String policyFN = tfirstName.getText();
				String policyLN = tlastName.getText();
				String policyDOB = tDOB.getText();
				String policyContact = tcontact.getText();
				String policyGender = tgender.getText();
				String policyJoinDate = tjoindate.getText();
				String policyAddressOne = taddressLineOne.getText();
				String policyAddressTwo = taddressLineTwo.getText();
				String policyCity = tcity.getText();
				String policyState = tstate.getText();
				String policyZip = tzipcode.getText();
				String policyEmail = temail.getText();
				String policyCountry = tcountry.getText();
				Date date, jdate;
				try {
					// validate the date of birth date format
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					date = sdf.parse(policyDOB);
					jdate = sdf.parse(policyJoinDate);
					if (!policyDOB.equals(sdf.format(date))) {
						validateError.setText("Invalid Date Format");
						validateError.setVisible(true);

					} else {
						validateError.setVisible(false);
					}

					// validate the join date format
					if (!policyJoinDate.equals(sdf.format(jdate))) {
						jdateError.setText("Invalid Date Format");
						jdateError.setVisible(true);
					} else {
						jdateError.setVisible(false);

					}
				} catch (ParseException e) {
					validateError.setText("Invalid Date Format");
					validateError.setVisible(true);
				}
				// validates the contact number format
				Pattern pattern = Pattern.compile("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}");
				Matcher matcher = pattern.matcher(policyContact);

				if (!matcher.matches()) {
					contactError.setText("Invalid Contact Number");
					contactError.setVisible(true);
				} else {
					contactError.setVisible(false);
				}

				// validates the email format
				Pattern epattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher ematcher = epattern.matcher(policyEmail);

				if (!ematcher.matches()) {
					emailError.setText("Invalid email address");
					emailError.setVisible(true);
				} else {
					emailError.setVisible(false);
				}

				// validates the zip code format
				Pattern zpattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");
				Matcher zmatcher = zpattern.matcher(policyZip);

				if (!zmatcher.matches()) {
					zipError.setText("Invalid Zip Code");
					zipError.setVisible(true);
				} else {
					zipError.setVisible(false);
				}

				// validates whether the first name and last name are alphabetic
				if (!policyFN.matches("[a-zA-Z_]+")) {
					fnError.setText("First Name cannot be numeric");
					fnError.setVisible(true);
				} else {
					fnError.setVisible(false);
				}
				if (!policyLN.matches("[a-zA-Z_]+")) {
					lnError.setText("Last Name cannot be numeric");
					lnError.setVisible(true);
				} else {
					lnError.setVisible(false);

				}

				// checks whether the personal information that needs to be
				// updated are in proper format
				if (policyFN.trim().equals("") || policyLN.trim().equals("") || policyDOB.trim().equals("")
						|| policyContact.trim().equals("") || policyAddressOne.trim().equals("")
						|| policyAddressTwo.trim().equals("") || policyCity.trim().equals("")
						|| policyZip.trim().equals("") || policyEmail.trim().equals("")
						|| policyGender.trim().equals("") || policyState.trim().equals("")
						|| policyCountry.trim().equals("")) {
					reqError.setText("Please enter all required fields");
					reqError.setVisible(true);

				} else {
					reqError.setVisible(false);
					submit.setDisable(false);
				}
				if (fnError.isVisible() || jdateError.isVisible() || lnError.isVisible() || validateError.isVisible()
						|| contactError.isVisible() || emailError.isVisible() || zipError.isVisible()) {
					reqError.setText("Please enter valid details");
					reqError.setVisible(true);
				} else {
					saveAlert.showAndWait();
					reqError.setVisible(false);
					submit.setDisable(false);

				}

			}
		});

		// method to update the policy holder's personal information
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String policyUN = tuserName.getText();
				String policyPW = tpassword.getText();
				String policyFN = tfirstName.getText();
				String policyLN = tlastName.getText();
				String policyDOB = tDOB.getText();
				String policyContact = tcontact.getText();
				String policyGender = tgender.getText();
				String policyJoinDate = tjoindate.getText();
				String policyAddressOne = taddressLineOne.getText();
				String policyAddressTwo = taddressLineTwo.getText();
				String policyCity = tcity.getText();
				String policyState = tstate.getText();
				String policyZip = tzipcode.getText();
				String policyEmail = temail.getText();
				String policyCountry = tcountry.getText();

				phcontrol.phupdatePersonalInfo(policyUN, policyPW, policyFN, policyLN, policyDOB, policyContact,
						policyGender, policyJoinDate, policyState, policyAddressOne, policyAddressTwo, policyCity,
						policyZip, policyEmail, policyCountry);
				alert.showAndWait();
			}
		});

		// validates the username and password and displays the personal records
		// of the policy holder
		viewProfile.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				try {
					String password = tpassword.getText();

					Users user = phcontrol.phLogin(error, tuserName, tpassword, tfirstName, tpolicyHolderID, tlastName,
							tDOB, tgender, tcontact, tjoindate, tstate, taddressLineOne, taddressLineTwo, tcity,
							tzipcode, temail, tcountry);

					if (user != null) {

						if ((user.getPassword().equals(password.trim()))) {
							error.setVisible(false);
							firstName.setVisible(true);
							lastName.setVisible(true);
							DOB.setVisible(true);
							gender.setVisible(true);
							contact.setVisible(true);
							joindate.setVisible(true);
							state.setVisible(true);
							addressLineOne.setVisible(true);
							addressLineTwo.setVisible(true);
							city.setVisible(true);
							zipcode.setVisible(true);
							email.setVisible(true);
							country.setVisible(true);
							tfirstName.setVisible(true);
							tlastName.setVisible(true);
							tDOB.setVisible(true);
							tgender.setVisible(true);
							tcontact.setVisible(true);
							tjoindate.setVisible(true);
							tstate.setVisible(true);
							taddressLineOne.setVisible(true);
							taddressLineTwo.setVisible(true);
							tcity.setVisible(true);
							tzipcode.setVisible(true);
							temail.setVisible(true);
							tcountry.setVisible(true);
							tfirstName.setEditable(false);
							tlastName.setEditable(false);
							tDOB.setEditable(false);
							tgender.setEditable(false);
							tcontact.setEditable(false);
							tjoindate.setEditable(false);
							tstate.setEditable(false);
							taddressLineOne.setEditable(false);
							taddressLineTwo.setEditable(false);
							tcity.setEditable(false);
							tzipcode.setEditable(false);
							temail.setEditable(false);
							tcountry.setEditable(false);
							editButton.setVisible(true);
							saveButton.setVisible(true);
							submit.setVisible(true);
							addPlan.setVisible(true);
							policyDetails.setVisible(true);
							policyHolderID.setVisible(true);
							tpolicyHolderID.setVisible(true);
							tpolicyHolderID.setEditable(false);
							viewClaim.setVisible(true);
							viewClaim.setDisable(true);
							claimLabel.setVisible(true);
							viewProfile.setDisable(true);
						}

					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});

		return (scene);
	}

	// public static void main(String[] args) {
	//
	// PolicyHolderDetails phDetails1 = new PolicyHolderDetails();
	// phDetails1.initAndShowGUI();
	//
	// }

}