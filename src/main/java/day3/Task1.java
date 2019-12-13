package day3;

import java.awt.Point;
import java.util.*;

import static java.util.Comparator.comparingInt;

class Task1 {

    public static void main(String[] args) {
        System.out.println(new Task1().solve("/day3/input.txt"));
    }

    int solve(String path) {
        List<String[]> wirePaths = new ArrayList<>();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(path))) {
            while (scanner.hasNextLine()) {
                String wirePath = scanner.nextLine();
                wirePaths.add(wirePath.split(","));
            }
        }

        Set<Point> wire1Ports = walkGrid(wirePaths.get(0));
        Set<Point> wire2Ports = walkGrid(wirePaths.get(1));

        Set<Point> intersection = intersection(wire1Ports, wire2Ports);
        intersection.remove(new Point(0, 0));

        Point closestIntersection = Collections.min(intersection, comparingInt(this::manhattanDistanceToCenter));
        return manhattanDistanceToCenter(closestIntersection);
    }

    private int manhattanDistanceToCenter(Point port) {
        return Math.abs(port.x) + Math.abs(port.y);
    }

    private static Set<Point> walkGrid(String[] wirePath) {
        Set<Point> ports = new HashSet<>();
        int x = 0;
        int y = 0;
        for (String instruction : wirePath) {
            int length = Integer.parseInt(instruction.substring(1));
            switch (instruction.charAt(0)) {
                case 'R':
                    for (int target = x + length; x < target; x++) {
                        ports.add(new Point(x, y));
                    }
                    break;
                case 'D':
                    for (int target = y - length; y > target; y--) {
                        ports.add(new Point(x, y));
                    }
                    break;
                case 'U':
                    for (int target = y + length; y < target; y++) {
                        ports.add(new Point(x, y));
                    }
                    break;
                case 'L':
                    for (int target = x - length; x > target; x--) {
                        ports.add(new Point(x, y));
                    }
                    break;
            }
        }
        return ports;
    }

    private Set<Point> intersection(Set<Point> a, Set<Point> b) {
        Set<Point> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
}
