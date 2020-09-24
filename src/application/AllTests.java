package application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	Add_Test.class,
	UpdateTest.class,
	SearchTest.class,
	DisplayTeam.class,
	DisplayManagerTests.class,
	DisplayPlayerTest.class
	
})
public class AllTests {


}


