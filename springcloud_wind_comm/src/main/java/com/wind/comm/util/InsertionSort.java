package com.wind.comm.util;

/**
 * 
 * 插入排序
 * 
 */
public class InsertionSort extends Constant {
    public static void main(String[] args) throws Exception {
        Constant.printResult(new InsertionSort().sort(Constant.array, Constant.len));
    }

    /**
     * 插入排序算法步骤 
     * 将第一个待排序的元素看作一个有序序列，把第二个元素到最后的元素当成未排序序列
     * 从头至尾扫描未排序序列，将扫描到的每个满足条件的元素插入有序的适合位置，如果碰到相同的元素则插入到相同元素的后面
     */
    @Override
    public Object[] sort(Object[] array, int len) {
        int i, j, temp;
        for (i = 1; i < len; i++) {
            temp = (int) array[i];
            for (j = i; j > 0 && temp < (int) array[j - 1]; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
        return array;
    }
}
