package shortestPath;

/**
 * 다익스트라 선형 알고리즘 기본 예제
 */
public class Dijkstra {
    public static final int INF = 100000;

    public static final int number = 6;

    public static int[][] graph = new int[][]{
            {0, 2, 5, 1, INF, INF},
            {2, 0, 3, 2, INF, INF},
            {5, 3, 0, 3, 1, 5},
            {1, 2, 3, 0, 1, INF},
            {INF, INF, 1, 1, 0, 2},
            {INF, INF, 5, INF, 2, 0},
    };

    public static int[] distance = new int[number];

    public static boolean[] isVisited = new boolean[number];

    public void linearDijkstra(int startIndex) {
        System.arraycopy(graph[startIndex], 0, distance, 0, number);
        isVisited[startIndex] = true;

        for (int i = 0; i < number - 2; i++) {
            int index = getSmallestIndex();
            isVisited[index] = true;

            for (int j = 0; j < number; j++) {
                if (!isVisited[j]) {
                    if (distance[j] > distance[index] + graph[index][j])
                        distance[j] = distance[index] + graph[index][j];
                }
            }
        }
    }

    private int getSmallestIndex() {
        int min = INF;
        int smallestIndex = 0;

        for (int i = 0; i < number; i++) {
            if (!isVisited[i] && min > distance[i]) {
                min = distance[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.linearDijkstra(0);

        // 0 2 3 1 2 4
        for (int distance : distance)
            System.out.print(distance + " ");
    }
}
