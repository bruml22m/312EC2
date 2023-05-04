public class FloydWarshall {

    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = { {0, 5, 4, 9},
                          {5, 0, 3, 6},
                          {4, 3, 0, 2},
                          {9, 6, 2, 0} };

        int[][] dist = new int[graph.length][graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                dist[i][j] = INF;
            }
        }

        memoizedFloydWarshall(graph, dist);
        printDistances(dist);
    }

    public static void memoizedFloydWarshall(int[][] graph, int[][] dist) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i != j && graph[i][j] != INF) {
                    dist[i][j] = graph[i][j];
                }
            }
        }
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    if (i != j && i != k && j != k && dist[i][k] != INF && dist[k][j] != INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void printDistances(int[][] dist) {
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("infinity ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}