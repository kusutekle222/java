package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
@Entity
@Table(name="manager")

/**
 * Car inherits from super class Vehicle
 */
public class Manager extends Person {


	@Column(name="DOB")
	private  String date;
	@Column(name="rate")
	private   int rate;
	@Transient private Team team;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="idmanager")
	private Integer managerid;  

	@Column(name="idTeam")
	private Integer Team_id;

	/**
	 * Parameters in the constructor
	 * 
	 * @param nam
	 * @param pho
	 * @param ema
	 * @param dob
	 * @param rat
	 */

	public Manager(Name nam, String pho, String ema, String dob, int rat) {
		super(nam, pho, ema);
		date=dob;
		rate=rat;


	}

	public Manager() {
		super();
	}


	/**
	 * Gets manager id 
	 * @return managerid 
	 */
	public Integer getManagerid() {
		return managerid;
	}

	/**
	 * set manager id
	 * @param managerid
	 */

	public void setManagerid(Integer managerid) {
		this.managerid = managerid;
	}

	/**
	 * 
	 * @param team
	 */

	public void setTeam(Team team) {
		this.team = team;
	}

	/**
	 * Gets team from the user input
	 * @return team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Gets teamid
	 * @return teamid
	 */
	public Integer getTeam_id() {
		return Team_id;
	}

	/**
	 * 
	 * @param team_id
	 */
	public void setTeam_id(Integer team_id) {
		Team_id = team_id;
	}
	/**
	 * set star rate and check the rate is between 1-10 
	 * @param rate
	 */

	public void setStarRate(int rate) {	
		if ((rate >0)&&(rate<10)) {
			this.rate=rate;
		}
		else
			System.out.println("please put between 1-10 numbers!");		
	}

	/**
	 * get star rate 
	 * @return rate
	 */
	public int getStarRate() {
		return rate;
	}

	/**
	 * get date of birth
	 * @return date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 
	 * @param date1
	 */
	public void setDate(String date1) {
		this.date= date;
	}

	/**
	 * tostring method to print the detail of manager
	 * @return the details
	 */
	@Override
	public String toString() {
		return "Manager "+super.toString()+",date: " + date + ", rate: " + rate ;
	}




}
