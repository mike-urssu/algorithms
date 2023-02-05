package tags.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1931
 */
public class No1931 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        int[][] schedules = new int[numberOfInput][2];
        for (int i = 0; i < numberOfInput; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            schedules[i][0] = Integer.parseInt(tokenizer.nextToken());
            schedules[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(schedules,
                (it, other) -> {
                    if (it[1] == other[1]) {
                        return it[0] - other[0];
                    } else
                        return it[1] - other[1];
                });

        int scheduleCount = 0;
        int endTime = 0;
        for (int i = 0; i < numberOfInput; i++) {
            if (endTime <= schedules[i][0]) {
                endTime = schedules[i][1];
                scheduleCount++;
            }
        }

        writer.write(String.valueOf(scheduleCount));
        writer.flush();
    }
}
