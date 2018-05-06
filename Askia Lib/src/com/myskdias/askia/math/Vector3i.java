package com.myskdias.askia.math;

import java.io.Serializable;

public class Vector3i implements Serializable, Cloneable
{
    private static final long serialVersionUID = 5480484393740737396L;
    protected int x;
    protected int y;
    protected int z;
    
    public Vector3i(final int x, final int y, final int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public int getX() {
        return this.x;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public int getZ() {
        return this.z;
    }
    
    public void setZ(final int z) {
        this.z = z;
    }
    
    public Vector3i mul(final int x, final int y, final int z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }
    
    public Vector3i div(final int x, final int y, final int z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }
    
    public Vector3i add(final int x, final int y, final int z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    
    public Vector3i remove(final int x, final int y, final int z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }
    
    public Vector3i mul_(final int x, final int y, final int z) {
        return this.copy().mul(x, y, z);
    }
    
    public Vector3i div_(final int x, final int y, final int z) {
        return this.copy().div(x, y, z);
    }
    
    public Vector3i add_(final int x, final int y, final int z) {
        return this.copy().add(x, y, z);
    }
    
    public Vector3i remove_(final int x, final int y, final int z) {
        return this.copy().remove(x, y, z);
    }
    
    public Vector3i mul(final int k) {
        return this.mul(k, k, k);
    }
    
    public Vector3i div(final int k) {
        return this.div(k, k, k);
    }
    
    public Vector3i add(final int k) {
        return this.add(k, k, k);
    }
    
    public Vector3i remove(final int k) {
        return this.remove(k, k, k);
    }
    
    public Vector3i mul_(final int k) {
        return this.mul_(k, k, k);
    }
    
    public Vector3i div_(final int k) {
        return this.div_(k, k, k);
    }
    
    public Vector3i add_(final int k) {
        return this.add_(k, k, k);
    }
    
    public Vector3i remove_(final int k) {
        return this.remove_(k, k, k);
    }
    
    public Vector3i copy() {
        return new Vector3i(this.x, this.y, this.z);
    }
    
    public Vector3d toVector3d() {
        return new Vector3d(this.x, this.y, this.z);
    }
    
    public Vector2i toVector2i() {
        return new Vector2i(this.x, this.z);
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + this.x;
        result = 31 * result + this.y;
        result = 31 * result + this.z;
        return result;
    }
    
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Vector3i other = (Vector3i)obj;
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }
}
