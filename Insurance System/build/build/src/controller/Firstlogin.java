package controller;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import dao.Connector;
import dao.daoModelClaim;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Hosipital;
import model.claim;

public  class Firstlogin  {
	
	public Scene claimscene,viewscene;
	public Stage stage;
	 
	
	//Declaraing field 
	public TextField policyIdField = new TextField();
	public TextArea ProcedureArea = new TextArea();
	public TextField AmountField = new TextField();
	public TextField claimId = new TextField();
	public TextField anySearch = new TextField();
	public TextField claimDate = new TextField();
	public TextArea proc = new TextArea();
	public DatePicker datePicker = new DatePicker();
	public TextField hosp = new TextField();
	//Declaraing button
	public Button createClaim = new Button("CREATE CLAIM ");
	public Button viewClaim = new Button("VIEW CLAIM ");
	public Button signOut = new Button("SIGN OUT ");
	public Button goBack = new Button("BACK");
	public Button submit = new Button("SUBMIT");
	public Button cancel = new Button("BACK");
	
	
	//Label
	public Label search = new Label("SEARCH :");
	

	
	//Method for vbox
	public VBox Hlogin(){
		
	  VBox Hosplogin = new VBox(30);
	   Hosplogin.setAlignment(Pos.CENTER);
	   Hosplogin.setSpacing(50);
	   Hosplogin.setPadding(new Insets(40, 40, 40, 40));
	   
	   return Hosplogin;
	   	
		
	}
	
	
	//Method to declare controls on vbox
	
	public void addbutton(VBox vbox){
		
		Label Hlabel = new Label("  WELCOME ");
		Hlabel.setFont(new Font("Cambria", 40));
		vbox.setAlignment(Pos.BASELINE_CENTER);
		
		//Button size
		createClaim.setMaxSize(250,250);
		createClaim.setStyle("-fx-font-weight: bold;");
		viewClaim.setMaxSize(250,250);
		viewClaim.setStyle("-fx-font-weight: bold;");
		signOut.setMaxSize(250,250);
		signOut.setStyle("-fx-font-weight: bold;");
		
		//Adding to pane
		vbox.getChildren().add(Hlabel);
		vbox.getChildren().addAll(createClaim,viewClaim,signOut);
		vbox.setSpacing(60);	

		
	}
	
	public HBox hbox(){
		
		HBox pane = new HBox();
		
		return pane;
		
	}
	
	//public void

	public GridPane Claim() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(30);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
       ColumnConstraints columnOneConstraints = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.CENTER);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(50,50, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }
	
	@SuppressWarnings("static-access")
	public void addUIControls(GridPane pane){
		
		Label header = new Label(" CLAIM REGISTRATION ");
		header.setTranslateX(80);
		header.setTranslateY(5);
		header.setFont(new Font("Cambria", 40));
		
		pane.setHalignment(header, HPos.CENTER);
		pane.add(header, 0, 0,2,1);
		
		
		//Add label 
		Label policyID = new Label("POLICY ID* :");
		pane.add(policyID, 0, 2);
		policyIdField .setPromptText("Enter your POLICY ID");
		 
		Label hospName = new Label(" HOSPITAL NAME :");
		pane.add( hospName, 0,1);
		
		
		Label Procedure = new Label(" PROCEDURE* ");
		pane.add(Procedure, 0, 3);
		
		Label Amount = new Label("CLAIM AMOUNT $*:");
		pane.add(Amount, 0, 4);
		
		Label cDate = new Label("VISIT DATE* :");
		pane.add(cDate, 0,5);
		
		
		//Add text field
		
		policyIdField.setPrefHeight(10);
		pane.add(policyIdField,1,2);
		
		//int x=1001;
		
		pane.add(hosp, 1, 1);
		hosp .setPromptText("x.get()");
		hosp.setDisable(true);
		
		ProcedureArea.setPrefHeight(100);
		pane.add(ProcedureArea,1,3);
		ProcedureArea.setPromptText("In 100 words only");
		
		AmountField.setPrefHeight(10);
		pane.add(AmountField,1,4);
		AmountField.setPromptText("Numbers only");
		
		pane.add(datePicker, 1, 5);
		claimDate.setPromptText("Enter the visit date");
		
		
		AmountField.textProperty().addListener((observable, oldValue, newValue) -> {
		    if(!newValue.matches("[0-9.]*")){
		    	AmountField.setText(oldValue);
		    }
		});
		
		ProcedureArea.setOnKeyTyped(event ->{
			
			int maxChar=200;
			if(ProcedureArea.getText().length()> maxChar) event.consume();
			
		});
		
		AmountField.setOnKeyTyped(event ->{
			
			int maxChar=9;
			if(AmountField.getText().length()> maxChar) event.consume();
			
		});
		//Add button
		
		submit.setPrefHeight(50);
		submit.setPrefWidth(100);
		submit.setStyle("-fx-font-weight: bold;");
		pane.add(submit, 0,7,3,1);
		pane.setHalignment(submit,HPos.RIGHT);
		pane.setMargin(submit, new Insets(20,0,20,0));
		
		
		
		cancel.setPrefHeight(50);
		cancel.setPrefWidth(100);
		cancel.setStyle("-fx-font-weight: bold;");
		pane.add(cancel, 0,7,3,1);
		pane.setHalignment(cancel,HPos.CENTER);
		pane.setMargin(cancel, new Insets(20,0,20,10)); 
		
	
		
		
	}
	
	/*@SuppressWarnings("static-access")
	public ObservableList<claim> createObservableList() throws Exception {
             
		//final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<claim> claimList = new ArrayList<>();
		daoModelClaim daoclm = new daoModelClaim();
		Connection connection = null;
		Statement statement = null;
		ResultSet rs = daoclm.getResultSet();
		Connector connector = new Connector();
				
		try {
			connection = connector.getConnection();			

			daoclm.createTable();
			System.out.println("Table created");
			 claim clm;
		
		while(rs.next()) {
			clm = new claim(rs.getInt("claim_id"), rs.getInt("policy_id"), rs.getDate("claim_dt").toLocalDate() , rs.getString("claim_status"), rs.getDouble("claim_amt"), rs.getString("claim_desc"));				
			claimList.add(clm);
			
		}		
		
		for (int i=0; i< claimList.size(); i++) {
			System.out.println("claim data: "+ claimList.get(i).getclaimAmount());
		}
			
		} catch (Exception exx) {
			System.out.println("Error while fetching result set.");
			exx.printStackTrace();
			
		} finally {			
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {					
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException ex) {
				
				System.out.println("Error while closing connection/preparedStatement");
				ex.printStackTrace();
			}
		} 
		
       
		System.out.println("Arraylist data");
		for (int i=0;i<claimList.size();i++){
			System.out.println("value: "+claimList.get(i).getpolicyID());
		}
		
		ObservableList<claim> data = FXCollections.observableArrayList(claimList);
		return data;  
		
		
	}*/
	
	ObservableList<claim> data;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public VBox tableview() throws Exception {
		
		TableView<claim> tab = new TableView<>();	
		
		tab.setRowFactory(tv -> {
			TableRow<claim> row = new TableRow<>();
			row.setOnMouseClicked(event -> {
				if (! row.isEmpty() && event.getButton()== MouseButton.PRIMARY
						&& event.getClickCount() == 1) {

					claim clickedRow = row.getItem();
					
					proc.setText(clickedRow.getclaim_desc());
					
				}
			});
			return row ;
		});
		Hosipital hospital = new Hosipital("hospital", "hospital");
		data = hospital.createObservableList();
		
		tab.setItems(data);
				
		tab.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		Label tableLabel = new Label("CLAIMS INFORMATION");
		tableLabel.setTextAlignment(TextAlignment.CENTER);
		tableLabel.setTranslateX(270);
		tableLabel.setFont(new Font("Arial",40));
		
		//tableLabel.setAlignment(Pos.BASELINE_CENTER);		
		
		//Declaring column name
		TableColumn<claim,Integer> col1 = new TableColumn<claim,Integer>(" CLAIM ID");
		TableColumn<claim,Integer> col2 = new TableColumn<claim,Integer>(" POLICY ID");
		TableColumn<claim,LocalDate> col3 = new TableColumn<claim,LocalDate> ("CLAIM DATE");
		TableColumn<claim,String>  col4 = new TableColumn<claim,String> (" STATUS ");
		TableColumn <claim,Double> col5 = new TableColumn<claim,Double> (" CLAIM AMOUNT");
		TableColumn<claim,String> col6 = new TableColumn<claim,String>("Description");
				
		col1.setMinWidth(200);
		col2.setMinWidth(200);
		col3.setMinWidth(200);
		col4.setMinWidth(200);
		col5.setMinWidth(200);
		col6.setMinWidth(200);
		col6.setVisible(true);
		
		// inserting value
		col1.setCellValueFactory(new PropertyValueFactory<claim,Integer>("claimID"));
		col2.setCellValueFactory(new PropertyValueFactory<claim,Integer>("policyID"));
		col3.setCellValueFactory(new PropertyValueFactory<claim,LocalDate>("claimDate"));
		col4.setCellValueFactory(new PropertyValueFactory<claim,String>("status"));
		col5.setCellValueFactory(new PropertyValueFactory<claim,Double>("claimAmount"));
		col6.setCellValueFactory(new PropertyValueFactory<claim,String>("claim_desc"));
		tab.getColumns().addAll(col1,col2,col3,col4,col5,col6);
		
		
		
		HBox hbtn = new HBox(10);
		hbtn.setPadding(new Insets(10,10,10,10));
		hbtn.setSpacing(30);
		
		
		proc.setPrefHeight(100);
		proc.setLayoutX(40);
		proc.setEditable(false);
		
		goBack.setPrefHeight(50);
		goBack.setPrefWidth(100);
		goBack.setStyle("-fx-font-weight: bold;");
		hbtn.getChildren().addAll(goBack,proc);
		
	
		/*delete.setOnAction(e->{
			
			ObservableList<claim> selectedClaim, allClaim;
			allClaim = tab.getItems();
			selectedClaim = tab.getSelectionModel().getSelectedItems();
			selectedClaim.forEach(allClaim::remove);
			
		});*/
		
		
       //search the data in table view
        search.setFont(new Font("Cambria", 20));
        search.setTranslateY(1.5);
		anySearch.setPromptText(" Search ");
		anySearch.setMinSize(18,18);
		HBox searchBox = new HBox(20);
		searchBox.setPadding(new Insets(10,10,10,10));
		searchBox.getChildren().addAll(search,anySearch);
		
		anySearch.textProperty().addListener(new InvalidationListener(){

			@Override
			public void invalidated(Observable o) {
				// TODO Auto-generated method stub
				
				if(anySearch.textProperty().get().isEmpty()){
					tab.setItems(data);
					return;
				}
				
				ObservableList<claim> tableItems = FXCollections.observableArrayList();
				ObservableList<TableColumn<claim, ?>> cols = tab.getColumns();
				for(int i=0;i<data.size();i++){
					
					for(int j=0;j<cols.size();j++){
						
						TableColumn col = cols.get(j);
						String cellValue = col.getCellData(data.get(i)).toString();
						cellValue=cellValue.toLowerCase();
						
						if(cellValue.contains(anySearch.textProperty().get().toLowerCase())){
							
							tableItems.add(data.get(i));
							break;
						}	
						
					}
					
				}
				
				tab.setItems(tableItems);
			}
			
			
		});
		
		
	
		
		VBox display = new VBox(20);
		display.getChildren().addAll(tableLabel,searchBox,tab,hbtn);
		display.setPadding(new Insets(20,10,20,10));
		display.setSpacing(10);
		
		return display;
		
	}
	
@SuppressWarnings("unused")
private String toString(int getpolicyID) {
		// TODO Auto-generated method stub
		return null;
	}



      private boolean validate(){
		
		if(policyIdField.getText().isEmpty() | ProcedureArea.getText().isEmpty() |AmountField .getText().isEmpty()|
				datePicker.getEditor().getText().isEmpty()){
			

			//Alert for empty field --- VALIDATING THE FIELDS
			
			Alert alertField = new Alert(AlertType.WARNING);
			alertField.setTitle("Validate fields");
			alertField.setHeaderText(null);
			alertField.setContentText("Please enter all the fields");
			alertField.showAndWait();
			
			return false;	
		}
		
		return true;
	}
	
	public void clearFields(){
		policyIdField.clear();
		ProcedureArea.clear();
		AmountField.clear();
		datePicker.getEditor().clear();
		
	}
	
	
	public void viewClaim(){
		viewClaim.setOnAction(e->{	
		});
		}
	
	
	@SuppressWarnings("static-access")
	public void btnView(){
		submit.setOnAction(e ->{
			if(validate()){
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			Connector connector = new Connector();
			daoModelClaim c = new daoModelClaim();
			c.createTable();
			//Alert for confirming
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("Confirmation Dialog");
			String s = "HOSPITAL ID:"+ hosp.getText()+ "\n"+
					"POLICY ID:"+policyIdField.getText()+"\n"+
					"PROCEDURE :"+ProcedureArea.getText()+"\n"+
					"CLAIM AMOUNT:"+AmountField.getText()+"\n"+
					"VISIT DATE:"+datePicker.getEditor().getText();
			alert.setHeaderText("Confirm to submit");
			alert.setContentText(s);
			//alert.showAndWait();
			
			Optional<ButtonType> result = alert.showAndWait();
			if((result.isPresent()) && (result.get() == ButtonType.OK)){
				
			
			System.out.println("aaaaaa");
			int policyID = Integer.parseInt(policyIdField.getText());
			String desc = ProcedureArea.getText();
			double amt = Double.parseDouble(AmountField.getText());
			
				
				
				Date claimDate = null;
				
				java.util.Date selectedDate = Date.from(datePicker.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
				java.sql.Date date = new java.sql.Date(selectedDate.getTime());
				String claim_status=null;
				
				//System.out.println("date selected: "+ date);
				
				

				try {
					connection = connector.getConnection();
					daoModelClaim clm = new daoModelClaim();

					clm.createTable();
				
					clm.insertClaim(policyID, desc, amt, date, claimDate,claim_status);
					System.out.println("Data inserted");
					
					data.removeAll(data);
					
					@SuppressWarnings("unused")
					List<claim> claimList = new ArrayList<>();
					daoModelClaim daoclm = new daoModelClaim();
					@SuppressWarnings("unused")
					Connection connection1 = null;
					Statement statement = null;
					ResultSet rs = daoclm.getResultSet();
					Connector connector1 = new Connector();
							
					try {
						connection1 = connector1.getConnection();			

						daoclm.createTable();
						System.out.println("Table created");
						 claim clm1;
					
					while(rs.next()) {
						clm1 = new claim(rs.getInt("claim_id"), rs.getInt("policy_id"),rs.getDate("claim_dt").toLocalDate(), rs.getString("claim_status"), rs.getDouble("claim_amt"), rs.getString("claim_desc"));				
						
						data.add(clm1);
						
						
						
					}	
					
					for(claim currentTab : data) {
					   
						
						System.out.println("View data: "+currentTab.getclaimDate());
					}
					//FXCollections.copy(data, claimList);
					
					/*for (int i=0; i< claimList.size(); i++) {
						System.out.println("claim data: "+ claimList.get(i).getclaimDate());
					}*/
						
					} catch (Exception exx) {
						System.out.println("Error while fetching result set.");
						exx.printStackTrace();
						
					} finally {			
						try {
							if (connection != null) {
								connection.close();
							}
							if (statement != null) {					
								statement.close();
							}
							if (rs != null) {
								rs.close();
							}
						} catch (SQLException ex) {
							
							System.out.println("Error while closing connection/preparedStatement");
							ex.printStackTrace();
						}
					} 
					
													
													
					clearFields();
					
					
					
					
			}catch (Exception x){
				System.out.println("Error: "+x.getMessage());
			}finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (preparedStatement != null) {
						
						preparedStatement.close();
					}
				} catch (SQLException y){
					System.out.println("Error while closing connection/preparedStatement");
					y.printStackTrace();
				}
				
			}} else{
				
				alert.close();
			}
			
			}
				
		});
			
	}	
		
}
	
	
	
	
	

