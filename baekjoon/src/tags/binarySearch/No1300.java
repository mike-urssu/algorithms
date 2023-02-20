package tags.binarySearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1300
 */
public class No1300 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static long getValue(long size, int index) {
        long low = 0;
        long high = size * size;

        while (low + 1 < high) {
            long mid = (low + high) / 2;
            if (getIndexByEqualOrLessThanIndex(size, mid) < index)
                low = mid;
            else
                high = mid;
        }
        return high;
    }

    private static long getIndexByEqualOrLessThanIndex(long size, long mid) {
        long index = 0;
        for (int i = 1; i <= size; i++)
            index += Math.min(mid / i, size);
        return index;
    }

    public static void main(String[] args) throws IOException {
        int size = Integer.parseInt(reader.readLine());
        int index = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(getValue(size, index)));
        writer.flush();
    }
}
