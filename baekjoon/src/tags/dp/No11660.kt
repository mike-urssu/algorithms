package tags.dp

/**
 * https://www.acmicpc.net/problem/11660
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { reader.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val prefixSum = getPrefixSum(n, graph)
    repeat(m) {
        val (x1, y1, x2, y2) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${prefixSum[x2][y2] - prefixSum[x2][y1 - 1] - prefixSum[x1 - 1][y2] + prefixSum[x1 - 1][y1 - 1]}\n")
    }
    writer.flush()
}

private fun getPrefixSum(n: Int, graph: Array<IntArray>): Array<IntArray> {
    val prefixSum = Array(n + 1) { IntArray(n + 1) }
    for (i in 1 until n + 1) {
        for (j in 1 until n + 1) {
            prefixSum[i][j] = graph[i - 1][j - 1] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
        }
    }
    return prefixSum
}
