package greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/13305
 */
public class No13305 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void sortCosts(int[] costs) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < costs.length; i++) {
            if (min > costs[i])
                min = costs[i];
            else
                costs[i] = min;
        }
    }

    public static void main(String[] args) throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] lengths = new int[numberOfInput - 1];
        for (int i = 0; i < numberOfInput - 1; i++)
            lengths[i] = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int[] costs = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            costs[i] = Integer.parseInt(tokenizer.nextToken());

        sortCosts(costs);

        long cost = 0;
        for (int i = 0; i < numberOfInput - 1; i++)
            cost += (long) costs[i] * lengths[i];

        writer.write(String.valueOf(cost));
        writer.flush();
    }
}
