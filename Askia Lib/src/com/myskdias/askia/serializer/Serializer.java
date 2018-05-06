package com.myskdias.askia.serializer;

import java.lang.reflect.Field;

public class Serializer {
	
	private Reflection reflection;
	
	public Serializer() {
		reflection = new Reflection();
	}
	
	public byte[] serialize(Object obj) {
		Class<?> t = obj.getClass();
		Field[] toSerialize = reflection.listAllNonStaticField(t);
		
		return new byte[0];
	}
	
}
