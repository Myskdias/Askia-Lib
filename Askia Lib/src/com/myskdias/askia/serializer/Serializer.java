package com.myskdias.askia.serializer;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializer {
	
	public static final HashMap<String, String> VOC = new HashMap<>();
	
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
		if(obj == null) {
			return new StringBuilder().append("null");
		}
		
		Class<?> c = obj.getClass();
		String equiv = VOC.get(c.getCanonicalName());
		if(equiv != null) {
			if(equiv.equalsIgnoreCase("$U")) {
				return new StringBuilder().append(equiv).append('-').append("\"").append(obj).append("\"");
			} else {
				return new StringBuilder().append(equiv).append('-').append(obj.toString());
			}
		}
		StringBuilder builder = serializeName(c);
		ArrayList<Field> toSerialize = reflection.listAllNonStaticField(c);
		System.out.println(toSerialize);
		int size = toSerialize.size();
		for(int i = 0; i < size; i++) {
			Object object = toSerialize.get(i).get(obj);
			if(object != null)
				builder.append(serialize0(object));
			else builder.append("null");
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
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Serializer serializer = new Serializer();
		StringBuilder build = serializer.serialize0(new StringBuilder());
		System.out.println(build.toString());
//		System.out.println(new Integer(5));
//		String s = "{java.io.Test:[$i-5,$b:1]}";
//		byte[] b = s.getBytes();
//		byte[] b1 = null;
//		try {
//			b1 = new BASE64Decoder().decodeBuffer(s);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		System.out.println(b.length +" | "+b1.length);
//		System.out.println(new BASE64Encoder().encode(b1));
	}
	
	static {
		VOC.put("int", "$i");
		VOC.put("char", "$c");
		VOC.put("boolean", "$b");
		VOC.put("float", "$f");
		VOC.put("long", "$l");
		VOC.put("byte", "$y");
		VOC.put("double", "$d");
		VOC.put("short", "$s");
		
		VOC.put("java.lang.Integer", "$I");
		VOC.put("java.lang.Character", "$C");
		VOC.put("java.lang.Boolean", "$B");
		VOC.put("java.lang.Float", "$F");
		VOC.put("java.lang.Long", "$L");
		VOC.put("java.lang.Byte", "$Y");
		VOC.put("java.lang.Double", "$D");
		VOC.put("java.lang.Short", "$S");
		VOC.put("java.lang.String", "$U");
	}
	
}
