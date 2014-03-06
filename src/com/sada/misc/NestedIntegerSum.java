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

import java.util.ArrayList;
import java.util.List;

public class NestedIntegerSum {

    public static void main(String[] args) {
        //Example 1: {{1,{3},1},2,{1,1}} returns 19
        List<NestedInteger> example1 = getExampleOne();
        System.out.printf("The final sum of %s is %d \n", "{{1,{3},1},2,{1,1}}", depthSum(example1));

        List<NestedInteger> example2 = getExampleTwo();
        System.out.printf("The final sum of %s is %d \n", "{1,{4,{6}}}", depthSum(example2));

    }


    /**
     * Given a nested list of integers, returns the sum of all integers in the list weighted by their depth * For example, given the list {{1,{3},1},2,{1,1}} the function should return 10 (four 1's at depth 2, one 2 at depth 1) * Given the list {1,{4,{6}}} the function should return 27 (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3)
     */
    public static int depthSum(List<NestedInteger> input) {
        int sum = 0;
        // loop through the input list and pass each com.sada.linkedin.NestedInteger element to the
        //1.1 i id not declared (int is not added),
        //1.2 wrote i.input.length() instead of i < input.size()
        // 1.3 wrote =++ rather than i++
        for (int i = 0; i < input.size(); i++) {
            sum += sumOfEachListElement(input.get(i), 1);
        }
        return sum;
        //Implementation here
    }

    public static int sumOfEachListElement(NestedInteger n, int subLevel) {
        int sumList = 0;
        if (n.isInteger()) //2. used direct method which should have called on n
            return n.getInteger() * subLevel;
        else {
            List<NestedInteger> list = n.getList(); //3. Used generic list without generics with com.sada.linkedin.NestedInteger object
            for (NestedInteger listElement : list) {
                sumList += sumOfEachListElement(listElement, subLevel + 1); //4. Method name was wrong.
            }
        }
        return sumList;
    }

    public static List<NestedInteger> getExampleOne() {
        NestedInteger three = new NestedInteger();
        three.self = "3";
        List<NestedInteger> threeList = new ArrayList<NestedInteger>();
        threeList.add(three);

        NestedInteger threeElement = new NestedInteger();
        threeElement.self = threeList;

        NestedInteger one_1 = new NestedInteger();
        one_1.self = "1";

        NestedInteger one_2 = new NestedInteger();
        one_2.self = "1";

        List<NestedInteger> firstElement = new ArrayList<NestedInteger>();
        firstElement.add(one_1);
        firstElement.add(threeElement);
        firstElement.add(one_2);


        NestedInteger two = new NestedInteger();
        two.self = "2";

        NestedInteger one_3 = new NestedInteger();
        one_3.self = "1";

        NestedInteger one_4 = new NestedInteger();
        one_4.self = "1";

        List<NestedInteger> thirdElement = new ArrayList<NestedInteger>();
        thirdElement.add(one_3);
        thirdElement.add(one_4);


        NestedInteger firstElementObject = new NestedInteger();
        firstElementObject.self = firstElement;

        NestedInteger thirdElementObject = new NestedInteger();
        thirdElementObject.self = thirdElement;


        List<NestedInteger> input = new ArrayList<NestedInteger>();
        input.add(firstElementObject);
        input.add(two);
        input.add(thirdElementObject);

        return input;
    }

    public static List<NestedInteger> getExampleTwo() {
        NestedInteger six = new NestedInteger();
        six.self = "6";
        List<NestedInteger> sixList = new ArrayList<NestedInteger>();
        sixList.add(six);
        NestedInteger sixElementObject = new NestedInteger();
        sixElementObject.self = sixList;

        NestedInteger four = new NestedInteger();
        four.self = "4";

        List<NestedInteger> secondElementList = new ArrayList<NestedInteger>();
        secondElementList.add(four);
        secondElementList.add(sixElementObject);

        NestedInteger secondElementObject = new NestedInteger();
        secondElementObject.self = secondElementList;


        NestedInteger one_1 = new NestedInteger();
        one_1.self = "1";

        List<NestedInteger> input = new ArrayList<NestedInteger>();
        input.add(one_1);
        input.add(secondElementObject);

        return input;
    }

}

/**
 * This is the interface that represents nested lists. * You should not implement it, or speculate about its implementation.
 */
class NestedInteger {
    Object self;

    // Returns true if this com.sada.linkedin.NestedInteger holds a single integer, rather than a nested list
    public boolean isInteger() {
        if (self instanceof String) {
            return true;
        }
        return false;
    }

    // Returns the single integer that this com.sada.linkedin.NestedInteger holds, if it holds a single integer
    // Returns null if this com.sada.linkedin.NestedInteger holds a nested list
    public Integer getInteger() {
        return Integer.valueOf(self.toString());
    }

    // Returns the nested list that this com.sada.linkedin.NestedInteger holds, if it holds a nested list
    // Returns null if this com.sada.linkedin.NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        if (!isInteger()) {
            return (List<NestedInteger>) self;
        }

        return null;
    }
}
