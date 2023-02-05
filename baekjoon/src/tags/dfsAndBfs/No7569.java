package tags.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7569
 */
public class No7569 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int x;
    public static int y;
    public static int z;
    public static int[][][] graph;
    public static boolean[][][] isVisited;
    public static int[] dx = new int[]{0, 0, 1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1, 0, 0};
    public static int[] dz = new int[]{-1, 0, 0, 0, 0, 1};

    public static void setGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        x = Integer.parseInt(tokenizer.nextToken());
        y = Integer.parseInt(tokenizer.nextToken());
        z = Integer.parseInt(tokenizer.nextToken());

        graph = new int[z][y][x];
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int k = 0; k < x; k++)
                    graph[i][j][k] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        isVisited = new boolean[z][y][x];
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (graph[i][j][k] == 1) {
                        isVisited[i][j][k] = true;
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            int currentZ = currentPosition[0];
            int currentY = currentPosition[1];
            int currentX = currentPosition[2];

            for (int i = 0; i < 6; i++) {
                int nextZ = currentZ + dz[i];
                int nextX = currentX + dy[i];
                int nextY = currentY + dx[i];

                if (nextZ < 0 || nextZ >= z || nextY < 0 || nextY >= y || nextX < 0 || nextX >= x)
                    continue;
                if (graph[nextZ][nextY][nextX] == -1 || isVisited[nextZ][nextY][nextX])
                    continue;

                graph[nextZ][nextY][nextX] = graph[currentZ][currentY][currentX] + 1;
                isVisited[nextZ][nextY][nextX] = true;
                queue.add(new int[]{nextZ, nextY, nextX});
            }
        }
    }

    public static int getDays() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    if (graph[i][j][k] == 0)
                        return -1;
                    max = Math.max(max, graph[i][j][k]);
                }
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
