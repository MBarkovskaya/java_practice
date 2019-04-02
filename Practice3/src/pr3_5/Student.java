package pr3_5;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String groupName;
    private int groupNumber;

    public Student(String firstName, String lastName, String groupName, int groupNumber) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return groupNumber == student.groupNumber &&
                firstName.equals(student.firstName) &&
                lastName.equals(student.lastName) &&
                groupName.equals(student.groupName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, groupName, groupNumber);
    }

    @Override
    public int compareTo(Student student) {
        return this.lastName.compareTo(student.lastName) ;
    }
}
