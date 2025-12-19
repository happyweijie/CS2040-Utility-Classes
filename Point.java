/**
 * Represents a functionally immutable 2D point.
 * Stores the x- and y-coordinates as {@code double} values.
 */
class Point implements Comparable<Point> {
    
    private static final double THRESHOLD = 1E-15;
    private final double x;
    private final double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate of this point.
     * 
     * @return the x-coordinate
     */
    public double x() {
        return this.x;
    }

     /**
     * Returns the y-coordinate of this point.
     * 
     * @return the y-coordinate
     */
    public double y() {
        return this.y;
    }

    /**
     * Returns a new {@link Point} with the x-coordinate set to its absolute value.
     * <p>
     * This point remains unchanged; a new point is returned.
     * 
     * @return a new point with a non-negative x-coordinate
     */
    public Point absoluteX() {
        return new Point(Math.abs(this.x), this.y);
    }

    /**
     * Returns the gradient (slope) from this {@link Point} to the given {@link Point}.
     * <p>
     * If the x-coordinates of both points are equal (difference less than {@link Point#THRESHOLD}),
     * this method returns 0.0 to avoid a division by zero error.
     *
     * @param point the target point
     * @return the gradient from this point to the target point
     */
    public double gradientTo(Point point) {
        // if x coordinates of both points are equal
        if (Math.abs(point.x - this.x) < Point.THRESHOLD) {
            return 0.0;
        }

        return (point.y - this.y) / (point.x - this.x);
    }

    /**
     * Returns the Euclidean (straight-line) distance from 
     * this {@link Point} to the given {@link Point}.
     *
     * @param point the target point
     * @return the straight-line distance to the target point
     */
    public double distanceTo(Point point) {
        // Euclidean distance
        return Math.hypot(point.y - this.y, point.x - this.x);
    }

    /**
     * Returns the Manhattan distance from 
     * this {@link Point} to the given {@link Point}.
     * <p>
     * The Manhattan distance is the sum of the absolute differences of the x- and y-coordinates.
     * It represents the distance traveled along grid lines (like city blocks).
     *
     * @param point the target point
     * @return the Manhattan distance to the target point
     */
    public double manhattanDistanceTo(Point point) {
        // Manhattan distance
        return Math.abs(point.y - this.y) + Math.abs(point.x - this.x);
    }

    /**
     * Compares this point to the specified object for equality.
     * <p>
     * Two points are equal if the absolute difference of 
     * their x- and y-coordinates are within {@link Point#THRESHOLD}.
     *
     * @param o the object to compare with
     * @return true if the points are equal, false otherwise
     */
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

    /**
     * Compares this point with the specified point for order.
     * <p>
     * Points are ordered first by x-coordinate, then by y-coordinate.
     *
     * @param point the point to compare to
     * @return a negative integer, zero, or a positive integer as this point
     *         is less than, equal to, or greater than the specified point
     */
    @Override
    public int compareTo(Point point) {
        // Compare x coords
        if (Math.abs(this.x - point.x) > Point.THRESHOLD) {
            return Double.compare(this.x, point.x);
        }

        // then y coords
        if (Math.abs(this.y - point.y) > Point.THRESHOLD) {
            return Double.compare(this.y, point.y);
        }

        return 0;
    }

    /**
     * Returns a string representation of this point in the format "(x, y)".
     * <p>
     * The x- and y- coordinates are formatted to 3 decimal places.
     *
     * @return the string representation of this point.
     */
    @Override
    public String toString() {
        return String.format("(%.3f, %.3f)", this.x, this.y);
    }
}
