package com.research.beans;

import java.lang.reflect.Field;
import java.util.HashMap;

import com.research.generics.MyList;

public abstract class Person {
	
	protected int id;
	protected String firstname;
	protected String lastname;
	protected String occupation;
	protected int age;
	protected int datebirth;
	
	private HashMap <String, Field> fMap = new HashMap <String,Field> ();
	private Field [] fields = Person.class.getDeclaredFields();
	
	public Person () {
		for (Field f : fields) {
			fMap.put(f.getName(), f);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getDatebirth() {
		return datebirth;
	}
	public void setDatebirth(int datebirth) {
		this.datebirth = datebirth;
	}
	
	public abstract String toString();
	
	public Field getField (String Field) {
		if (fMap.containsKey(Field)) {
			fMap.get(Field).setAccessible(true);
			return fMap.get(Field);
			}
		else return null;
	}
	
	@SuppressWarnings("unchecked")
	public static void main (String [] args) throws IllegalArgumentException, IllegalAccessException {
	
		
	}
	
	

}
