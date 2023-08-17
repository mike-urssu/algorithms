package tags.prefix_sum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/19951
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, m) = reader.readLine().split(" ").map { it.toInt() }
    val heights = reader.readLine().split(" ").map { it.toInt() }
    val prefixSum = getPrefixSum(n, m)
    (0 until n).forEach { i -> writer.write("${heights[i] + prefixSum[i]} ") }
    writer.flush()
}

private fun getPrefixSum(n: Int, m: Int): IntArray {
    val dh = IntArray(n)
    repeat(m) {
        val (a, b, k) = reader.readLine().split(" ").map { it.toInt() }
        dh[a - 1] += k
        if (b != n) {
            dh[b] += -k
        }
    }
    return dh.runningFold(0, Int::plus).drop(1).toIntArray()
}
