package com.wind.comm.util;

public class ShellSort extends Constant {

    public static void main(String[] args) throws Exception {
        Constant.printResult(new ShellSort().sort(Constant.array, Constant.len));
    }

    @Override
    public Object[] sort(Object[] array, int len) {
        int i, j, increment;
        int temp;
        for (increment = len / 2; increment > 0; increment /= 2) {
            for (i = increment; i < len; i++) {
                temp = (int) array[i];
                for (j = i; j >= increment; j -= increment) {
                    if (temp < (int) array[j - increment]) {
                        array[j] = array[j - increment];
                    } else {
                        break;
                    }
                }
                array[j] = temp;
            }
        }
        return array;
    }

}
