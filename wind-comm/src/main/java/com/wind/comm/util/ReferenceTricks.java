package com.wind.comm.util;

public class ReferenceTricks {
    public static void main(String[] args) {
        ReferenceTricks r = new ReferenceTricks();
        // reset integer
        r.i = 0;
        System.out.println("Before changeInteger:" + r.i);
        changeReference(r);
        System.out.println("=="+r.i);
    }

    private static void changeReference(ReferenceTricks r) {
        r = new ReferenceTricks();
        r.i = 5;
        System.out.println("In changeReference: " + r.i);
    }

    private static void changeInteger(ReferenceTricks r) {
        r.i = 5;
        System.out.println("In changeInteger:" + r.i);
    }

    public int i;

}
