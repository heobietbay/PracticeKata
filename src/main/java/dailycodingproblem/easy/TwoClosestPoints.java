package dailycodingproblem.easy;

import java.util.*;

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
        System.out.println(twoClosestPoints);


        pointList = new ArrayList<>();
        pointList.add(new Point(1,1));
        pointList.add(new Point(1,2));
        pointList.add(new Point(2,3));
        pointList.add(new Point(3,4));
        pointList.add(new Point(1,0));
        pointList.add(new Point(1,-1));
        pointList.add(new Point(-2,3));
        pointList.add(new Point(-2,1));
        pointList.add(new Point(3,2));

        twoClosestPoints = solution(pointList);
        System.out.println(twoClosestPoints);
    }

    // TODO: do more unit test
    /**
     * <a>https://en.wikipedia.org/wiki/Closest_pair_of_points_problem</a>
     * My approach is to sort the points by comparing the distance of each point to the base (0,0) point.
     *
     * @param pointList
     * @return
     */
    public static List<Point> solution(List<Point> pointList) {

        Collections.sort(pointList,
                Comparator.comparingDouble(Point::distanceFromBase)
                          .thenComparing(point -> point.x));

        //TODO: NOT done yet
        return Arrays.asList(pointList.get(0), pointList.get(1));
    }

    static class Point {

        static Point G_POINT = new Point(0,0);

        public double distanceFromBase(){
            return distanceFromPoint(G_POINT);
        }
        public double distanceFromPoint(Point otherP){
            double tmp = Math.pow((x - otherP.x),2) + Math.pow((y - otherP.y),2);
            return Math.sqrt(tmp);
        }

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

        @Override
        public String toString() {
            return "[" +
                     x +
                    "," + y +
                    ']';
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int x;
        public int y;

    }
}
