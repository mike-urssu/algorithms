package tags.dfsAndBfs;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1012
 */
public class No1012 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int width;
    public static int height;
    public static int[][] graph;

    public static void setGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        width = Integer.parseInt(tokenizer.nextToken());
        height = Integer.parseInt(tokenizer.nextToken());
        graph = new int[height][width];

        int input = Integer.parseInt(tokenizer.nextToken());
        for (int i = 0; i < input; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int col = Integer.parseInt(tokenizer.nextToken());
            int row = Integer.parseInt(tokenizer.nextToken());
            graph[row][col] = 1;
        }
    }

    public static void bfs(int row, int col) {
        graph[row][col] = -1;
        if (row - 1 >= 0 && graph[row - 1][col] == 1)
            bfs(row - 1, col);
        if (col + 1 < width && graph[row][col + 1] == 1)
            bfs(row, col + 1);
        if (row + 1 < height && graph[row + 1][col] == 1)
            bfs(row + 1, col);
        if (col - 1 >= 0 && graph[row][col - 1] == 1)
            bfs(row, col - 1);
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCase; i++) {
            setGraph();
            int worm = 0;
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < width; k++) {
                    if (graph[j][k] == 1) {
                        bfs(j, k);
                        worm++;
                    }
                }
            }
            writer.write(String.valueOf(worm));
            writer.newLine();
        }
        writer.flush();
    }
}
