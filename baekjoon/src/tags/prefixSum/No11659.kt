package tags.prefixSum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11659
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val prefixSums = IntArray(n + 1)
    for (i in 1..n) {
        prefixSums[i] = prefixSums[i - 1] + numbers[i - 1]
    }

    repeat(m) {
        val (i, j) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${prefixSums[j] - prefixSums[i - 1]}\n")
    }
    writer.flush()
}
