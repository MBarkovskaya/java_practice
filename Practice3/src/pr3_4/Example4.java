package pr3_4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Example4 {
    public static void main(String[] args) {
        Example4 example4 = new Example4();
        HashSet<String> stSet = example4.setCreation();
        for (String el : stSet) {
            System.out.println(el);
        }
        for (Iterator<String> i = stSet.iterator(); i.hasNext(); ) {
            String el = i.next();
            if (el.startsWith("A") || el.startsWith("E") || el.startsWith("I") || el.startsWith("O") || el.startsWith("U")) {
                i.remove();
            }
        }
        System.out.println(stSet);

        System.out.println("==========================");

        TreeSet<String> stGroup = example4.groupCreation();
        for (String el : stGroup) {
            System.out.println(el);
        }

        Iterator<String> iterator = stGroup.iterator();
        for (int i = 0; i < 5; i++) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
            }
        }
        System.out.println(stGroup);
    }

    private HashSet<String> setCreation() {
        HashSet<String> studentSet = new HashSet<>();
        studentSet.add("Ivanov");
        studentSet.add("One");
        studentSet.add("Petrov");
        studentSet.add("Vasechckin");
        studentSet.add("Bezimyanniy");
        studentSet.add("Juststudent");
        return studentSet;
    }

    private TreeSet<String> groupCreation() {
        TreeSet<String> stGroup = new TreeSet<>();
        stGroup.add("Ivanov");
        stGroup.add("Baranov");
        stGroup.add("Azarov");
        stGroup.add("Doe");
        stGroup.add("Erofeev");
        stGroup.add("Chebotarev");
        stGroup.add("Chan");
        stGroup.add("You");
        stGroup.add("Verzin");
        stGroup.add("Trofimov");
        stGroup.add("Word");
        stGroup.add("Ford");
        stGroup.add("Nord");
        stGroup.add("Yard");
        stGroup.add("Metr");
        stGroup.add("Orehov");
        stGroup.add("Matveev");
        return stGroup;
    }
}
