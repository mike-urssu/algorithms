package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11866
 */
public class No11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int people = Integer.parseInt(tokenizer.nextToken());
        int order = Integer.parseInt(tokenizer.nextToken());

        Queue<String> queue = new LinkedList<>();
        for (int i = 1; i <= people; i++)
            queue.add(String.valueOf(i));

        List<String> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            for (int i = 0; i < order - 1; i++)
                queue.add(queue.poll());
            list.add(queue.poll());
        }

        System.out.print("<");
        System.out.print(String.join(", ", list.toArray(new CharSequence[0])));
        System.out.print(">");
    }
}
