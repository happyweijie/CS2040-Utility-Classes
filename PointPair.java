class PointPair implements Comparable<PointPair> {
    private final static double THRESHOLD = 1E-15;
    private final double weight;
    private final Point v;

    public PointPair(double weight, Point v) {
        this.weight = weight;
        this.v = v;
    }

    public double weight() {
        return this.weight;
    }

    public Point v() {
        return this.v;
    }

    @Override
    public int compareTo(PointPair other) {
        // compare by weights first
        if (Math.abs(this.weight - other.weight) > THRESHOLD) {
            return Double.compare(this.weight, other.weight);
        }

        // then by point as a tiebreaker
        return this.v.compareTo(other.v);
    }

    @Override
    public String toString() {
        return String.format("PointPair[weight=%.3f, v=%s]", this.weight, this.v);
    }
}
