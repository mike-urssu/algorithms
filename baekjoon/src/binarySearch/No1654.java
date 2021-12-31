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
    public static long low;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        numberOfWires = Integer.parseInt(tokenizer.nextToken());
        requiredWires = Integer.parseInt(tokenizer.nextToken());

        wires = new int[numberOfWires];
        for (int i = 0; i < numberOfWires; i++)
            wires[i] = Integer.parseInt(reader.readLine());
    }

    public static long getMaxWireLength() {
        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (getWires(mid) >= requiredWires)
                low = mid;
            else
                high = mid;
        }
        return low;
    }

    private static int getWires(long mid) {
        int count = 0;
        for (int wire : wires)
            count += wire / mid;
        return count;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxWireLength()));
        writer.flush();
    }
}
