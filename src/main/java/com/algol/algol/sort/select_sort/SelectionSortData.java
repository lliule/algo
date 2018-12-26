package com.algol.algol.sort.select_sort;

public class SelectionSortData {

    private int[] numbers;
    public int orderedIndex = -1;
    // 当前正在比较的元素的索引
    public int currentCampareIndex = -1;
    // 当前最小值的索引
    public int currentMinIndex = -1;

    /**
     * 创建排序的数组
     * @param N 数组的个数
     * @param randomBound 数组的最大范围
     */
    public SelectionSortData(int N, int randomBound){

        numbers = new int[N];

        for( int i = 0 ; i < N ; i ++)
            numbers[i] = (int)(Math.random()*randomBound) + 1;
    }

    public int N(){
        return numbers.length;
    }

    public int get(int index){
        if( index < 0 || index >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        return numbers[index];
    }

    public void swap(int i, int j) {

        if( i < 0 || i >= numbers.length || j < 0 || j >= numbers.length)
            throw new IllegalArgumentException("Invalid index to access Sort Data.");

        int t = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = t;
    }
}
