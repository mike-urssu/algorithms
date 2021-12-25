package dfsAndBfs;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class DFS {
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static Stack<Integer> stack = new Stack<>();
    public static final int nodes = 7;
    public static final int startAt = 1;
    public static boolean[] isVisited = new boolean[nodes + 1];

    public static int[][] graph = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 1, 1},
            {0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0, 1, 0},
    };

    public static void dfs(int startAt) throws IOException {
        stack.push(startAt);
        isVisited[startAt] = true;
        writer.write(startAt + " ");

        for (int i = 1; i <= nodes; i++) {
            if (graph[startAt][i] == 1 && !isVisited[i])
                dfs(i);
        }
    }

    public static void main(String[] args) throws IOException {
        // 1 2 3 6 7 4 5
        dfs(startAt);
        writer.flush();
    }
}
