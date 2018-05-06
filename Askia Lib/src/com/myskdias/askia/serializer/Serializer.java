package com.myskdias.askia.serializer;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import com.myskdias.askia.utils.ArrayUtils;
import com.myskdias.askia.utils.E;

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
		if(c.isArray()) {
			builder.append("[");
			int dim = ArrayUtils.getNumberOfDimensions(obj);
			int length = ArrayUtils.getLength(obj);
				for(int i = 0; i < length; i++) {
					Object val = ArrayUtils.get(obj, i);
					if(val == null) {
						builder.append("null");
					} else {
						builder.append(serialize0(val));
					}
					if(i != length -1) {
						builder.append(",");
					}
				}
				builder.append("]");
			
		} else {
			ArrayList<Field> toSerialize = reflection.listAllNonStaticField(c);
			int size = toSerialize.size();
			for(int i = 0; i < size; i++) {
				Field f = toSerialize.get(i);
				f.setAccessible(true);
				Object object = f.get(obj);
				if(object != null)
					builder.append(serialize0(object));
				else builder.append("null");
				if(i != size - 1)
					builder.append(",");
			}
		}
		
		builder.append(")}");
		return builder;
	}
	
	private StringBuilder serializeName(Class<?> c) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{");
		stringBuilder.append(c.getCanonicalName());
		stringBuilder.append(":(");
		return stringBuilder;
	}
	
	public <T> T deserialize(byte[] data, Class<T> cl) {
		if(cl == null) return null;
		String s = new String(data);
		E<Class<?>, Integer> e = getObjectClass(s);
		Class<?> current = e.getK();
		if(current == null) {
			return null;
		}
		if(!cl.isAssignableFrom(current)) {
			System.out.println(cl.getCanonicalName() +" is not a superclass or the same class of "+current.getCanonicalName());
			return null;
		}
		return null;
	}
	
	private E<Class<?>, Integer> getObjectClass(String s) {
		int a = s.indexOf(':');
		String className = s.substring(1, a);
		Class<?> cl = null;
		try {
			cl = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			System.out.println("Class not load ! "+className);
		}
		
		E<Class<?>, Integer> e = new E<Class<?>, Integer>(cl, a);
		
		return e;
	}
	
	
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Class<Integer> c = Integer.TYPE;
		Class<Number> c1 = Number.class;
//		Serializer serializer = new Serializer();
//		ArrayList<Object> z = new ArrayList<>();
//		z.add("Salut");
//		z.add(new Vector<>());
//		z.add(45);
//		z.add(new BigDecimal(45));
//		StringBuilder build = serializer.serialize0(z);
//		System.out.println(build.toString());
//		BigDecimal dec = serializer.deserialize(null, BigDecimal.class);
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
