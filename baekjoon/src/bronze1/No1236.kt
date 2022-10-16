package bronze1

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1236
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<CharArray>
private lateinit var guardsInCol: BooleanArray

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    setGraph(size)
    setGuardsInCol(size)

    var count = 0
    for (i in 0 until size[0]) {
        if (graph[i].all { it == '.' }) {
            for (j in size[1] - 1 downTo 0) {
                if (guardsInCol.all { it }) {
                    graph[i][0] = 'X'
                    count++
                    break
                } else if (!guardsInCol[j]) {
                    guardsInCol[j] = true
                    graph[i][j] = 'X'
                    count++
                    break
                }
            }
        }
    }

    count += guardsInCol.count { !it }

    writer.write("$count")
    writer.flush()
}

private fun setGraph(size: List<Int>) {
    graph = Array(size[0]) { reader.readLine().toCharArray() }
}

private fun setGuardsInCol(size: List<Int>) {
    guardsInCol = BooleanArray(size[1])
    for (j in 0 until size[1]) {
        for (i in 0 until size[0]) {
            if (graph[i][j] == 'X') {
                guardsInCol[j] = true
                break
            }
        }
    }
}