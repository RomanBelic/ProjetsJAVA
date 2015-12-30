package com.itparis.b3.associations.common;

import java.util.Iterator;

public class CustomError extends Exception implements Iterable<Throwable> {
	
	/* Classe CustomError;
	 * Pas encore implementee;
	 * Sera utilisee dans la gestion d'erreurs personnelle
	 */
	private static final long serialVersionUID = 1L;
	private int Code;
	private String Description;
	private String Reference;
	
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getReference() {
		return Reference;
	}
	public void setReference(String reference) {
		Reference = reference;
	}
	@Override
	public Iterator<Throwable> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
