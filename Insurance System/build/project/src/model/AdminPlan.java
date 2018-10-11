package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AdminPlan {

	
	 private SimpleIntegerProperty planID;
	 public StringProperty planName;
	 private StringProperty planDescription;
	 private StringProperty planStatus;
	 private DoubleProperty planAmount;
	 
		public AdminPlan (int planID,String planName,String planDescription,String planStatus,Double planAmount){
		      
			   
			   this.planID = new SimpleIntegerProperty(planID);
			   this.planName= new SimpleStringProperty(planName);
			   this.planDescription=new SimpleStringProperty (planDescription);
			   this.planStatus=new SimpleStringProperty(planStatus);
			   this.planAmount=new SimpleDoubleProperty(planAmount);
		   }
		
		public AdminPlan(String planName){
		      
			   this.planName= new SimpleStringProperty(planName);
		   }
		   
	     public String getplanName(){
			   return planName.get();   
		   }
		   
		   public void setplanName(String value){
			   planName.set(value);;
		   }
		   
		   public StringProperty planNameProperty(){
			   return planName;   
		   }
		 public String getplanDescription(){
			   return planDescription.get();   
		   }
		   
		   public void setplanDescription(String value){
			  planDescription.set(value);
		   }
		   
		 public int getplanID(){
			   return planID.get();
		   }

		   public void setplanID(int value){
			   planID.set(value);
		   }
		  
		   public IntegerProperty planIDProperty(){
			   return planID;
		   }
		 
		 public String getplanStatus(){
			   return planStatus.get();   
		   }
		   
		   public void setplanStatus(String value){
			   planStatus.set(value);;
		   }
		   
		 
		   public double getplanAmount(){
			   return planAmount.get();
		   }

		   public void setplanAmount(double value){
			   planAmount.set(value);;
		   }
		  
		   public AdminPlan(){
			   
			   
		   }

		public AdminPlan(String string, String string2, String string3, double double1) {
			// TODO Auto-generated constructor stub
		}



	
}
