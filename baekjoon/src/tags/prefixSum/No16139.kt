package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/16139
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val s = reader.readLine()
    val prefixSum = getPrefixSum(s)

    val q = reader.readLine().toInt()
    repeat(q) {
        val (c, l, r) = reader.readLine().split(" ")
        val index = c[0] - 'a'
        writer.write("${prefixSum[index][r.toInt() + 1] - prefixSum[index][l.toInt()]}\n")
    }
    writer.flush()
}

private fun getPrefixSum(s: String): Array<IntArray> {
    val prefixSum = Array(26) { IntArray(s.length + 1) }
    for (i in s.indices) {
        val c = s[i] - 'a'
        prefixSum[c][i + 1]++
    }

    for (i in prefixSum.indices) {
        for (j in 1..s.length) {
            prefixSum[i][j] += prefixSum[i][j - 1]
        }
    }
    return prefixSum
}
