class PointTriple implements Comparable<PointTriple> {
    private static final double THRESHOLD = 1E-15;
    private final Point u;
    private final Point v;
    private final double weight;

    public PointTriple(Point u, Point v, double weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public Point u() {
        return this.u;
    }

    public Point v() {
        return this.v;
    }

    public double weight() {
        return this.weight;
    }

    @Override
    public int compareTo(PointTriple other) {
        // compare by weight
        if (Math.abs(this.weight - other.weight) > THRESHOLD) {
            return Double.compare(this.weight, other.weight);
        }
        
        // then compare by u
        if (this.u.compareTo(other.u) != 0) {
            return this.u.compareTo(other.u);
        }

        // the finally v
        return this.v.compareTo(other.v);
    }

    @Override
    public String toString() {
        return String.format(
            "PointTriple[u=%s, v=%s, weight=%.3f]", 
            this.u, this.v, this.weight);
    }
}
