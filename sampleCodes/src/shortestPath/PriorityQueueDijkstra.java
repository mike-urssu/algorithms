package shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueDijkstra {
    public static final int INF = 1000000000;

    public static int number = 6;

    public static List<Node> graph = new ArrayList<>();

    public static boolean[] isVisited = new boolean[number];

    public static int[] distances = new int[number];

    public static void priorityQueueDijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Arrays.fill(distances, INF);
        queue.add(new Node(start, 0));
        distances[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int destination = node.getDestination();
            if (isVisited[destination])
                continue;
            else
                isVisited[destination] = true;

            for (Node n : graph) {

            }

        }

    }

    public static void main(String[] args) {
        graph.add(new Node(1, 2));
        graph.add(new Node(2, 5));
        graph.add(new Node(3, 1));

        graph.add(new Node(0, 2));
        graph.add(new Node(2, 3));
        graph.add(new Node(3, 2));

        graph.add(new Node(0, 5));
        graph.add(new Node(1, 3));
        graph.add(new Node(3, 3));
        graph.add(new Node(4, 1));
        graph.add(new Node(5, 5));

        graph.add(new Node(0, 1));
        graph.add(new Node(1, 2));
        graph.add(new Node(2, 3));
        graph.add(new Node(4, 1));

        graph.add(new Node(2, 1));
        graph.add(new Node(3, 1));
        graph.add(new Node(5, 2));

        graph.add(new Node(2, 5));
        graph.add(new Node(4, 2));

        priorityQueueDijkstra(0);

        // 0 2 3 1 2 4
        for (int distance : distances)
            System.out.print(distance + " ");
    }
}

class Node implements Comparable<Node> {
    private int destination;

    private int weight;

    public Node(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.weight, other.weight);
    }
}
