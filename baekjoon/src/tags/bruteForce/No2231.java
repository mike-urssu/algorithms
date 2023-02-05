package tags.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class No2231 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int getSubtotal(final int number) {
        int smallestSubtotal = 0;
        for (int i = number; i > 0; i--) {

            int subtotal = i;

            int temp = i;
            while (temp > 0) {
                subtotal += temp % 10;
                temp /= 10;
            }
            if (subtotal == number)
                smallestSubtotal = i;
        }
        return smallestSubtotal;
    }

    public static void main(String[] args) throws IOException {
        int number = Integer.parseInt(reader.readLine());
        writer.write(String.valueOf(getSubtotal(number)));
        writer.flush();
    }
}
