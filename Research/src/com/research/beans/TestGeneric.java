package com.research.beans;

import java.lang.reflect.*;

public abstract class TestGeneric <T extends Person>   {

	private Class <T> test;
	
	@SuppressWarnings("unchecked")
	public TestGeneric () {
		 ParameterizedType genericSuperclass = (ParameterizedType)getClass().getGenericSuperclass();
		 Type type = genericSuperclass.getActualTypeArguments()[0];
		 if (type instanceof Class)
			 this.test = (Class<T>) type;	 
	}
	
	public Class <T> getGeneric () {
		return test;
	}
	
	public static void main (String [] args) {
		TestGeneric <Pupil>g = new TestGeneric <Pupil> ();
		//System.out.println();

	}
}
