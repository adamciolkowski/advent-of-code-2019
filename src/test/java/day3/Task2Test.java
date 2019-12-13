package day3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task2Test {

    Task2 task = new Task2();

    @ParameterizedTest
    @MethodSource("args")
    void test(String inputPath, int answer) {
        assertEquals(answer, task.solve(inputPath));
    }

    private static List<Arguments> args() {
        return Arrays.asList(
                Arguments.of("/day3/sample0.txt", 30),
                Arguments.of("/day3/sample1.txt", 610),
                Arguments.of("/day3/sample2.txt", 410),
                Arguments.of("/day3/input.txt", 13698)
        );
    }
}