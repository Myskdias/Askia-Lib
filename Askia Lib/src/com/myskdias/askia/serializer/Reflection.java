package com.myskdias.askia.serializer;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Reflection {

	public ArrayList<Field> listAllNonStaticField(Class<?> c) {
		Field[] allField = c.getDeclaredFields();
		ArrayList<Field> list = new ArrayList<>();
		for(Field f : allField) {
			if(Modifier.isStatic(f.getModifiers())) {
				list.add(f);
			}
		}
		return list;
	}
	
}
