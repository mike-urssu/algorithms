package tags.dp;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9184
 */
public class No9184 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[][][] w = new int[21][21][21];

    public static int w(int a, int b, int c) {
        if (isInRange(a, b, c) && w[a][b][c] != 0)
            return w[a][b][c];

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20)
            return w[20][20][20] = w(20, 20, 20);

        if (a < b && b < c)
            return w[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);

        return w[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }

    private static boolean isInRange(int a, int b, int c) {
        return (0 <= a && a <= 20) && (0 <= b && b <= 20) && (0 <= c && c <= 20);
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            writer.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
            writer.newLine();
        }
        writer.flush();
    }
}
