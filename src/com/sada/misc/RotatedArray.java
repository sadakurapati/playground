package com.sada.misc;

/**
 * Created by Sada on 2/17/14.
 */
public class RotatedArray {

    public static void main(String[] args){
        int[] array = {5,8,12,1,2,4};
        System.out.println(findStartingPoint(array));

    }

    public static int findStartingPoint(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        while (arr[low] > arr[high]) {
            int mid = (low + high) >>> 1;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
