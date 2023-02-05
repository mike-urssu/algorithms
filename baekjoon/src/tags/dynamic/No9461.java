package tags.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/9461
 */
public class No9461 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static long[] lengths = new long[101];

    public static void setLengths() {
        lengths[1] = lengths[2] = lengths[3] = 1;
        lengths[4] = lengths[5] = 2;
        for (int i = 6; i < lengths.length; i++)
            lengths[i] = lengths[i - 5] + lengths[i - 1];
    }

    public static void main(String[] args) throws IOException {
        setLengths();
        int numberOfInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInput; i++) {
            int number = Integer.parseInt(reader.readLine());
            writer.write(String.valueOf(lengths[number]));
            writer.newLine();
        }
        writer.flush();
    }
}
