package pr3_4;

import java.util.HashSet;

public class Example4 {
    public static void main(String[] args) {
        Example4 example4 = new Example4();
        HashSet<String> stList = example4.listCreation();
        for (String el:stList) {
            System.out.println(el);
            if(el.startsWith("A")||el.startsWith("E")||el.startsWith("I")||el.startsWith("O")||el.startsWith("U")){
            }
        }
    }

    private HashSet<String> listCreation() {
        HashSet<String> studentSet = new HashSet<>();
        studentSet.add("Ivanov");
        studentSet.add("Petrov");
        studentSet.add("Vasechckin");
        studentSet.add("Bezimyanniy");
        studentSet.add("Juststudent");
     return studentSet;
    }

}
