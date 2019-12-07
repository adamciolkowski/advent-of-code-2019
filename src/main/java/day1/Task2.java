package day1;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        int answer = solve("/day1/input.txt");
        System.out.println(answer);
    }

    private static int solve(String inputPath) {
        try (Scanner scanner = new Scanner(Task2.class.getResourceAsStream(inputPath))) {
            int total = 0;
            while (scanner.hasNextInt()) {
                int mass = scanner.nextInt();
                total += fuelRequirement(mass);
            }
            return total;
        }
    }

    private static int fuelRequirement(int moduleMass) {
        int sum = 0;
        int mass = moduleMass;
        int fuel;
        while ((fuel = mass / 3 - 2) > 0) {
            sum += fuel;
            mass = fuel;
        }
        return sum;
    }
}
