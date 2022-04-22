class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point: (" + x + ", " + y + ")";
    }

    public boolean equals(Point another) {
        if(another.x == x && another.y == y) {
            return true;
        } else {
            return false;
        }
    }

    public double distanceTo(Point another) {
        double diffX = another.x - x;
        double diffY = another.y - y;
        return Math.sqrt(Math.pow(diffX, 2)  + Math.pow(diffY, 2));
    }

    public Point midPoint(Point another) {
        return new Point((x + another.x) / 2, (y + another.y) / 2);
    }

    public double angle(Point another) {
        return Math.atan2(midPoint(another).y, midPoint(another).x);
    }

    public Point moveTo(double angle, double distance) {
        return new Point(x + (distance*Math.cos(angle)), y + (distance*Math.sin(angle)));
    }
}