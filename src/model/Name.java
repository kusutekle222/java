package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This class is name class to get and set names
 * @author kusu
 *
 */
@Embeddable
public class Name {
	@Column(name="firstname")
private String firstname;
	@Column(name="lastname")
private String lastname;
	@Column(name="middlename")
private String middlename;
	
	/**
	 * Constructor Parameter
	 * 
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 */
   public Name(String firstname, String middlename, String lastname) {
	   this.firstname=firstname;
	   this.middlename=middlename;
	   this.lastname=lastname;
   }
   
   public Name() {
	   
   }
   
   /**
    * get firstname from user
    * @return firstname
    */
public String getFirstname() {
	return firstname;
}

/**
 * 
 * @param firstname
 */
public void setFirstname(String firstname) {
	this.firstname = firstname;
}

/**
 * get lastName from user
 * @return lastname
 */
public String getLastname() {
	return lastname;
}

/**
 * 
 * @param lastname
 */
public void setLastname(String lastname) {
	this.lastname = lastname;
}

/**
 * get middleName from user 
 * @return middlename
 */
public String getMiddlename() {
	return middlename;
}

/**
 * 
 * @param middlename
 */
public void setMiddlename(String middlename) {
	this.middlename = middlename;
}

/**
 * toString method to return name detaiils
 */
@Override
public String toString() {
	return "firstname: " + firstname + ", lastname: " + lastname + ", middlename: " + middlename ;
}
   
   
}
