package day2;

class Task1 {

    public static void main(String[] args) {
        System.out.println(new Task1().solve("/day2/input.txt"));
    }

    int solve(String inputPath) {
        int[] arr = InstructionReader.readInstructions(inputPath);
        arr[1] = 12;
        arr[2] = 2;
        new Intcode().run(arr);
        return arr[0];
    }
}
