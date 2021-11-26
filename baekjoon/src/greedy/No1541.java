package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/1541
 */
public class No1541 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int index;

    public static boolean isPreviousSignPositive = true;

    public static int getNumber(String line) {
        StringBuilder builder = new StringBuilder();
        while (line.length() != index && !Arrays.asList('+', '-').contains(line.charAt(index)))
            builder.append(line.charAt(index++));
        return Integer.parseInt(builder.toString());
    }

    public static void main(String[] args) throws IOException {
        String line = reader.readLine();
        int sum = getNumber(line);

        while (line.length() != index) {
            boolean isPositive = line.charAt(index++) == '+';
            int number = getNumber(line);

            if (isPreviousSignPositive) {
                if (isPositive) {
                    sum += number;
                } else {
                    sum -= number;
                    isPreviousSignPositive = false;
                }
            } else
                sum -= number;

            if (line.length() == index)
                break;
        }
        System.out.println(sum);
    }
}
