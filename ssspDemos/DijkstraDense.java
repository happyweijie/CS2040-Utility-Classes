import java.util.Arrays;

/**
 * Dijkstra's algorithm with adjacency matrix
 * instead of a pq, we directly work with the array
 * O(n^2) time complexity, where n is the number of vertices
 */
class DijkstraDense {

    public static final int INF = 1_000_000_000;
    public static void main(String[] args) {

        // Adjacency matrix
        int n = 5; // number of vertices 
        int[][] adjMatrix = {
            {0,3,7,5,0},
            {3,0,2,1,0},
            {7,2,0,4,0},
            {5,1,4,0,0},
            {0,0,0,0,0}
        };

        /* Dijkstra's algorithm */
        // init sssp
        int[] shortestDist = new int[n];
        Arrays.fill(shortestDist, INF);

        // visited array to track which vertices have been finalized
        boolean[] visited = new boolean[n];

        int start = 0; // starting vertex
        shortestDist[start] = 0; // distance from start to itself is 0
        int end = 4; // ending vertex

        // while we haven't visited the end point, keep relaxing edges
        while (!visited[end]) {
            // Find the unvisited vertex with the smallest distance
            int u = -1;
            int minDist = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && shortestDist[i] < minDist){
                    minDist = shortestDist[i];
                    u = i;
                }
            }
            
            // If we didn't find a valid vertex, break
            if (u == -1) {
                break;
            }

            // Mark vertex u as visited/finalized
            visited[u] = true;

            // loop over neighbours of u
            for (int v = 0; v < n; v++) {
                if (!visited[v] && adjMatrix[u][v] != 0) {
                    // relaxation
                    shortestDist[v] = Math.min(
                        shortestDist[v], 
                        shortestDist[u] + adjMatrix[u][v]);
                }
            }
        }

        // print shortest time from start to end
        System.out.println(shortestDist[end] != INF ? shortestDist[end] : "No path exists");
    }
}