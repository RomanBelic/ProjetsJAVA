package com.research.genericsinterfaces;

import java.lang.reflect.Field;

import com.research.generics.MyList;

public interface SearchableList {
	
	public MyList <? extends Object> Where (Field f, Object value);
	
	public MyList <? extends Object> OrderBy (Field f, String Order);

}
