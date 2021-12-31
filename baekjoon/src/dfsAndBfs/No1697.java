package dfsAndBfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1697
 */
public class No1697 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;
    public static int[] isVisited = new int[100001];

    public static int bfs(int x1, int x2) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[x1] = 1;
        queue.add(x1);

        while (!queue.isEmpty()) {
            int currentNumber = queue.poll();
            if (currentNumber == x2)
                break;

            int[] nextNumbers = new int[]{currentNumber - 1, currentNumber + 1, currentNumber * 2};
            if (nextNumbers[0] >= 0 && isVisited[nextNumbers[0]] == 0) {
                isVisited[nextNumbers[0]] = isVisited[currentNumber] + 1;
                queue.add(nextNumbers[0]);
            }
            if (nextNumbers[1] <= 100000 && isVisited[nextNumbers[1]] == 0) {
                isVisited[nextNumbers[1]] = isVisited[currentNumber] + 1;
                queue.add(nextNumbers[1]);
            }
            if (nextNumbers[2] <= 100000 && isVisited[nextNumbers[2]] == 0) {
                isVisited[nextNumbers[2]] = isVisited[currentNumber] + 1;
                queue.add(nextNumbers[2]);
            }
        }
        return isVisited[x2] - 1;
    }

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int x1 = Integer.parseInt(tokenizer.nextToken());
        int x2 = Integer.parseInt(tokenizer.nextToken());
        writer.write(String.valueOf(bfs(x1, x2)));
        writer.flush();
    }
}
