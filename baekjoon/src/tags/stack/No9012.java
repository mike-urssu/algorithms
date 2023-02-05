package tags.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/9012
 */
public class No9012 {
    public static void command(String command) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < command.length(); i++)
            stack.push(command.charAt(i));
        System.out.println(isVPS(stack) ? "YES" : "NO");
    }

    private static boolean isVPS(Stack<Character> stack) {
        int closedTime = 0;
        while (!stack.empty()) {
            if (stack.pop() == '(') {
                if (closedTime > 0)
                    closedTime--;
                else
                    return false;
            } else
                closedTime++;
        }
        return closedTime == 0;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfInput = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfInput; i++)
                command(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
