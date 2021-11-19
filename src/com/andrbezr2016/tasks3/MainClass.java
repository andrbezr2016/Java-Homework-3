package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.mycollections.MyLinkedList;
import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.Arrays;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
//        testMyLinkedList();
        testLinkedLists();
        System.out.println();
        testLinkedLists();
        System.out.println();
        testLinkedLists();
        System.out.println();
        testLinkedLists();
        System.out.println();
//        ComparisonCollections comparisonCollections = new ComparisonCollections();
//        comparisonCollections.testList(1_000_000);
//        comparisonCollections.testSet(1_000_000);
//        comparisonCollections.testMap(1_000_000);
    }

    public static void testLinkedLists() {
        int[] numbersOfTests = new int[]{10_000, 100_000, 1_000_000};
        int numbersOfTestsLength = numbersOfTests.length;
        long[] avgAddMyLinkedList = new long[numbersOfTestsLength];
        long[] avgAddLinkedList = new long[numbersOfTestsLength];
        long[] avgGetMyLinkedList = new long[numbersOfTestsLength];
        long[] avgGetLinkedList = new long[numbersOfTestsLength];
        long[] avgClearMyLinkedList = new long[numbersOfTestsLength];
        long[] avgClearLinkedList = new long[numbersOfTestsLength];
        MyTimer myTimer = new MyTimer();
        MyLinkedList<Integer> myLinkedList;
        LinkedList<Integer> linkedList;
        // Test add, get, clear
        for (int j = 0; j < numbersOfTestsLength; j++) {
            long avgTimeAdd1 = 0;
            long avgTimeGet1 = 0;
            long avgTimeClear1 = 0;
            long avgTimeAdd2 = 0;
            long avgTimeGet2 = 0;
            long avgTimeClear2 = 0;
            Integer num = 20;
            // Average time
            for (int i = 0; i < 1000; i++) {
                myLinkedList = new MyLinkedList<>();
                linkedList = new LinkedList<>();
                // 1 Add
                myTimer.start();
                for (int test = 0; test < numbersOfTests[j]; test++) {
                    myLinkedList.add(num);
                }
                avgTimeAdd1 += myTimer.end();
                // Get
                myTimer.start();
                myLinkedList.get(numbersOfTests[j] / 2);
                avgTimeGet1 += myTimer.end();
                // Clear
                myTimer.start();
                myLinkedList.clear();
                avgTimeClear1 += myTimer.end();
                // 2 Add
                myTimer.start();
                for (int test = 0; test < numbersOfTests[j]; test++) {
                    linkedList.add(num);
                }
                avgTimeAdd2 += myTimer.end();
                // Get
                myTimer.start();
                linkedList.get(numbersOfTests[j] / 2);
                avgTimeGet2 += myTimer.end();
                // Clear
                myTimer.start();
                linkedList.clear();
                avgTimeClear2 += myTimer.end();
            }
            avgAddMyLinkedList[j] = avgTimeAdd1 / 100;
            avgAddLinkedList[j] = avgTimeAdd2 / 100;
            avgGetMyLinkedList[j] = avgTimeGet1 / 100;
            avgGetLinkedList[j] = avgTimeGet2 / 100;
            avgClearMyLinkedList[j] = avgTimeClear1 / 100;
            avgClearLinkedList[j] = avgTimeClear2 / 100;
        }
        System.out.println("MyLinkedList add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddMyLinkedList));
        System.out.println("LinkedList add 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgAddLinkedList));
        System.out.println("MyLinkedList get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetMyLinkedList));
        System.out.println("LinkedList get 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgGetLinkedList));
        System.out.println("MyLinkedList clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearMyLinkedList));
        System.out.println("LinkedList clear 10_000, 100_000, 1_000_000 over time: " + Arrays.toString(avgClearLinkedList));
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
