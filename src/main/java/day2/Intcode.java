package day2;

class Intcode {

    void run(int[] arr) {
        int i = 0;
        while (true) {
            int opcode = arr[i];
            switch (opcode) {
                case 1: {
                    int arg1 = read(arr, i + 1);
                    int arg2 = read(arr, i + 2);
                    write(arr, i + 3, arg1 + arg2);
                    i += 4;
                    break;
                }
                case 2: {
                    int arg1 = read(arr, i + 1);
                    int arg2 = read(arr, i + 2);
                    write(arr, i + 3, arg1 * arg2);
                    i += 4;
                    break;
                }
                case 99:
                    return;
            }
        }
    }

    private int read(int[] arr, int i) {
        return arr[arr[i]];
    }

    private void write(int[] arr, int i, int val) {
        arr[arr[i]] = val;
    }
}
