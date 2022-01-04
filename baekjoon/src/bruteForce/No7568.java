package bruteForce;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/7568
 */
public class No7568 {
    private static class Body {
        private final int weight;
        private final int height;

        public Body(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public boolean isSmaller(Body other) {
            return this.weight < other.weight && this.height < other.height;
        }
    }

    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static List<Body> bodies = new ArrayList<>();

    public static void setValues() throws IOException {
        int numberOfInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInput; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(tokenizer.nextToken());
            int height = Integer.parseInt(tokenizer.nextToken());
            bodies.add(new Body(weight, height));
        }
    }

    public static void printAwards() throws IOException {
        for (Body body : bodies) {
            int award = 1;
            for (Body other : bodies) {
                if (body.isSmaller(other))
                    award++;
            }
            writer.write(award + " ");
        }
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        setValues();
        printAwards();
    }
}
