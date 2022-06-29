package Advanced.DefiningClasses.CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String getName() {
        return name;
    }

    public void addEmployee(Employee e) {
        this.employeeList.add(e);
    }

    public double calculateAvgSalary(){
        return employeeList.stream().mapToDouble(Employee::getSalary).average().getAsDouble();
    }
}
