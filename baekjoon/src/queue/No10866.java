package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/10866
 */
public class No10866 {
    public static Deque<Integer> deque = new LinkedList<>();

    public static StringBuilder builder = new StringBuilder();

    public static void command(BufferedReader reader) throws IOException {
        String[] orders = reader.readLine().split(" ");
        if (orders.length == 2) {
            switch (orders[0]) {
                case "push_back":
                    deque.addLast(Integer.parseInt(orders[1]));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(orders[1]));
                    break;
            }
        } else {
            switch (orders[0]) {
                case "pop_front":
                    builder.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    builder.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
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
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInput = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfInput; i++)
            command(reader);
        System.out.println(builder);
    }
}
