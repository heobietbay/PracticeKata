package core;

import java.util.HashSet;
import java.util.Set;

public class Equality {

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(1,1);

        // 1: a should equal b
        System.out.println(p1.equals(p2));
        // 2: b should equal a (cause 1)
        System.out.println(p2.equals(p1));

        Set<Point> pointSet = new HashSet<>();
        pointSet.add(p1);
        pointSet.add(p2);

        System.out.println(pointSet.contains(p1));
        // now change p1.x, lets see
        p1.x = 7;
        // this will print false!!!, reason is Set store the initial hash code value upon adding element
        // needs to be extra careful, when hashcode relies on muttable field, in this case the "x" property
        System.out.println(pointSet.contains(p1));
    }

    static class Point
    {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
