package com.research.genericsinterfaces;

import java.lang.reflect.Field;
import java.util.ArrayList;

public interface SearchableList {
	
	public ArrayList <? extends Object> Where (Field f, Object value);
	
	public ArrayList <? extends Object> OrderBy (Field f, String Order);

}
