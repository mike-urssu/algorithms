package tags.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1003
 */
public class No1003 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static final int[] fibonacci = new int[41];

    public static void calculateFibonacci() {
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < fibonacci.length; i++)
            fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
    }

    public static void main(String[] args) throws IOException {
        calculateFibonacci();

        int testCase = Integer.parseInt(reader.readLine());
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(new StringTokenizer(reader.readLine()).nextToken());
            if (number == 0)
                writer.write("1 0");
            else
                writer.write(fibonacci[number - 1] + " " + fibonacci[number]);
            writer.newLine();
            writer.flush();
        }
    }
}
