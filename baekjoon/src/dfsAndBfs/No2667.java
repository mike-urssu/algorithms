package dfsAndBfs;

import java.io.*;
import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/2667
 */
public class No2667 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int square;
    public static int[][] graph;
    public static int[] cities;
    public static int index;
    public static int city = 11;

    public static void setGraph() throws IOException {
        square = Integer.parseInt(reader.readLine());
        graph = new int[square][square];
        cities = new int[625];
        for (int i = 0; i < square; i++) {
            String cities = reader.readLine();
            for (int j = 0; j < square; j++)
                graph[i][j] = cities.charAt(j) - '0';
        }
    }

    public static void updateCities() {
        for (int i = 0; i < square; i++) {
            for (int j = 0; j < square; j++) {
                if (graph[i][j] == 1) {
                    bfs(i, j, city++);
                    index++;
                }
            }
        }
    }

    public static void bfs(int row, int col, int city) {
        graph[row][col] = city;
        cities[index]++;
        for (int i = row; i < square; i++) {
            for (int j = col; j < square; j++) {
                if (row - 1 >= 0 && graph[row - 1][col] == 1) {
                    graph[row - 1][col] = city;
                    bfs(row - 1, col, city);
                } else if (col + 1 < square && graph[row][col + 1] == 1) {
                    graph[row][col + 1] = city;
                    bfs(row, col + 1, city);
                } else if (row + 1 < square && graph[row + 1][col] == 1) {
                    graph[row + 1][col] = city;
                    bfs(row + 1, col, city);
                } else if (col - 1 >= 0 && graph[row][col - 1] == 1) {
                    graph[row][col - 1] = city;
                    bfs(row, col - 1, city);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        setGraph();
        updateCities();

        writer.write(String.valueOf(index));
        writer.newLine();
        Integer[] arr = new Integer[index];
        for (int i = 0; i < index; i++)
            arr[i] = cities[i];
        Arrays.sort(arr);

        for (int i = 0; i < index; i++) {
            writer.write(String.valueOf(arr[i]));
            writer.newLine();
        }
        writer.flush();
    }
}
