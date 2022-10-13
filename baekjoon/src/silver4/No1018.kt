package silver4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1018
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var board: Array<CharArray>

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    board = Array(size[0]) { reader.readLine().toCharArray() }

    var min = Int.MAX_VALUE
    for (i in 0 until size[0] - 7) {
        for (j in 0 until size[1] - 7) {
            min = min.coerceAtMost(getCount(i, j))
        }
    }

    writer.write("$min")
    writer.flush()
}

private fun getCount(row: Int, col: Int): Int {
    var count1 = 0
    for (i in row..row + 7) {
        for (j in col..col + 7) {
            if ((i + j) % 2 == 0 && board[i][j] == 'W') {
                count1++
            } else if ((i + j) % 2 == 1 && board[i][j] == 'B') {
                count1++
            }
        }
    }

    var count2 = 0
    for (i in row..row + 7) {
        for (j in col..col + 7) {
            if ((i + j) % 2 == 1 && board[i][j] == 'W') {
                count2++
            } else if ((i + j) % 2 == 0 && board[i][j] == 'B') {
                count2++
            }
        }
    }

    return count1.coerceAtMost(count2)
}