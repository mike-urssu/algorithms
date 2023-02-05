package tags.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/17298
 */
public class No17298 {
    public static int[] sequences;

    public static void initSequences(int numberOfInput, String command) {
        StringTokenizer tokenizer = new StringTokenizer(command);
        sequences = new int[numberOfInput];
        for (int i = 0; i < numberOfInput; i++)
            sequences[i] = Integer.parseInt(tokenizer.nextToken());
    }

    public static void updateSequence(int numberOfInput) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numberOfInput; i++) {
            while (!stack.empty() && sequences[stack.peek()] < sequences[i])
                sequences[stack.pop()] = sequences[i];
            stack.push(i);
        }

        while (!stack.empty())
            sequences[stack.pop()] = -1;
    }

    public static void printNGE() {
        StringBuilder builder = new StringBuilder();
        for (int number : sequences)
            builder.append(number).append(" ");
        System.out.println(builder);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfInput = Integer.parseInt(reader.readLine());
            String sequences = reader.readLine();
            initSequences(numberOfInput, sequences);
            updateSequence(numberOfInput);
            printNGE();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
