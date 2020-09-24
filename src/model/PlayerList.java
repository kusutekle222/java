package model;

import java.util.ArrayList;

import javassist.compiler.Parser;

/**
 * this class for store list of player
 * @author kusu
 *
 */
public class PlayerList  {
	private ArrayList<Player> playList;

	public PlayerList() {
		playList= new ArrayList<Player>();
	}

	/**
	 * Setter
	 * @param playList
	 */
	public void setListPlayer(ArrayList<Player> playList){
		this.playList = playList;
	}

	/**
	 * Getter
	 * @return playList
	 */

	public ArrayList<Player> getListPlayer() {
		return this.playList;
	}

	/**
	 * add player to the ArrayList of player
	 * @param play1
	 */
	public void addPlay(Player play1) {
		playList.add(play1);
	}

	/**
	 *  return  player by specific index
	 * @param i
	 * @return player
	 */
	public Player getPlayers(int i){
		if ((i>-1) && (i < playList.size()))
			return playList.get(i);
		return null;
	}
	
	/**
	 * remove player by firstname
	 * @param str
	 */
	public void removePlayer(String str) {

		for (int i = 0 ; i< playList.size(); i++) {
			if (playList.get(i).getName().getFirstname().equals(str))
				playList.remove(i);}

	}


	/**
	 * search player by input firstName
	 * @param firstname
	 * @return player detail
	 */

	public Player search(String firstname) {
		for(Player p: playList) 
		{
			if(p.getName().getFirstname().equals(firstname)) 
			{
				return p;	
			}
		}
		return null; 
	}

	/**
	 * toString method to return the details of players
	 */

	public String toString() {
		//Use stringbuilder to convert given data to string and then
		//appends the characters of that string to the string builder
		StringBuilder sb = new StringBuilder(); 
		for(int i = 1; i <= playList.size(); i++){
			Player player = playList.get(i-1);
			//Player player1 = (Player) playList.get(i-1);
			// Append i (the player) and their attributes
			sb.append(i + ": "+ "First Name: " + player.getName().getFirstname() + " , " + "Middle Name : " + player.getName().getMiddlename() +
					" , " + "Last Name:  " + player.getName().getLastname()+ " , " + "Email:  " + player.getEmail() + " , " +
					"Phone: "+player.getPhone()+ ",  Goal:  " + player.getGoals() + "\n");
		}
		return sb.toString();
	}

	public PlayerList getPlayer(int i) {
		
		return null;
	}


}


