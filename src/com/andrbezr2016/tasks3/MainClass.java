package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.mycollections.MyLinkedList;

import java.util.Arrays;
import java.util.LinkedList;

public class MainClass {
    public static void main(String[] args) {
        testMyLinkedList();
        testLinkedLists();
        ComparisonCollections comparisonCollections = new ComparisonCollections();
        comparisonCollections.testList(1_000_000);
        comparisonCollections.testSet(1_000_000);
        comparisonCollections.testMap(1_000_000);
    }

    public static void testLinkedLists() {
        int numberOfTests = 1_000_000;
        long timeStart;
        long timeElapsed;

        // 1 MyLinkedList
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        // Test add
        timeStart = System.nanoTime();
        for (int i = 0; i < numberOfTests; i++) {
            myLinkedList.add(10);
        }
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Add time to MyLinkedList: " + timeElapsed / 1_000_000 + "ms");
        // Test get
        timeStart = System.nanoTime();
        myLinkedList.get(numberOfTests / 2);
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Get time to MyLinkedList: " + timeElapsed / 1_000_000 + "ms");
        // Test clear
        timeStart = System.nanoTime();
        myLinkedList.clear();
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Clear time to MyLinkedList: " + timeElapsed / 1_000_000 + "ms");

        // 2 LinkedList
        LinkedList<Integer> linkedList = new LinkedList<>();
        // Test add
        timeStart = System.nanoTime();
        for (int i = 0; i < numberOfTests; i++) {
            linkedList.add(10);
        }
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Add time to LinkedList: " + timeElapsed/1_000_000 + "ms");
        // Test get
        timeStart = System.nanoTime();
        linkedList.get(numberOfTests/2);
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Get time to LinkedList: " + timeElapsed/1_000_000 + "ms");
        // Test clear
        timeStart = System.nanoTime();
        linkedList.clear();
        timeElapsed = System.nanoTime() - timeStart;
        System.out.println("Clear time to LinkedList: " + timeElapsed/1_000_000 + "ms");
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
