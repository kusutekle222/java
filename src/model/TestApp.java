package model;

import Controller.controller;

/**
 * some tests for add and remove players and manager
 * add team  
 * add player and manager to the team 
 * add team to the league
 * @author kusu
 *
 */
public class TestApp {

	public static void main(String[] args) {
		
		Name name=new Name("abi","danny","miki");
		Player player= new Player(name,"abi@yahoo.ie","789654",2,true);
		System.out.println(player);
		
		Name name2=new Name("Isaac","danny","meda");
		Player player2= new Player(name2,"Isaac@yahoo.ie","5321654",3,true);
		System.out.println(player2);
		
		
		Name name3=new Name("arzanesh","tughrul","miki");
		Player player3= new Player(name,"arzianish@yahoo.ie","02563254",0,false);
		System.out.println(player3);
	
		Name name4=new Name("Dave","karen","ben");
		Player player4= new Player(name,"dave@yahoo.ie","65789654",0,false);
		System.out.println(player4);
		
		System.out.println("");
		
		Name namem=new Name("Mary","Dlyan","Ben");
		Manager manager= new Manager(namem,"65789654","Mary@yahoo.ie","1990",5);
		System.out.println(manager);
		
		
		Name namem1=new Name("Victor","Riyan","Ben");
		Manager manager1= new Manager(namem1,"65789654","Victor@yahoo.ie","2008",1);
		System.out.println(manager1);
		
		
		
		Team team=new Team("Blue");
		Team team1=new Team("Red");
		Team team2=new Team("Green");
		Team team3=new Team("Yellow");
			
		team.add(player);
		team.add(player3);
		
		team1.add(player2);
		team1.add(player4);
		
		team.setaManager(manager);
		team1.setaManager(manager1);
		
		System.out.println();
		team.display();
		
		System.out.println();
		team1.display();
		
		League league=new League();
		league.add(team);
		league.add(team1);
		league.add(team2);
		league.add(team3);
		
		
		league.display();
		
		controller cont= new controller();
		System.out.println("\nMemory Usage");
		System.out.println("-------------------");
		System.out.println(cont.processDemo());
			
	}

}
