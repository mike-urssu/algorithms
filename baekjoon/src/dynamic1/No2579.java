package dynamic1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2579
 */
public class No2579 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int numberOfInput;
    public static int[] scores;
    public static int[] dp;

    public static void setValues() throws IOException {
        numberOfInput = Integer.parseInt(reader.readLine());
        dp = new int[numberOfInput + 1];
        scores = new int[numberOfInput + 1];
        for (int i = 1; i < numberOfInput + 1; i++)
            scores[i] = Integer.parseInt(reader.readLine());
    }

    public static int getMaxScore() {
        int length = scores.length;
        dp[1] = scores[1];
        if (numberOfInput >= 2)
            dp[2] = scores[1] + scores[2];
        for (int i = 3; i < length; i++)
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + scores[i - 1]) + scores[i];
        return dp[length - 1];
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxScore()));
        writer.flush();
    }
}
