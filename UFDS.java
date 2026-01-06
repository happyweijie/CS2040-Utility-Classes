// Adapted from the CS2040 Teaching Team
import java.util.*;

class UFDS {

    private int[] p;
    private int[] rank;
    private int[] size;
    private int[] sum;
    int count;

    public UFDS(int N) {
        p = new int[N];
        rank = new int[N];
        size = new int[N];
        sum = new int[N];
        count = N;

        for (int i = 0; i < N; i++) {
            p[i] = i;
            rank[i] = 0;
            size[i] = 1;
            sum[i] = i;
        }
    }

    public int findSet(int i) {
        if (p[i] == i) {
            return i;
        } else {
            p[i] = findSet(p[i]);
            return p[i];
        }
    }

    public Boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    public int size(int i) {
        return size[findSet(i)];
    }

    // Kruskal Optimisation
    public int countSets() {
        return count;
    }

    public void unionSet(int i, int j) {
        if (!isSameSet(i, j)) {
            int x = findSet(i), y = findSet(j);
            
            if (rank[x] > rank[y]) {
                p[y] = x;
                size[x] += size[y];
                sum[x] += sum[y];
            } else {
                p[x] = y;
                if (rank[x] == rank[y]) {
                    rank[y] = rank[y] + 1;
                }
                size[y] += size[x];
                sum[y] += sum[x];
            }
        }

        count--;
    }

    // For Debugging/Visualisation Only
    public List<List<Integer>> viewSets() {
        Map<Integer, List<Integer>> sets = new HashMap<>();
        for (int i = 0; i < p.length; i++) {
            int root = findSet(i);
            sets.computeIfAbsent(root, key -> new ArrayList<>())
                .add(i);
        }
        return sets.values().stream().toList();
    }
}
