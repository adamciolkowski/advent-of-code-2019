package day1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {

    Task1 task = new Task1();

    @ParameterizedTest
    @MethodSource("args")
    void test(int moduleMass, int requiredFuel) {
        assertEquals(task.fuelRequirement(moduleMass), requiredFuel);
    }

    private static List<Arguments> args() {
        return Arrays.asList(
                Arguments.of(12, 2),
                Arguments.of(14, 2),
                Arguments.of(1969, 654),
                Arguments.of(100756, 33583)
        );
    }
}