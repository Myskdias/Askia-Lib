package com.myskdias.askia.math;

import java.io.Serializable;

public class Vector2i implements Serializable, Cloneable {

	private static final long serialVersionUID = 5480484392740737396L;
	protected int x, z;

	/**
	 * 
	 * @param x
	 * @param z
	 */
	public Vector2i(int x, int z) {
		this.x = x;
		this.z = z;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public Vector2i mul(int x, int z) {
		this.x *= x;
		this.z *= z;
		return this;
	}
	
	public Vector2i div(int x, int z) {
		this.x /= x;
		this.z /= z;
		return this;
	}
	
	public Vector2i add(int x, int z) {
		this.x += x;
		this.z += z;
		return this;
	}
	
	public Vector2i remove(int x, int z) {
		this.x -= x;
		this.z -= z;
		return this;
	}
	
	public Vector2i mul_(int x, int z) {
		return copy().mul(x, z);
	}
	
	public Vector2i div_(int x, int z) {
		return copy().div(x, z);
	}
	
	public Vector2i add_(int x, int z) {
		return copy().add(x, z);
	}
	
	public Vector2i remove_(int x, int z) {
		return copy().remove(x, z);
	}
	
	public Vector2i mul(int k) {
		return mul(k,k);
	}
	
	public Vector2i div(int k) {
		return div(k,k);
	}
	
	public Vector2i add(int k) {
		return add(k,k);
	}
	
	public Vector2i remove(int k) {
		return remove(k,k);
	}
	
	
	public Vector2i mul_(int k) {
		return mul_(k,k);
	}
	
	public Vector2i div_(int k) {
		return div_(k,k);
	}
	
	public Vector2i add_(int k) {
		return add_(k,k);
	}
	
	public Vector2i remove_(int k) {
		return remove_(k,k);
	}
	
	public Vector2i copy() {
		return new Vector2i(x, z);
	}

	public Vector3d toVector3d() {
		return new Vector3d(x, 0, z);
	}
	
	public Vector3i toVector3i() {
		return new Vector3i(x, 0, z);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector2i other = (Vector2i) obj;
		if (x != other.x)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
}

