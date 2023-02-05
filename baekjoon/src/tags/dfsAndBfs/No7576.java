package tags.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7576
 */
public class No7576 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int width;
    public static int height;
    public static int[][] graph;
    public static boolean[][] isVisited;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};

    public static void setGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        width = Integer.parseInt(tokenizer.nextToken());
        height = Integer.parseInt(tokenizer.nextToken());

        graph = new int[height][width];
        for (int i = 0; i < height; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < width; j++)
                graph[i][j] = Integer.parseInt(tokenizer.nextToken());
        }

        isVisited = new boolean[height][width];
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    isVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int currentRow = currentPosition[0];
            int currentCol = currentPosition[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = currentRow + dy[i];
                int nextCol = currentCol + dx[i];

                if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width)
                    continue;
                if (graph[nextRow][nextCol] == -1 || isVisited[nextRow][nextCol])
                    continue;

                graph[nextRow][nextCol] = graph[currentRow][currentCol] + 1;
                isVisited[nextRow][nextCol] = true;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }

    public static int getDays() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (graph[i][j] == 0)
                    return -1;
                max = Math.max(max, graph[i][j]);
            }
        }
        return max - 1;
    }


    public static void main(String[] args) throws IOException {
        setGraph();
        bfs();
        writer.write(String.valueOf(getDays()));
        writer.flush();
    }
}
