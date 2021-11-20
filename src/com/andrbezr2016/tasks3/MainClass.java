package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.comparisons.ComparisonCollections;
import com.andrbezr2016.tasks3.mycollections.MyLinkedList;
import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.Arrays;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        testMyLinkedList();
//        testLinkedLists();
//        ComparisonCollections comparisonCollections = new ComparisonCollections();
//        comparisonCollections.testList();
//        comparisonCollections.testSet();
//        comparisonCollections.testMap();
    }

    public static void testLinkedLists() {
        int numberOfTestsAvg = 10;
        int[] numbersOfTests = new int[]{10_000, 100_000, 1_000_000};
        int numbersOfTestsLength = numbersOfTests.length;
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        long[][] resultsAdd = new long[2][numbersOfTestsLength];
        long[][] resultsGet = new long[2][numbersOfTestsLength];
        long[][] resultsIndexOf = new long[2][numbersOfTestsLength];
        long[][] resultsRemove = new long[2][numbersOfTestsLength];
        // Test add, indexOf, get, remove
        for (int i = 0; i < numbersOfTestsLength; i++) {
            myLinkedList.clear();
            linkedList.clear();
            for (int k = 0; k < numbersOfTests[i]; k++) {
                myLinkedList.add(k);
                linkedList.add(k);
            }
            // Test add, get, indexOf, remove
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsAdd[0][i] += timeAdd(myLinkedList, numbersOfTests[i] / 2, -1);
                resultsAdd[1][i] += timeAdd(linkedList, numbersOfTests[i] / 2, -1);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsGet[0][i] += timeGet(myLinkedList, numbersOfTests[i] / 2);
                resultsGet[1][i] += timeGet(linkedList, numbersOfTests[i] / 2);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsIndexOf[0][i] += timeIndexOf(myLinkedList, -1);
                resultsIndexOf[1][i] += timeIndexOf(linkedList, -1);
            }
            for (int j = 0; j < numberOfTestsAvg; j++) {
                resultsRemove[0][i] += timeRemove(myLinkedList, numbersOfTests[i] / 2);
                resultsRemove[1][i] += timeRemove(linkedList, numbersOfTests[i] / 2);
            }
            for (int j = 0; j < 2; j++) {
                resultsAdd[j][i] /= numberOfTestsAvg;
                resultsGet[j][i] /= numberOfTestsAvg;
                resultsIndexOf[j][i] /= numberOfTestsAvg;
                resultsRemove[j][i] /= numberOfTestsAvg;
            }
        }
        System.out.println("Add to MyLinkedList and LinkedList: " + Arrays.deepToString(resultsAdd));
        System.out.println("Get from MyLinkedList and LinkedList: " + Arrays.deepToString(resultsGet));
        System.out.println("IndexOf from MyLinkedList and LinkedList: " + Arrays.deepToString(resultsIndexOf));
        System.out.println("Remove from MyLinkedList and LinkedList: " + Arrays.deepToString(resultsRemove));
        System.out.println("========");
    }

    private static long timeAdd(MyLinkedList<Integer> myLinkedList, int index, Integer element) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        myLinkedList.add(index, element);
        return myTimer.end();
    }

    private static long timeAdd(LinkedList<Integer> linkedList, int index, Integer element) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        linkedList.add(index, element);
        return myTimer.end();
    }

    private static long timeGet(MyLinkedList<Integer> myLinkedList, int index) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        myLinkedList.get(index);
        return myTimer.end();
    }

    private static long timeGet(LinkedList<Integer> linkedList, int index) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        linkedList.get(index);
        return myTimer.end();
    }

    private static long timeIndexOf(MyLinkedList<Integer> myLinkedList, Integer element) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        myLinkedList.indexOf(element);
        return myTimer.end();
    }

    private static long timeIndexOf(LinkedList<Integer> linkedList, Integer element) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        linkedList.indexOf(element);
        return myTimer.end();
    }

    private static long timeRemove(MyLinkedList<Integer> myLinkedList, int index) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        myLinkedList.remove(index);
        return myTimer.end();
    }

    private static long timeRemove(LinkedList<Integer> linkedList, int index) {
        MyTimer myTimer = new MyTimer();
        myTimer.start();
        linkedList.remove(index);
        return myTimer.end();
    }

    public static void testMyLinkedList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        // Test add
        System.out.println("==Test add==");
        for (int i = 0; i < 8; i++) {
            myLinkedList.add(i);
        }
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
        myLinkedList.add(4, 100);
        myLinkedList.add(0, 100);
        myLinkedList.add(myLinkedList.size(), 100);
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
        // Test get
        System.out.println("==Test get==");
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.print('\n');
        // Test set
        System.out.println("==Test set==");
        myLinkedList.set(5, 200);
        myLinkedList.set(0, 200);
        myLinkedList.set(myLinkedList.size() - 1, 200);
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
        // Test remove
        System.out.println("==Test remove==");
        for (int i = 6; i >= 4; i--) {
            myLinkedList.remove(i);
        }
        myLinkedList.remove(0);
        myLinkedList.remove(myLinkedList.size() - 1);
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
        // Test indexOf
        System.out.println("==Test indexOf==");
        System.out.printf("Element: %d, index: %s\n", 0, myLinkedList.indexOf(0));
        System.out.printf("Element: %d, index: %s\n", 7, myLinkedList.indexOf(7));
        System.out.printf("Element: %d, index: %s\n", 5, myLinkedList.indexOf(5));
        System.out.printf("Element: %d, index: %s\n", 10, myLinkedList.indexOf(10));
        // Test iterator
        System.out.println("==Test iterator==");
        for (Integer number : myLinkedList) {
            System.out.print(number + " ");
        }
        System.out.print('\n');
        // Test toArray
        System.out.println("==Test toArray==");
        Integer[] integers1 = myLinkedList.toArray(new Integer[0]);
        System.out.println(integers1.getClass());
        System.out.println(Arrays.toString(integers1));
        Object[] integers2 = myLinkedList.toArray();
        System.out.println(integers2.getClass());
        System.out.println(Arrays.toString(integers2));
        // Test clear
        System.out.println("==Test clear==");
        myLinkedList.clear();
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
    }
}
