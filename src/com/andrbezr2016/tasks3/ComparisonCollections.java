package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.*;

public final class ComparisonCollections {

    MyTimer myTimer = new MyTimer();

    public ComparisonCollections() {
    }

    private static void addNumbers(Collection<Integer> collection, int numberOfTests) {
        for (int i = 0; i < numberOfTests; i++) {
            collection.add(i);
        }
    }

    private static void putPair(Map<Integer, String> collection, int numberOfTests) {
        String value = "Value";
        for (int i = 0; i < numberOfTests; i++) {
            collection.put(i, value);
        }
    }

    public void testList(int numberOfTests) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        // Test add
        myTimer.start();
        addNumbers(arrayList, numberOfTests);
        myTimer.end("Add time to ArrayList: ");
        //
        myTimer.start();
        addNumbers(linkedList, numberOfTests);
        myTimer.end("Add time to LinkedList: ");
        // Test get
        myTimer.start();
        arrayList.get(numberOfTests / 2);
        myTimer.end("Get time to ArrayList: ");
        //
        myTimer.start();
        linkedList.get(numberOfTests / 2);
        myTimer.end("Get time to LinkedList: ");
        // Test clear
        myTimer.start();
        arrayList.clear();
        myTimer.end("Clear time to ArrayList: ");
        //
        myTimer.start();
        linkedList.clear();
        myTimer.end("Clear time to LinkedList: ");
    }

    public void testSet(int numberOfTests) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        // Test add
        myTimer.start();
        addNumbers(hashSet, numberOfTests);
        myTimer.end("Add time to HashSet: ");
        //
        myTimer.start();
        addNumbers(linkedHashSet, numberOfTests);
        myTimer.end("Add time to LinkedHashSet: ");
        //
        myTimer.start();
        addNumbers(treeSet, numberOfTests);
        myTimer.end("Add time to TreeSet: ");
        // Test contains
        myTimer.start();
        hashSet.contains(numberOfTests / 2);
        myTimer.end("Contains time to HashSet: ");
        //
        myTimer.start();
        linkedHashSet.contains(numberOfTests / 2);
        myTimer.end("Contains time to LinkedHashSet: ");
        //
        myTimer.start();
        treeSet.contains(numberOfTests / 2);
        myTimer.end("Contains time to TreeSet: ");
        // Test clear
        myTimer.start();
        hashSet.clear();
        myTimer.end("Clear time to HashSet: ");
        //
        myTimer.start();
        linkedHashSet.clear();
        myTimer.end("Clear time to LinkedHashSet: ");
        //
        myTimer.start();
        treeSet.clear();
        myTimer.end("Clear time to TreeSet: ");
    }

    public void testMap(int numberOfTests) {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        // Test add
        myTimer.start();
        putPair(hashMap, numberOfTests);
        myTimer.end("Add time to HashMap: ");
        //
        myTimer.start();
        putPair(linkedHashMap, numberOfTests);
        myTimer.end("Add time to LinkedHashMap: ");
        //
        myTimer.start();
        putPair(treeMap, numberOfTests);
        myTimer.end("Add time to TreeMap: ");
        // Test contains
        myTimer.start();
        hashMap.containsKey(numberOfTests / 2);
        myTimer.end("Contains time to HashMap: ");
        //
        myTimer.start();
        linkedHashMap.containsKey(numberOfTests / 2);
        myTimer.end("Contains time to LinkedHashMap: ");
        //
        myTimer.start();
        treeMap.containsKey(numberOfTests / 2);
        myTimer.end("Contains time to TreeMap: ");
        // Test clear
        myTimer.start();
        hashMap.clear();
        myTimer.end("Clear time to HashMap: ");
        //
        myTimer.start();
        linkedHashMap.clear();
        myTimer.end("Clear time to LinkedHashMap: ");
        //
        myTimer.start();
        treeMap.clear();
        myTimer.end("Clear time to TreeMap: ");
    }
}
