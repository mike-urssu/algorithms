package dynamic1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10844
 */
public class No10844 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static final int MOD = 1000000000;
    public static Integer[][] dp;

    public static int getStairs(int digit, int index) {
        if (digit == 1)
            return dp[digit][index];

        if (dp[digit][index] == null) {
            if (index == 0)
                dp[digit][index] = getStairs(digit - 1, 1) % MOD;
            else if (index == 9)
                dp[digit][index] = getStairs(digit - 1, 8) % MOD;
            else
                dp[digit][index] = (getStairs(digit - 1, index - 1) + getStairs(digit - 1, index + 1)) % MOD;
        }

        return dp[digit][index];
    }

    public static void main(String[] args) throws IOException {
        int digit = Integer.parseInt(reader.readLine());
        dp = new Integer[digit + 1][10];
        for (int i = 0; i < 10; i++)
            dp[1][i] = 1;

        long count = 0;
        for (int i = 1; i < 10; i++)
            count += getStairs(digit, i);

        writer.write(String.valueOf(count % MOD));
        writer.flush();
    }
}
