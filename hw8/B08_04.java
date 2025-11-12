package hw8;
import java.util.PriorityQueue;

public class B08_04 {
    static class Point {
        double x, y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        // обчислює відстань до центру координат
        public double distanceToOrigin() {
            return Math.sqrt(x * x + y * y);
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        // створюємо чергу з пріоритетом за відстанню до центру
        PriorityQueue<Point> queue = new PriorityQueue<>(
                (p1, p2) -> Double.compare(p1.distanceToOrigin(), p2.distanceToOrigin())
        );

        // додаємо точки
        queue.add(new Point(3, 4));   // відстань 5
        queue.add(new Point(1, 1));   // відстань ≈ 1.41
        queue.add(new Point(0, 2));   // відстань 2
        queue.add(new Point(-2, -2)); // відстань ≈ 2.83
        queue.add(new Point(5, 12));  // відстань 13

        System.out.println("точки у порядку зростання відстані до центру координат:");
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            System.out.printf("%s -> відстань = %.2f%n", p, p.distanceToOrigin());
        }
    }
}

