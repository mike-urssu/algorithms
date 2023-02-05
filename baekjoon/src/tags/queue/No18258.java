package tags.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/18258
 */
public class No18258 {
    public static final Deque<Integer> deque = new LinkedList<>();

    public static final StringBuilder builder = new StringBuilder();

    public static void command(String command) {
        String[] orders = command.split(" ");
        if (orders.length == 1) {
            switch (orders[0]) {
                case "pop":
                    builder.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "size":
                    builder.append(deque.size()).append("\n");
                    break;
                case "empty":
                    builder.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    builder.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back":
                    builder.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        } else
            deque.add(Integer.parseInt(orders[1]));
    }

    public static void printResult() {
        System.out.println(builder);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInput; i++) {
            String command = reader.readLine();
            command(command);
        }
        printResult();
    }
}
