package tags.binarySearchh;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2110
 */
public class No2110 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static int numberOfHouses;
    public static int wlans;
    public static int[] houses;

    public static int high;
    public static int low = 1;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        numberOfHouses = Integer.parseInt(tokenizer.nextToken());
        wlans = Integer.parseInt(tokenizer.nextToken());

        houses = new int[numberOfHouses];
        for (int i = 0; i < numberOfHouses; i++) {
            houses[i] = Integer.parseInt(reader.readLine());
            high = Math.max(high, houses[i]);
        }
        Arrays.sort(houses);
    }

    public static int getMaxDistance() {
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (getWlanCount(mid) < wlans)
                high = mid;
            else
                low = mid;
        }
        return low;
    }

    private static int getWlanCount(int distance) {
        int count = 1;
        int previousHouse = houses[0];
        for (int i = 0; i < numberOfHouses; i++) {
            if (houses[i] - previousHouse < distance)
                continue;
            previousHouse = houses[i];
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMaxDistance()));
        writer.flush();
    }
}
