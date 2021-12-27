package interviewQuestion;

public class RoutePlanner {
    static boolean isRouteExists;

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        int length = mapMatrix.length;
        boolean[][] isVisited = new boolean[length][length];
        isVisited[fromRow][fromColumn] = true;
        bfs(fromRow, fromColumn, toRow, toColumn, mapMatrix, isVisited, length);
        return isRouteExists;
    }

    public static void bfs(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix, boolean[][] isVisited, int length) {
//        System.out.println("(" + fromRow + ", " + fromColumn + ") -> (" + toRow + ", " + toColumn + ")");

        if (!mapMatrix[fromRow][fromColumn])
            return;

        if (fromRow == toRow && fromColumn == toColumn) {
            isRouteExists = true;
            return;
        }
        if (fromRow - 1 >= 0 && mapMatrix[fromRow - 1][fromColumn] && !isVisited[fromRow - 1][fromColumn]) {
            isVisited[fromRow - 1][fromColumn] = true;
            bfs(fromRow - 1, fromColumn, toRow, toColumn, mapMatrix, isVisited, length);
            isVisited[fromRow - 1][fromColumn] = false;
        }
        if (fromColumn + 1 < length && mapMatrix[fromRow][fromColumn + 1] && !isVisited[fromRow][fromColumn + 1]) {
            isVisited[fromRow][fromColumn + 1] = true;
            bfs(fromRow, fromColumn + 1, toRow, toColumn, mapMatrix, isVisited, length);
            isVisited[fromRow][fromColumn + 1] = false;
        }
        if (fromRow + 1 < length && mapMatrix[fromRow + 1][fromColumn] && !isVisited[fromRow + 1][fromColumn]) {
            isVisited[fromRow + 1][fromColumn] = true;
            bfs(fromRow + 1, fromColumn, toRow, toColumn, mapMatrix, isVisited, length);
            isVisited[fromRow + 1][fromColumn] = false;
        }
        if (fromColumn - 1 >= 0 && mapMatrix[fromRow][fromColumn - 1] && !isVisited[fromRow][fromColumn - 1]) {
            isVisited[fromRow][fromColumn - 1] = true;
            bfs(fromRow, fromColumn - 1, toRow, toColumn, mapMatrix, isVisited, length);
            isVisited[fromRow][fromColumn - 1] = false;
        }
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false},
                {true, true, false},
                {false, true, true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }
}
