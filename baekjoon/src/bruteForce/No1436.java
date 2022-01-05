package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1436
 */
public class No1436 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int getNumberOfTheEnd(int order) {
        int count = 0;
        int number = 666;
        while (count != order) {
            if (String.valueOf(number++).contains("666"))
                count++;
        }
        return number - 1;
    }

    public static void main(String[] args) throws IOException {
        int order = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(getNumberOfTheEnd(order)));
        writer.flush();
    }
}
