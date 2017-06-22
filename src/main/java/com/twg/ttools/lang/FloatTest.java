package com.twg.ttools.lang;

/**
 * Created by twg on 2017/4/26.
 */
public class FloatTest {
    public static void main(String[] args) {
        float f = 20014999;
        double d = f;
        double d2 = 20014999;
        System.out.println("f=" + f);
        System.out.println("d=" + d);
        System.out.println("d2=" + d2);

        float f1 = 8;
        int i = Float.floatToIntBits(f1);
        System.out.println(Integer.toBinaryString(i));


    }
}
