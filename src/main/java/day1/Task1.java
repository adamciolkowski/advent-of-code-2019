package day1;

import java.util.Scanner;

class Task1 {

    public static void main(String[] args) {
        int answer = new Task1().solve("/day1/input.txt");
        System.out.println(answer);
    }

    private int solve(String inputPath) {
        try (Scanner scanner = new Scanner(Task1.class.getResourceAsStream(inputPath))) {
            int total = 0;
            while (scanner.hasNextInt()) {
                int mass = scanner.nextInt();
                total += fuelRequirement(mass);
            }
            return total;
        }
    }

    int fuelRequirement(int mass) {
        return mass / 3 - 2;
    }
}
