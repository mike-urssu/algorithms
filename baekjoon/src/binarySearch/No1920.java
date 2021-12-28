package binarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1920
 */
public class No1920 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;
    public static int[] target;
    public static int[] source;

    public static void setArrays() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        target = new int[numberOfInput];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfInput; i++)
            target[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(target);

        numberOfInput = Integer.parseInt(reader.readLine());
        source = new int[numberOfInput];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfInput; i++)
            source[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void searchNumbers() throws IOException {
        for (int number : source) {
            writer.write(String.valueOf(binarySearch(target, number)));
            writer.newLine();
        }
    }

    private static int binarySearch(int[] array, int number) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (array[mid] < number)
                low = mid + 1;
            else if (array[mid] == number)
                return 1;
            else
                high = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        setArrays();
        searchNumbers();
        writer.flush();
    }
}
