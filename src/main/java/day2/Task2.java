package day2;

class Task2 {

    public static void main(String[] args) {
        System.out.println(new Task2().solve("/day2/input.txt", 19690720));
    }

    int solve(String inputPath, int expectedOutput) {
        int[] arr = InstructionReader.readInstructions(inputPath);

        for (int noun = 0; noun < 100; noun++) {
            for (int verb = 0; verb < 100; verb++) {
                int[] memory = arr.clone();
                memory[1] = noun;
                memory[2] = verb;
                new Intcode().run(memory);
                if (memory[0] == expectedOutput) {
                    return 100 * noun + verb;
                }
            }
        }
        throw new IllegalStateException();
    }
}
