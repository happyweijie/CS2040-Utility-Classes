class Point implements Comparable<Point> {
    
    private static final double THRESHOLD = 1E-15;
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public Point absoluteX() {
        return new Point(Math.abs(this.x), this.y);
    }

    public double gradientTo(Point point) {
        // if x coordinates of both points are equal
        if (Math.abs(point.x - this.x) < Point.THRESHOLD) {
            return 0.0;
        }

        return (point.y - this.y) / (point.x - this.x);
    }

    public double distanceTo(Point point) {
        // Euclidean distance
        return Math.hypot(point.y - this.y, point.x - this.x);
    }

    public double manhattanDistanceTo(Point point) {
        // Manhattan distance
        return Math.abs(point.y - this.y) + Math.abs(point.x - this.x);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o instanceof Point point) {
            return Math.abs(point.x - this.x) < Point.THRESHOLD &&
               Math.abs(point.y - this.y) < Point.THRESHOLD;
        }

        return false;
    }

    @Override
    public int compareTo(Point point) {
        // Compare x coords
        if (Math.abs(this.x - point.x) > Point.THRESHOLD) {
            return Double.compare(this.x, point.x);
        }

        // then y coords
        if (Math.abs(this.y - point.y) <= Point.THRESHOLD) {
            return 0;
        }
        return Double.compare(this.y, point.y);
    }

    @Override
    public String toString() {
        return String.format("(%.3f, %.3f)", this.x, this.y);
    }
}
