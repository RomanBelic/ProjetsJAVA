package com.itparis.b3.associations.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itparis.b3.associations.metier.EventMetier;

public class EvenDAOTest {

	@Test
	public void getObjectEventDAO() {
	    assertEquals(1 ,EventMetier.getAssociationEvent(1).getId());
	}
	
	@Test
	public void getListEventDAO() {
	    assertEquals(1 ,EventMetier.getListAssociationEvents(1, "", "", "").size());
	}

	@Test
	public void getObjectParticipantDAO() {
	    assertEquals(1 ,EventMetier.getParticipantEvent(1, 1, 1).utilisateur.getId());
	}
	
	@Test
	public void getListParticpantDAO() {
	    assertEquals(2 ,EventMetier.getListParticipantEvents(1, 1, "", "").size());
	}

}
