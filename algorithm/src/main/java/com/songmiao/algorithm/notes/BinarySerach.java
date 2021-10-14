package com.songmiao.algorithm.notes;

/**
 * 二分查找
 */
public class BinarySerach {
    public static void main(String[] args) {
        System.out.println(findFirstltByBinarySerach(new int[]{1,2,3,3,3,6,7,8,9},3,0,8));
//        System.out.println(1+((1+9)>>1));
    }

    /**
     * 非递归方法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySerach(int[] a,int n,int value){
        int low = 0;
        int high = n-1;
        while (low<=high){
            int mid = (low+high)/2;
            if(a[mid]==value){
                return mid;
            }else if(a[mid]>value){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 递归方法
     * @param a
     * @param n
     * @param value
     * @return
     */
    public static int binarySerachRecursive(int[] a,int n,int value){
        return binarySerachInternally(a,0,n-1,value);
    }
    public static int binarySerachInternally(int[] a,int low,int high,int value){
        if(low>high){
            return -1;
        }
        int mid = (low+high)/2;
        if(a[mid]==value){
            return mid;
        }else if(a[mid]>value){
            return binarySerachInternally(a,low,mid-1,value);
        }else{
            return binarySerachInternally(a,mid+1,high,value);
        }
    }

    /**
     * 查找第一个值等于给定值的元素
     * @return
     */
    public static int findFirstByBinarySerach(int[] a ,int n,int value,int low,int high){
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid]>value){
                high = mid-1;
            }else if(a[mid]<value){
                low = mid+1;
            }else{
                //相等的情况下,mid为0就代表已经是第一个数，a[mid-1]不是value就代表肯定是第一个
                if(mid==0 || a[mid-1]!=value){
                    return mid;
                }
                high = mid-1;
            }
        }
        return -1;
    }
    /**
     * 查找最后一个值等于给定值的元素
     * @return
     */
    public static int findEndByBinarySerach(int[] a,int value,int low,int high){
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid]>value){
                high = mid-1;
            }else if(a[mid]<value){
                low = mid+1;
            }else{
                //相等的情况下,mid为0就代表已经是第一个数，a[mid-1]不是value就代表肯定是第一个
                if(mid==0 || a[mid+1]!=value){
                    return mid;
                }
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @return
     */
    public static int findFirstgtByBinarySerach(int[] a ,int value,int low,int high){
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid]>=value){
                if(mid==0||a[mid-1]<value){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @return
     */
    public static int findFirstltByBinarySerach(int[] a ,int value,int low,int high){
        while(low<=high){
            int mid = low+((high-low)>>1);
            if(a[mid]<=value){
                if(mid==0||a[mid+1]>value){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
}
