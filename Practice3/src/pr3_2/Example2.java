package pr3_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

public class Example2 implements Comparator<Long> {
    public static void main(String[] args) {
        long startTimeLinkedList1 = System.currentTimeMillis();
        Example2 example2 = new Example2();
        example2.linkedListAddMethod();
        long stopTimeLinkedList1 = System.currentTimeMillis();
        long elapsedTimeLinkedList1 = stopTimeLinkedList1 - startTimeLinkedList1;

        long startTimeArrayList1 = System.currentTimeMillis();
        example2.arrayListAddMethod();
        long stopTimeArrayList1 = System.currentTimeMillis();
        long elapsedTimeArrayList1 = stopTimeArrayList1 - startTimeArrayList1;
        System.out.println("the add method takes: " + example2.compare(elapsedTimeArrayList1, elapsedTimeLinkedList1) + " milliseconds");
        System.out.println("======================================");

        long startTimeLinkedList2 = System.currentTimeMillis();
        example2.linkedListReadMethod();
        long stopTimeLinkedList2 = System.currentTimeMillis();
        long elapsedTimeLinkedList2 = stopTimeLinkedList2 - startTimeLinkedList2;

        long startTimeArrayList2 = System.currentTimeMillis();
        example2.arrayListReadMethod();
        long stopTimeArrayList2 = System.currentTimeMillis();
        long elapsedTimeArrayList2 = stopTimeArrayList2 - startTimeArrayList2;
        System.out.println("the read method takes: " + example2.compare(elapsedTimeArrayList2, elapsedTimeLinkedList2) + " milliseconds");
        System.out.println("======================================");

        long startTimeLinkedList3 = System.currentTimeMillis();
        example2.linkedListSetMethod();
        long stopTimeLinkedList3 = System.currentTimeMillis();
        long elapsedTimeLinkedList3 = stopTimeLinkedList3 - startTimeLinkedList3;

        long startTimeArrayList3 = System.currentTimeMillis();
        example2.arrayListSetMethod();
        long stopTimeArrayList3 = System.currentTimeMillis();
        long elapsedTimeArrayList3 = stopTimeArrayList3 - startTimeArrayList3;
        System.out.println("the set method takes: " + example2.compare(elapsedTimeArrayList3, elapsedTimeLinkedList3) + " milliseconds");
        System.out.println("======================================");

        long startTimeLinkedList4 = System.currentTimeMillis();
        example2.linkedListRemoveMethod();
        long stopTimeLinkedList4 = System.currentTimeMillis();
        long elapsedTimeLinkedList4 = stopTimeLinkedList4 - startTimeLinkedList4;

        long startTimeArrayList4 = System.currentTimeMillis();
        example2.arrayListRemoveMethod();
        long stopTimeArrayList4 = System.currentTimeMillis();
        long elapsedTimeArrayList4 = stopTimeArrayList4 - startTimeArrayList4;
        System.out.println("the remove method takes: " + example2.compare(elapsedTimeArrayList4, elapsedTimeLinkedList4) + " milliseconds");
    }

    private LinkedList<String> linkedListAddMethod() {
        String el = "el";
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            linkedList.addFirst(el + i);
        }
        return linkedList;
    }

    private ArrayList<String> arrayListAddMethod() {
        String el = "el";
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, el + i);
        }
        return arrayList;
    }

    private void linkedListReadMethod() {
        LinkedList<String> linkedList = linkedListAddMethod();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
    }

    private void arrayListReadMethod() {
        ArrayList<String> arrayList = arrayListAddMethod();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(i);
        }
    }

    private void linkedListSetMethod() {
        LinkedList<String> linkedList = linkedListAddMethod();
        String el = "element";
        for (int i = 0; i < 100000; i++) {
            linkedList.set(i, el + i);
        }
    }

    private void arrayListSetMethod() {
        ArrayList<String> arrayList = arrayListAddMethod();
        String el = "element";
        for (int i = 0; i < 100000; i++) {
            arrayList.set(i, el + i);
        }
    }

    private void linkedListRemoveMethod() {
        LinkedList<String> linkedList = linkedListAddMethod();
        linkedList.remove(0);
    }

    private void arrayListRemoveMethod() {
        ArrayList<String> arrayList = arrayListAddMethod();
        arrayList.remove(0);
    }

    @Override
    public int compare(Long elapsedTimeArrayList, Long elapsedTimeLinkedList) {
        int result = 0;
        int difference = Math.toIntExact(elapsedTimeArrayList - elapsedTimeLinkedList);
        if (difference < 0) {
            result = Math.toIntExact(elapsedTimeLinkedList);
            System.out.println("linkedList method takes more time than arrayList method which takes: " + elapsedTimeArrayList + " milliseconds");
        } else if (difference > 0) {
            result = Math.toIntExact(elapsedTimeArrayList);
            System.out.println("arrayList method takes more time than linkedList method which takes: " + elapsedTimeLinkedList + " milliseconds");
        } else System.out.println("arrayList method and linkedList method takes equal time");
        return result;
    }

}
