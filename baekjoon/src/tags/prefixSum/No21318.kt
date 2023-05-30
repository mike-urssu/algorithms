package tags.prefixSum

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/21318
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val mistakes = IntArray(n)
    (1 until n)
        .filter { i -> numbers[i] < numbers[i - 1] }
        .forEach { i -> mistakes[i] = 1 }
    val prefixSum = mistakes.runningFold(0, Int::plus)

    val q = reader.readLine().toInt()
    repeat(q) {
        val (x, y) = reader.readLine().split(" ").map { it.toInt() }
        if (x == y) {
            writer.write("0\n")
        } else {
            writer.write("${prefixSum[y] - prefixSum[x]}\n")
        }
    }
    writer.flush()
}
