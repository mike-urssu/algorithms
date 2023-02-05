package tags.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://www.acmicpc.net/problem/2164
 */
public class No2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new LinkedList<>();
        int input = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= input; i++)
            deque.addLast(i);

        while (deque.size() > 1 && (deque.pollFirst() != 0))
            deque.addLast(deque.pollFirst());

        System.out.println(deque.poll());
    }
}
