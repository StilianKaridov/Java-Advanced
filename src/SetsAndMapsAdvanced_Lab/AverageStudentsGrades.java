package SetsAndMapsAdvanced_Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, ArrayList<Double>> students = new TreeMap<>();

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        while (numberOfStudents-- > 0) {
            String[] data = scanner.nextLine().split(" ");
            ArrayList<Double> grades = new ArrayList<>();
            String name = data[0];
            double grade = Double.parseDouble(data[1]);

            if (students.containsKey(name)) {
                grades = students.get(name);
            }
            grades.add(grade);
            students.put(name, grades);
        }

        for (Map.Entry<String, ArrayList<Double>> entry : students.entrySet()) {
            ArrayList<Double> grades = entry.getValue();

            int countGrades = 0;
            double average = 0;

            for (Double grade : grades) {
                average += grade;
                countGrades++;
            }

            average /= countGrades;

            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), getGradesFromList(entry.getValue()), average);
        }
    }

    public static String getGradesFromList(List<Double> grades) {
        return grades.stream().map(g -> String.format("%.2f", g))
                .collect(Collectors.joining(" "));
    }
}