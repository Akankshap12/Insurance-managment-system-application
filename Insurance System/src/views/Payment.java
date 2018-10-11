
/* 
Program for the policy holder to pay his premium due regularly
Final Project;Programmer: Sadaa Sree Ravichandar, File Name: Payment.java
Date:11/23/2017
   
 */

//packages required for the polciy holder to make necessary payments
package views;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controller.PolicyHolderController;

/*	Class which is used  for the policy holder to pay his premium due regularly
 * 
 * @Programmer : Sadaa Sree Ravichandar
 * Date		   : 11/23/2017	
 * 
 * */
public class Payment {

	PolicyHolderController phcontrol = new PolicyHolderController();

	// This method is invoked on the EDT thread
	public void paymentGUI(String paymentPID, String paymentPHID, String premAmount) {

		JFrame frame = new JFrame("Payment and Claim Status");
		final JFXPanel fxPanel = new JFXPanel();
		frame.add(fxPanel);
		frame.setSize(3500, 2000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        frame.setContentPane(pane);
		
		String pID = paymentPID;
		String phID = paymentPHID;
		String pAmount = premAmount;

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				initFX(fxPanel, pID, phID, pAmount);
			}
		});
	}

	// This method is invoked on the JavaFX thread
	public void initFX(JFXPanel fxPanel, String paymentPID, String paymentPHID, String premAmount) {

		String psID = paymentPID;
		String pshID = paymentPHID;
		String psAmount = premAmount;
		Scene scene = createScene(psID, pshID, psAmount);
		fxPanel.setScene(scene);
	}

	// method to create javafx scenes for the policy holder to make the payment
	public Scene createScene(String paymentPID, String paymentPHID, String premAmount) {

		String psceneID = paymentPID;
		String psceneshID = paymentPHID;
		String pscenesAmount = premAmount;
		Group root = new Group();
		Scene scene = new Scene(root, Color.CADETBLUE);

		// to set an image to the scene
		Rectangle rectangle = new Rectangle(700, 500);
		rectangle.setLayoutX(2000);
		rectangle.setLayoutY(1100);
		final String healthImage = "file:Payment.jpg";
		Image health = new Image(healthImage);
		ImagePattern pattern = new ImagePattern(health);
		rectangle.setFill(pattern);

		// required labels,button,text fields,datepicker for the policy holder
		// payment page
		Label paymentForm, phID, pID, pPremium, lphID, lpID, lpPremium, lpaymentDate, paymentType, creditNumber,
				expiryDate, cvv, eDateF, creditName, pinNumber, cnError, cardNameError, dateError, expiredError,
				cvvError, pinError;
		Button makePayment, logout;
		DatePicker paymentDate = new DatePicker();
		RadioButton ccRadio = new RadioButton("Credit Card");
		RadioButton dcRadio = new RadioButton("Debit Card");
		TextField tcreditNumber, texpiryDate, tcvv, tcreditName;
		tcreditNumber = new TextField();
		texpiryDate = new TextField();
		tcvv = new TextField();
		tcreditName = new TextField();
		PasswordField tpinNumber = new PasswordField();

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Log out Confirmation");
		alert.setHeaderText(null);
		alert.setContentText("Are you sure you want to log out");

		Alert alertPaid = new Alert(AlertType.INFORMATION);
		alertPaid.setTitle("Payment Confirmation");
		alertPaid.setHeaderText(null);
		alertPaid.setContentText("You have made the payment successfully");

		paymentForm = new Label();
		pinNumber = new Label();
		creditName = new Label();
		phID = new Label();
		pID = new Label();
		pPremium = new Label();
		lpaymentDate = new Label();
		paymentType = new Label();
		creditNumber = new Label();
		expiryDate = new Label();
		cvv = new Label();
		eDateF = new Label();
		cnError = new Label();
		cardNameError = new Label();
		dateError = new Label();
		expiredError = new Label();
		cvvError = new Label();
		makePayment = new Button();
		logout = new Button();
		lphID = new Label();
		lpID = new Label();
		lpPremium = new Label();
		pinError = new Label();

		Alert saveAlert = new Alert(AlertType.CONFIRMATION);
		saveAlert.setTitle("Payment Confirmation ");
		saveAlert.setHeaderText(null);
		saveAlert.setContentText("Are you sure you want to continue to make the payment");

		paymentForm.setFont(Font.font("Amble CN", FontWeight.BOLD, 35));
		paymentForm.setLayoutX(1000);
		paymentForm.setLayoutY(50);
		paymentForm.setText("Payment Form");

		phID.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		phID.setLayoutX(150);
		phID.setLayoutY(150);
		phID.setText("Insured ID :");

		pID.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		pID.setLayoutX(168);
		pID.setLayoutY(250);
		pID.setText("Policy ID :");

		pPremium.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		pPremium.setLayoutX(76);
		pPremium.setLayoutY(350);
		pPremium.setText("Policy Premium :");

		lphID.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		lphID.setLayoutX(400);
		lphID.setLayoutY(150);
		lphID.setText(psceneshID);

		lpID.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		lpID.setLayoutX(400);
		lpID.setLayoutY(250);
		lpID.setText(psceneID);

		lpPremium.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		lpPremium.setLayoutX(400);
		lpPremium.setLayoutY(350);
		lpPremium.setText(pscenesAmount);

		lpaymentDate.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		lpaymentDate.setLayoutX(90);
		lpaymentDate.setLayoutY(450);
		lpaymentDate.setText("Payment Date :");

		dateError.setLayoutX(800);
		dateError.setLayoutY(450);
		dateError.setVisible(false);
		dateError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		dateError.setTextFill(Color.RED);

		paymentType.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		paymentType.setLayoutX(90);
		paymentType.setLayoutY(550);
		paymentType.setText("Payment Type :");

		creditName.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		creditName.setLayoutX(115);
		creditName.setLayoutY(650);
		creditName.setText(" Card Name :");
		creditName.setVisible(false);

		cardNameError.setLayoutX(800);
		cardNameError.setLayoutY(650);
		cardNameError.setVisible(false);
		cardNameError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		cardNameError.setTextFill(Color.RED);

		creditNumber.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		creditNumber.setLayoutX(90);
		creditNumber.setLayoutY(750);
		creditNumber.setText(" Card Number :");
		creditNumber.setVisible(false);

		expiryDate.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		expiryDate.setLayoutX(130);
		expiryDate.setLayoutY(849);
		expiryDate.setText("Expiry Date :");
		expiryDate.setVisible(false);

		cvv.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		cvv.setLayoutX(220);
		cvv.setLayoutY(955);
		cvv.setText("CVV :");
		cvv.setVisible(false);

		pinNumber.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		pinNumber.setLayoutX(220);
		pinNumber.setLayoutY(1055);
		pinNumber.setText("PIN :");
		pinNumber.setVisible(false);

		pinError.setLayoutX(800);
		pinError.setLayoutY(1055);
		pinError.setVisible(false);
		pinError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		pinError.setTextFill(Color.RED);

		tcreditName.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		tcreditName.setLayoutX(400);
		tcreditName.setLayoutY(650);
		tcreditName.setVisible(false);

		tcreditNumber.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		tcreditNumber.setLayoutX(400);
		tcreditNumber.setLayoutY(750);
		tcreditNumber.setVisible(false);

		cnError.setLayoutX(800);
		cnError.setLayoutY(750);
		cnError.setVisible(false);
		cnError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		cnError.setTextFill(Color.RED);

		texpiryDate.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		texpiryDate.setLayoutX(400);
		texpiryDate.setLayoutY(849);
		texpiryDate.setVisible(false);

		expiredError.setLayoutX(1000);
		expiredError.setLayoutY(855);
		expiredError.setVisible(false);
		expiredError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		expiredError.setTextFill(Color.RED);

		eDateF.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		eDateF.setLayoutX(810);
		eDateF.setLayoutY(854);
		eDateF.setText("(mm/yyyy)");
		eDateF.setVisible(false);

		tcvv.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		tcvv.setLayoutX(400);
		tcvv.setLayoutY(950);
		tcvv.setVisible(false);

		cvvError.setLayoutX(800);
		cvvError.setLayoutY(953);
		cvvError.setVisible(false);
		cvvError.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		cvvError.setTextFill(Color.RED);

		tpinNumber.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		tpinNumber.setLayoutX(400);
		tpinNumber.setLayoutY(1050);
		tpinNumber.setVisible(false);

		makePayment.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));
		makePayment.setLayoutX(400);
		makePayment.setLayoutY(1200);
		makePayment.setText("Make Payment");
		makePayment.setVisible(false);

		paymentDate.setLayoutX(400);
		paymentDate.setLayoutY(450);

		ccRadio.setLayoutX(400);
		ccRadio.setLayoutY(555);
		dcRadio.setLayoutX(600);
		dcRadio.setLayoutY(555);

		logout.setText("Logout");
		logout.setLayoutX(2500);
		logout.setLayoutY(1740);
		logout.setVisible(true);
		logout.setFont(Font.font("Amble CN", FontWeight.BOLD, 30));

		// method to display the required fields when a credit card button is
		// selected
		ccRadio.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				dcRadio.setSelected(false);
				creditNumber.setVisible(true);
				expiryDate.setVisible(true);
				cvv.setVisible(true);
				tcreditNumber.setVisible(true);
				texpiryDate.setVisible(true);
				tcvv.setVisible(true);
				makePayment.setVisible(true);
				creditName.setVisible(true);
				tcreditName.setVisible(true);
				eDateF.setVisible(true);
				pinError.setVisible(false);
				pinNumber.setVisible(false);
				tpinNumber.setVisible(false);

			}
		});

		// method to display the required fields when a debit card button is
		// selected
		dcRadio.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ccRadio.setSelected(false);
				creditNumber.setVisible(true);
				expiryDate.setVisible(true);
				cvv.setVisible(true);
				tcreditNumber.setVisible(true);
				texpiryDate.setVisible(true);
				tcvv.setVisible(true);
				makePayment.setVisible(true);
				creditName.setVisible(true);
				tcreditName.setVisible(true);
				eDateF.setVisible(true);
				tpinNumber.setVisible(true);
				pinNumber.setVisible(true);

			}
		});

		// method to exit the system when a logout button is selected
		logout.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() != ButtonType.OK) {
					return;
				}
				System.exit(0);
			}
		});

		// adding all the required labels text fields,radio button to the scene
		root.getChildren().add(logout);
		root.getChildren().add(eDateF);
		root.getChildren().add(expiryDate);
		root.getChildren().add(cvv);
		root.getChildren().add(creditName);
		root.getChildren().add(tcreditName);
		root.getChildren().add(creditNumber);
		root.getChildren().add(pinNumber);
		root.getChildren().add(tpinNumber);
		root.getChildren().add(texpiryDate);
		root.getChildren().add(tcvv);
		root.getChildren().add(tcreditNumber);
		root.getChildren().add(paymentForm);
		root.getChildren().add(paymentType);
		root.getChildren().add(ccRadio);
		root.getChildren().add(dcRadio);
		root.getChildren().add(phID);
		root.getChildren().add(pID);
		root.getChildren().add(pPremium);
		root.getChildren().add(lphID);
		root.getChildren().add(lpID);
		root.getChildren().add(lpPremium);
		root.getChildren().add(makePayment);
		root.getChildren().add(paymentDate);
		root.getChildren().add(lpaymentDate);
		root.getChildren().add(cnError);
		root.getChildren().add(cardNameError);
		root.getChildren().add(dateError);
		root.getChildren().add(expiredError);
		root.getChildren().add(cvvError);
		root.getChildren().add(pinError);
		root.getChildren().add(rectangle);

		// validating the details and allowing the policy holder to make
		// necessary payments
		makePayment.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				String cardNumber = tcreditNumber.getText();
				String cardName = tcreditName.getText();
				String cvvcheck = tcvv.getText();
				String pinCheck = tpinNumber.getText();
				String date = null;

				String expiryDate = texpiryDate.getText();
				List<String> cards = new ArrayList<String>();
				// validating the credit card information based on the card type
				String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
						+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
						+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
				Pattern pattern = Pattern.compile(regex);

				cards.add(cardNumber);

				for (String card : cards) {
					// Strip all hyphens
					card = card.replaceAll("-", "");

					// Match the card
					Matcher matcher = pattern.matcher(card);

					if (!matcher.matches()) {
						cnError.setText("Invalid Credit Card Number");
						cnError.setVisible(true);
					} else {
						cnError.setVisible(false);
					}
				}

				// validates the format of the credit card holder's name
				if (!cardName.matches("[a-zA-Z_]+")) {
					cardNameError.setText("Invalid Card name");
					cardNameError.setVisible(true);
				} else {
					cardNameError.setVisible(false);
				}

				// validates the date format
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
				simpleDateFormat.setLenient(false);
				Date expiry;
				try {
					expiry = simpleDateFormat.parse(expiryDate);
					boolean expired = expiry.before(new Date());
					if (expired == true) {
						expiredError.setText("Please enter valid expiry date");
						expiredError.setVisible(true);
					} else if (expiryDate.equals(null) || expiryDate.trim().equals("")) {
						expiredError.setText("Please enter expiry date");
						expiredError.setVisible(true);
					} else {
						expiredError.setVisible(false);
					}
				} catch (ParseException e) {
					expiredError.setText("Please enter valid expiry date");
					expiredError.setVisible(true);
				}

				// validates CVV number
				if (!cvvcheck.matches("[0-9]*")) {
					cvvError.setText("Please enter valid CVV");
					cvvError.setVisible(true);
				} else if (cvvcheck.equals(null) || cvvcheck.trim().equals("") || (cvvcheck.length() > 3)) {
					cvvError.setText("Please enter valid CVV");
					cvvError.setVisible(true);
				} else {
					cvvError.setVisible(false);
				}

				// validates whether the pin number entered is in correct format
				if (dcRadio.isSelected()) {
					if (!pinCheck.matches("[0-9]*")) {
						pinError.setText("Please enter valid PIN");
						pinError.setVisible(true);
					} else if (!(pinCheck.length() == 4)) {
						pinError.setText("Wrong PIN !");
						pinError.setVisible(true);
					} else {
						pinError.setVisible(false);
					}
				}
				try {
					date = paymentDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					dateError.setVisible(false);
				} catch (NullPointerException e1) {
					dateError.setText("Please select date");
					dateError.setVisible(true);

				}

				// validates the credit card and debit card information and make
				// the payment
				if (pinError.isVisible() || cnError.isVisible() || cardNameError.isVisible() || dateError.isVisible()
						|| expiredError.isVisible() || cvvError.isVisible()) {
				} else {
					saveAlert.showAndWait();
					phcontrol.phmakePremiumPayment(psceneshID, psceneID, pscenesAmount, date);
					alertPaid.showAndWait();

				}
			}
		});

		return (scene);

	}

	public static void main(String[] args) {
		Payment payment = new Payment();
		payment.paymentGUI(null, null, null);

	}
}