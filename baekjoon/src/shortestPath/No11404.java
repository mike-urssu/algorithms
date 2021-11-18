package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11404
 */
public class No11404 {
    public static int INF = 1000000000;

    public static int[][] graph;

    public static int cities;

    public static void drawGraph() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            initGraph(reader);
            updatePath(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initGraph(BufferedReader reader) throws IOException {
        cities = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        graph = new int[cities + 1][cities + 1];
        for (int i = 1; i < cities + 1; i++)
            Arrays.fill(graph[i], INF);
        for (int i = 1; i < cities + 1; i++)
            graph[i][i] = 0;
    }

    private static void updatePath(BufferedReader reader) throws IOException {
        int buses = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
        for (int i = 0; i < buses; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int src = Integer.parseInt(tokenizer.nextToken());
            int dest = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            graph[src][dest] = Math.min(graph[src][dest], weight);
        }
    }

    public static void calculateShortestPaths() {
        for (int i = 1; i < cities + 1; i++) {
            for (int j = 1; j < cities + 1; j++) {
                if (i == j) continue;
                for (int k = 1; k < cities + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }
    }

    public static void printGraph() {
        for (int i = 1; i < cities + 1; i++) {
            for (int j = 1; j < cities + 1; j++)
                System.out.print((graph[i][j] == INF ? 0 : graph[i][j]) + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        drawGraph();
        calculateShortestPaths();
        printGraph();
    }
}
