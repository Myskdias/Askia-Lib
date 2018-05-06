package com.myskdias.askia.math;

import java.io.Serializable;

public class Vector3f implements Serializable
{
    private static final long serialVersionUID = -2929485503999222694L;
    private float x;
    private float y;
    private float z;
    
    public Vector3f() {
        this(0.0f, 0.0f, 0.0f);
    }
    
    public Vector3f(final Vector3f v) {
        this(v.x, v.y, v.z);
    }
    
    public Vector3f(final float x, final float y, final float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public float length() {
        return (float)Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
    }
    
    public Vector3f normalize() {
        this.x /= this.length();
        this.y /= this.length();
        this.z /= this.length();
        return this;
    }
    
    public Vector3f add(final Vector3f vec) {
        this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
        return this;
    }
    
    public Vector3f sub(final Vector3f vec) {
        this.x -= vec.getX();
        this.y -= vec.getY();
        this.z -= vec.getZ();
        return this;
    }
    
    public Vector3f mul(final Vector3f vec) {
        this.x *= vec.getX();
        this.y *= vec.getY();
        this.z *= vec.getZ();
        return this;
    }
    
    public Vector3f div(final Vector3f vec) {
        this.x /= vec.getX();
        this.y /= vec.getY();
        this.z /= vec.getZ();
        return this;
    }
    
    public Vector3f add(final float v) {
        this.x += v;
        this.y += v;
        this.z += v;
        return this;
    }
    
    public Vector3f sub(final float v) {
        this.x -= v;
        this.y -= v;
        this.z -= v;
        return this;
    }
    
    public Vector3f mul(final float v) {
        this.x *= v;
        this.y *= v;
        this.z *= v;
        return this;
    }
    
    public Vector3f div(final float v) {
        this.x /= v;
        this.y /= v;
        this.z /= v;
        return this;
    }
    
    public float getX() {
        return this.x;
    }
    
    public void setX(final float x) {
        this.x = x;
    }
    
    public Vector3f addX(final float v) {
        this.x += v;
        return this;
    }
    
    public Vector3f subX(final float v) {
        this.x -= v;
        return this;
    }
    
    public float getY() {
        return this.y;
    }
    
    public void setY(final float y) {
        this.y = y;
    }
    
    public Vector3f addY(final float v) {
        this.y += v;
        return this;
    }
    
    public Vector3f subY(final float v) {
        this.y -= v;
        return this;
    }
    
    public float getZ() {
        return this.z;
    }
    
    public void setZ(final float z) {
        this.z = z;
    }
    
    public Vector3f addZ(final float v) {
        this.z += v;
        return this;
    }
    
    public Vector3f subZ(final float v) {
        this.z -= v;
        return this;
    }
    
    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Float.floatToIntBits(this.x);
        result = 31 * result + Float.floatToIntBits(this.y);
        result = 31 * result + Float.floatToIntBits(this.z);
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
        final Vector3f other = (Vector3f)obj;
        return Float.floatToIntBits(this.x) == Float.floatToIntBits(other.x) && Float.floatToIntBits(this.y) == Float.floatToIntBits(other.y) && Float.floatToIntBits(this.z) == Float.floatToIntBits(other.z);
    }
}
