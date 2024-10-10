package code.HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class HashTable {

    public static void main(String[] args) {
        

        // HashMap 非线程安全，允许 null 键和值。
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Alice", 25);
        hashMap.put("Bob", 30);
        System.out.println(hashMap.get("Alice")); // 输出：25


        // HashSet 基于 HashMap 实现，用于唯一值集合。
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple"); // 重复元素不会被添加
        System.out.println(hashSet.contains("Banana")); // 输出：true


        // HashTable 线程安全的 HashMap，不允许 null 键和值。
         Map<String, Integer> hashtable = new Hashtable<>();
        hashtable.put("Tom", 40);
        hashtable.put("Jerry", 35);
        System.out.println(hashtable.get("Tom")); // 输出：40

    }
    
}
