package binarySearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1654
 */
public class No1654 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int numberOfWires;
    public static int requiredWires;
    public static int[] wires;
    public static long high = Long.MAX_VALUE;
    public static long low = 0;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        numberOfWires = Integer.parseInt(tokenizer.nextToken());
        requiredWires = Integer.parseInt(tokenizer.nextToken());

        wires = new int[numberOfWires];
        for (int i = 0; i < numberOfWires; i++) {
            wires[i] = Integer.parseInt(reader.readLine());
            high = Math.max(high, wires[i]);
        }
    }

    public static long getMaxWires() {
        long mid = low + (high - low) / 2;
        while (low + 1 < high) {
            if (isValid(mid))
                low = mid;
            else
                high = mid;
            mid = (high + low) / 2;
        }
        return low;
    }

    private static boolean isValid(long mid) {
        long count = 0;
        for (int i = 0; i < numberOfWires; i++)
            count += wires[i] / mid;
        return count >= requiredWires;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxWires()));
        writer.flush();
    }
}
