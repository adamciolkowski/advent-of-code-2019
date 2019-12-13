package day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    Task1 task = new Task1();

    @Test
    void puzzle() {
        int answer = task.solve("/day2/input.txt");

        assertEquals(4023471, answer);
    }
}