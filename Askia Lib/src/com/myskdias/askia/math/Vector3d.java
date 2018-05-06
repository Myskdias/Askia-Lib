package com.myskdias.askia.math;

import java.io.Serializable;

public class Vector3d implements Serializable, Cloneable
{
    private static final long serialVersionUID = 5480484393740737396L;
    protected double x;
    protected double y;
    protected double z;
    
    public Vector3d(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public double getX() {
        return this.x;
    }
    
    public void setX(final double x) {
        this.x = x;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setY(final double y) {
        this.y = y;
    }
    
    public double getZ() {
        return this.z;
    }
    
    public void setZ(final double z) {
        this.z = z;
    }
    
    public Vector3d mul(final double x, final double y, final double z) {
        this.x *= x;
        this.y *= y;
        this.z *= z;
        return this;
    }
    
    public Vector3d div(final double x, final double y, final double z) {
        this.x /= x;
        this.y /= y;
        this.z /= z;
        return this;
    }
    
    public Vector3d add(final double x, final double y, final double z) {
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }
    
    public Vector3d remove(final double x, final double y, final double z) {
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }
    
    public Vector3d mul_(final double x, final double y, final double z) {
        return this.copy().mul(x, y, z);
    }
    
    public Vector3d div_(final double x, final double y, final double z) {
        return this.copy().div(x, y, z);
    }
    
    public Vector3d add_(final double x, final double y, final double z) {
        return this.copy().add(x, y, z);
    }
    
    public Vector3d remove_(final double x, final double y, final double z) {
        return this.copy().remove(x, y, z);
    }
    
    public Vector3d mul(final double k) {
        return this.mul(k, k, k);
    }
    
    public Vector3d div(final double k) {
        return this.div(k, k, k);
    }
    
    public Vector3d add(final double k) {
        return this.add(k, k, k);
    }
    
    public Vector3d add(final Vector3f vec) {
        return this.add(vec.getX(), vec.getY(), vec.getZ());
    }
    
    public Vector3d remove(final double k) {
        return this.remove(k, k, k);
    }
    
    public Vector3d mul_(final double k) {
        return this.mul_(k, k, k);
    }
    
    public Vector3d div_(final double k) {
        return this.div_(k, k, k);
    }
    
    public Vector3d add_(final double k) {
        return this.add_(k, k, k);
    }
    
    public Vector3d remove_(final double k) {
        return this.remove_(k, k, k);
    }
    
    public Vector3d copy() {
        return new Vector3d(this.x, this.y, this.z);
    }
    
    public Vector3i toVector3i() {
        return new Vector3i((int)this.x, (int)this.y, (int)this.z);
    }
    
    public Vector2i toVector2i() {
        return new Vector2i((int)this.x, (int)this.z);
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        long temp = Double.doubleToLongBits(this.x);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        temp = Double.doubleToLongBits(this.z);
        result = 31 * result + (int)(temp ^ temp >>> 32);
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
        final Vector3d other = (Vector3d)obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(other.x) && Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y) && Double.doubleToLongBits(this.z) == Double.doubleToLongBits(other.z);
    }
}
