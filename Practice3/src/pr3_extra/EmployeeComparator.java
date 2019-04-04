package pr3_extra;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee employee, Employee employee1) {
        return Float.compare(employee1.getSalary(), employee.getSalary());
    }
}
