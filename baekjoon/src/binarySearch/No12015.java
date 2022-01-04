package binarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No12015 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] array;
    public static List<Integer> sequence = new ArrayList<>();

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        array = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            array[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static int getSequenceSize() {
        sequence.add(0);
        for (int number : array) {
            if (sequence.get(sequence.size() - 1) < number)
                sequence.add(number);
            else
                sequence.set(getUpperBound(number), number);
        }
        return sequence.size() - 1;
    }

    private static int getUpperBound(int number) {
        int low = 0;
        int high = sequence.size() - 1;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (number <= sequence.get(mid))
                high = mid;
            else
                low = mid;
        }
        return high;
    }

    public static void main(String[] args) throws IOException {
        sequence = new ArrayList<>();
        setValues();

        writer.write(String.valueOf(getSequenceSize()));
        writer.newLine();
        writer.flush();
    }
}
