package advanced.setsAndMapsAdvanced_Lab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> students = new TreeMap<>();

        int numbersOfStudents = Integer.parseInt(scanner.nextLine());
        while (numbersOfStudents-- > 0) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble).collect(Collectors.toList());

            students.put(name, grades);
        }

        for (Map.Entry<String, List<Double>> student : students.entrySet()) {
            DecimalFormat format = new DecimalFormat("0.##################################################");
            double average = 0.0;
            for (double grade : student.getValue()) {
                average += grade;
            }
            average /= student.getValue().size();
            System.out.printf("%s is graduated with %s%n", student.getKey(), format.format(average));
        }

    }
}