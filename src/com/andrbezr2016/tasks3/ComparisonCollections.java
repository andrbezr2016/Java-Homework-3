package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.*;

public final class ComparisonCollections {

    MyTimer myTimer;
    int[] numbersOfTests;
    int numbersOfTestsLength;
    int numberOfTestsAvg;

    public ComparisonCollections() {
        this.myTimer = new MyTimer();
        this.numbersOfTests = new int[]{10_000, 100_000, 1_000_000};
        this.numbersOfTestsLength = numbersOfTests.length;
        this.numberOfTestsAvg = 1000;
    }

    private long timeToAdd(Collection<Integer> collection, int numberOfTests) {
        myTimer.start();
        addNumbers(collection, numberOfTests);
        return myTimer.end();
    }

    private long timeToAdd(Map<Integer, String> map, int numberOfTests) {
        myTimer.start();
        putPair(map, numberOfTests);
        return myTimer.end();
    }

    private long timeToGet(List<Integer> list, int index) {
        myTimer.start();
        list.get(index);
        return myTimer.end();
    }

    private long timeToGet(Set<Integer> set, Integer element) {
        myTimer.start();
        set.contains(element);
        return myTimer.end();
    }

    private long timeToGet(Map<Integer, String> map, Integer key) {
        myTimer.start();
        map.containsKey(key);
        return myTimer.end();
    }

    private long timeToRemove(List<Integer> list, int index) {
        myTimer.start();
        list.remove(index);
        return myTimer.end();
    }

    private long timeToRemove(Set<Integer> set, Integer element) {
        myTimer.start();
        set.remove(element);
        return myTimer.end();
    }

    private long timeToRemove(Map<Integer, String> map, Integer key) {
        myTimer.start();
        map.remove(key);
        return myTimer.end();
    }

    public void testList() {
        long[] avgAddArrayList = new long[numbersOfTestsLength];
        long[] avgAddLinkedList = new long[numbersOfTestsLength];

        long[] avgGetArrayList = new long[numbersOfTestsLength];
        long[] avgGetLinkedList = new long[numbersOfTestsLength];

        long[] avgRemoveArrayList = new long[numbersOfTestsLength];
        long[] avgRemoveLinkedList = new long[numbersOfTestsLength];

        long[] avgClearArrayList = new long[numbersOfTestsLength];
        long[] avgClearLinkedList = new long[numbersOfTestsLength];

        List<Integer> arrayList;
        List<Integer> linkedList;
        // Test add, get, remove, clear
        for (int j = 0; j < numbersOfTestsLength; j++) {
            long avgTimeAdd1 = 0;
            long avgTimeGet1 = 0;
            long avgTimeRemove1 = 0;
            long avgTimeClear1 = 0;
            long avgTimeAdd2 = 0;
            long avgTimeGet2 = 0;
            long avgTimeRemove2 = 0;
            long avgTimeClear2 = 0;
            for (int i = 0; i < numberOfTestsAvg; i++) {
                arrayList = new ArrayList<>();
                linkedList = new LinkedList<>();
                // Test add
                myTimer.start();
                addNumbers(arrayList, numbersOfTests[j]);
                avgTimeAdd1 += myTimer.end();
                //
                myTimer.start();
                addNumbers(linkedList, numbersOfTests[j]);
                avgTimeAdd2 += myTimer.end();
                // Test get (middle element)
                myTimer.start();
                arrayList.get(numbersOfTests[j] / 2);
                avgTimeGet1 += myTimer.end();
                //
                myTimer.start();
                linkedList.get(numbersOfTests[j] / 2);
                avgTimeGet2 += myTimer.end();
                // Test remove (middle element)
                myTimer.start();
                arrayList.remove(numbersOfTests[j] / 2);
                avgTimeRemove1 += myTimer.end();
                //
                myTimer.start();
                linkedList.remove(numbersOfTests[j] / 2);
                avgTimeRemove2 += myTimer.end();
                // Test clear
                myTimer.start();
                arrayList.clear();
                avgTimeClear1 += myTimer.end();
                //
                myTimer.start();
                linkedList.clear();
                avgTimeClear2 += myTimer.end();
            }
            avgAddArrayList[j] = avgTimeAdd1 / numberOfTestsAvg;
            avgAddLinkedList[j] = avgTimeAdd2 / numberOfTestsAvg;
            avgGetArrayList[j] = avgTimeGet1 / numberOfTestsAvg;
            avgGetLinkedList[j] = avgTimeGet2 / numberOfTestsAvg;
            avgRemoveArrayList[j] = avgTimeRemove1 / numberOfTestsAvg;
            avgRemoveLinkedList[j] = avgTimeRemove2 / numberOfTestsAvg;
            avgClearArrayList[j] = avgTimeClear1 / numberOfTestsAvg;
            avgClearLinkedList[j] = avgTimeClear2 / numberOfTestsAvg;
        }
        System.out.println("ArrayList add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddArrayList));
        System.out.println("LinkedList add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddLinkedList));

        System.out.println("ArrayList get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetArrayList));
        System.out.println("LinkedList get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetLinkedList));

        System.out.println("ArrayList remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveArrayList));
        System.out.println("LinkedList remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveLinkedList));

        System.out.println("ArrayList clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearArrayList));
        System.out.println("LinkedList clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearLinkedList));
        System.out.println("========");
    }

    public void testSet() {
        long[] avgAddHashSet = new long[numbersOfTestsLength];
        long[] avgAddLinkedHashSet = new long[numbersOfTestsLength];
        long[] avgAddTreeSet = new long[numbersOfTestsLength];

        long[] avgGetHashSet = new long[numbersOfTestsLength];
        long[] avgGetLinkedHashSet = new long[numbersOfTestsLength];
        long[] avgGetTreeSet = new long[numbersOfTestsLength];

        long[] avgRemoveHashSet = new long[numbersOfTestsLength];
        long[] avgRemoveLinkedHashSet = new long[numbersOfTestsLength];
        long[] avgRemoveTreeSet = new long[numbersOfTestsLength];

        long[] avgClearHashSet = new long[numbersOfTestsLength];
        long[] avgClearLinkedHashSet = new long[numbersOfTestsLength];
        long[] avgClearTreeSet = new long[numbersOfTestsLength];

        Set<Integer> hashSet;
        Set<Integer> linkedHashSet;
        Set<Integer> treeSet;
        // Test add, get, remove, clear
        for (int j = 0; j < numbersOfTestsLength; j++) {
            long avgTimeAdd1 = 0;
            long avgTimeGet1 = 0;
            long avgTimeRemove1 = 0;
            long avgTimeClear1 = 0;
            long avgTimeAdd2 = 0;
            long avgTimeGet2 = 0;
            long avgTimeRemove2 = 0;
            long avgTimeClear2 = 0;
            long avgTimeAdd3 = 0;
            long avgTimeGet3 = 0;
            long avgTimeRemove3 = 0;
            long avgTimeClear3 = 0;
            for (int i = 0; i < numberOfTestsAvg; i++) {
                hashSet = new HashSet<>();
                linkedHashSet = new LinkedHashSet<>();
                treeSet = new TreeSet<>();
                // Test add
                myTimer.start();
                addNumbers(hashSet, numbersOfTests[j]);
                avgTimeAdd1 += myTimer.end();
                //
                myTimer.start();
                addNumbers(linkedHashSet, numbersOfTests[j]);
                avgTimeAdd2 += myTimer.end();
                //
                myTimer.start();
                addNumbers(treeSet, numbersOfTests[j]);
                avgTimeAdd3 += myTimer.end();
                // Test contains
                myTimer.start();
                hashSet.contains(numbersOfTests[j] / 2);
                avgTimeGet1 += myTimer.end();
                //
                myTimer.start();
                linkedHashSet.contains(numbersOfTests[j] / 2);
                avgTimeGet2 += myTimer.end();
                //
                myTimer.start();
                treeSet.contains(numbersOfTests[j] / 2);
                avgTimeGet3 += myTimer.end();
                // Test remove
                myTimer.start();
                hashSet.remove(numbersOfTests[j] / 2);
                avgTimeRemove1 += myTimer.end();
                //
                myTimer.start();
                linkedHashSet.remove(numbersOfTests[j] / 2);
                avgTimeRemove2 += myTimer.end();
                //
                myTimer.start();
                treeSet.remove(numbersOfTests[j] / 2);
                avgTimeRemove3 += myTimer.end();
                // Test clear
                myTimer.start();
                hashSet.clear();
                avgTimeClear1 += myTimer.end();
                //
                myTimer.start();
                linkedHashSet.clear();
                avgTimeClear2 += myTimer.end();
                //
                myTimer.start();
                treeSet.clear();
                avgTimeClear3 += myTimer.end();
            }
            avgAddHashSet[j] = avgTimeAdd1 / numberOfTestsAvg;
            avgAddLinkedHashSet[j] = avgTimeAdd2 / numberOfTestsAvg;
            avgAddTreeSet[j] = avgTimeAdd3 / numberOfTestsAvg;
            avgGetHashSet[j] = avgTimeGet1 / numberOfTestsAvg;
            avgGetLinkedHashSet[j] = avgTimeGet2 / numberOfTestsAvg;
            avgGetTreeSet[j] = avgTimeGet3 / numberOfTestsAvg;
            avgRemoveHashSet[j] = avgTimeRemove1 / numberOfTestsAvg;
            avgRemoveLinkedHashSet[j] = avgTimeRemove2 / numberOfTestsAvg;
            avgRemoveTreeSet[j] = avgTimeRemove3 / numberOfTestsAvg;
            avgClearHashSet[j] = avgTimeClear1 / numberOfTestsAvg;
            avgClearLinkedHashSet[j] = avgTimeClear2 / numberOfTestsAvg;
            avgClearTreeSet[j] = avgTimeClear3 / numberOfTestsAvg;
        }
        System.out.println("HashSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddHashSet));
        System.out.println("LinkedHashSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddLinkedHashSet));
        System.out.println("TreeSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddTreeSet));

        System.out.println("HashSet get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetHashSet));
        System.out.println("LinkedHashSet get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetLinkedHashSet));
        System.out.println("TreeSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetTreeSet));

        System.out.println("HashSet remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveHashSet));
        System.out.println("LinkedHashSet remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveLinkedHashSet));
        System.out.println("TreeSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveTreeSet));

        System.out.println("HashSet clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearHashSet));
        System.out.println("LinkedHashSet clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearLinkedHashSet));
        System.out.println("TreeSet add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearTreeSet));
        System.out.println("========");
    }

    public void testMap() {
        long[] avgAddHashMap = new long[numbersOfTestsLength];
        long[] avgAddLinkedHashMap = new long[numbersOfTestsLength];
        long[] avgAddTreeMap = new long[numbersOfTestsLength];

        long[] avgGetHashMap = new long[numbersOfTestsLength];
        long[] avgGetLinkedHashMap = new long[numbersOfTestsLength];
        long[] avgGetTreeMap = new long[numbersOfTestsLength];

        long[] avgRemoveHashMap = new long[numbersOfTestsLength];
        long[] avgRemoveLinkedHashMap = new long[numbersOfTestsLength];
        long[] avgRemoveTreeMap = new long[numbersOfTestsLength];

        long[] avgClearHashMap = new long[numbersOfTestsLength];
        long[] avgClearLinkedHashMap = new long[numbersOfTestsLength];
        long[] avgClearTreeMap = new long[numbersOfTestsLength];

        Map<Integer, String> hashMap;
        Map<Integer, String> linkedHashMap;
        Map<Integer, String> treeMap;
        // Test add, get, remove, clear
        for (int j = 0; j < numbersOfTestsLength; j++) {
            long avgTimeAdd1 = 0;
            long avgTimeGet1 = 0;
            long avgTimeRemove1 = 0;
            long avgTimeClear1 = 0;
            long avgTimeAdd2 = 0;
            long avgTimeGet2 = 0;
            long avgTimeRemove2 = 0;
            long avgTimeClear2 = 0;
            long avgTimeAdd3 = 0;
            long avgTimeGet3 = 0;
            long avgTimeRemove3 = 0;
            long avgTimeClear3 = 0;
            for (int i = 0; i < numberOfTestsAvg; i++) {
                hashMap = new HashMap<>();
                linkedHashMap = new LinkedHashMap<>();
                treeMap = new TreeMap<>();
                // Test add
                myTimer.start();
                putPair(hashMap, numbersOfTests[j]);
                avgTimeAdd1 += myTimer.end();
                //
                myTimer.start();
                putPair(linkedHashMap, numbersOfTests[j]);
                avgTimeAdd2 += myTimer.end();
                //
                myTimer.start();
                putPair(treeMap, numbersOfTests[j]);
                avgTimeAdd3 += myTimer.end();
                // Test contains
                myTimer.start();
                hashMap.containsKey(numbersOfTests[j] / 2);
                avgTimeGet1 += myTimer.end();
                //
                myTimer.start();
                linkedHashMap.containsKey(numbersOfTests[j] / 2);
                avgTimeGet2 += myTimer.end();
                //
                myTimer.start();
                treeMap.containsKey(numbersOfTests[j] / 2);
                avgTimeGet3 += myTimer.end();
                // Test remove
                myTimer.start();
                hashMap.remove(numbersOfTests[j] / 2);
                avgTimeRemove1 += myTimer.end();
                //
                myTimer.start();
                linkedHashMap.remove(numbersOfTests[j] / 2);
                avgTimeRemove2 += myTimer.end();
                //
                myTimer.start();
                treeMap.remove(numbersOfTests[j] / 2);
                avgTimeRemove3 += myTimer.end();
                // Test clear
                myTimer.start();
                hashMap.clear();
                avgTimeClear1 += myTimer.end();
                //
                myTimer.start();
                linkedHashMap.clear();
                avgTimeClear2 += myTimer.end();
                //
                myTimer.start();
                treeMap.clear();
                avgTimeClear3 += myTimer.end();
            }
            avgAddHashMap[j] = avgTimeAdd1 / numberOfTestsAvg;
            avgAddLinkedHashMap[j] = avgTimeAdd2 / numberOfTestsAvg;
            avgAddTreeMap[j] = avgTimeAdd3 / numberOfTestsAvg;
            avgGetHashMap[j] = avgTimeGet1 / numberOfTestsAvg;
            avgGetLinkedHashMap[j] = avgTimeGet2 / numberOfTestsAvg;
            avgGetTreeMap[j] = avgTimeGet3 / numberOfTestsAvg;
            avgRemoveHashMap[j] = avgTimeRemove1 / numberOfTestsAvg;
            avgRemoveLinkedHashMap[j] = avgTimeRemove2 / numberOfTestsAvg;
            avgRemoveTreeMap[j] = avgTimeRemove3 / numberOfTestsAvg;
            avgClearHashMap[j] = avgTimeClear1 / numberOfTestsAvg;
            avgClearLinkedHashMap[j] = avgTimeClear2 / numberOfTestsAvg;
            avgClearTreeMap[j] = avgTimeClear3 / numberOfTestsAvg;
        }
        System.out.println("HashMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddHashMap));
        System.out.println("LinkedHashMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddLinkedHashMap));
        System.out.println("TreeMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddTreeMap));

        System.out.println("HashMap get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetHashMap));
        System.out.println("LinkedHashMap get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetLinkedHashMap));
        System.out.println("TreeMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetTreeMap));

        System.out.println("HashMap remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveHashMap));
        System.out.println("LinkedHashMap remove 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveLinkedHashMap));
        System.out.println("TreeMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgRemoveTreeMap));

        System.out.println("HashMap clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearHashMap));
        System.out.println("LinkedHashMap clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearLinkedHashMap));
        System.out.println("TreeMap add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearTreeMap));
        System.out.println("========");
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
}
