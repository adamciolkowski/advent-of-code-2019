package day1;

import java.util.Scanner;

class Task2 {

    public static void main(String[] args) {
        System.out.println(new Task2().solve("/day1/input.txt"));
    }

    private int solve(String inputPath) {
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(inputPath))) {
            int total = 0;
            while (scanner.hasNextInt()) {
                int mass = scanner.nextInt();
                total += fuelRequirement(mass);
            }
            return total;
        }
    }

    int fuelRequirement(int moduleMass) {
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
