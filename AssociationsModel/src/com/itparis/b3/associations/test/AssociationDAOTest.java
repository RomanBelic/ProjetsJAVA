package com.itparis.b3.associations.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.metier.AssociationMetier;

public class AssociationDAOTest {
	
	    @Parameter
	    private Association a1  = new Association ();
	    @Parameter
	    private ArrayList<Association> lsta1 = new ArrayList<Association>();
	    	    

		@Test
		public void getObjectAssociationDAO() {
		    assertEquals(1 ,AssociationMetier.getAssociation(1).getId());
		}
		
	    @Test
		public void getListAssociationDAO() {
		    assertEquals(2 ,AssociationMetier.getListAssociations(0, "", "").size());
		}
		
		
}
