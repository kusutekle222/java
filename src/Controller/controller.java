package Controller;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sun.glass.ui.Application;
import com.sun.glass.ui.CommonDialogs.ExtensionFilter;
import com.sun.glass.ui.CommonDialogs.FileChooserResult;
import com.sun.glass.ui.Cursor;
import com.sun.glass.ui.Pixels;
import com.sun.glass.ui.Robot;
import com.sun.glass.ui.Screen;
import com.sun.glass.ui.Size;
import com.sun.glass.ui.Timer;
import com.sun.glass.ui.View;
import com.sun.glass.ui.Window;

import javafx.collections.ObservableList;
import model.League;
import model.Manager;
import model.Name;
import model.Player;
import model.Team;

import java.util.List;

/**
 * Controller class connect database(Model) and view
 * @author kusu
 *
 */

public class controller {
	private League league;


	public controller() {
		league = new League();
	}

	/**
	 * Add player to the database player table
	 * 
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param phone
	 * @param email
	 * @param goal
	 * @param goalie
	 * @param tea
	 */
	public void addplayer(String firstname, String middlename, 
			String lastname,String phone, String email, int goal, boolean goalie, String tea) {
		Name n1=new Name(firstname,middlename, lastname);
		Player p1=new Player(n1,phone,email,goal,goalie);

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT te.Team_id FROM Team te WHERE te.colour = ?1");
		query.setParameter(1, tea);
		Integer foreign = (Integer)query.getSingleResult();
		System.out.println(foreign);
		p1.setTeamid(foreign);
		createEntityManager.persist(p1);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		Team team=league.getTeam(tea);
		team.add(p1);
	}


	/**
	 * remove player from the database
	 * 
	 * @param firstname
	 * @param team1
	 */
	public void removeplayer(String firstname) {
		//Team team= league.getTeam(team1);

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT m.idplayer FROM Player m WHERE m.firstname = '"+firstname+"'");

		Integer foreign = (Integer)query.getSingleResult();
		Player p = createEntityManager.find(Player.class, foreign);
		System.out.println(p);
		createEntityManager.remove(p);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		//team.remove(firstname);
	}

	/**
	 * search player by firstname and middlename
	 * 
	 * @param firstname
	 * @param lastname
	 * @return details of result for player
	 */
	public String search(String firstname, String middlename ) {
		String detail="";
		//detail+="Player goal and manager Detail\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query que =createEntityManager.createNativeQuery( "SELECT p.goal, m.firstname,m.middlename, m.lastname,m.email,m.phone, m.DOB, m.rate "
				+ "FROM manager m, player p, team t "
				+ "WHERE  p.Teamid= t.idTeam and t.idTeam=m.idTeam and p.firstname =\""+ firstname +"\" and p.middlename=\""+middlename+"\"");

		List<Manager> lis = que.getResultList();
		Iterator itr = lis.iterator();
		Object[] obj = (Object[]) itr.next();
		while(itr.hasNext()){

			//now you have one array of Object for each row
			Integer goals = Integer.parseInt(String.valueOf(obj[0]));
			String firstname1 = String.valueOf(obj[1]);
			String middlename1 = String.valueOf(obj[2]);  
			String lastname1 = String.valueOf(obj[3]);  
			String email = String.valueOf(obj[4]); 
			String phone = String.valueOf(obj[5]);
			String dob = String.valueOf(obj[6]);  
			Integer rate = Integer.parseInt(String.valueOf(obj[7]));}


		detail+=detail+"Player Goals: "+obj[0]+"\n\nManager Detail \n********************\n"
				+"FirstName: "+obj[1]+"\n"+"MiddleName: "+obj[2]+"\n"+"lastName: "+ obj[3]+"\n"
				+"Email: "+obj[4]+"\n"+"Phone: "+obj[5]+"\n"+"DOB: "+obj[6]+"\n"+"Star Rate: "+obj[7]+"\n";

		detail +="\n";
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		System.out.println(""+detail);
		return detail;
	}


	/**
	 * Update player goals
	 * 
	 * @param goal
	 * @param firstname
	 */
	public void Update(int goal, String firstname) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT m.idplayer FROM player m WHERE m.firstname = '"+firstname+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Player player=createEntityManager.find(Player.class,foreign); 

		player.setGoals(goal);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

	}


	/**
	 * sort player by firstName alphabetic order 
	 */

	public void sortPlayer() {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		String jql ="from player p order by p.firstname";
		Query query = createEntityManager.createQuery (jql);

		createEntityManager.persist(query);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

	}

	/**
	 * Add team to the database team table and add to the league
	 * @param color
	 */


	public void addTeam(String color) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Team t1=new Team(color);
		createEntityManager.persist(t1);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		league.add(t1);
	}


	/**
	 * remove team 
	 * @param color
	 */
	public void removeTeam(String color) {	

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query =createEntityManager.createNativeQuery( "SELECT t.idTeam FROM team t WHERE t.Colour = '"+color+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Team t = createEntityManager.find(Team.class, foreign);
		System.out.println(t);
		createEntityManager.remove(t);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();	


	}

	/**
	 * 
	 * Add manager to the database manager table 
	 * and set to the team
	 * 
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param phone
	 * @param email
	 * @param dob
	 * @param rat
	 * @param team1
	 */
	public void addManager(String firstname,String middlename, String lastname,String phone,String email,String dob,int rat,String team1) {
		Name n1=new Name(firstname,middlename, lastname);
		Team team= league.getTeam(team1);
		Manager m= new Manager(n1, phone,email,dob,rat);

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query = createEntityManager.createQuery( "SELECT t.Team_id FROM Team t WHERE t.colour = :color");
		query.setParameter("color", team1);
		Integer foreign = (Integer)query.getSingleResult();
		System.out.println(foreign);
		m.setTeam_id(foreign);
		createEntityManager.persist(m);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();


		m.setTeam(team);
		team.setaManager(m);
	}

	/**
	 * remove manager from team
	 * @param t
	 */
	public void removeManag(String t) {
		Team team= league.getTeam(t);
		Manager m= team.getaManager();
		m.setTeam(null);
		team.setaManager(null);
	}


	/**
	 * remove manager detail from the database manager table and from team by firstname
	 * 
	 * @param firstname
	 */
	public void removeManager(String firstname) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query query =createEntityManager.createNativeQuery( "SELECT m.idmanager FROM manager m WHERE m.firstname = '"+firstname+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Manager p = createEntityManager.find(Manager.class, foreign);
		System.out.println(p);
		createEntityManager.remove(p);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();	
	}

	/**
	 * display player detail in a particular team 
	 * by team color
	 * 
	 * @param tcolor
	 * @return the result
	 */
	public String playerDetail(String tcolor ) {
		String detail="";
		detail +="Player Details of  team "+ tcolor+"\n";
		detail+="===========================================\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query que =createEntityManager.createNativeQuery( "SELECT p.firstname, p.middlename,p.lastname,p.email,p.phone,"
				+ "p.goalie, p.goal, t.Colour FROM player p , team t WHERE  p.Teamid = t.idTeam and t.Colour = '"+tcolor+"' order by p.firstname");
		List<Player> lis = que.getResultList();

		Iterator itr = lis.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			//now you have one array of Object for each row
			String firstname = String.valueOf(obj[0]);  
			String middlename = String.valueOf(obj[1]);  
			String lastname = String.valueOf(obj[2]);  
			String email = String.valueOf(obj[3]); 
			String phone = String.valueOf(obj[4]);
			boolean goalie =Boolean.parseBoolean(String.valueOf(obj[5])); 
			Integer goals = Integer.parseInt(String.valueOf(obj[6])); 


			for(int i=0; i<obj.length; i++) {
				detail=detail+obj[i]+", ";
			}
			detail +="\n";

		}

		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		return detail;

	}


	/**
	 * display all the team in the league
	 * @return all theteams 
	 */
	public String displayTeam() {
		String detail="";
		detail +="Teams in  the League\n";
		detail+="===========================================\n\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query quer =createEntityManager.createNativeQuery( "SELECT Colour FROM team ");
		List<String> lis = quer.getResultList();

		for(int i=0; i<lis.size(); i++) {
			detail= detail+"\n"+(i+1)+".  "+ lis.get(i);
		}

		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		return detail;

	}

	/**
	 * Display all manager details in order by rate and firstName
	 * @return all managers 
	 */
	public String displayManager() {
		String detail="";
		detail +="All Managers in Order \n";
		detail+="=========================================\n\n";
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		Query quer =createEntityManager.createNativeQuery( "SELECT firstname,middlename,lastname,email,phone,DOB,rate,t.Colour "
				+ "FROM manager m, team t where m.idTeam= t.idTeam order by  rate ASc,  firstname Asc");
		List<Manager> lis = quer.getResultList();
		Iterator itr = lis.iterator();
		while(itr.hasNext()){
			Object[] obj = (Object[]) itr.next();
			//now you have one array of Object for each row
			String firstname = String.valueOf(obj[0]);  
			String middlename = String.valueOf(obj[1]);  
			String lastname = String.valueOf(obj[2]);  
			String email = String.valueOf(obj[3]); 
			String phone = String.valueOf(obj[4]);
			boolean goalie =Boolean.parseBoolean(String.valueOf(obj[5])); 
			Integer goals = Integer.parseInt(String.valueOf(obj[6])); 


			for(int i=0; i<obj.length; i++) {
				detail=detail+obj[i]+",   ";
			}
			detail +="\n";
		}
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		return detail;

	}

	/**
	 * fill comboBox from team table to select it 
	 * @param options
	 */

	public void fillComboBox(ObservableList options) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query quer =createEntityManager.createNativeQuery( "SELECT Colour FROM team ");
		List<String> lis = quer.getResultList();
		//Iterator itr = lis.iterator();

		for(int i=0; i<lis.size();i++) {
			options.add(lis.get(i));		

			//System.out.println(options);
		}
	}


	/**
	 * memory usage in this project
	 * @return the detail of memory usage
	 */
	public static String processDemo() {
		Runtime r=Runtime.getRuntime();
		for(int i=0;i<=10000;i++){
			new Object();
		}

		String result= ("\nNo of Processor: "+ r.availableProcessors()) 
				+"\nTotal memory: "+r.totalMemory()+
				"\nFree memory: "+r.freeMemory()+
				"\nMemory occupied: "+ (r.totalMemory()-r.freeMemory());

		r.gc();
		String result1="\n\n::Memory status::"+ 
				"\nTotal memory: "+r.totalMemory()+
				"\nFree memory: "+r.freeMemory()+
				"\nMemory occupied: "+ (r.totalMemory()-r.freeMemory());

		return result+result1;
	}

	public int getGoal(String firstname) {
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT p.goal FROM player p WHERE p.firstname = '"+firstname+"'");
		Integer foreign = (Integer)query.getSingleResult();
		Player player=createEntityManager.find(Player.class,foreign); 

		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
		return foreign;
	}

	public String getFirstName(String middlename) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();

		Query query =createEntityManager.createNativeQuery( "SELECT p.firstname FROM player p WHERE p.middlename = '"+middlename+"'");
		String foreign = (String) query.getSingleResult();
		//Player player=createEntityManager.find(Player.class,foreign); 

		System.out.println(foreign);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();
		
		return foreign;
	}
	


}

