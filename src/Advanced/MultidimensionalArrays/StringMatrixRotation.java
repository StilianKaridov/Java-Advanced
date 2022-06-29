package Advanced.MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(scanner.nextLine());
        int degree = 0;
        while (matcher.find()) {
            degree = Integer.parseInt(matcher.group());
        }

        //Get the input and store it in ArrayList
        List<String> inputs = new ArrayList<>();
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            inputs.add(command);
            command = scanner.nextLine();
        }

        //Get the max length in the ArrayList
        int maxLength = Integer.MIN_VALUE;
        for (String word : inputs) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        int rows = inputs.size();
        int cols = maxLength;
        //Fill the matrix
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String currentWord = inputs.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        int angleOfRotation = degree % 360;
        //Print the matrix
        switch (angleOfRotation) {
            case 0:
                for (char[] arr : matrix) {
                    for (char current : arr) {
                        System.out.print(current);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < maxLength; col++) {
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = matrix.length - 1; row >= 0; row--) {
                    for (int col = maxLength - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = maxLength - 1; col >= 0; col--) {
                    for (int row = 0; row < matrix.length; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }
}