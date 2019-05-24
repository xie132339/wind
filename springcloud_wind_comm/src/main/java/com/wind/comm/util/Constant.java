package com.wind.comm.util;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 排序算法
 *
 */
public abstract class Constant {
    public static final Object[] array = { 8, 34, 64, 51, 33, 22, 44, 55, 88, 1, 0, 2, 2 };
    // 有序数组
    public static final Object[] array2 = { 0, 1, 2, 2, 8, 22, 33, 34, 44, 51, 55, 64, 88 };

    public static final int len = array.length;

    public abstract Object[] sort(Object[] array, int len);

    /**
     * 优化版
     * 
     * @param array
     * @param len
     * @return
     */
    public Object[] sort2(Object[] array, int len) {
        return new Object[0];
    }

    public static void printResult(Object[] array) throws Exception {
        if (array == null || array.length == 0) {
            throw new Exception("no element or invalid element in array");
        }
        System.out.println(Arrays.stream(array).map(x -> x.toString()).collect(Collectors.joining(",", "[", "]")));
    }
}
