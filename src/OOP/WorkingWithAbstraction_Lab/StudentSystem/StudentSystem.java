package OOP.WorkingWithAbstraction_Lab.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> studentsByName;

    public StudentSystem() {
        this.studentsByName = new HashMap<>();
    }

    public Map<String, Student> getStudentsByName() {
        return this.studentsByName;
    }

    public void ParseCommand(String[] commands) {
        String command = commands[0];
        String name = commands[1];

        if (command.equals("Create")) {
            int age = Integer.parseInt(commands[2]);
            double grade = Double.parseDouble(commands[3]);

            if (!studentsByName.containsKey(name)) {
                Student student = new Student(name, age, grade);
                studentsByName.put(name, student);
            }

        } else if (command.equals("Show")) {
            Student student = studentsByName.get(name);

            if (student != null) {
                System.out.println(student.getInfo());
            }
        }
    }
}