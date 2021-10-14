package com.songmiao.algorithm.notes;

import java.util.Arrays;

public class CountionSort {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,2,1,4,5,6,5,0};
        countionSor(array,9);
        System.out.println(Arrays.toString(array));
    }
    public static void countionSor(int[] array,int n){
        //查找最大值,看需要建立多长的数组
        int max = array[0];
        for(int i=1;i<array.length;i++){
            if(max<array[i]){
                max = array[i];
            }
        }
        //建立数组c，计算array中出现每个值的次数，并放到该值对应的c数组下标中
        int[] c = new int[max+1];
        for(int i=0;i<n;i++){
            c[array[i]]++;
        }
        //计算后面一个值=当前值+前面那个值
        for(int i=1;i<c.length;i++){
            c[i] = c[i]+c[i-1];
        }
        //存储排序后的数组
        int[] r = new int[n];
        for(int i=n-1;i>=0;--i){
            int index = c[array[i]]-1;//计算array[i]应该存储在r哪个位置，c中记录了当前这个数据前面有多少数据（这个是包含本身的）所以需要减一
            r[index] = array[i];
            c[array[i]]--;
        }
        for(int i=0;i<n;i++){
            array[i] = r[i];
        }
    }
}
