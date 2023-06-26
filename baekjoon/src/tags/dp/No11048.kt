package tags.dp

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

/**
 * https://www.acmicpc.net/problem/11048
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var tokenizer = StringTokenizer(readLine())
    val height = tokenizer.nextToken().toInt()
    val width = tokenizer.nextToken().toInt()
    val maze = Array(height + 1) { i ->
        if (i == 0)
            IntArray(width + 1)
        else {
            tokenizer = StringTokenizer(readLine())
            IntArray(width + 1) { i ->
                if (i == 0) 0
                else tokenizer.nextToken().toInt()
            }
        }
    }

    for (i in 1..height) {
        for (j in 1..width)
            maze[i][j] = maze[i][j] + maze[i - 1][j].coerceAtLeast(maze[i][j - 1])
    }

    with(BufferedWriter(OutputStreamWriter(System.out))) {
        write("${maze[height][width]}")
        flush()
    }
}