package com.itparis.b3.associations.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itparis.b3.associations.metier.UserMetier;

public class UserDAOTest {

	@Test
	public void getObjectUserDAO() {
     assertEquals(1, UserMetier.getUser(1).getId());
	}

	@Test
	public void getListUserDAO() {
		 assertEquals(4, UserMetier.getListUsers(0, 0, "").size());
	}
	
	@Test
	public void getObjectFicheParticipantDAO() {
		 assertEquals(1, UserMetier.getFicheParticipant(1).utilisateur.getId());
	}
	
	@Test
	public void getListFicheParticipantDAO() {
		 assertEquals(3, UserMetier.getListFicheParticipant(0, 0, 0, "", "").size());
	}

}
