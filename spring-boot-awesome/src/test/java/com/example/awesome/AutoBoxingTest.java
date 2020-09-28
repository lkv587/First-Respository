package com.example.awesome;

public class AutoBoxingTest {
    public static void main(String[] args) {
        System.out.println("===================例1=======================");
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        /**
         * 1.Integer.valueOf(n);
         * 2. if (i >= IntegerCache.low && i <= IntegerCache.high)
         *         return IntegerCache.cache[i + (-IntegerCache.low)];
         *    else   return new Integer(i);
         *    IntegerCache.low = -128;
         *    IntegerCache.high = 127 或 JVM配置：java.lang.Integer.IntegerCache.high
         *    Integer、Short、Byte、Character、Long类似
         */
        System.out.println(i1 == i2);//true
        System.out.println(i3 == i4);//false
        System.out.println("===================例2=======================");

        Double d1 = 100.0;
        Double d2 = 100.0;
        Double d3 = 200.0;
        Double d4 = 200.0;
        /**
         * Double.valueOf()
         * return new Double()
         * Double,Float类似
         */
        System.out.println(d1 == d2);//false
        System.out.println(d3 == d4);//false

        System.out.println("===================例3=======================");
        Boolean b1 = true;
        Boolean b2 = true;
        Boolean b3 = false;
        Boolean b4 = false;
        /** Boolean.valueOf(s);
            return (b ? TRUE : FALSE);
            public static final Boolean TRUE = new Boolean(true);
            public static final Boolean FALSE = new Boolean(false);
         */
        System.out.println(b1 == b2);//true
        System.out.println(b3 == b4);//true

        System.out.println("===================例4=======================");
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;
        System.out.println(c == d);//true
        System.out.println(e == f);//false
        System.out.println(c == (a+b));//true
        System.out.println(c.equals(a+b));//true
        System.out.println(g == (a+b));//true ?
        System.out.println(g.equals(a+b));//false ?
        System.out.println(g.equals(a+h));//true
    }
}
