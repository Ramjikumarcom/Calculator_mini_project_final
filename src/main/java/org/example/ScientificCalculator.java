package org.example;

import java.util.Scanner;

public class ScientificCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Scientific Calculator!");
        System.out.println("Choose an operation:");
        System.out.println("1. Square Root (√x)");
        System.out.println("2. Factorial (x!)");
        System.out.println("3. Natural Logarithm (ln(x))");
        System.out.println("4. Power Function (x^b)");
        System.out.println("5. Exit");

        while (true) {
            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            System.out.print("Enter a number: ");
            double num = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + squareRoot(num));
                    break;
                case 2:
                    System.out.println("Result: " + factorial((int) num));
                    break;
                case 3:
                    System.out.println("Result: " +  naturalLogarithm(num));
                    break;
                case 4:
                    System.out.print("Enter the exponent (b): ");
                    double exponent = scanner.nextDouble();
                    System.out.println("Result: " + power(num, exponent));
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    public static long factorial(int n) {
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static double squareRoot(double i) {
      return  Math.sqrt(i);

    }

    public static double naturalLogarithm(double i) {
        return Math.log(i);
    }

    public static double power(double i, double i1) {
        return (int) Math.pow(i, i1);
    }
}
