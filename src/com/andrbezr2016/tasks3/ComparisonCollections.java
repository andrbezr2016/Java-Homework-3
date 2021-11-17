package com.andrbezr2016.tasks3;

import java.util.*;

public final class ComparisonCollections {

    private long timeStart;
    private long timeEnd;

    public ComparisonCollections() {
    }

    private void start() {
        this.timeStart = System.nanoTime();
    }

    private void end(String message) {
        this.timeEnd = System.nanoTime();
        System.out.println(message + (timeEnd - timeStart) / 1_000_000 + "ms");
    }

    private void addNumbers(Collection<Integer> collection, int numberOfTests) {
        for (int i = 0; i < numberOfTests; i++) {
            collection.add(10);
        }
    }

    private void putPair(Map<Integer, String> collection, int numberOfTests) {
        for (int i = 0; i < numberOfTests; i++) {
            collection.put(10,"String");
        }
    }

    public void testList(int numberOfTests) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        // Test add
        start();
        addNumbers(arrayList, numberOfTests);
        end("Add time to ArrayList: ");
        //
        start();
        addNumbers(linkedList, numberOfTests);
        end("Add time to LinkedList: ");
        // Test get
        start();
        arrayList.get(numberOfTests / 2);
        end("Get time to ArrayList: ");
        //
        start();
        linkedList.get(numberOfTests / 2);
        end("Get time to LinkedList: ");
        // Test clear
        start();
        arrayList.clear();
        end("Clear time to ArrayList: ");
        //
        start();
        linkedList.clear();
        end("Clear time to LinkedList: ");
    }

    public void testSet(int numberOfTests) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        // Test add
        start();
        addNumbers(hashSet, numberOfTests);
        end("Add time to HashSet: ");
        //
        start();
        addNumbers(linkedHashSet, numberOfTests);
        end("Add time to LinkedHashSet: ");
        //
        start();
        addNumbers(treeSet, numberOfTests);
        end("Add time to TreeSet: ");
        // Test contains
        start();
        hashSet.contains(-10);
        end("Contains time to HashSet: ");
        //
        start();
        linkedHashSet.contains(-10);
        end("Contains time to LinkedHashSet: ");
        //
        start();
        treeSet.contains(-10);
        end("Contains time to TreeSet: ");
        // Test clear
        start();
        hashSet.clear();
        end("Clear time to HashSet: ");
        //
        start();
        linkedHashSet.clear();
        end("Clear time to LinkedHashSet: ");
        //
        start();
        treeSet.clear();
        end("Clear time to TreeSet: ");
    }

    public void testMap(int numberOfTests) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        // Test add
        start();
        putPair(hashMap, numberOfTests);
        end("Add time to HashMap: ");
        //
        start();
        putPair(linkedHashMap, numberOfTests);
        end("Add time to LinkedHashMap: ");
        //
        start();
        putPair(treeMap, numberOfTests);
        end("Add time to TreeMap: ");
        // Test contains
        start();
        hashMap.containsKey(-10);
        end("Contains time to HashMap: ");
        //
        start();
        linkedHashMap.containsKey(-10);
        end("Contains time to LinkedHashMap: ");
        //
        start();
        treeMap.containsKey(-10);
        end("Contains time to TreeMap: ");
        // Test clear
        start();
        hashMap.clear();
        end("Clear time to HashMap: ");
        //
        start();
        linkedHashMap.clear();
        end("Clear time to LinkedHashMap: ");
        //
        start();
        treeMap.clear();
        end("Clear time to TreeMap: ");
    }
}
