package com.songmiao.learningcode.algorithm.notes;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{6,5,4,3,2,1})));
    }
    public static int[] insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int j =i-1;
            int t = array[i];
            for(;j>=0;j--){
                if(t<array[j]){
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1] = t;
        }
        return array;
    }
}
