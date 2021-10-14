package com.songmiao.learningcode.algorithm.notes;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{4,5,6,3,2,1})));
    }

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j=i+1;
            int min = i;
            for(;j<array.length;j++){
                if(array[j]<array[min]){
                    min = j;
                }
            }
            int t = array[i];
            array[i] = array[min];
            array[min] = t;
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
