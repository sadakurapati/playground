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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericValidator {

    public static void main(String[] args) {
        String input = "233235.5";
        System.out.println(isNumber1(input));
        System.out.println(isNumber2(input));
        System.out.println(isNumber3(input));
    }

    public static boolean isNumber1(String input) {
        if (null == input || input.trim().length() == 0) return false;

        try {
            Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //does not handle negative and real numbers. TODO - add those specific conditions.
    public static boolean isNumber2(String input) {
        if (null == input || input.trim().length() == 0) return false;

        for (char c : input.toCharArray()) {
            if (c < '0' || c > '9') return false;
        }
        return true;
    }

    public static boolean isNumber3(String input) {
        Pattern numberPattern = Pattern.compile("-?\\d+.\\d+");
        Matcher matcher = numberPattern.matcher(input);
        return matcher.matches();
    }
}
