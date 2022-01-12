package dynamic1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2156
 */
public class No2156 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] wines;
    public static int[] dp;

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        wines = new int[numberOfInput + 1];
        for (int i = 1; i < numberOfInput + 1; i++)
            wines[i] = Integer.parseInt(reader.readLine());
        dp = new int[numberOfInput + 1];
    }

    public static void setDP() {
        dp[0] = 0;
        dp[1] = wines[1];

        if (wines.length > 2) {
            dp[2] = wines[1] + wines[2];
            for (int i = 3; i < dp.length; i++)
                dp[i] = Math.max(Math.max(dp[i - 3] + wines[i - 1], dp[i - 2]) + wines[i], dp[i - 1]);
        }
    }

    public static int getMax() {
        int max = Integer.MIN_VALUE;
        for (int number : dp) max = Math.max(max, number);
        return max;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        setDP();
        writer.write(String.valueOf(getMax()));
        writer.flush();
    }
}
