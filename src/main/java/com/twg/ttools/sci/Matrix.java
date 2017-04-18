package com.twg.ttools.sci;

import java.math.BigInteger;

/**
 * Created by twg on 2017/4/10.
 */
public class Matrix {
    // a b
    // c d
    /**
     * 左上角的值
     */
    public final BigInteger a;
    /**
     * 右上角的值
     */
    public final BigInteger b;
    /**
     * 左下角的值
     */
    public final BigInteger c;
    /**
     * 右下角的值
     */
    public final BigInteger d;

    public Matrix(int a, int b, int c, int d) {
        this(BigInteger.valueOf(a), BigInteger.valueOf(b),
                BigInteger.valueOf(c), BigInteger.valueOf(d));
    }

    public Matrix(BigInteger a, BigInteger b, BigInteger c, BigInteger d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * multiply
     *
     * @param m multiplier
     * @return
     */
    public Matrix mul(Matrix m) {
        return new Matrix(
                a.multiply(m.a).add(b.multiply(m.c)), // a*a + b*c
                a.multiply(m.b).add(b.multiply(m.d)), // a*b + b*d
                c.multiply(m.a).add(d.multiply(m.c)), // c*a + d*c
                c.multiply(m.b).add(d.multiply(m.d)));// c*b + d*d
    }

    /**
     * power of exponent
     *
     * @param exponent
     * @return
     */
    public Matrix pow(int exponent) {
        Matrix matrix = this.copy();

        for (int i = 1; i < exponent; i++) {
            matrix = matrix.mul(this);
        }

        return matrix;
    }

    public Matrix copy() {
        return new Matrix(a, b, c, d);
    }

}
