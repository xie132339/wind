package com.wind.comm.util;

import java.util.HashMap;
import java.util.Map;

public class Demo {

    public final static int OUTOFMEMORY = 200000000;
    private String oom;
    private int length;
    StringBuffer tempOOM = new StringBuffer();

    static class OOMObject {

    }

    public Demo(int length) {
        this.length = length;
        int i = 0;
        while (i < length) {
            i++;
            try {
                tempOOM.append("a");
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        this.oom = tempOOM.toString();
    }

    public static void main(String[] args) {
        Demo demo = new Demo(Demo.OUTOFMEMORY);
        System.out.println(demo.getOom().length());
    }

    public String getOom() {
        return oom;
    }

    public void setOom(String oom) {
        this.oom = oom;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
