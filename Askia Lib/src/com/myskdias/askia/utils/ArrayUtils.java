package com.myskdias.askia.utils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A class which made for fill all thing miss in <code> java.lang.utils.Arrays </code>
 * class.
 * 
 * @author SkyDiams
 * 
 *
 */
public class ArrayUtils {
	
	private static final Map<Class<?>, Class<?>> PRIM;
	private static final Map<Class<?>, Class<?>> PRIM1;
	
	public static final int AS_ARRAY_EMPTY = 0;
	public static final int AS_ARRAY_DEFAULT = 1;
	public static final int AS_SYSTEM_METHOD = 7;
	public static final int AS_ARRAYUTILS_METHOD = 9;
	public static final int AS_REMOVE_ILLEGAL_VALUE = 11;
	
	static {
		PRIM = new HashMap<>();
		PRIM.put(Integer.class, int.class);
		PRIM.put(Double.class, double.class);
		PRIM.put(Float.class, float.class);
		PRIM.put(Long.class, long.class);
		PRIM.put(Short.class, short.class);
		PRIM.put(Byte.class, byte.class);
		PRIM.put(Boolean.class, boolean.class);
		PRIM.put(Character.class, char.class);
		PRIM1 = new HashMap<>();
		PRIM.put(int.class, Integer.class);
		PRIM.put(double.class, Double.class);
		PRIM.put(float.class, Float.class);
		PRIM.put(long.class, Long.class);
		PRIM.put(short.class, Short.class);
		PRIM.put(byte.class, Byte.class);
		PRIM.put(boolean.class, Boolean.class);
		PRIM.put(char.class, Character.class);
	}
	
	private static boolean isArgs(int i, int i2) {
		return i == i2;
	}
	
	public static Class<?> getArrayType(Class<?> componentType, int dimensions) throws ClassNotFoundException {
        if (dimensions == 0) {
            return componentType;
        }

        String rawName = componentType.getName();
        switch (rawName) {
            case "byte":    rawName = "B"; break;
            case "char":    rawName = "C"; break;
            case "double":  rawName = "D"; break;
            case "float":   rawName = "F"; break;
            case "int":     rawName = "I"; break;
            case "long":    rawName = "J"; break;
            case "short":   rawName = "S"; break;
            case "boolean": rawName = "Z"; break;
            default:
                rawName = "L" + rawName + ";";
                break;
        }

        for (int i = 0; i < dimensions; i++) {
            rawName = "[" + rawName;
        }
        return Class.forName(rawName);
    }

    public static Object createArray(Class<?> componentType, int dimensions, int length) throws NegativeArraySizeException, ClassNotFoundException {
        if (dimensions == 0) {
            return null;
        }

        Object array = Array.newInstance(getArrayType(componentType, dimensions - 1), length);

        for (int i = 0; i < length; i++) {
            Array.set(array, i, createArray(componentType, dimensions - 1, length));
        }

        return array;
    }
	
    public static Object[] fusion(Object[] a, Object[] b) {
    	Object[] nData = new Object[a.length+b.length];
		System.arraycopy(a, 0, nData, 0, a.length);
		System.arraycopy(b, 0, nData, a.length, b.length);
		return nData;
    }
    
    public static byte[] fusion(byte[] a, byte[] b) {
    	byte[] nData = new byte[a.length+b.length];
		System.arraycopy(a, 0, nData, 0, a.length);
		System.arraycopy(b, 0, nData, a.length, b.length);
		return nData;
    }
    
	public static Object createArray(int dim, Class<?> type, boolean a, int empty) {
		if(a)
			type = getBaseClass(type);
		Object array = null;
		try {
			array = Array.newInstance(getArrayType(type, dim), empty);
		} catch (NegativeArraySizeException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public static Object createArray(Class<?> type, int length) {
		Object array = null;
		try {
			array = Array.newInstance(type.getComponentType() == null ? type : type.getComponentType(), length);
		} catch (NegativeArraySizeException e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public static Class<?> swapFromPrimitive(Class<?> other) {
		if(other == null) System.out.println("kk");
		if(!isPrimitiveArray(other)) {
			System.out.println("primArray");
			return PRIM.get(getBaseClass(other));
		}
		System.out.println("rml");
		System.out.println(getBaseClass(other).getCanonicalName());
		if(!PRIM1.containsKey(other)) {
			System.out.println("noKey");
		}
		return PRIM1.get(getBaseClass(other));
	}
	
	public static int getLength(Object array) {
		return Array.getLength(array);
	}

	public static Object get(Object array, int index) {
		return Array.get(array, index);
	}

	public static boolean getBoolean(Object array, int index) {
		return Array.getBoolean(array, index);
	}

	public static byte getByte(Object array, int index) {
		return Array.getByte(array, index);
	}

	public static char getChar(Object array, int index) {
		return Array.getChar(array, index);
	}

	public static short getShort(Object array, int index) {
		return Array.getShort(array, index);
	}

	public static int getInt(Object array, int index) {
		return Array.getInt(array, index);
	}

	public static long getLong(Object array, int index) {
		return Array.getLong(array, index);
	}

	public static float getFloat(Object array, int index) {
		return Array.getFloat(array, index);
	}

	public static double getDouble(Object array, int index) {
		return Array.getDouble(array, index);
	}

	public static void set(Object array, int index, Object value) {
		Array.set(array, index, value);
	}

	public static void setBoolean(Object array, int index, boolean value) {
		Array.setBoolean(array, index, value);
	}

	public static void setByte(Object array, int index, byte value) {
		Array.setByte(array, index, value);
	}

	public static void setChar(Object array, int index, char value) {
		Array.setChar(array, index, value);
	}

	public static void setShort(Object array, int index, short value) {
		Array.setShort(array, index, value);
	}

	public static void setInt(Object array, int index, int value) {
		Array.setInt(array, index, value);
	}

	public static void setLong(Object array, int index, long value) {
		Array.setLong(array, index, value);
	}

	public static void setFloat(Object array, int index, float value) {
		Array.setFloat(array, index, value);
	}

	public static void setDouble(Object array, int index, double value) {
		Array.setDouble(array, index, value);
	}
	
	
	
	public static void fill(Object array, int methodType, Object... values) {
		if (!isArray(array))
			return;
		int limit = 0;
		if (values.length < getLength(array)) {
			limit = getLength(values);
		} else {
			limit = getLength(array);
		}
		limit--;
		boolean b = isArgs(methodType, AS_ARRAYUTILS_METHOD | AS_REMOVE_ILLEGAL_VALUE); 
		if (isArgs(AS_SYSTEM_METHOD, methodType)) {
			System.arraycopy(array, 0, values, 0, limit);
		} else if (isArgs(AS_ARRAYUTILS_METHOD, methodType) || b) {
			if (isPrimitiveArray(array)) {
				if (isPrimitiveArray(values)) {
					fill(array, AS_SYSTEM_METHOD, values);
					return;
				} else {
					for(int index = 0; index < limit; index++) {
						Object value = values[index];
						index++;
						Class<?> valueClass = value.getClass();
						if(isArray(valueClass)) {
							if(getNumberOfDimensions(array) -1 == getNumberOfDimensions(valueClass)) {
								if(!isPrimitiveArray(valueClass)) {
									fill(get(array, index), methodType, value);
								} else {
									fill(get(array, index), AS_SYSTEM_METHOD, value);
								}
							} else {
								if(!b) {
									throw new ClassCastException("Impossible to cast "+valueClass.getCanonicalName()+" to "+getBaseClass(array).getCanonicalName());
								}
							}
						} else if(isArray(get(array, index))) {
							if(!b) {
								throw new ClassCastException("Impossible to cast "+valueClass.getCanonicalName()+" to "+getBaseClass(array).getCanonicalName());
							}
							continue;
						}
						
						if (valueClass == byte.class) {
							set(array, index, new Byte((byte)value));
							continue;
						} else if (valueClass == short.class) {
							set(array, index, new Short((short)value));
							continue;
						} else if (valueClass == int.class) {
							set(array, index, new Integer((int)value));
							continue;
						} else if (valueClass == long.class) {
							set(array, index, new Long((long)value));
							continue;
						} else if (valueClass == char.class) {
							set(array, index, new Character((char)value));
							continue;
						} else if (valueClass == float.class) {
							set(array, index, new Float((float)value));
							continue;
						} else if (valueClass == double.class) {
							set(array, index, new Double((double)value));
							continue;
						} else if (valueClass == boolean.class) {
							set(array, index, new Boolean((boolean)value));
							continue;
						} else {
							if(!b) {
								throw new ClassCastException("Impossible to cast "+valueClass.getCanonicalName()+" to "+getBaseClass(array).getCanonicalName());
							}
							continue;
						}
					}

				}
			} else {
				for(int index = 0; index < limit; index++) {
					Object value = values[index];
					Class<?> valueClass = value.getClass();
					index++;
					if(getBaseClass(array).isInstance(value)) {
						set(array, index, value);
					} else {
						if(!b) {
							throw new ClassCastException("Impossible to cast "+valueClass.getCanonicalName()+" to "+getBaseClass(array).getCanonicalName());
						}
					}
				}
			}
		} else {
			throw new IllegalArgumentException("Invalid method for fill (arg2 ->  methodType)");
		}

	}
	
	public static Object[] fromPrimitiveType(Object array) {
		if(!isArray(array)) return null;
		if(!isPrimitiveArray(array)) return (Object[]) array;
		try {
			Class<?> equivalent = getArrayType(swapFromPrimitive(array.getClass()), getNumberOfDimensions(array));
			Object newArray = createArray(equivalent, getLength(array));
			fill(newArray, AS_ARRAYUTILS_METHOD | AS_REMOVE_ILLEGAL_VALUE, array);
			return (Object[]) newArray;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Object toPrimitiveType(Object[] array) {
		if(isPrimitiveArray(array)) return array;
		if(array == null) {
			System.out.println("rr");
		}
		try {
			Class<?> swap = swapFromPrimitive(array.getClass());
			if(swap == null) {
				System.out.println("rre");
			}
			Class<?> equivalent = getArrayType(swap, getNumberOfDimensions(array));
			System.out.println(equivalent.getCanonicalName()+" i");
			Object newArray = createArray(equivalent, getLength(array));
			System.out.println(newArray.getClass().getCanonicalName()+" m");
			fill(newArray, AS_ARRAYUTILS_METHOD | AS_REMOVE_ILLEGAL_VALUE, array);
			return newArray;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Object fromString(String array, Class<?> classType) {
		return null;
	}
	
	public static Class<?> getBaseClass(Object obj) {
		return getBaseClass(obj.getClass());
	}
	
	public static Class<?> getBaseClass(Class<?> type) {
		if(type == null) {
			System.out.println("kkkkkl");
		}
		if (type.getComponentType() == null) {
			return type;
		} else {
			return getBaseClass(type.getComponentType());
		}
	}
	
	public static boolean isArray(Object obj) {
		return obj.getClass().isArray();
	}
	
	public static boolean isPrimitiveArray(Object obj) {
		return !(obj instanceof Object[]) && obj.getClass().isArray();
	}
	
	public static int getNumberOfDimensions(Object array) {
		if(!isArray(array)) {
			throw new IllegalArgumentException("The first argument must be an array !");
		}
		return getNumberOfDimensions(array.getClass());
	}
	
	public static int getNumberOfDimensions(Class<?> type) {
		if (type.getComponentType() == null) {
			return 0;
		} else {
			return getNumberOfDimensions(type.getComponentType()) + 1;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String deepToString(Object tab) {
		if (tab == null) {
			return "null";
		} else {
			int arg0 = 20 * Array.getLength(tab);
			if (Array.getLength(tab) != 0 && arg0 <= 0) {
				arg0 = Integer.MAX_VALUE;
			}

			StringBuilder builder = new StringBuilder(arg0);
			deepToString(tab, builder, new HashSet());
			return builder.toString();
		}
	}

	// <tab:>
	private static void deepToString(Object tab, StringBuilder builder, Set<Object> hashSet) {
		if (tab == null) {
			builder.append("null");
		} else {
			int length = getLength(tab) - 1;
			if (length == -1) {
				builder.append("[]");
			} else {
				hashSet.add(tab);
				builder.append("[");
				int index = 0;

				while (true) {
					Object obj = get(tab, index);
					if (obj == null) {
						builder.append("null");
					} else {
						Class<?> ownClass = obj.getClass();
						if (ownClass.isArray()) {
							if (ownClass == byte[].class) {
								builder.append(Arrays.toString((byte[]) ((byte[]) obj)));
							} else if (ownClass == short[].class) {
								builder.append(Arrays.toString((short[]) ((short[]) obj)));
							} else if (ownClass == int[].class) {
								builder.append(Arrays.toString((int[]) ((int[]) obj)));
							} else if (ownClass == long[].class) {
								builder.append(Arrays.toString((long[]) ((long[]) obj)));
							} else if (ownClass == char[].class) {
								builder.append(Arrays.toString((char[]) ((char[]) obj)));
							} else if (ownClass == float[].class) {
								builder.append(Arrays.toString((float[]) ((float[]) obj)));
							} else if (ownClass == double[].class) {
								builder.append(Arrays.toString((double[]) ((double[]) obj)));
							} else if (ownClass == boolean[].class) {
								builder.append(Arrays.toString((boolean[]) ((boolean[]) obj)));
							} else if (hashSet.contains(obj)) {
								builder.append("[...]");
							} else {
								deepToString((Object[]) ((Object[]) obj), builder, hashSet);
							}
						} else {
							
							 builder.append(obj.toString());
						}
					}

					if (index == length) {
						builder.append("]");
						hashSet.remove(tab);
						return;
					}

					builder.append(", ");
					index++;
				}
			}
		}
	}
	
}
