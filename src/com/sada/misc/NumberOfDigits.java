package com.sada.misc;

import java.util.Arrays;

/**
 * Created by Sada on 2/14/14.
 */
public class NumberOfDigits {

    public static void main(String[] args){
        int[] range = {9,99,999,9999,99999,999999,9999999,99999999,999999999};
        int key = 100;
        int index = Arrays.binarySearch(range, key);
        index = (index >= 0)? index +1: - index;
        System.out.println(index);
    }
}
