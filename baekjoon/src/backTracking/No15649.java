package backTracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15649
 */
public class No15649 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] sequence;
    public static boolean[] isVisited;

    public static void dfs(int maxNumber, int sequenceLength, int depth) throws IOException {
        if (sequenceLength == depth) {
            for (int number : sequence)
                writer.write(number + " ");
            writer.newLine();
            writer.flush();
            return;
        }

        for (int i = 0; i < maxNumber; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                sequence[depth] = i + 1;
                dfs(maxNumber, sequenceLength, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int maxNumber = Integer.parseInt(tokenizer.nextToken());
        int sequenceLength = Integer.parseInt(tokenizer.nextToken());
        isVisited = new boolean[maxNumber];
        sequence = new int[sequenceLength];

        dfs(maxNumber, sequenceLength, 0);
    }
}
