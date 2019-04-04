package pr3_extra;

public class Employee implements Comparable<Employee> {
    private String name;
    private String surname;
    private int id;
    private float salary;

    public Employee(String name, String surname, int id, float salary) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.salary = salary;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.id, o.id);
    }
}
