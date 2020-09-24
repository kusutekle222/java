package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * test for add to the database using jpa
 * @author kusu
 *
 */
public class Test {

	public static void main(String[] args) throws ParseException {
	
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("java");
		EntityManager createEntityManager = factory.createEntityManager();
		createEntityManager.getTransaction().begin();
		
		Team manu= new Team();
		manu.setColour("red");
		Name name= new Name("kusu", "meda", "meda"); 
		Manager manag= new Manager(name,"45654564","kusu@mycit.ie","2002",7);
		manag.setTeam_id(2);
		
		
		createEntityManager.persist(manu);
		createEntityManager.persist(manag);
		createEntityManager.getTransaction().commit();
		createEntityManager.close();
		factory.close();

		
	}

}
