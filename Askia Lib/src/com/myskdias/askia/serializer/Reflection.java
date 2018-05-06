package com.myskdias.askia.serializer;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Reflection {

	public ArrayList<Field> listAllNonStaticField(Class<?> c) {
		Field[] allField = c.getDeclaredFields();
		ArrayList<Field> list = new ArrayList<>();
		for(Field f : allField) {
			if(!Modifier.isStatic(f.getModifiers())) {
				list.add(f);
			}
		}
		Class<?> cl = c;
		while((cl = cl.getSuperclass()) != Object.class) {
			list.addAll(listAllNonStaticField(cl));
			
		}
		return list;
	}

	public boolean isSuper(Class<?> base, Class<?> sup) {
		if(base == sup) {
			return true;
		}
		if(sup.isInterface()) {
			return containsInterface(base, sup);
		} else {
			return conatinsSuperClass(base, sup);
		}
	}
	
	public boolean conatinsSuperClass(Class<?> c, Class<?> c1) {
		if(c == null) return false;
		if(c == c1) return true;
		if(c == Object.class) return false;
		return conatinsSuperClass(c.getSuperclass(), c1);
	}
	
	public boolean containsInterface(Class<?> c, Class<?> c1) {
		if(c == null) return false;
		if(c == Object.class) return false;
		for(Class<?> i : c.getInterfaces()) {
			if(i == c1) {
				return true;
			}
			if(containsInterface(i, c1)) {
				return true;
			}
		}
		return containsInterface(c.getSuperclass(), c1);
	}
	
	public static void main(String[] args) {
		Class<?> c = BufferedOutputStream.class;
		Class<?> c1 = OutputStream.class;
		System.out.println(new Reflection().isSuper(c, c1));
	}
	
}
