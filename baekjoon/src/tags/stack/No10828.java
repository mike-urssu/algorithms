package tags.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/10828
 */
public class No10828 {
    private static final Stack<Integer> stack = new Stack<>();

    public static void command(String command) {
        String[] commands = command.split(" ");
        if (commands.length == 1)
            System.out.println(getValue(commands[0]));
        else
            push(Integer.parseInt(commands[1]));
    }

    private static int getValue(String command) {
        switch (command) {
            case "top":
                return top();
            case "size":
                return size();
            case "empty":
                return empty();
            case "pop":
                return pop();
            default:
                return -1;
        }
    }

    public static void push(int number) {
        stack.push(number);
    }

    public static int top() {
        return stack.empty() ? -1 : stack.peek();
    }

    public static int pop() {
        return stack.empty() ? -1 : stack.pop();
    }

    public static int size() {
        return stack.size();
    }

    public static int empty() {
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int orderCount = Integer.parseInt(reader.readLine());
            for (int i = 0; i < orderCount; i++)
                command(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
