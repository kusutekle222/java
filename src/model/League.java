package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class League {
	 private ArrayList<Team> team=new ArrayList<Team>();  
	 
	 
	 public League(){
		 
	 }
	 
	 
	 /**
	  * Add team to the league
	  * @param team1
	  */
	 public void add(Team team1) {
		 team.add(team1);
	 }

	 /**
	  * remove team from the league by colour
	  * @param colo
	  */
	 
	 public void remove(String colo) {
		 for(int i=0;i<team.size(); i++) {
			 if(team.get(i).getColour().equals(colo)) {
				 team.remove(i);
			 }
		 }
	 }
	 
	 /**
	  * get the colour from user and return the team name
	  * @param colour
	  * @return team
	  */
	 public Team getTeam(String colour) {
		 Team team1 = null;
		
		 for(int i=0;i<team.size();i++) {
			 if(team.get(i).getColour().equals(colour)) {
			 
				team1=team.get(i);
			 }
		 }
		return team1;
		
	 }
	 

	 /**
	  * print all the team in the league
	  */
		public void display() {
			System.out.println("\n*************************************************************************");
			System.out.print("Teams in the League\n");
			System.out.println("--------------------------------------");
			for (int i = 0; i < team.size(); i++) {
				System.out.println(team.get(i).toString());
			}
			
			System.out.println("\n*************************************************************************");

		}
	 
	
}
