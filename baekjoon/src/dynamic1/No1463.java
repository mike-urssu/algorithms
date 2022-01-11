package dynamic1;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1463
 */
public class No1463 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static Integer[] dp;

    public static int makeOne(int number) {
        if (dp[number] == null) {
            if (number % 6 == 0)
                dp[number] = Math.min(Math.min(makeOne(number / 3), makeOne(number / 2)), makeOne(number - 1)) + 1;
            else if (number % 3 == 0)
                dp[number] = Math.min(makeOne(number / 3), makeOne(number - 1)) + 1;
            else if (number % 2 == 0)
                dp[number] = Math.min(makeOne(number / 2), makeOne(number - 1)) + 1;
            else
                dp[number] = makeOne(number - 1) + 1;
        }
        return dp[number];
    }

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(reader.readLine());
        dp = new Integer[number + 1];
        dp[0] = dp[1] = 0;
        writer.write(String.valueOf(makeOne(number)));
        writer.flush();
    }
}
