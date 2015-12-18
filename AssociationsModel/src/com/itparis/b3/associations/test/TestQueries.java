package com.itparis.b3.associations.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.beans.AssociationEvent;
import com.itparis.b3.associations.beans.FicheParticipant;
import com.itparis.b3.associations.beans.ParticipantEvents;
import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.metier.AssociationMetier;
import com.itparis.b3.associations.metier.EventMetier;
import com.itparis.b3.associations.metier.UserMetier;

public class TestQueries {
	
	private TestInterface frame;
	private List <Association> lstAssoc;
	private List <User> lstUser;
	private List <AssociationEvent> lstAevent;
	private List <ParticipantEvents> lstPe;
	private List <FicheParticipant> lstfiche;
	
	public TestQueries () {
		frame = new TestInterface ();
		lstAssoc  = new ArrayList <Association> ();
		lstUser = new ArrayList <User> ();
		lstAevent = new ArrayList<AssociationEvent> ();
		lstPe = new ArrayList <ParticipantEvents> ();
		lstfiche = new ArrayList<FicheParticipant> ();
	}
	
	public static void main (String[] args) throws UnsupportedEncodingException {
		TestQueries t = new TestQueries ();
		t.frame.setVisible(true);
		t.FillData();
		t.SetActionButton1();
	}
	
	protected  ActionListener SetActionButton1() {
		ActionListener l = new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
     		   frame.comboBox.removeAllItems();
    		   frame.comboBox2.removeAllItems();
    		   
               if (!Utilities.isNullOrEmptyList(lstAssoc)) {
            	   for (Association a : lstAssoc) {
            		   frame.comboBox.addItem(a.desc.getNomAssoc());
            	   }  
               }
				
               if (!Utilities.isNullOrEmptyList(lstUser)) {
            	   for (User u : lstUser) {
            		   frame.comboBox2.addItem(u.getNom());
            	   }  
               }
			}
		};
		frame.button1.addActionListener(l);
		return l;
	}
	
	protected void FillData () {
		lstAssoc = AssociationMetier.getListAssociations("bd","");
		lstUser = UserMetier.getListUsers(1, 0, "");
		lstAevent = EventMetier.getListAssociationEvents(1, "", "", "");
		lstPe =  EventMetier.getListParticipantEvents(1, 1, "asd", "");
		lstfiche = UserMetier.getListFicheParticipant(1, 0, 0, "", "");	
	}
	

	
	
}
