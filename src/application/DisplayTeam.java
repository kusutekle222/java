package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Controller.controller;

class DisplayTeam {

	@Test
	void test() {
		controller con= new controller();

		assertNotNull(con.displayTeam());
	}

}
