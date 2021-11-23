package com.andrbezr2016.tasks3.comparisons;

import com.andrbezr2016.tasks3.mycollections.MyLinkedList;
import com.andrbezr2016.tasks3.mytimers.MyTimer;

import java.util.Arrays;
import java.util.LinkedList;

public class ComparisonLists {

    private MyTimer myTimer = new MyTimer();
    private final int[] numbersOfTests = new int[]{10_000, 100_000, 1_000_000};
    private final int numbersOfTestsLength = numbersOfTests.length;
    private final int numberOfTestsAvg = 10;

    public ComparisonLists() {
    }

    public void testLinkedLists() {
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

    private long timeAdd(MyLinkedList<Integer> myLinkedList, int index, Integer element) {
        myTimer.start();
        myLinkedList.add(index, element);
        return myTimer.end();
    }

    private long timeAdd(LinkedList<Integer> linkedList, int index, Integer element) {
        myTimer.start();
        linkedList.add(index, element);
        return myTimer.end();
    }

    private long timeGet(MyLinkedList<Integer> myLinkedList, int index) {
        myTimer.start();
        myLinkedList.get(index);
        return myTimer.end();
    }

    private long timeGet(LinkedList<Integer> linkedList, int index) {
        myTimer.start();
        linkedList.get(index);
        return myTimer.end();
    }

    private long timeIndexOf(MyLinkedList<Integer> myLinkedList, Integer element) {
        myTimer.start();
        myLinkedList.indexOf(element);
        return myTimer.end();
    }

    private long timeIndexOf(LinkedList<Integer> linkedList, Integer element) {
        myTimer.start();
        linkedList.indexOf(element);
        return myTimer.end();
    }

    private long timeRemove(MyLinkedList<Integer> myLinkedList, int index) {
        myTimer.start();
        myLinkedList.remove(index);
        return myTimer.end();
    }

    private long timeRemove(LinkedList<Integer> linkedList, int index) {
        myTimer.start();
        linkedList.remove(index);
        return myTimer.end();
    }
}
