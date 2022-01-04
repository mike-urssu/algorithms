package bruteForce;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2798
 */
public class No2798 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[] cards;
    public static int number;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        int numberOfInput = Integer.parseInt(tokenizer.nextToken());
        number = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        cards = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            cards[i] = Integer.parseInt(tokenizer.nextToken());
        Arrays.sort(cards);
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sumOfCards = cards[i] + cards[j] + cards[k];
                    if (sumOfCards > number)
                        break;
                    sum = Math.max(sum, sumOfCards);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getSum()));
        writer.flush();
    }
}
