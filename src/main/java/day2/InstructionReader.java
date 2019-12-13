package day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InstructionReader {

    static int[] readInstructions(String inputPath) {
        List<Integer> instructions = new ArrayList<>();
        try (Scanner scanner = new Scanner(InstructionReader.class.getResourceAsStream(inputPath)).useDelimiter(",")) {
            while (scanner.hasNextInt()) {
                instructions.add(scanner.nextInt());
            }
        }
        return instructions.stream().mapToInt(i -> i).toArray();
    }
}
