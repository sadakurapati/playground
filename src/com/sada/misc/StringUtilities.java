package com.sada.misc;

import java.util.HashSet;

/**
 * Created by Sada on 2/22/14.
 */
public class StringUtilities {

    public static void main(String[] args) {

        String input = "Hello";
        //System.out.println(distinctChars(input));
        System.out.println(reverse(input));

    }

    public static String reverse(String input) {
        if (null == input || input.length() <= 1) return input;
        char[] inputCharArray = input.toCharArray();
        int left = 0, right = inputCharArray.length - 1;
        while (left < right) {
            //swap
            Character temp = inputCharArray[left];
            inputCharArray[left] = inputCharArray[right];
            inputCharArray[right] = temp;
            left++;
            right--;
        }
        return new String(inputCharArray);
    }

    public static boolean distinctChars(String input) {

        if (null == input || input.length() <= 1) return true;
        HashSet<Character> charSet = new HashSet<Character>();
        char[] charArray = input.toCharArray();
        for (Character c : charArray) {
            if (charSet.contains(c)) return false;
            charSet.add(c);
        }

        return true;
    }

}
