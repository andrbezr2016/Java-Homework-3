package com.andrbezr2016.tasks3;

import com.andrbezr2016.tasks3.comparisons.ComparisonCollections;
import com.andrbezr2016.tasks3.comparisons.ComparisonLists;
import com.andrbezr2016.tasks3.mycollections.MyLinkedList;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        testMyLinkedList();
//        ComparisonLists comparisonLists = new ComparisonLists();
//        comparisonLists.testLinkedLists();
//        ComparisonCollections comparisonCollections = new ComparisonCollections();
//        comparisonCollections.testList();
//        comparisonCollections.testSet();
//        comparisonCollections.testMap();
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
        Number[] numbers1 = myLinkedList.toArray(new Number[0]);
        System.out.println(numbers1.getClass());
        System.out.println(Arrays.toString(numbers1));
        Object[] integers2 = myLinkedList.toArray();
        System.out.println(integers2.getClass());
        System.out.println(Arrays.toString(integers2));
        // Test clear
        System.out.println("==Test clear==");
        myLinkedList.clear();
        System.out.printf("List: %s, size: %s\n", myLinkedList, myLinkedList.size());
    }
}
