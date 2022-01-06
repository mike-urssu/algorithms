package backTracking;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15650
 */
public class No15650 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] sequence;

    public static int maxNumber;
    public static int sequenceSize;

    public static void dfs(int numberToInput, int depth) throws IOException {
        if (depth == sequenceSize) {
            for (int number : sequence)
                writer.write(number + " ");
            writer.newLine();
            writer.flush();
            return;
        }

        for (int i = numberToInput; i <= maxNumber; i++) {
            sequence[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        maxNumber = Integer.parseInt(tokenizer.nextToken());
        sequenceSize = Integer.parseInt(tokenizer.nextToken());
        sequence = new int[sequenceSize];

        int startNumber = 1;
        dfs(startNumber, 0);
    }
}
