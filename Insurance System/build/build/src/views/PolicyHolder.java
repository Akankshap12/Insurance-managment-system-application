
/* 
Program to view the policy holder registration page (JFrame) where he can enter his personal record and get his own ID
   
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: PolicyHolder.java
Date:11/23/2017
   
 */

//packages required to create a view for policy holder page
package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import controller.PolicyHolderController;
import views.PolicyHolderDetails;
import javafx.embed.swing.JFXPanel;
import model.Users;

/*	Class which is used to view the policy holder registration page where he can enter his personal record and get his own ID
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
@SuppressWarnings("serial")
public class PolicyHolder extends JFrame {

	// to connect the database and the view the class PolicyHolderController is
	// instantiated
	PolicyHolderController phcontrol = new PolicyHolderController();

	// creating required,text fields,lists,alerts for the policy holder
	// registration view
	TextField firstText, lastText, contactText, addressLineOneText, addressLineTwoText, cityText, zipText, emailText,
			otherCountryText, userText;
	JPasswordField passwordText;
	Button next, submit;
	Label reqError;
	private Scanner input;

	public PolicyHolder() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width,screenSize.height);
		setLayout(new FlowLayout());
		this.setLayout(null);
		this.getContentPane().setBackground(new Color(255, 228, 196));
		this.setSize(screenSize.width,screenSize.height);

		// creating required labels for the policy holder registration view
		Label firstLabel = new Label("First Name :", Label.CENTER);
		Label lastLabel = new Label("Last Name :", Label.CENTER);
		Label username = new Label("User Name :", Label.CENTER);
		Label password = new Label("Password :", Label.CENTER);
		Label contacttLabel = new Label("Contact Number :", Label.CENTER);
		Label dobLabel = new Label("Date Of Birth  :", Label.CENTER);
		Label dobFormatLabel = new Label("(yyyy-mm-dd)", Label.CENTER);
		Label joinDateFormatLabel = new Label("(yyyy-mm-dd)", Label.CENTER);
		Label femaleLabel = new Label("Female", Label.CENTER);
		Label maleLabel = new Label("Male", Label.CENTER);
		Label genderLabel = new Label("Gender :", Label.CENTER);
		Label joinDateLabel = new Label("Joined Date :", Label.CENTER);
		Label addressLineOneLabel = new Label("Address Line 1 :", Label.CENTER);
		Label addressLineTwoLabel = new Label("Address Line 2 :", Label.CENTER);
		Label cityLabel = new Label("City        :", Label.CENTER);
		Label zipLabel = new Label("ZipCode :", Label.CENTER);
		Label stateLabel = new Label("State        :", Label.CENTER);
		Label otherStateLabel = new Label("Specify Other :", Label.CENTER);
		Label emailLabel = new Label("Email     :", Label.CENTER);
		Label countryLabel = new Label("Country     :", Label.CENTER);
		Label otherCountryLabel = new Label("Specify Other :", Label.CENTER);
		Label policyIDLabel = new Label("Policy Holder ID :", Label.CENTER);
		Label reqError = new Label("Please Enter all required fields", Label.CENTER);
		Label unError = new Label("Username must be minimum 7 characters", Label.CENTER);
		Label pwError = new Label("Password must be minimum 7 characters", Label.CENTER);
		Label fnError = new Label("Invalid First Name", Label.CENTER);
		Label lnError = new Label("Invalid Last Name", Label.CENTER);
		Label unExistsError = new Label("Username already exists", Label.CENTER);
		Label contactError = new Label("Invalid Contact Number", Label.CENTER);
		Label emailError = new Label("Invalid email address", Label.CENTER);
		Label zipError = new Label("Invalid zipcode format", Label.CENTER);
		Label unpwError = new Label("User Name and Password must be minimum 7 characters", Label.CENTER);

		unError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		unError.setForeground(Color.red);
		unError.setVisible(false);

		pwError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		pwError.setForeground(Color.red);
		pwError.setVisible(false);

		fnError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		fnError.setForeground(Color.red);
		fnError.setVisible(false);

		lnError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		lnError.setForeground(Color.red);
		lnError.setVisible(false);

		unExistsError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		unExistsError.setForeground(Color.red);
		unExistsError.setVisible(false);

		contactError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		contactError.setForeground(Color.red);
		contactError.setVisible(false);

		emailError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		emailError.setForeground(Color.red);
		emailError.setVisible(false);

		zipError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		zipError.setForeground(Color.red);
		zipError.setVisible(false);

		unpwError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		unpwError.setForeground(Color.red);
		unpwError.setVisible(false);

		reqError.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		reqError.setForeground(Color.red);
		reqError.setVisible(false);

		// font size and font style for all the required label,text fields and
		// buttons
		username.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		password.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		firstLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		lastLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		contacttLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		dobLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		dobFormatLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		joinDateFormatLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		femaleLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		maleLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		genderLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		joinDateLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		addressLineOneLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		addressLineTwoLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		cityLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		stateLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		zipLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		otherStateLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		emailLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		countryLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		otherCountryLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		policyIDLabel.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		policyIDLabel.setVisible(false);
		JFormattedTextField dateText = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		dateText.setValue(new Date());
		JFormattedTextField joinDateText = new JFormattedTextField(new SimpleDateFormat("yyyy-MM-dd"));
		joinDateText.setValue(new Date());
		userText = new TextField(50);
		userText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		firstText = new TextField(50);
		firstText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		lastText = new TextField(30);
		lastText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		contactText = new TextField(25);
		contactText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		dateText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		joinDateText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		addressLineOneText = new TextField(25);
		addressLineOneText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		addressLineTwoText = new TextField(25);
		addressLineTwoText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		cityText = new TextField(25);

		JComboBox<String> listOfStates = new JComboBox<String>();
		JComboBox<String> listOfCountry = new JComboBox<String>();

		// creating an array to store all the 50 states
		String[] stateList = new String[100];
		int counter = 0;
		try {
			input = new Scanner(new File("State.txt"));
			while (input.hasNext()) {
				stateList[counter] = input.next();
				counter++;
			}
		} catch (FileNotFoundException e) {
		}

		for (int i = 0; i < stateList.length; i++) {
			listOfStates.addItem(stateList[i]);
		}

		String country[] = { "United States Of America", "Other" };

		for (int i = 0; i < country.length; i++) {
			listOfCountry.addItem(country[i]);
		}

		cityText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		listOfStates.setFont(new Font("HelvNueDemi", Font.PLAIN, 26));
		listOfCountry.setFont(new Font("HelvNueDemi", Font.PLAIN, 26));
		zipText = new TextField(25);
		zipText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		TextField otherStateText = new TextField(25);
		otherStateText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		otherStateText.setEnabled(false);
		emailText = new TextField(25);
		emailText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		emailText = new TextField(25);
		emailText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		otherCountryText = new TextField(25);
		otherCountryText.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		otherCountryText.setEnabled(false);
		Label policyHolderText = new Label();
		policyHolderText.setFont(new Font("HelvNueDemi", Font.BOLD, 35));
		policyHolderText.setVisible(false);
		JRadioButton female = new JRadioButton("");
		JRadioButton male = new JRadioButton("");
		next = new Button("Next");
		next.setVisible(true);
		submit = new Button("Submit");
		next.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		submit.setFont(new Font("HelvNueDemi", Font.PLAIN, 25));
		next.setBackground(Color.CYAN);
		submit.setBackground(Color.CYAN);

		// adding all the labels,text fields,buttons and combo box to the layout
		this.add(reqError);
		this.add(unError);
		this.add(unpwError);
		this.add(pwError);
		this.add(fnError);
		this.add(lnError);
		this.add(unExistsError);
		this.add(contactError);
		this.add(emailError);
		this.add(zipError);
		this.add(firstLabel);
		this.add(firstText);
		this.add(lastLabel);
		this.add(lastText);
		this.add(contacttLabel);
		this.add(contactText);
		this.add(dobLabel);
		this.add(dateText);
		this.add(genderLabel);
		this.add(female);
		this.add(femaleLabel);
		this.add(male);
		this.add(maleLabel);
		this.add(joinDateLabel);
		this.add(joinDateText);
		this.add(addressLineOneLabel);
		this.add(addressLineOneText);
		this.add(addressLineTwoLabel);
		this.add(addressLineTwoText);
		this.add(cityLabel);
		this.add(cityText);
		this.add(cityLabel);
		this.add(cityText);
		this.add(stateLabel);
		this.add(listOfStates);
		this.add(otherStateLabel);
		this.add(otherStateText);
		this.add(zipLabel);
		this.add(zipText);
		this.add(emailLabel);
		this.add(emailText);
		this.add(countryLabel);
		this.add(listOfCountry);
		this.add(otherCountryLabel);
		this.add(otherCountryText);
		this.add(next);
		this.add(submit);
		this.add(policyIDLabel);
		this.add(policyHolderText);
		this.add(dobFormatLabel);
		this.add(joinDateFormatLabel);
		this.add(username);
		this.add(password);
		this.add(userText);
		this.add(passwordText);
		JFXPanel jFXPanel = new JFXPanel();
		this.add(jFXPanel);

		// setting required position for all the labels,text fields,buttons and
		// combo boxes added to the layout
		username.setBounds(90, 70, 200, 90);
		userText.setBounds(300, 90, 450, 45);
		password.setBounds(750, 70, 200, 90);
		passwordText.setBounds(950, 90, 450, 45);
		firstLabel.setBounds(90, 160, 200, 90);
		firstText.setBounds(300, 175, 450, 45);
		lastLabel.setBounds(750, 160, 200, 90);
		lastText.setBounds(950, 175, 450, 45);
		contacttLabel.setBounds(59, 220, 200, 90);
		dobLabel.setBounds(68, 285, 200, 90);
		genderLabel.setBounds(104, 400, 200, 90);
		contactText.setBounds(300, 245, 450, 45);
		dateText.setBounds(300, 310, 200, 45);
		dobFormatLabel.setBounds(500, 310, 200, 45);
		male.setBounds(300, 400, 19, 40);
		male.setBackground(new Color(255, 228, 196));
		maleLabel.setBounds(345, 400, 100, 40);
		female.setBounds(300, 450, 19, 40);
		female.setBackground(new Color(255, 228, 196));
		femaleLabel.setBounds(360, 450, 100, 40);
		joinDateLabel.setBounds(80, 485, 200, 90);
		joinDateText.setBounds(300, 510, 200, 45);
		joinDateFormatLabel.setBounds(500, 510, 200, 45);
		addressLineOneLabel.setBounds(65, 560, 200, 90);
		addressLineOneText.setBounds(300, 585, 450, 45);
		addressLineTwoLabel.setBounds(65, 635, 200, 90);
		addressLineTwoText.setBounds(300, 660, 450, 45);
		cityLabel.setBounds(100, 715, 200, 90);
		cityText.setBounds(300, 740, 450, 45);
		stateLabel.setBounds(90, 800, 200, 90);
		listOfStates.setBounds(300, 820, 450, 45);
		listOfStates.setBackground(Color.white);
		otherStateLabel.setBounds(70, 880, 200, 90);
		otherStateText.setBounds(300, 905, 450, 45);
		zipLabel.setBounds(94, 955, 200, 90);
		zipText.setBounds(300, 980, 450, 45);
		emailLabel.setBounds(94, 1030, 200, 90);
		emailText.setBounds(300, 1050, 450, 45);
		countryLabel.setBounds(87, 1120, 200, 90);
		listOfCountry.setBounds(300, 1140, 450, 45);
		listOfCountry.setBackground(Color.white);
		otherCountryLabel.setBounds(70, 1205, 200, 90);
		otherCountryText.setBounds(300, 1230, 450, 45);
		next.setBounds(550, 1350, 70, 45);
		submit.setBounds(350, 1350, 100, 45);
		policyIDLabel.setBounds(70, 1420, 200, 90);
		policyHolderText.setBounds(300, 1440, 450, 49);
		reqError.setBounds(200, 1420, 500, 100);
		unError.setBounds(1400, 90, 650, 45);
		pwError.setBounds(1450, 90, 650, 45);
		unpwError.setBounds(1400, 90, 750, 45);
		fnError.setBounds(1250, 175, 450, 45);
		lnError.setBounds(1250, 175, 450, 45);
		unExistsError.setBounds(1400, 90, 750, 45);
		contactError.setBounds(600, 245, 450, 45);
		emailError.setBounds(700, 1050, 450, 45);
		zipError.setBounds(600, 980, 450, 45);

		// if other is selected from the states list
		listOfStates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String otherState = listOfStates.getSelectedItem().toString();
				if (otherState.equals("Other")) {
					otherStateText.setEnabled(true);
				}

			}
		});

		// if other is selected from the country list
		listOfCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String otherCountry = listOfCountry.getSelectedItem().toString();
				if (otherCountry.equals("Other")) {
					otherCountryText.setEnabled(true);
				}

			}
		});

		// method to perform validation when a submit button is clicked
		submit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// to validate all the field values assigning them to their
				// required variable
				String policyGender, policyState, policyCountry;
				String policyFN = firstText.getText();
				String policyLN = lastText.getText();
				String policyDOB = dateText.getText();
				String policyContact = contactText.getText();
				String policyJoinDate = joinDateText.getText();
				String policyAddressOne = addressLineOneText.getText();
				String policyAddressTwo = addressLineTwoText.getText();
				String policyCity = cityText.getText();
				String policyZip = zipText.getText();
				String policyEmail = emailText.getText();
				String policyUN = userText.getText();
				@SuppressWarnings("deprecation")
				String policyPW = passwordText.getText();

				if (male.isSelected()) {
					policyGender = "Male";
				} else {
					policyGender = "Female";
				}
				if ((male.isSelected() == false) && (female.isSelected() == false)) {
					policyGender = "";
				}
				if (otherStateText.isEnabled()) {
					policyState = otherStateText.getText();
				} else {
					policyState = listOfStates.getSelectedItem().toString();

				}
				if (otherCountryText.isEnabled()) {
					policyCountry = otherCountryText.getText();
				} else {
					policyCountry = listOfCountry.getSelectedItem().toString();

				}

				// checks whether the contact number entered is in correct
				// format
				Pattern pattern = Pattern.compile("((\\+[1-9]{3,4}|0[1-9]{4}|00[1-9]{3})\\-?)?\\d{8,20}");
				Matcher matcher = pattern.matcher(policyContact);

				if (!matcher.matches()) {
					contactError.setVisible(true);
				} else {
					contactError.setVisible(false);
				}

				// checks whether the email entered is in correct format
				Pattern epattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
						+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
				Matcher ematcher = epattern.matcher(policyEmail);

				if (!ematcher.matches()) {
					emailError.setVisible(true);
				} else {
					emailError.setVisible(false);
				}

				// checks whether the zip code entered is in correct format
				Pattern zpattern = Pattern.compile("^[0-9]{5}(?:-[0-9]{4})?$");
				Matcher zmatcher = zpattern.matcher(policyZip);

				if (!zmatcher.matches()) {
					zipError.setVisible(true);
				} else {
					zipError.setVisible(false);
				}

				// checks whether the user already exists
				ArrayList<Users> users = new ArrayList<Users>();

				try {
					users = (ArrayList<Users>) phcontrol.phgetUser();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for (Users userList : users) {
					if (userList.getUsername().equals(policyUN)) {
						unExistsError.setVisible(true);
					} else {
						unExistsError.setVisible(false);
					}
				}

				// checks for the username and password length
				if ((policyPW.length() <= 7) && (policyUN.length() <= 7)) {
					unpwError.setVisible(true);
					unError.setVisible(false);
					pwError.setVisible(false);
				} else if (policyPW.length() <= 7) {
					pwError.setVisible(true);
					unError.setVisible(false);
					unpwError.setVisible(false);
				} else if (policyUN.length() <= 7) {
					unError.setVisible(true);
					pwError.setVisible(false);
					unpwError.setVisible(false);
				} else {
					unError.setVisible(false);
					pwError.setVisible(false);
					unpwError.setVisible(false);
				}

				// checks whether the first name and last name are alphabetic
				if (!policyFN.matches("[a-zA-Z_]+")) {
					fnError.setVisible(true);
					lnError.setVisible(false);
				} else if (!policyLN.matches("[a-zA-Z_]+")) {
					lnError.setVisible(true);
					fnError.setVisible(false);
				} else {
					lnError.setVisible(false);
					fnError.setVisible(false);
				}

				// validates the policy holder information and inserts them into
				// policy holder table
				if (policyFN.trim().equals("") || policyLN.trim().equals("") || policyDOB.trim().equals("")
						|| policyContact.trim().equals("") || policyAddressOne.trim().equals("")
						|| policyAddressTwo.trim().equals("") || policyCity.trim().equals("")
						|| policyZip.trim().equals("") || policyEmail.trim().equals("")
						|| policyGender.trim().equals("") || policyState.trim().equals("")
						|| policyCountry.trim().equals("")) {
					reqError.setVisible(true);

				} else if (unError.isVisible() || unpwError.isVisible() || pwError.isVisible() || fnError.isVisible()
						|| lnError.isVisible() || unExistsError.isVisible() || contactError.isVisible()
						|| emailError.isVisible() || zipError.isVisible()) {
					reqError.setText("Please enter valid details");
					reqError.setVisible(true);

				} else {
					phcontrol.phaddPersonalDetails(policyUN, policyPW, policyFN, policyLN, policyDOB, policyContact,
							policyGender, policyJoinDate, policyState, policyAddressOne, policyAddressTwo, policyCity,
							policyZip, policyEmail, policyCountry, policyHolderText);
					reqError.setVisible(false);
					policyHolderText.setVisible(true);
					policyIDLabel.setVisible(true);
					submit.setEnabled(false);
					UIManager.put("OptionPane.minimumSize", new Dimension(600, 300));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(null, "Your Policy Holder ID has been generated",
							"Policy Holder ID information", JOptionPane.INFORMATION_MESSAGE);

				}
			}

		});

		// method which take the new policy holder to the next page where he can
		// view his policy records
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (reqError.isVisible() || unError.isVisible() || unpwError.isVisible() || pwError.isVisible()
						|| fnError.isVisible() || lnError.isVisible() || unExistsError.isVisible()
						|| contactError.isVisible() || emailError.isVisible() || zipError.isVisible()) {
					UIManager.put("OptionPane.minimumSize", new Dimension(600, 300));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(null, "Please enter valid information", "Policy Holder Registration",
							JOptionPane.INFORMATION_MESSAGE);

				} else {

					UIManager.put("OptionPane.minimumSize", new Dimension(600, 300));
					UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Verdana", Font.BOLD, 20)));
					JOptionPane.showMessageDialog(null, "Enter Username and Password to view your personal information",
							"Policy Holder Registration", JOptionPane.INFORMATION_MESSAGE);

					PolicyHolderDetails phDetails = new PolicyHolderDetails();
					phDetails.initAndShowGUI();
				}

			}
		});

		// when male radio button is selected the female radio button is
		// unselected
		male.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				female.setSelected(false);
			}
		});

		// when female radio button is selected the male radio button is
		// unselected
		female.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				male.setSelected(false);
			}
		});

	}

}