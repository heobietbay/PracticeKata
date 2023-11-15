package leetcode.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points construct a square.
 * 	The coordinate of a point pi is represented as [xi, yi]. The input is not given in any order.
 * 	A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 *
 * 	Example 1:
 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 Output: true

 * 	Example 2:
 Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 Output: false

 * 	Example 3:
 Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 Output: true
 */
public class ValidSquare {
    public static void main(String[] args) {
        boolean isValid = validSquare(
                new Point(new int[]{0,0}),
                new Point(new int[]{1,1}),
                new Point(new int[]{1,0}),
                new Point(new int[]{0,1}));
        System.out.println(isValid);

        isValid = validSquare(
                new Point(new int[]{0,0}),
                new Point(new int[]{1,1}),
                new Point(new int[]{1,0}),
                new Point(new int[]{0,12}));
        System.out.println(isValid);

        isValid = validSquare(
                new Point(new int[]{1,0}),
                new Point(new int[]{-1,0}),
                new Point(new int[]{0,1}),
                new Point(new int[]{0,-1}));
        System.out.println(isValid);
    }

    // https://www.splashlearn.com/math-vocabulary/diagonal-of-a-square#:~:text=A%20square%20has%20two%20diagonals,each%20other%20at%20right%20angles.

    /**
     * A square by definition should have 4 equal sides, also, 2 diagonal squares must have same len
     * So we should have only 2 distances, 1 is for the side, 1 is for diagonal square
     * @param point1
     * @param point2
     * @param point3
     * @param point4
     * @return
     */
    private static boolean validSquare(Point point1, Point point2, Point point3, Point point4) {
        Set<Double> distances = new HashSet<>();
        distances.add(point1.distance(point2));
        distances.add(point1.distance(point3));
        distances.add(point1.distance(point4));
        distances.add(point2.distance(point3));
        distances.add(point2.distance(point4));
        distances.add(point3.distance(point4));

        return distances.size() == 2;
    }

    public static class Point {

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public double distance(Point p) {
            return Math.sqrt(Math.pow(x - p.x,2) + Math.pow(y - p.y,2));
        }

        public boolean isVerticalAlign(Point b) {
            return x == b.x;
        }

        public boolean isHorizontalAlign(Point b) {
            return y == b.y;
        }


        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int[] coordinates) {
            this.x = coordinates[0];
            this.y = coordinates[1];
        }

        int x;
        int y;
    }
}
