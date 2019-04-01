package pr3_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Example1 {

    public static void main(String[] args) {
        Example1 example1 = new Example1();
        ArrayList<String> list = example1.firstJob(10);
        for (String el : list) {
            System.out.println(el);
        }
    }

    private ArrayList<String> getList(int num) {
        ArrayList<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < num; i++) {
            System.out.println("Write text: ");
            list.add(sc.nextLine());
        }
        return list;
    }

    private ArrayList<String> firstJob(int num) {
        ArrayList<String> list = getList(10);
        ArrayList<String> list2 = getList(5);

        for (int i = 0; i < 15; i++) {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }
        for (int i = 0; i < 5; i++) {
            list.set(i + 5, list2.get(i));
        }
        return list;
    }

}