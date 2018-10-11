/* 
Program which acts as an interface for the sub class Hospital.java  to implement the methods that include various operation on claims
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: HospitalClaims.java
Date:11/23/2017
   
 */

package model;

import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;

public interface HospitalClaims {

	public ObservableList<claim> createObservableList();
	public VBox tableview();
	public void btnView();
	public void viewClaim();

	


}
