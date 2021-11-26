package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11399
 */
public class No11399 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        int[] minutes = new int[numberOfInput];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfInput; i++)
            minutes[i] = Integer.parseInt(tokenizer.nextToken());

        Arrays.sort(minutes);

        int totalMinutes = 0;
        for (int i = 0; i < numberOfInput; i++)
            totalMinutes += minutes[i] * (numberOfInput - i);

        System.out.println(totalMinutes);
    }
}
