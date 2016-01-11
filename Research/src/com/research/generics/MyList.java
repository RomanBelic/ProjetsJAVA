package com.research.generics;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

import com.research.genericsinterfaces.SearchableList;

public class MyList <E> extends ArrayList <E> implements List<E>, RandomAccess, 
                                              Cloneable, Serializable, SearchableList{
	
	private static final long serialVersionUID = 1L;
	private Field [] fields;
	private ArrayList <Object> lstTemp; 
	
    @Override
	public ArrayList <? extends Object> Where (Field f, Object value) {
    	
		lstTemp =  new MyList <Object> ();
		
		try {
			for (Object obj : this) {
				
	            if (obj.getClass().getSuperclass().isAssignableFrom(obj.getClass())) {
	            	fields = obj.getClass().getSuperclass().getDeclaredFields();
	            }
	            else fields = obj.getClass().getDeclaredFields();
	            
				for (Field ftemp : fields) {
					ftemp.setAccessible(true);
					if (ftemp.equals(f)) {
						
            			if (f.get(obj) instanceof char[]){
            				if (obj == value){
            					lstTemp.add(obj);
            				}
            			}
            			
						if (ftemp.get(obj).equals(value)) {
							lstTemp.add(obj);
						}
					}
				}	
			}
		}
		catch (Exception e) {e.getMessage();}
		return lstTemp;
	}

	@Override
	public MyList<? extends Object> OrderBy(Field f, String Order) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
	
}
