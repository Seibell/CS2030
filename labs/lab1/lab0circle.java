class Circle {
    private double radius;
    private Point centre;

    private Circle(Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public static Circle getCircle(Point centre, double radius) {
        if (radius <= 0) {
            return null;

        }
        return new Circle(centre, radius);
    }

    public boolean containsPoint(Point point) {
        return centre.distanceTo(point) <= radius;
    }
}