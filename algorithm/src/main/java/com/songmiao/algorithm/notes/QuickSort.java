package com.songmiao.algorithm.notes;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,9,2,3,6,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void quickSort(int[] array){
        quick_sort_c(array,0,array.length-1);
    }

    private static void quick_sort_c(int[] array, int p, int r) {
        if(p>=r){
            return;
        }
        int q = partition(array,p,r);
        quick_sort_c(array,p,q-1);
        quick_sort_c(array,q+1,r);
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for(int j=p;j<r;j++){
            if(array[j]<pivot){
                int t = array[j];
                array[j] = array[i];
                array[i] = t;
                i = i+1;
            }
        }
        int t = array[i];
        array[i] = array[r];
        array[r] = t;
        return i;
    }

}
