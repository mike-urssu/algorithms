package tags.binarySearchh;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10816
 */
public class No10816 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] cards;
    public static int[] numbers;

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        cards = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(cards);

        numberOfInput = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());

        numbers = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void printCardsCount() throws IOException {
        for (int number : numbers)
            writer.write((getUpperBound(number) - getLowerBound(number)) + " ");
        writer.flush();
    }

    private static int getUpperBound(int number) {
        int low = -1;
        int high = cards.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (number >= cards[mid])
                low = mid;
            else
                high = mid;
        }
        return high;
    }

    private static int getLowerBound(int number) {
        int low = -1;
        int high = cards.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (number <= cards[mid])
                high = mid;
            else
                low = mid;
        }
        return low + 1;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        printCardsCount();
    }

    /**
     * Map을 이용한 풀이
     *
     * public static void main(String[] args) throws IOException {
     *         Map<Integer, Integer> map = new HashMap<>();
     *         int numberOfInput = Integer.parseInt(reader.readLine());
     *         tokenizer = new StringTokenizer(reader.readLine());
     *         for (int i = 0; i < numberOfInput; i++) {
     *             int number = Integer.parseInt(tokenizer.nextToken());
     *             map.put(number, map.getOrDefault(number, 0) + 1);
     *         }
     *
     *         numberOfInput = Integer.parseInt(reader.readLine());
     *         tokenizer = new StringTokenizer(reader.readLine());
     *         for (int i = 0; i < numberOfInput; i++) {
     *             int number = Integer.parseInt(tokenizer.nextToken());
     *             writer.write(map.getOrDefault(number, 0) + " ");
     *         }
     *         writer.flush();
     *     }
     */
}
