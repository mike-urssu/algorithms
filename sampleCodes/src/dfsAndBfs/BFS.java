package dfsAndBfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS {
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Queue<Integer> queue = new LinkedList<>();
    public static final int nodes = 7;
    public static final int startAt = 1;
    public static boolean[] isVisited = new boolean[nodes + 1];

    public static int[][] graph = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 0},
            {0, 1, 1, 0, 0, 0, 1, 1},
            {0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1, 0},
    };

    public static void bfs(int startAt) throws IOException {
        queue.add(startAt);
        isVisited[startAt] = true;

        while (!queue.isEmpty()) {
            int number = queue.poll();
            writer.write(number + " ");
            for (int i = 0; i <= nodes; i++) {
                if (graph[number][i] == 1 && !isVisited[i]) {
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 1 2 3 4 5 6 7
        bfs(startAt);
        writer.flush();
    }
}
