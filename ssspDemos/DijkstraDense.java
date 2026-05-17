import java.util.Arrays;

/**
 * Dijkstra's algorithm for dense graphs.
 * <p>
 * Instead of a pq, we directly work with the array
 * O(n^2) time complesxity, where n is the number of vertices.
 */
class DijkstraDense {

    private static final int INF = 1_000_000_000;
    
    public static void main(String[] args) {

        // Adjacency matrix representation of the graph
        // Can use adjacency list as well, but for dense graphs, matrix is more efficient
        int[][] adjMatrix = {
            {0, 3, 7, 5, 0},
            {3, 0, 2, 1, 0},
            {7, 2, 0, 4, 0},
            {5, 1, 4, 0, 0},
            {0, 0, 0, 0, 0}
        };

        int start = 0; 
        int end = 2; 

        // Run Dijkstra's algorithm
        int dist = dijkstra(adjMatrix, start, end);
        System.out.println(dist == INF ? "No path exists" : dist);
    }

    /* Dijkstra's algorithm */
    public static int dijkstra(int[][] graph, int start, int end) {
        // number of vertices in the graph
        int n = graph.length;

        // init sssp
        int[] shortestDist = new int[n];
        Arrays.fill(shortestDist, INF);
        shortestDist[start] = 0;

        // visited array to track which vertices have been finalized
        boolean[] visited = new boolean[n];

        while (!visited[end]) {
            // Find the unvisited vertex with the smallest shortestDist
            int u = -1;
            int minDist = INF;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && shortestDist[i] < minDist){
                    u = i;
                    minDist = shortestDist[i];
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
                if (!visited[v] && graph[u][v] != 0) {
                    // relaxation
                    shortestDist[v] = Math.min(
                        shortestDist[v], 
                        shortestDist[u] + graph[u][v]);
                }
            }
        }

        return shortestDist[end]; 
    }
}