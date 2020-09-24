package model;

import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="team")
@Embeddable

/**
 * This CLass is team class add and remove and also they have setting and getting
 * @author kusu
 *
 */
public class Team  {
	//Attributes
	@Transient private Manager manager;
	@Transient private ArrayList<Player> player = new ArrayList<Player>();

	@Column(name="Colour")
	private String colour;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idTeam")
	private Integer Team_id;

	/**
	 * Parameter of a constructor
	 * @param c
	 */
	public Team(String c) {
		colour = c;
	}
	public Team() {

	}

	/**
	 * get team id
	 * @return Team_id
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
	 * get manager
	 * @return manager
	 */
	public Manager getaManager() {
		return manager;
	}

/**
 * 
 * set a manager
 * @param manager
 */
	public void setaManager(Manager manager) {
		this.manager = manager;
	}

/**
 * 
 * @return colour
 */
	public String getColour() {
		return colour;
	}
/**
 * 
 * @param colour
 */

	public void setColour(String colour) {
		this.colour = colour;
	}
	
	/**
	 * add player to the team
	 * @param player1
	 */
	public void add(Player player1) {
		player.add(player1);
	}
	
	/**
	 * remove player from the team
	 * @param p
	 */

	public void remove(Player p) {
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).equals(p)) {
				player.remove(i);
			}
		}
	}

/**
 * remove player from team by firstname
 * @param firstname
 */
	public void remove(String firstname) {
		for (int i = 0; i < player.size(); i++) {
			if (player.get(i).getName().getFirstname().equals(firstname)) {
				player.remove(i);
			}
		}
	}
	
	/**
	 * toString method to retun the detail of team
	 * @return teamdetail
	 */
	@Override
	public String toString() {
		return "Team colour: " + colour ;
	}

	/**
	 * print all team details with all the player and manager 
	 */
	public void display() {
		System.out.println("\n*********************************************************************************************************");
		System.out.println(toString() +" details");
		System.out.println("================================");

		System.out.println("\nManager of the team");
		System.out.println("--------------------------");
		System.out.println(manager+"\n");
		
		System.out.print("Players in the Team\n");
		System.out.println("--------------------------------------");
		for (int i = 0; i < player.size(); i++) {
			System.out.println(player.get(i).toString());
		}
		
		System.out.println("\n**************************************************************************************************");

	}

}
