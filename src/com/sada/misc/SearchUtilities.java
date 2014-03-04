/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 Sada Kurapati <sadakurapati@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.sada.misc;

public class SearchUtilities {


    public static void main(String[] args) {
        int[] input = {10, 12};
        System.out.println(binarySearch(input, 3));
        printUnSortedArray(input);
    }

    public static void printUnSortedArray(int[] inputArray) {

        //move left to right till we break sorted order
        int left = 0;
        int length = inputArray.length;
        while (left + 1 < length && inputArray[left] < inputArray[left + 1]) {
            left++;
        }
        left++;
        if (left == length) {
            System.out.println("Array is fully sorted");
            //return;
        }
        //move right to left till order is broken
        int right = length - 1;
        while (right > 0 && inputArray[right] > inputArray[right - 1]) {
            right--;
        }
        right--;
        System.out.printf("Start: %d", left);
        System.out.printf("End: %d", right);
    }

    public static int binarySearch(int[] inputArray, int key) {
        int low = 0, high = inputArray.length;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (inputArray[mid] == key) return mid;
            if (inputArray[mid] > key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
