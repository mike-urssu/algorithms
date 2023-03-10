package tags.greedy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/1080
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val numbers = reader.readLine().split(' ').map { it.toInt() }.toIntArray()
    val height = numbers[0]
    val width = numbers[1]

    val firstMetrics = getMetrics(height, width)
    val secondMetrics = getMetrics(height, width)

    var count = 0
    for (i in 0 until height - 2) {
        for (j in 0 until width - 2) {
            if (firstMetrics[i][j] != secondMetrics[i][j]) {
                reverseMetrics(firstMetrics, i, j)
                count++
            }
        }
    }

    if (isMetricsMatches(firstMetrics, secondMetrics))
        writer.write(count.toString())
    else
        writer.write((-1).toString())
    writer.flush()
}

private fun getMetrics(height: Int, width: Int): Array<IntArray> {
    val metrics = Array(height) { IntArray(width) }
    for (i in 0 until height) {
        val row = reader.readLine()
        for (j in 0 until width)
            metrics[i][j] = row[j].digitToInt()
    }
    return metrics
}

private fun reverseMetrics(metrics: Array<IntArray>, col: Int, row: Int) {
    for (i in col until col + 3) {
        for (j in row until row + 3)
            metrics[i][j] = if (metrics[i][j] == 1) 0 else 1
    }
}

private fun isMetricsMatches(firstMetrics: Array<IntArray>, secondMetrics: Array<IntArray>): Boolean {
    for (i in firstMetrics.indices) {
        for (j in 0 until firstMetrics[i].size) {
            if (firstMetrics[i][j] != secondMetrics[i][j])
                return false
        }
    }
    return true
}
