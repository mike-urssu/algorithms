package tags.dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7562 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[][] board;
    public static boolean[][] isVisited;
    public static int length;

    public static int x1;
    public static int y1;
    public static int x2;
    public static int y2;
    public static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void setValues() throws IOException {
        length = Integer.parseInt(reader.readLine());
        board = new int[length][length];
        for (int j = 0; j < length; j++) {
            for (int k = 0; k < length; k++)
                board[j][k] = -1;
        }
        isVisited = new boolean[length][length];

        tokenizer = new StringTokenizer(reader.readLine());
        x1 = Integer.parseInt(tokenizer.nextToken());
        y1 = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        x2 = Integer.parseInt(tokenizer.nextToken());
        y2 = Integer.parseInt(tokenizer.nextToken());
    }

    public static void bfs(int x1, int y1, int x2, int y2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x1, y1});
        board[x1][y1] = 0;
        isVisited[x1][y1] = true;

        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int currentX = currentPos[0];
            int currentY = currentPos[1];

            if (currentX == x2 && currentY == y2)
                return;

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];
                if (nextX < 0 || nextX >= length || nextY < 0 || nextY >= length)
                    continue;

                if (!isVisited[nextX][nextY] && board[nextX][nextY] == -1) {
                    board[nextX][nextY] = board[currentX][currentY] + 1;
                    isVisited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInput; i++) {
            setValues();
            bfs(x1, y1, x2, y2);
            writer.write(String.valueOf(board[x2][y2]));
            writer.newLine();
        }
        writer.flush();
    }
}
