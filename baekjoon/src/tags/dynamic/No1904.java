package tags.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1904
 */
public class No1904 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] fibonacci = new int[1000001];

    public static int countCases(int length) {
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        for (int i = 3; i <= length; i++)
            fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % 15746;
        return fibonacci[length];
    }

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(countCases(number)));
        writer.newLine();
        writer.flush();
    }
}
