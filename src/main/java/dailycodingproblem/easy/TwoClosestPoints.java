package dailycodingproblem.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This problem was asked by Google.
 <p>
 * Given a set of points (x, y) on a 2D cartesian plane, find the two closest points.
 * For example, given the points <font color='blue'>[(1, 1), (-1, -1), (3, 4), (6, 1), (-1, -6), (-4, -3)]</font> , return <b>[(-1, -1), (1, 1)]</b>.
 </p>
 */
public class TwoClosestPoints {

    public static void main(String[] args) {

        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(1,1));
        pointList.add(new Point(-1,-1));
        pointList.add(new Point(3,4));
        pointList.add(new Point(6,1));
        pointList.add(new Point(-1,-6));
        pointList.add(new Point(-4,-3));

        List<Point> twoClosestPoints = solution(pointList);
    }

    private static List<Point> solution(List<Point> pointList) {
        return null;
    }

    static class Point {

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;

    }
}
