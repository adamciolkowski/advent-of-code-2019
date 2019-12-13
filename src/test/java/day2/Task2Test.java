package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    Task2 task = new Task2();

    @Test
    void puzzle() {
        int answer = task.solve("/day2/input.txt", 19690720);

        assertEquals(8051, answer);
    }
}