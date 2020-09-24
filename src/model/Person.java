package model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 * this class is a super class 
 * @author kusu
 *
 */

@MappedSuperclass
public class Person {
 @Embedded
 private Name name;
	@Column(name="phone")
 private String phone;
	@Column(name="email")
 private String email;
	
	/**
	 * Constructor parameters
	 *  
	 * @param name
	 * @param phone
	 * @param email
	 */
 public Person(Name name, String phone, String email) {
	this.name=name;
	 this.phone=phone;
	 this.email=email;
 }
 
 public Person() {
	 
 }
 
/**
 *  get name detail from user
 * @return name
 */
 
public Name getName() {
	return name;
}

/**
 * 
 * @param name
 */
public void setName(Name name) {
	this.name = name;
}

/**
 * get phone number from user 
 * @return phone
 */
public String getPhone() {
	return phone;
}

/**
 * 
 * @param phone
 */
public void setPhone(String phone) {
	this.phone = phone;
}

/**
 * get email from user
 * @return
 */
public String getEmail() {
	return email;
}

/**
 * 
 * @param email
 */
public void setEmail(String email) {
	this.email = email;
}

/**
 * toString method to return detail of person
 */
@Override
public String toString() {
	return name + ", phone: " + phone + ", email: " + email ;
}
 
 
}
