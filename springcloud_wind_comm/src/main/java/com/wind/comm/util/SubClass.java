package com.wind.comm.util;

public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
        value = 1;
    }
    public static int value = 123;
}
