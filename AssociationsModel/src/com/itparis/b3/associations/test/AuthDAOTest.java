package com.itparis.b3.associations.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itparis.b3.associations.metier.AuthMetier;

public class AuthDAOTest {

	@Test
	public void getStatusAuthDAOTest() {
		assertEquals (true, AuthMetier.CheckAuthentification("log", "mdp"));
	}
	
	@Test
	public void getUserAuthDataDAOTest() {
		assertEquals (1, AuthMetier.getUserAuthData("log", "mdp").getIdUser());
	}

}
