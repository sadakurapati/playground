package com.sada.misc;

/**
 * Created by Sada on 2/23/14.
 */
public class SearchUtilities {


    public static void main(String[] args){
        int[] input = {10,12};
        //System.out.println(binarySearch(input, 3));
       printUnSortedArray(input);
    }

    public static void printUnSortedArray(int[] inputArray){

        //move left to right till we break sorted order
        int left = 0;
        int length = inputArray.length;
        while(left +1 < length && inputArray[left] < inputArray[left +1]){
            left++;
        }
        left++;
        if(left == length){
            System.out.println("Array is fully sorted");
            //return;
        }
        //move right to left till order is broken
        int right  = length -1;
        while(right >0 && inputArray[right] > inputArray[right-1]){
            right--;
        }
        right--;
        System.out.printf("Start: %d", left);
        System.out.printf("End: %d", right);
    }

    public static int binarySearch(int[] inputArray, int key){
        int low =0, high = inputArray.length;
        while(low <= high){
           int mid = (low + high) >>> 1;
           if(inputArray[mid] == key) return mid;
           if(inputArray[mid] > key){
               high = mid -1;
           }else{
               low = mid + 1;
           }
        }
        return -1;
    }
}
