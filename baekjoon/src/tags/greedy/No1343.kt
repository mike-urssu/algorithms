package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1343
 */
fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))
    val board = reader.readLine()
    writer.write(getPolyomino(board))
    writer.flush()
}

fun getPolyomino(board: String): String {
    val words = board.split('.')
    for (word in words) {
        if (word.length % 2 == 1)
            return "-1"
    }
    return board.replace("XXXX", "AAAA").replace("XX", "BB")
}
