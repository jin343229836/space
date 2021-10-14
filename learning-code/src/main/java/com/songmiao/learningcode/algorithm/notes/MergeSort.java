package com.songmiao.learningcode.algorithm.notes;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{11,8,3,9,7,1,2,5};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void mergeSort(int[] array){
        merge_sort_c(array,0,array.length-1);
    }

    private static void merge_sort_c(int[] array, int p, int r) {
        //终止条件
        if(p>=r){
            return;
        }
        //取中间位置
        int q = (p+r)/2;
        merge_sort_c(array,p,q);
        merge_sort_c(array,q+1,r);
        //合并
        merge(p,q,r,array);
    }

    /**
     * 合并
     * @param p 起始位置
     * @param q 中间位置
     * @param r 末尾位置
     * @param array
     */
    private static void merge(int p, int q, int r, int[] array) {
        int i = p;
        int j = q+1;
        int k = 0;
        int[] temp = new int[array.length];
        //比较大小
        while(i<=q&&j<=r){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }
        //判读哪个有剩余数据，放到temp中
        while(i<=q){
            temp[k++] = array[i];
            i++;
        }
        while(j<=r){
            temp[k++] = array[j];
            j++;
        }
        //copy数据到array
        for(int m=0;m<=r-p;m++){
            array[p+m] = temp[m];
        }
    }
}
