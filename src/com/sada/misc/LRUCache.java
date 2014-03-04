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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRUCache<K, V> {
    private int capacity;
    private Queue<K> orderQueue;
    private Map<K, V> dataMap;

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<Integer, String>(4);
        cache.put(1, "one");
        cache.put(2, "two");
        cache.put(3, "three");
        cache.put(4, "four");
        cache.put(5, "four");

        cache.get(2);
        cache.put(3, "nine");
        System.out.println("Bye");

    }


    public V get(K key) {
        V value = dataMap.get(key);
        //if key exists, move this to end of the queue as when we purge, we take the first element from queue.
        if (null != value) {
            orderQueue.remove(key); //remove from queue
            orderQueue.add(key); //add it to tail
        }
        return value;
    }

    public void put(K key, V value) {
        //if already available, remove it from map as old value might be different.
        if (dataMap.containsKey(key)) {
            dataMap.remove(key);
            orderQueue.remove(key);
        }
        //if queue is full, remove oldest element
        if (orderQueue.size() >= capacity) {
            K keyToRemove = orderQueue.poll();
            dataMap.remove(keyToRemove);
        }
        //now, add it to map and enqueue in the queue.
        dataMap.put(key, value);
        orderQueue.add(key);
    }

    public LRUCache(final int size) {
        capacity = size;
        orderQueue = new LinkedList<K>();
        dataMap = new HashMap<K, V>(size);
    }

}
