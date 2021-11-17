package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11404
 * <p>
 * 문제
 * n(2 ≤ n ≤ 100)개의 도시가 있다. 그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1 ≤ m ≤ 100,000)개의 버스가 있다.
 * 각 버스는 한 번 사용할 때 필요한 비용이 있다.
 * 모든 도시의 쌍 (A, B)에 대해서 도시 A에서 B로 가는데 필요한 비용의 최솟값을 구하는 프로그램을 작성하시오.
 * <p>
 * 입력
 * 첫째 줄에 도시의 개수 n이 주어지고 둘째 줄에는 버스의 개수 m이 주어진다.
 * 그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다.
 * 먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
 * 버스의 정보는 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c로 이루어져 있다.
 * 시작 도시와 도착 도시가 같은 경우는 없다. 비용은 100,000보다 작거나 같은 자연수이다.
 * 시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있다.
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
