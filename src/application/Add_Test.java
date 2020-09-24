package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.controller;

class Add_Test {

	@Test
	void test() {
		controller con= new controller();	
		String st = con.getFirstName("Ben");
		assertEquals("Peter",st);
	}

}
