package com.wind.comm.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    /**
     * 拆分list
     * 
     * @param targe
     *            需要拆分的list
     * @param size
     *            每次拆分大小
     * @return T
     */
    public static <T> List<List<T>> createList(List<T> targe, int size) {
        List<List<T>> listArr = new ArrayList<>();
        // 获取被拆分的数组个数
        int arrSize = targe.size() % size == 0 ? targe.size() / size : targe.size() / size + 1;
        for (int i = 0; i < arrSize; i++) {
            List<T> sub = new ArrayList<>();
            // 把指定索引数据放入到list中
            for (int j = i * size; j <= size * (i + 1) - 1; j++) {
                if (j <= targe.size() - 1) {
                    sub.add(targe.get(j));
                }
            }
            listArr.add(sub);
        }
        return listArr;
    }

}
