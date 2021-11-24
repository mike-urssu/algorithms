package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11047
 */
public class No11047 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int getMinimumCoinCount(int[] moneys, int total) {
        int count = 0;
        for (int i = moneys.length - 1; i >= 0; i--) {
            if (total == 0)
                break;
            count += total / moneys[i];
            total %= moneys[i];
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfInput = Integer.parseInt(tokenizer.nextToken());
        int total = Integer.parseInt(tokenizer.nextToken());

        int[] moneys = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            moneys[i] = Integer.parseInt(reader.readLine());

        System.out.println(getMinimumCoinCount(moneys, total));
    }
}
