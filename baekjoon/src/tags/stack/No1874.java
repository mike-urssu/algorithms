package tags.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.acmicpc.net/problem/1874
 */
public class No1874 {
    public static final Stack<Integer> stack = new Stack<>();

    public static int[] array;

    public static List<Character> pushOrPop = new ArrayList<>();

    public static boolean isStackAvailable() {
        int numberToStack = 1;
        for (int value : array) {
            if (numberToStack <= value) {
                while (numberToStack <= value) {
                    stack.push(numberToStack++);
                    pushOrPop.add('+');
                }
            } else if (stack.peek() != value)
                return false;
            stack.pop();
            pushOrPop.add('-');
        }
        return true;
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int numberOfInput = Integer.parseInt(reader.readLine());
            array = new int[numberOfInput];
            for (int i = 0; i < numberOfInput; i++)
                array[i] = Integer.parseInt(reader.readLine());
            if (isStackAvailable()) {
                for (char pushOrPop : pushOrPop)
                    System.out.println(pushOrPop);
            } else
                System.out.println("NO");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
