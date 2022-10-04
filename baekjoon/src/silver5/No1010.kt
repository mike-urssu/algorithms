package silver5

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1010
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))
private lateinit var graph: Array<IntArray>

fun main() {
    setGraph()

    val numberOfInput = reader.readLine().toInt()
    repeat(numberOfInput) {
        val numbers = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${graph[numbers[1]][numbers[0]]}\n")
    }
    writer.flush()
}

private fun setGraph() {
    graph = Array(31) { IntArray(31) }
    for (i in 0..30) {
        for (j in 0..i) {
            if (j == 0 || j == i)
                graph[i][j] = 1
            else
                graph[i][j] = graph[i - 1][j - 1] + graph[i - 1][j]
        }
    }
}