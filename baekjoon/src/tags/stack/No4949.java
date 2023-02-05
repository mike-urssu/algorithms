package tags.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/4949
 */
public class No4949 {
    public static List<Character> roundBrackets = Arrays.asList('(', ')');

    public static List<Character> squareBrackets = Arrays.asList('[', ']');

    public static void command(String command) {
        System.out.println(isVPS(command) ? "yes" : "no");
    }

    private static boolean isVPS(String command) {
        Stack<Character> stack = new Stack<>();
        for (char character : command.toCharArray()) {
            if (roundBrackets.contains(character)) {
                if (character == '(')
                    stack.push(character);
                else if (stack.empty() || stack.pop() != '(')
                    return false;
            } else if (squareBrackets.contains(character)) {
                if (character == '[')
                    stack.push(character);
                else if (stack.empty() || stack.pop() != '[')
                    return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("."))
                break;
            command(command);
        }
    }
}
