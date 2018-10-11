package model;
import java.time.LocalDate;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class claim {
	

	   private SimpleIntegerProperty claimID;
	   private SimpleIntegerProperty policyID;
	   private  ObjectProperty<LocalDate> claimDate;
	   private StringProperty status;
	   private DoubleProperty claimAmount;
	   private StringProperty claim_desc;
	   
	   public claim (int claimID, int policyID, LocalDate claimDate, String status, double claimAmount, String claim_desc){
      
		   
		   this.claimID = new SimpleIntegerProperty(claimID);
		   this.policyID = new SimpleIntegerProperty(policyID);
		   this.claimDate = new SimpleObjectProperty<LocalDate>(claimDate);
		   this.status= new SimpleStringProperty(status);
		   this.claimAmount= new SimpleDoubleProperty(claimAmount);
		   this.claim_desc= new SimpleStringProperty(claim_desc);
		   
	   }
	   
	   public LocalDate getclaimDate(){
		   return claimDate.get();
	   }
	   
	   public void setclaimDate(LocalDate value){
		   claimDate.set(value);
	   }
	   
	   public ObjectProperty<LocalDate> claimDateProperty(){
		   return claimDate;
	   }
	   public String getstatus(){
		   return status.get();   
	   }
	   
	   public void setstatus(String value){
		   status.set(value);
	   }
	   
	   public StringProperty statusProperty(){
		   return status;
	   }
	   
	  public int getclaimID(){
		   return claimID.get();
	   }

	   public void setclaimID(int value){
		   claimID.set(value);
	   }
	  
	   public IntegerProperty claimIDProperty(){
		   return claimID;
	   }
	 
	   public int getpolicyID(){
		   return policyID.get();
	   }

	   public void setpolicyID(int value){
		   policyID.set(value);
	   }
	  
	   public IntegerProperty policyIDProperty(){
		   return policyID;
	   }
	   
	   public double getclaimAmount(){
		   return claimAmount.get();
	   }

	   public void setclaimAmount(double value){
		   claimAmount.set(value);
	   }
	  
	   public DoubleProperty claimAmountProperty(){
		   return claimAmount;
	   }
	   
	   
	   public String getclaim_desc(){
		   return claim_desc.get();   
	   }
	   
	   public void setclaim_desc(String value){
		   claim_desc.set(value);
	   }
	   
	   public StringProperty claim_descProperty(){
		   return claim_desc;
	   }


	   
}
