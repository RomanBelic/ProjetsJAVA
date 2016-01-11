package com.research.run;

import com.research.beans.*;
import com.research.generics.MyList;

public class TreatementClass {
	
	private Person person1;
	private Person person2;
	private Person person3;
	private MyList <Person> lstPersons;
	
	public TreatementClass () {
		
	}
	
	protected Person SetData (Object obj, int age, int dob, String firstname, 
			                String lastname, String occupation ) {
		Object p = new Object ();
		if (obj instanceof Pupil ) {
		    p = new Pupil ();
		}
		try {
			((Person) p).setAge(age);
			((Person) p).setDatebirth(dob);
			((Person) p).setFirstname(firstname);
			((Person) p).setLastname(lastname);
			((Person) p).setOccupation(occupation);
		}
		catch (Exception e){
			e.getMessage();
			return null;
		}
		return ((Person) p);
	}
	
	
	@SuppressWarnings("unchecked")
	public static void main (String[] args) {
		
		TreatementClass EntryPoint = new TreatementClass ();
		EntryPoint.person1 = new Pupil ();
		EntryPoint.person2 = new Pupil ();
		EntryPoint.person3 = new Pupil ();
		EntryPoint.lstPersons = new MyList <Person> ();
		
		EntryPoint.person1 = EntryPoint.SetData (new Pupil (), 20, 1990, "roman", "belic", "driver");
		EntryPoint.person2 = EntryPoint.SetData (new Pupil (), 25, 1990, "niko", "belic", "killer");
		EntryPoint.person3 = EntryPoint.SetData (new Pupil (), 30, 1980, "dmitry", "larin", "mafiozi");
		
		EntryPoint.lstPersons.add(EntryPoint.person1);
		EntryPoint.lstPersons.add(EntryPoint.person2);
		EntryPoint.lstPersons.add(EntryPoint.person3);
		
		EntryPoint.lstPersons = 
		(MyList<Person>) EntryPoint.lstPersons.Where(Person.getField("datebirth"), 1990);
		
		for (Person p : EntryPoint.lstPersons) {
			System.out.println(p.toString());
			
		}
		
		
	}
	
	
	
	
	
	

}
