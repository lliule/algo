package com.algol.algol.sort.insert_sort;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dana on 2018/12/30.
 *
 * @author dana
 */
public class InsertSortData {

    private int[] numbers;
    // 从 [0,ordererIndex）区间是有序的
    @Getter
    @Setter
    private int orderedIndex;
    // 当前处理的数据的位置
    @Getter
    @Setter
    private int currentIndex;

    public InsertSortData(int n,int max) {
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = (int)(Math.random() * max + 1  );
        }
    }

    public int get(int index){
        return numbers[index];
    }

    public int size(){
        return numbers.length;
    }

    public void swap(int j, int i) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
