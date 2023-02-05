package tags.shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1753
 */
public class No1753 {
    public static int INF = 1000000;

    public static int[][] graph;

    public static int[] distance;

    public static boolean[] isVisited;

    public static int[] getShortestPaths(int startIndex) {
        distance = new int[graph.length];
        isVisited = new boolean[graph.length];
        System.arraycopy(graph[startIndex], 0, distance, 0, graph.length);
        isVisited[startIndex] = true;

        for (int i = 1; i < graph.length; i++) {
            int index = getSmallestIndex();
            for (int j = 1; j < graph.length; j++) {
                if (distance[j] > distance[index] + graph[index][j]) {
                    distance[j] = distance[index] + graph[index][j];
                    isVisited[index] = true;
                }
            }
        }

        return distance;
    }

    private static int getSmallestIndex() {
        int min = INF;
        int smallestIndex = INF;

        for (int i = 1; i < distance.length; i++) {
            if (!isVisited[i] && min > distance[i]) {
                smallestIndex = i;
                min = distance[i];
            }
        }
        return smallestIndex;
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            int nodes = Integer.parseInt(tokenizer.nextToken());
            int paths = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int startIndex = Integer.parseInt(tokenizer.nextToken());

            graph = new int[nodes + 1][nodes + 1];
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = (i == j ? 0 : INF);
                }
            }

            for (int i = 0; i < paths; i++) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                int source = Integer.parseInt(tokenizer.nextToken());
                int destination = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());
                graph[source][destination] = weight;
            }

            int[] shortestDistances = No1753.getShortestPaths(startIndex);
            for (int i = 1; i < shortestDistances.length; i++) {
                System.out.println(shortestDistances[i] == INF ? "INF" : shortestDistances[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
