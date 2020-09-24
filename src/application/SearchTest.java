package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.controller;

class SearchTest {

	@Test
	void test() {
		controller con= new controller();
		assertNotNull(con.search("Isaac","Meda"));
	}

}
