package dynamic1;

import java.io.*;
import java.util.StringTokenizer;

public class No1932 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] dp;

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        dp = new int[numberOfInput];
        for (int i = 1; i <= numberOfInput; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int[] scores = new int[i];
            for (int j = 0; j < i; j++)
                scores[j] = Integer.parseInt(tokenizer.nextToken());
            updateDp(scores);
        }
    }

    private static void updateDp(int[] scores) {
        for (int i = 0; i < scores.length; i++) {
            if (i == 0)
                scores[i] += dp[i];
            else if (i == scores.length - 1)
                scores[i] += dp[i - 1];
            else
                scores[i] += Math.max(dp[i - 1], dp[i]);
        }
        System.arraycopy(scores, 0, dp, 0, scores.length);
    }

    public static int getMaxScore() {
        int max = Integer.MIN_VALUE;
        for (int score : dp) max = Math.max(max, score);
        return max;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxScore()));
        writer.newLine();
        writer.flush();
    }
}
