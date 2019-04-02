package pr3_5;

import java.util.HashSet;
import java.util.TreeSet;

public class Example5{

    public static void main(String[] args) {
        Example5 example5 = new Example5();
        HashSet<Student> studentsInfo = example5.studentsInfoCreation();
        Student student = new Student("Fedor", "Ivanov", "A", 11);
        boolean containsTrue = studentsInfo.contains(student);
        studentsInfo.remove(student);
        boolean containsFalse = studentsInfo.contains(student);
        System.out.println("containsTrue is " + containsTrue + ", containsFalse is " + containsFalse);
        System.out.println("=================");

        TreeSet<Student> students = example5.studentsSetCreation();
//        Collections.sort();
    }

    private HashSet<Student> studentsInfoCreation() {
        HashSet<Student> stGroup = new HashSet<>();
        stGroup.add(new Student("Fedor", "Ivanov", "A", 11));
        stGroup.add(new Student("Fedor", "Baranov", "A", 11));
        stGroup.add(new Student("Fedor", "Azarov", "A", 11));
        stGroup.add(new Student("Fedor", "Doe", "A", 11));
        stGroup.add(new Student("Fedor", "Erofeev", "A", 11));
        stGroup.add(new Student("Fedor", "Chebotarev", "A", 11));
        stGroup.add(new Student("Fedor", "Chan", "A", 11));
        stGroup.add(new Student("Fedor", "You", "A", 11));
        stGroup.add(new Student("Fedor", "Verzin", "A", 11));
        stGroup.add(new Student("Fedor", "Trofimov", "A", 11));
        stGroup.add(new Student("Fedor", "Word", "A", 11));
        stGroup.add(new Student("Fedor", "Ford", "A", 11));
        stGroup.add(new Student("Fedor", "Nord", "A", 11));
        stGroup.add(new Student("Fedor", "Yard", "A", 11));
        stGroup.add(new Student("Fedor", "Metr", "A", 11));
        stGroup.add(new Student("Fedor", "Orehov", "A", 11));
        stGroup.add(new Student("Fedor", "Matveev", "A", 11));
        return stGroup;
    }

    private TreeSet<Student> studentsSetCreation() {
        TreeSet<Student> stGroup = new TreeSet<>();
        stGroup.add(new Student("Ivan", "Ivanov", "A", 11));
        stGroup.add(new Student("Zahar", "Baranov", "A", 11));
        stGroup.add(new Student("Dmitry", "Azarov", "A", 11));
        stGroup.add(new Student("John", "Doe", "A", 11));
        stGroup.add(new Student("Bob", "Erofeev", "A", 11));
        stGroup.add(new Student("Alex", "Chebotarev", "A", 11));
        stGroup.add(new Student("Lee", "Chan", "A", 11));
        stGroup.add(new Student("Lee", "Kwang", "A", 11));
        stGroup.add(new Student("Pavel", "Verzin", "A", 11));
        stGroup.add(new Student("Nelly", "Trofimova", "A", 11));
        stGroup.add(new Student("Zeina", "Word", "A", 11));
        stGroup.add(new Student("Emma", "Ford", "A", 11));
        stGroup.add(new Student("Zac", "Nord", "A", 11));
        stGroup.add(new Student("Dennis", "Yard", "A", 11));
        stGroup.add(new Student("Olga", "Korkina", "A", 11));
        stGroup.add(new Student("Harry", "Orehov-Zuev", "A", 11));
        stGroup.add(new Student("Igor", "Matveev", "A", 11));
        return stGroup;
    }
}
