package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name="player")
@Table(name="player")

/**
 * Car inherits from super class Vehicle
 */
public class Player extends Person {
	/**
	 * Attributes
	 */
	@Column(name="goal")
   int goals;
	@Column(name="goalie")
   boolean goalie;
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="idplayer")
   int playerid;
   
   @Column(name="Teamid")
   int teamid;
   
   /**
    * Parameters in the constructor
    * 
    * @param nam
    * @param pho
    * @param ema
    * @param goa
    * @param goalie
    */
   
	public Player(Name nam, String pho, String ema,  int goa, boolean goalie) {
		super(nam, pho, ema);
		goals=goa;
		this.goalie=goalie;
		
	
	}
	
	public Player() {
		
	}
	
	/**
	 * 
	 * @return goalie
	 */
	
	public boolean isGoalie() {
		return goalie;
		
	}
	
	/**
	 * 
	 * @param goalie
	 */
	public void setGoalie(boolean goalie) {
		this.goalie = goalie;
	}
	
	/**
	 * 
	 * @return goals
	 */
	public int getGoals() {
		return goals;
	}
	
	/**
	 * 
	 * @param goals
	 */
	public void setGoals(int goals) {
		this.goals = goals;
	}
	
	/**
	 * 
	 * @return playerid
	 */
	
	public int getPlayerid() {
		return playerid;
	}

	/**
	 * 
	 * @param playerid
	 */
	public void setPlayerid(int playerid) {
		this.playerid = playerid;
	}

	/**
	 * 
	 * @return teamid
	 */
	public int getTeamid() {
		return teamid;
	}

	/**
	 * 
	 * @param teamid
	 */
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}

	/**
	 * toString method 
	 * @return the player detail
	 */
	@Override
	public String toString() {
		return "Player "+super.toString() + ", goals=" + goals + ", goalie=" + goalie ;
	}
	
	
	

}
