package advanced.definingClasses.companyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfEmployees = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>();
        while (numberOfEmployees-- > 0) {

            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String departmentName = data[3];
            Employee employee = null;

            switch (data.length) {
                case 4:
                    employee = new Employee(name, salary, position, departmentName);
                    break;
                case 5:
                    int age;
                    String email;
                    if (data[4].matches("\\d+")) {
                        age = Integer.parseInt(data[4]);
                        employee = new Employee(name, salary, position, departmentName, age);
                    } else {
                        email = data[4];
                        employee = new Employee(name, salary, position, departmentName, email);
                    }
                    break;
                case 6:
                    email = data[4];
                    age = Integer.parseInt(data[5]);
                    employee = new Employee(name, salary, position, departmentName, email, age);
                    break;
            }

            employees.add(employee);
            boolean departmentExists = departmentList.stream().anyMatch(dep -> dep.getName().equals(departmentName));
            if(!departmentExists){
                departmentList.add(new Department(departmentName));
            }
            Department currentDepartment = departmentList.stream().filter(dep -> dep.getName().equals(departmentName)).findFirst().get();
            currentDepartment.getEmployeeList().add(employee);
        }
        Department highestPaidDepartment = departmentList.stream()
                .max(Comparator.comparingDouble(Department::calculateAvgSalary))
                .get();
        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

        highestPaidDepartment.getEmployeeList().stream()
                .sorted((e1,e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(System.out::println);
    }
}
