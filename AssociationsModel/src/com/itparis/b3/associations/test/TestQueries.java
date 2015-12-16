package com.itparis.b3.associations.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.metier.AssociationMetier;
import com.itparis.b3.associations.metier.UserMetier;

public class TestQueries {
	
	private TestInterface frame;
	private List <Association> lstAssoc;
	private List <User> lstUser;
	
	
    
	public TestQueries () {
		frame = new TestInterface ();
		lstAssoc  = new ArrayList <Association> ();
		lstUser = new ArrayList <User> ();
	}
	
	public static void main (String[] args) {
		TestQueries t = new TestQueries ();
		t.frame.setVisible(true);
		t.FillData();
		//t.SetActionButton1();
		t.frame.button1.addActionListener(t.SetActionButton1());

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
		return l;
		//frame.button1.addActionListener(l);
	}
	
	protected void FillData () {
		lstAssoc = AssociationMetier.getAssociations("bd","");
		lstUser = UserMetier.getUsers(1, 2, "");
	}
	
	
	
}
