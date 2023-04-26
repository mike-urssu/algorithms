package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/17390
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n, q) = reader.readLine().split(" ").map { it.toInt() }
    val array = reader.readLine().split(" ").map { it.toInt() }.sorted()
    val prefixSum = IntArray(n + 1)
    (1..n).forEach { i -> prefixSum[i] = prefixSum[i - 1] + array[i - 1] }

    repeat(q) {
        val (l, r) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${prefixSum[r] - prefixSum[l - 1]}\n")
    }
    writer.flush()
}
