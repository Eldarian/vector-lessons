package com.solvd.vector;

/**
 * @author asemenkov
 * @since Jun 29, 2021
 */
public class TriCoordVector extends Vector implements VectorMultipliable<TriCoordVector> {

    private final double x;
    private final double y;
    private final double z;

    public TriCoordVector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public double getScalarProduct(Vector vector) {
        TriCoordVector that = castToTriCoordVector(vector);
        return this.x * that.x + this.y * that.y + this.z * that.z;
    }

    @Override
    public double getCosAngle(Vector vector) {
        return getScalarProduct(vector) / (this.getLength() * vector.getLength());
    }

    public TriCoordVector castToTriCoordVector(Vector that) {
        if (that instanceof TriCoordVector) return (TriCoordVector) that;
        else throw new IllegalArgumentException("Not a TriCoordVector");
    }

    @Override
    public TriCoordVector multiply(TriCoordVector that) {
        return new TriCoordVector( //
                this.y * that.z - this.z * that.y, //
                this.z * that.x - this.x * that.z, //
                this.x * that.y - this.y * that.x);
    }

    @Override
    public String toString() {
        return "TriCoordVector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", length = " + getLength() +
                '}';
    }
}
