package com.myskdias.askia.utils;

public class E<K,V> {

	private K k;
	private V v;
	
	public E(K k, V v) {
		this.k = k;
		this.v = v;
	}
	
	public E(K k) {
		this.k = k;
	}
	
	public E() {
	}
	
	public K getK() {
		return k;
	}
	
	public V getV() {
		return v;
	}
	
	public void setK(K k) {
		this.k = k;
	}
	
	public void setV(V v) {
		this.v = v;
	}
	
}
