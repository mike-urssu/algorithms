package tags.bruteForce;

import java.io.*;
import java.util.StringTokenizer;

public class No1018 {
    public static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static StringTokenizer tokenizer;

    public static char[][] chessBoard;
    public static int height;
    public static int width;

    public static void setValues() throws IOException {
        tokenizer = new StringTokenizer(reader.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        chessBoard = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = reader.readLine();
            for (int j = 0; j < width; j++)
                chessBoard[i][j] = line.charAt(j);
        }
    }

    public static int getMinimumBoardsToPaint() {
        int min = Integer.MAX_VALUE;
        for (int row = 0; row <= height - 8; row++) {
            for (int col = 0; col <= width - 8; col++)
                min = Math.min(min, getBoardsToPaint(row, col));
        }
        return min;
    }

    private static int getBoardsToPaint(int row, int col) {
        int count1 = 0;
        final char color = chessBoard[row][col];
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if ((i + j) % 2 == 0 && chessBoard[i][j] != color)
                    count1++;
                else if ((i + j) % 2 == 1 && chessBoard[i][j] == color)
                    count1++;
            }
        }

        int count2 = 0;
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {
                if ((i + j) % 2 == 0 && chessBoard[i][j] == color)
                    count2++;
                else if ((i + j) % 2 == 1 && chessBoard[i][j] != color)
                    count2++;
            }
        }
        return Math.min(count1, count2);
    }


    public static void main(String[] args) throws IOException {
        setValues();
        writer.write(String.valueOf(getMinimumBoardsToPaint()));
        writer.flush();
    }
}
