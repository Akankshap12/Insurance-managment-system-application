/* 
Program which acts as model for the three users admin,policy holder and hospital with  getters and setters for the users to login and perform various operations 
   
Final Project,Programmer: Sadaa Sree Ravichandar, File Name: Users.java
Date:11/23/2017
   
 */
package model;

/* class called Users.java which acts as the main class and includes getters and setters to login and direct the users to their respective page
 * Programmer : Sadaa Sree Ravichandar
 * Date		  :09/24/2017
 * */

public class Users {

	Integer id, contactNumber;
	String username, password, userRole, firstName, LastName, email;

	public Integer getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Integer contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

}
