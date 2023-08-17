package tags.prefix_sum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/5549
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (m, n) = reader.readLine().split(" ").map { it.toInt() }
    val k = reader.readLine().toInt()

    val graph = getGraph(m, n)
    val prefixSum = getPrefixSum(m, n, graph)

    repeat(k) {
        val (a, b, c, d) = reader.readLine().split(" ").map { it.toInt() }
        Type.values().forEach { type ->
            writer.write("${prefixSum[type.ordinal][c][d] - prefixSum[type.ordinal][a - 1][d] - prefixSum[type.ordinal][c][b - 1] + prefixSum[type.ordinal][a - 1][b - 1]} ")
        }
        writer.newLine()
    }
    writer.flush()
}

private fun getGraph(m: Int, n: Int): Array<Array<IntArray>> {
    val graph = Array(3) { Array(m) { IntArray(n) } }
    repeat(m) { i ->
        val characters = reader.readLine().toCharArray()
        characters.forEachIndexed { j, c ->
            when (c) {
                'J' -> graph[Type.JUNGLE.ordinal][i][j] = 1
                'O' -> graph[Type.OCEAN.ordinal][i][j] = 1
                'I' -> graph[Type.ICE.ordinal][i][j] = 1
            }
        }
    }
    return graph
}

private fun getPrefixSum(m: Int, n: Int, graph: Array<Array<IntArray>>): Array<Array<IntArray>> {
    val prefixSum = Array(3) { Array(m + 1) { IntArray(n + 1) } }
    Type.values().forEach { type ->
        (1..m).forEach { i ->
            (1..n).forEach { j ->
                prefixSum[type.ordinal][i][j] =
                    graph[type.ordinal][i - 1][j - 1] + prefixSum[type.ordinal][i - 1][j] + prefixSum[type.ordinal][i][j - 1] - prefixSum[type.ordinal][i - 1][j - 1]
            }
        }
    }
    return prefixSum
}

private enum class Type {
    JUNGLE, OCEAN, ICE
}
