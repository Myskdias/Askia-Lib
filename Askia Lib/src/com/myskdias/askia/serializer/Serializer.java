package com.myskdias.askia.serializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import sun.misc.*;

@SuppressWarnings("restriction")
public class Serializer {
	
	private Reflection reflection;
	
	public Serializer() {
		reflection = new Reflection();
	}
	
	public byte[] serialize(Object obj) {
		try {
			return serialize0(obj).toString().getBytes();
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private StringBuilder serialize0(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class<?> c = obj.getClass();
		StringBuilder builder = serializeName(c);
		
		ArrayList<Field> toSerialize = reflection.listAllNonStaticField(c);
		int size = toSerialize.size();
		for(int i = 0; i < size; i++) {
			builder.append(serialize0(toSerialize.get(i).get(obj)));
			if(i != size - 1)
				builder.append(",");
		}
		builder.append("]}");
		return builder;
	}
	
	private StringBuilder serializeName(Class<?> c) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		stringBuilder.append(c.getCanonicalName());
		stringBuilder.append(":[");
		return stringBuilder;
	}
	
	public static void main(String[] args) {
		String s = "{java.io.Test:[$i-5,$b:1]}";
		byte[] b = s.getBytes();
		byte[] b1 = null;
		try {
			b1 = new BASE64Decoder().decodeBuffer(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(b.length +" | "+b1.length);
		System.out.println(new BASE64Encoder().encode(b1));
	}
	
}
