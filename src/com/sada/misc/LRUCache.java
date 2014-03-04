package com.sada.misc;

import java.util.*;

/**
 * Created by Sada on 3/3/14.
 */
public class LRUCache<K,V> {
    private int capacity;
    private Queue<K> orderQueue;
    private Map<K, V> dataMap;

    public static void main(String[] args){
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




    public V get(K key){
        V value = dataMap.get(key);
        //if key exists, move this to end of the queue as when we purge, we take the first element from queue.
        if(null != value){
            orderQueue.remove(key); //remove from queue
            orderQueue.add(key); //add it to tail
        }
        return value;
    }

    public void put(K key, V value){
        //if already available, remove it from map as old value might be different.
        if(dataMap.containsKey(key)){
            dataMap.remove(key);
            orderQueue.remove(key);
        }
        //if queue is full, remove oldest element
        if(orderQueue.size() >= capacity){
            K keyToRemove = orderQueue.poll();
            dataMap.remove(keyToRemove);
        }
        //now, add it to map and enqueue in the queue.
        dataMap.put(key, value);
        orderQueue.add(key);
    }

    public LRUCache(final int size){
        capacity = size;
        orderQueue = new LinkedList <K>();
        dataMap = new HashMap<K, V>(size);
    }

}
