package level.bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1236
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(size[0]) { reader.readLine().toCharArray() }

    var guardsNotInRow = 0
    graph.forEach { row ->
        if (row.all { it == '.' }) {
            guardsNotInRow++
        }
    }

    var guardsNotInCol = 0
    for (j in 0 until size[1]) {
        var isColContainsGuard = false
        for (i in 0 until size[0]) {
            if (graph[i][j] == 'X') {
                isColContainsGuard = true
                break
            }
        }
        if (!isColContainsGuard) {
            guardsNotInCol++
        }
    }

    writer.write("${guardsNotInRow.coerceAtLeast(guardsNotInCol)}")
    writer.flush()
}