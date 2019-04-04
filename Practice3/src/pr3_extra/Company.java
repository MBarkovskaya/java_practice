package pr3_extra;

import java.util.Comparator;
import java.util.TreeSet;

public class Company {
    private String address;
    private String name;

    public static void main(String[] args) {
        Company company = new Company();
        company.method1();
        System.out.println("====================");
        company.method2();
        System.out.println("====================");
        company.method3();
    }

    private void method1() {
        TreeSet<Employee> set1 = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee employee1) {
                int compareResult = employee.getSurname().compareTo(employee1.getSurname());
                if (compareResult == 0) {
                    compareResult= employee.getName().compareTo(employee1.getName());
                }
                return compareResult;
            }
        });
        dataTreeSetGenerator(set1);
        for (Employee employee : set1) {
            System.out.println(employee.getSurname() + " " + employee.getName());
        }
    }

    private void method2() {
        TreeSet<Employee> set2 = new TreeSet<>();
        dataTreeSetGenerator(set2);
        for (Employee employee : set2) {
            System.out.println(employee.getId());
        }
    }

    private void method3() {
        TreeSet<Employee> set3 = new TreeSet<>(new EmployeeComparator());
        dataTreeSetGenerator(set3);
        for (Employee employee : set3) {
            System.out.println(employee.getSalary());
        }
    }


    private void dataTreeSetGenerator(TreeSet<Employee> set) {
        set.add(new Employee("Ivan", "Ivanov", 1, 1100.25f));
        set.add(new Employee("Zahar", "Baranov", 4, 1800.15f));
        set.add(new Employee("Ivan", "Baranov", 3, 4100.05f));
        set.add(new Employee("Dmitry", "Azarov", 8, 2100.95f));
    }

}
