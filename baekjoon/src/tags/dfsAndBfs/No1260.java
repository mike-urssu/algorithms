package tags.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1260
 */
public class No1260 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int nodes;
    public static int connections;
    public static int startAt;
    public static boolean[] isVisited;
    public static int[][] map;

    public static void setMap() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        nodes = Integer.parseInt(tokenizer.nextToken());
        connections = Integer.parseInt(tokenizer.nextToken());
        startAt = Integer.parseInt(tokenizer.nextToken());

        map = new int[nodes + 1][nodes + 1];
        for (int i = 0; i < connections; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int source = Integer.parseInt(tokenizer.nextToken());
            int destination = Integer.parseInt(tokenizer.nextToken());
            map[source][destination] = map[destination][source] = 1;
        }
    }

    public static Stack<Integer> stack = new Stack<>();

    public static Queue<Integer> queue = new LinkedList<>();

    public static void dfs(int startAt) throws IOException {
        stack.push(startAt);
        isVisited[startAt] = true;
        writer.write(startAt + " ");

        for (int i = 1; i <= nodes; i++) {
            if (map[startAt][i] == 1 && !isVisited[i])
                dfs(i);
        }
    }

    public static void bfs(int startAt) throws IOException {
        queue.add(startAt);
        isVisited[startAt] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            writer.write(number + " ");

            for (int i = 1; i <= nodes; i++) {
                if (map[number][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        setMap();

        isVisited = new boolean[nodes + 1];
        dfs(startAt);
        writer.newLine();

        isVisited = new boolean[nodes + 1];
        bfs(startAt);
        writer.flush();
    }
}
