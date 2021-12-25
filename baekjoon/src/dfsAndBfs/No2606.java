package dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2606
 */
public class No2606 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int nodes;
    public static int connections;
    public static final int startAt = 1;
    public static boolean[] isVisited;
    public static int[][] graph;

    public static void setGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        nodes = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        connections = Integer.parseInt(tokenizer.nextToken());
        isVisited = new boolean[nodes + 1];
        graph = new int[nodes + 1][nodes + 1];

        for (int i = 0; i < connections; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int source = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            graph[source][destination] = graph[destination][source] = 1;
        }
    }

    public static int countWormVirus(int startAt) {
        int wormVirus = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startAt);
        isVisited[startAt] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            for (int i = 1; i <= nodes; i++) {
                if (graph[number][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                    wormVirus++;
                }
            }
        }
        return wormVirus;
    }

    public static void main(String[] args) throws IOException {
        setGraph();
        writer.write(String.valueOf(countWormVirus(startAt)));
        writer.flush();
    }
}
