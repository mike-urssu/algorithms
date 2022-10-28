package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2167
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

private lateinit var graph: Array<IntArray>

fun main() {
    val size = reader.readLine().split(" ").map { it.toInt() }
    setGraph(size)

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        var sum = 0
        val positions = reader.readLine().split(" ").map { it.toInt() }
        for (i in positions[0] - 1 until positions[2]) {
            for (j in positions[1] - 1 until positions[3]) {
                sum += graph[i][j]
            }
        }
        writer.write("$sum\n")
    }
    writer.flush()
}

private fun setGraph(size: List<Int>) {
    graph = Array(size[0]) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
}