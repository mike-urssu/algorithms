package shortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1753
 * <p>
 * 문제
 * 방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
 * 단, 모든 간선의 가중치는 10 이하의 자연수이다.
 * <p>
 * 입력
 * 첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
 * 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
 * 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
 * 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
 * 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
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
