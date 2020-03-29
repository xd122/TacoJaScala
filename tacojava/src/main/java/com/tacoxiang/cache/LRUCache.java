package com.tacoxiang.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang
 * Time : 2020/3/29
 * Package : com.tacoxiang.cache
 * ProjectName: TacoJaScala
 * Describe :
 * ============================================================
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;
    private final float factor;

    public LRUCache(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
        this.capacity = initialCapacity;
        this.factor = loadFactor;
    }

    /**
     * @param eldest
     * @return 清除策略，在插入的时候就会调用 等同于FIFO
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static class MyLRUCache {
        public static LRUCache<String, Integer> cache = new LRUCache<String, Integer>(4, 0.75f);

        static {
            for (int i = 0; i < 4; i++) {
                cache.put("tacoxiang" + i, i);
            }
        }

        public static void main(String[] args) {
            System.out.println("First round" + cache);

            // Test second round
            cache.put("tacoxiang4",4);
            System.out.println("Second round" + cache);

            // Test three round
            cache.put("tacoxiang5",5);
            System.out.println("Three round" + cache);

            // Test four round
            cache.put("tacoxiang6",6);
            System.out.println("Four round" + cache);
        }
    }

}
