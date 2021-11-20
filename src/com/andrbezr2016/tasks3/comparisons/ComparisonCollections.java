package com.andrbezr2016.tasks3.comparisons;

import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.*;

public final class ComparisonCollections {

    private MyTimer myTimer = new MyTimer();
    private final int[] numbersOfTests = new int[]{10_000, 100_000, 1_000_000};
    private final int numbersOfTestsLength = numbersOfTests.length;
    private final int numberOfTestsAvg = 10;

    public ComparisonCollections() {
    }

    public void testList() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        long[][] resultsFill = new long[2][numbersOfTestsLength];
        long[][] resultsAddFront = new long[2][numbersOfTestsLength];
        long[][] resultsAddMiddle = new long[2][numbersOfTestsLength];
        long[][] resultsAddBack = new long[2][numbersOfTestsLength];
        long[][] resultsGet = new long[2][numbersOfTestsLength];
        long[][] resultsRemove = new long[2][numbersOfTestsLength];
        // Test fill, add, get, remove
        for (int i = 0; i < numbersOfTestsLength; i++) {
            for (int j = 0; j < numberOfTestsAvg; j++) {
                arrayList.clear();
                linkedList.clear();
                resultsFill[0][i] += timeFillList(arrayList, numbersOfTests[i]);
                resultsFill[1][i] += timeFillList(linkedList, numbersOfTests[i]);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAddFront[0][i] += timeAddList(arrayList, 0, -1);
                resultsAddFront[1][i] += timeAddList(linkedList, 0, -1);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAddMiddle[0][i] += timeAddList(arrayList, numbersOfTests[i] / 2, -1);
                resultsAddMiddle[1][i] += timeAddList(linkedList, numbersOfTests[i] / 2, -1);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAddBack[0][i] += timeAddList(arrayList, numbersOfTests[i] - 1, -1);
                resultsAddBack[1][i] += timeAddList(linkedList, numbersOfTests[i] - 1, -1);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsGet[0][i] += timeGetList(arrayList, numbersOfTests[i] / 2);
                resultsGet[1][i] += timeGetList(linkedList, numbersOfTests[i] / 2);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsRemove[0][i] += timeRemoveList(arrayList, numbersOfTests[i] / 2);
                resultsRemove[1][i] += timeRemoveList(linkedList, numbersOfTests[i] / 2);
            }
            for (int j = 0; j < 2; j++) {
                resultsFill[j][i] /= numberOfTestsAvg;
                resultsAddFront[j][i] /= numberOfTestsAvg;
                resultsAddMiddle[j][i] /= numberOfTestsAvg;
                resultsAddBack[j][i] /= numberOfTestsAvg;
                resultsGet[j][i] /= numberOfTestsAvg;
                resultsRemove[j][i] /= numberOfTestsAvg;
            }
        }
        System.out.println("List test");
        System.out.println("Fill ArrayList and LinkedList: " + Arrays.deepToString(resultsFill));
        System.out.println("AddFront to ArrayList and LinkedList: " + Arrays.deepToString(resultsAddFront));
        System.out.println("AddMiddle to ArrayList and LinkedList: " + Arrays.deepToString(resultsAddMiddle));
        System.out.println("AddBack to ArrayList and LinkedList: " + Arrays.deepToString(resultsAddBack));
        System.out.println("Get from ArrayList and LinkedList: " + Arrays.deepToString(resultsGet));
        System.out.println("Remove from ArrayList and LinkedList: " + Arrays.deepToString(resultsRemove));
        System.out.println("========");
    }

    public void testSet() {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        Set<Integer> treeSet = new TreeSet<>();
        long[][] resultsFill = new long[3][numbersOfTestsLength];
        long[][] resultsAdd = new long[3][numbersOfTestsLength];
        long[][] resultsGet = new long[3][numbersOfTestsLength];
        long[][] resultsRemove = new long[3][numbersOfTestsLength];
        // Test fill, add, get, remove
        for (int i = 0; i < numbersOfTestsLength; i++) {
            for (int j = 0; j < numberOfTestsAvg; j++) {
                hashSet.clear();
                linkedHashSet.clear();
                treeSet.clear();
                resultsFill[0][i] = timeFillSet(hashSet, numbersOfTests[i]);
                resultsFill[1][i] = timeFillSet(linkedHashSet, numbersOfTests[i]);
                resultsFill[2][i] = timeFillSet(treeSet, numbersOfTests[i]);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAdd[0][i] = timeAddSet(hashSet, -1 - j);
                resultsAdd[1][i] = timeAddSet(linkedHashSet, -1 - j);
                resultsAdd[2][i] = timeAddSet(treeSet, -1 - j);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsGet[0][i] = timeGetSet(hashSet, -1 - j);
                resultsGet[1][i] = timeGetSet(linkedHashSet, -1 - j);
                resultsGet[2][i] = timeGetSet(treeSet, -1 - j);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsRemove[0][i] = timeRemoveSet(hashSet, numbersOfTests[i] / 2 + j);
                resultsRemove[1][i] = timeRemoveSet(linkedHashSet, numbersOfTests[i] / 2 + j);
                resultsRemove[2][i] = timeRemoveSet(treeSet, numbersOfTests[i] / 2 + j);
            }
            for (int j = 0; j < 3; j++) {
                resultsFill[j][i] /= numberOfTestsAvg;
                resultsAdd[j][i] /= numberOfTestsAvg;
                resultsGet[j][i] /= numberOfTestsAvg;
                resultsRemove[j][i] /= numberOfTestsAvg;
            }
        }
        System.out.println("Set test");
        System.out.println("Fill HashSet, LinkedHashSet and TreeSet: " + Arrays.deepToString(resultsFill));
        System.out.println("Add to HashSet, LinkedHashSet and TreeSet: " + Arrays.deepToString(resultsAdd));
        System.out.println("Get from HashSet, LinkedHashSet and TreeSet: " + Arrays.deepToString(resultsGet));
        System.out.println("Remove from HashSet, LinkedHashSet and TreeSet: " + Arrays.deepToString(resultsRemove));
        System.out.println("========");
    }

    public void testMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> treeMap = new TreeMap<>();
        String value = "NewValue";
        long[][] resultsFill = new long[3][numbersOfTestsLength];
        long[][] resultsAdd = new long[3][numbersOfTestsLength];
        long[][] resultsGet = new long[3][numbersOfTestsLength];
        long[][] resultsRemove = new long[3][numbersOfTestsLength];
        // Test fill, add, get, remove
        for (int i = 0; i < numbersOfTestsLength; i++) {
            for (int j = 0; j < numberOfTestsAvg; j++) {
                hashMap.clear();
                linkedHashMap.clear();
                treeMap.clear();
                resultsFill[0][i] = timeFillMap(hashMap, numbersOfTests[i]);
                resultsFill[1][i] = timeFillMap(linkedHashMap, numbersOfTests[i]);
                resultsFill[2][i] = timeFillMap(treeMap, numbersOfTests[i]);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAdd[0][i] = timeAddMap(hashMap, -1 - j, value);
                resultsAdd[1][i] = timeAddMap(linkedHashMap, -1 - j, value);
                resultsAdd[2][i] = timeAddMap(treeMap, -1 - j, value);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsGet[0][i] = timeGetMap(hashMap, -1 - j);
                resultsGet[1][i] = timeGetMap(linkedHashMap, -1 - j);
                resultsGet[2][i] = timeGetMap(treeMap, -1 - j);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsRemove[0][i] = timeRemoveMap(hashMap, numbersOfTests[i] / 2 + j);
                resultsRemove[1][i] = timeRemoveMap(linkedHashMap, numbersOfTests[i] / 2 + j);
                resultsRemove[2][i] = timeRemoveMap(treeMap, numbersOfTests[i] / 2 + j);
            }
            for (int j = 0; j < 3; j++) {
                resultsFill[j][i] /= numberOfTestsAvg;
                resultsAdd[j][i] /= numberOfTestsAvg;
                resultsGet[j][i] /= numberOfTestsAvg;
                resultsRemove[j][i] /= numberOfTestsAvg;
            }
        }
        System.out.println("Map test");
        System.out.println("Fill HashMap, LinkedHashMap and TreeMap: " + Arrays.deepToString(resultsFill));
        System.out.println("Add to HashMap, LinkedHashMap and TreeMap: " + Arrays.deepToString(resultsAdd));
        System.out.println("Get from HashMap, LinkedHashMap and TreeMap: " + Arrays.deepToString(resultsGet));
        System.out.println("Remove from HashMap, LinkedHashMap and TreeMap: " + Arrays.deepToString(resultsRemove));
        System.out.println("========");
    }

    private long timeFillList(List<Integer> list, int numberOfTests) {
        myTimer.start();
        addNumbers(list, numberOfTests);
        return myTimer.end();
    }

    private long timeFillSet(Set<Integer> set, int numberOfTests) {
        myTimer.start();
        addNumbers(set, numberOfTests);
        return myTimer.end();
    }

    private long timeFillMap(Map<Integer, String> map, int numberOfTests) {
        myTimer.start();
        putPair(map, numberOfTests);
        return myTimer.end();
    }

    private long timeAddList(List<Integer> list, int index, Integer element) {
        myTimer.start();
        list.add(index, element);
        return myTimer.end();
    }

    private long timeAddSet(Set<Integer> set, Integer element) {
        myTimer.start();
        set.add(element);
        return myTimer.end();
    }

    private long timeAddMap(Map<Integer, String> map, Integer key, String value) {
        myTimer.start();
        map.put(key, value);
        return myTimer.end();
    }

    private long timeGetList(List<Integer> list, int index) {
        myTimer.start();
        list.get(index);
        return myTimer.end();
    }

    private long timeGetSet(Set<Integer> set, Integer element) {
        myTimer.start();
        set.contains(element);
        return myTimer.end();
    }

    private long timeGetMap(Map<Integer, String> map, Integer key) {
        myTimer.start();
        map.containsKey(key);
        return myTimer.end();
    }

    private long timeRemoveList(List<Integer> list, int index) {
        myTimer.start();
        list.remove(index);
        return myTimer.end();
    }

    private long timeRemoveSet(Set<Integer> set, Integer element) {
        myTimer.start();
        set.remove(element);
        return myTimer.end();
    }

    private long timeRemoveMap(Map<Integer, String> map, Integer key) {
        myTimer.start();
        map.remove(key);
        return myTimer.end();
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
