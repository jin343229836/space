package com.songmiao.algorithm.notes;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{6,5,4,3,2,1})));
    }
    public static int[] bubbleSort(int[] array){
        boolean flag = false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int t = array[j];
                    array[j] = array[j+1];
                    array[j+1] = t;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
        return array;
    }
}
