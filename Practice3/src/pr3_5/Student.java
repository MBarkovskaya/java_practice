package pr3_5;


public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private String groupName;
    private int groupNumber;

    public Student(String firstName, String lastName, String groupName, int groupNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
        this.groupNumber = groupNumber;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    @Override
    public int compareTo(Student student) {
        return this.lastName.compareTo(student.lastName);
    }

}
