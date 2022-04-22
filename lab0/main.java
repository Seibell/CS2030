import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPoints = sc.nextInt();
        System.out.println("Enter points: ");

        Point[] points = new Point[numOfPoints];

        for (int i = 0; i < numOfPoints; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            points[i] = new Point(x, y);
        }
        
        sc.close();

        int maxPoints = 0;

        for (int i = 0; i < points.length - 1; i++) {
            Point p1 = points[i];

            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];

                Circle circle = createCircle(p1, p2, 1.0);

                if(circle == null)
                    continue;

                int numberOfPointsInCircle = getNumberOfPointsInCircle(circle, points);

                maxPoints = Math.max(numberOfPointsInCircle, maxPoints);
            }
        }

        System.out.println("Maximum disc coverage: " + maxPoints);
    }

    public static Circle createCircle(Point p1, Point p2, double radius) {
        if (p1.equals(p2) || p1.distanceTo(p2) > radius*2) {
            return null;
        }

        Point midPoint = p1.midPoint(p2);
        double mc = Math.sqrt(Math.pow(radius, 2) - Math.pow(midPoint.distanceTo(p2), 2));
        double tetha = midPoint.angle(p2) + Math.PI / 2;
        Point c = midPoint.moveTo(tetha, mc);

        return Circle.getCircle(c, radius);
    }

    public static int getNumberOfPointsInCircle(Circle circle, Point[] points) {
        int numOfPoints = 0;

        for (int i = 0; i < points.length; i++) {
            Point point = points[i];

            if(circle.containsPoint(point)) {
                numOfPoints++;
            }
        }
        return numOfPoints;
    }
}