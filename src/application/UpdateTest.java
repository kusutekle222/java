package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.controller;

class UpdateTest {

	@Test
	void test() {
		controller cont= new controller();
		cont.Update(2, "Abi");
		
		int goal= cont.getGoal("Abi");
		
		assertEquals(2, goal);
	}

}
