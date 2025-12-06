class IntegerPair implements Comparable<IntegerPair> {

    private final int weight;
    private final int v;

    public IntegerPair(int weight, int v) {
        this.weight = weight;
        this.v = v;
    }

    public int weight() {
        return this.weight;
    }

    public int v() {
        return this.v;
    }

    @Override
    public int compareTo(IntegerPair other) {
        // order by weight
        if (this.weight - other.weight != 0) {
            return this.weight - other.weight;
        }

        return this.v - other.v;
    }

    @Override
    public String toString() {
        return String.format(
            "IntegerPair[weight=%d, v=%d]", 
            this.weight, this.v);
    }
}
