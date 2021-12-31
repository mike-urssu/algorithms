package binarySearch;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2805
 */
public class No2805 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int numberOfTrees;
    public static int requiredLength;
    public static int[] trees;
    public static int high = Integer.MAX_VALUE;
    public static int low = 0;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        numberOfTrees = Integer.parseInt(tokenizer.nextToken());
        requiredLength = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        trees = new int[numberOfTrees];
        for (int i = 0; i < numberOfTrees; i++)
            trees[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static int getMaxHeight() {
        int mid = (high + low) / 2;
        while (low + 1 < high) {
            if (isValid(mid))
                low = mid;
            else
                high = mid;
            mid = (high + low) / 2;
        }
        return mid;
    }

    private static boolean isValid(int mid) {
        long sum = 0;
        for (int i = 0; i < numberOfTrees; i++) {
            if (trees[i] > mid)
                sum += trees[i] - mid;
        }
        return sum >= requiredLength;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxHeight()));
        writer.flush();
    }
}
