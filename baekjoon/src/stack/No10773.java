package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10773
 */
public class No10773 {
    private static final Stack<Integer> stack = new Stack<>();

    public static void command(int number) {
        if (number == 0 && !stack.empty())
            stack.pop();
        else
            stack.push(number);
    }

    public static int getSumOfStack() {
        int sum = 0;
        while (!stack.empty())
            sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfCommands = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfCommands; i++)
                command(Integer.parseInt(reader.readLine()));
            System.out.println(getSumOfStack());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
