package tags.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2178
 */
public class No2178 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int width;
    public static int height;
    public static int[][] graph;
    public static boolean[][] isVisited;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{-1, 0, 1, 0};
    public static int min = Integer.MAX_VALUE;

    public static void setGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        graph = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = reader.readLine();
            for (int j = 0; j < width; j++)
                graph[i][j] = line.charAt(j) - '0';
        }

        isVisited = new boolean[height][width];
    }

    public static int getShortestPath() {
        bfs();
        return graph[height - 1][width - 1];

//        dfs(0, 0, 1);
//        return min;
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int row = currentPosition[0];
            int col = currentPosition[1];
            int value = graph[row][col];

            if (row == height - 1 && col == width - 1)
                return;

            for (int i = 0; i < 4; i++) {
                int nextRow = row + dy[i];
                int nextCol = col + dx[i];

                if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width)
                    continue;
                if (graph[nextRow][nextCol] == 0 || isVisited[nextRow][nextCol])
                    continue;

                graph[nextRow][nextCol] = value + 1;
                isVisited[nextRow][nextCol] = true;
                queue.add(new int[]{nextRow, nextCol});
            }
        }
    }

    public static void bfs2() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int row = currentPosition[0];
            int col = currentPosition[1];
            int value = graph[row][col];

            if (row == height - 1 && col == width - 1)
                return;

            if (row - 1 >= 0 && graph[row - 1][col] == 1 && !isVisited[row - 1][col]) {
                isVisited[row - 1][col] = true;
                graph[row - 1][col] = value + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (col + 1 < width && graph[row][col + 1] == 1 && !isVisited[row][col + 1]) {
                isVisited[row][col + 1] = true;
                graph[row][col + 1] = value + 1;
                queue.add(new int[]{row, col + 1});
            }
            if (row + 1 < height && graph[row + 1][col] == 1 && !isVisited[row + 1][col]) {
                isVisited[row + 1][col] = true;
                graph[row + 1][col] = value + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col - 1 >= 0 && graph[row][col - 1] == 1 && !isVisited[row][col - 1]) {
                isVisited[row][col - 1] = true;
                graph[row][col - 1] = value + 1;
                queue.add(new int[]{row, col - 1});
            }
        }
    }

    public static void dfs(int row, int col, int count) {
        isVisited[row][col] = true;

        if (row == height - 1 && col == width - 1) {
            min = Math.min(min, count);
            return;
        }

        if (min < count)
            return;

        if (row - 1 >= 0 && graph[row - 1][col] == 1 && !isVisited[row - 1][col]) {
            dfs(row - 1, col, count + 1);
            isVisited[row - 1][col] = false;
        }
        if (col + 1 < width && graph[row][col + 1] == 1 && !isVisited[row][col + 1]) {
            dfs(row, col + 1, count + 1);
            isVisited[row][col + 1] = false;
        }
        if (row + 1 < height && graph[row + 1][col] == 1 && !isVisited[row + 1][col]) {
            dfs(row + 1, col, count + 1);
            isVisited[row + 1][col] = false;
        }
        if (col - 1 >= 0 && graph[row][col - 1] == 1 && !isVisited[row][col - 1]) {
            dfs(row, col - 1, count + 1);
            isVisited[row][col - 1] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        setGraph();
        writer.write(String.valueOf(getShortestPath()));
        writer.flush();
    }
}
