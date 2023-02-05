package tags.dynamic;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1966
 */
public class No1966 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int[][] houses;

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        houses = new int[numberOfInput][3];
        for (int i = 0; i < numberOfInput; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int r = Integer.parseInt(tokenizer.nextToken());
            int g = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            houses[i] = new int[]{r, g, b};
        }
    }

    public static int getCost() {
        int length = houses.length;
        for (int i = 1; i < length; i++) {
            houses[i][0] += Math.min(houses[i - 1][1], houses[i - 1][2]);
            houses[i][1] += Math.min(houses[i - 1][0], houses[i - 1][2]);
            houses[i][2] += Math.min(houses[i - 1][0], houses[i - 1][1]);
        }
        return Math.min(Math.min(houses[length - 1][0], houses[length - 1][1]), houses[length - 1][2]);
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getCost()));
        writer.flush();
    }
}
