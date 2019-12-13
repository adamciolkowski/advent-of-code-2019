package day3;

import java.awt.Point;
import java.util.*;

class Task2 {

    public static void main(String[] args) {
        System.out.println(new Task2().solve("/day3/input.txt"));
    }

    int solve(String path) {
        List<String[]> wirePaths = new ArrayList<>();
        try (Scanner scanner = new Scanner(getClass().getResourceAsStream(path))) {
            while (scanner.hasNextLine()) {
                String wirePath = scanner.nextLine();
                wirePaths.add(wirePath.split(","));
            }
        }

        List<Point> wire1Ports = walkGrid(wirePaths.get(0));
        List<Point> wire2Ports = walkGrid(wirePaths.get(1));

        Set<Point> intersections = intersection(wire1Ports, wire2Ports);
        intersections.remove(new Point(0, 0));

        Map<Point, Integer> distances = new HashMap<>();
        stepsToFirstIntersection(distances, wire1Ports, intersections);
        stepsToFirstIntersection(distances, wire2Ports, intersections);
        return Collections.min(distances.values());
    }

    private void stepsToFirstIntersection(Map<Point, Integer> distances,
                                          List<Point> wirePath,
                                          Set<Point> intersections) {
        for (int i = 0; i < wirePath.size(); i++) {
            Point port = wirePath.get(i);
            if (intersections.contains(port)) {
                distances.merge(port, i, Integer::sum);
            }
        }
    }

    private static List<Point> walkGrid(String[] wirePath) {
        List<Point> ports = new ArrayList<>();
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

    private Set<Point> intersection(Collection<Point> a, Collection<Point> b) {
        Set<Point> result = new HashSet<>(a);
        result.retainAll(new HashSet<>(b));
        return result;
    }
}
