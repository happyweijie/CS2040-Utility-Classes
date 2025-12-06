class IntegerTriple implements Comparable<IntegerTriple> {

    private final int weight;
    private final int u;
    private final int v;

    public IntegerTriple(int weight, int u, int v) {
        this.weight = weight; // weight of edges
        this.u = u; // starting vertex
        this.v = v; // ending vertex
    }

    public int weight() {
        return this.weight;
    }

    public int u() {
        return this.u;
    }

    public int v() {
        return this.v;
    }

    @Override
    public int compareTo(IntegerTriple other) {
        // compare by weight
        int weightComp = this.weight - other.weight;
        if (weightComp != 0) {
            return weightComp;
        }

        // then by u
        int uComp = this.u - other.u;
        if (uComp != 0) {
            return uComp;
        }

        // then by v
        return this.v - other.v;
    }

    @Override
    public String toString() {
        return String.format(
            "IntegerTriple[weight=%d, u=%d, v=%d]", 
            this.weight, this.u, this.v);
    }
}