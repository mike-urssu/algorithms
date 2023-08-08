package tags.dp

/**
 * https://www.acmicpc.net/problem/10942
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val n = reader.readLine().toInt()
    val numbers = getNumbers(n)
    val dp = getDp(n, numbers)
    val m = reader.readLine().toInt()
    repeat(m) {
        val (s, e) = reader.readLine().split(" ").map { it.toInt() }
        writer.write("${dp[s][e]}\n")
    }
    writer.flush()
}

private fun getNumbers(n: Int) =
    IntArray(n + 1).apply {
        reader.readLine().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }

private fun getDp(n: Int, numbers: IntArray): Array<IntArray> {
    val dp = Array(n + 1) { IntArray(n + 1) }
    for (i in n downTo 1) {
        for (j in i..n) {
            dp[i][j] = if (numbers[i] == numbers[j]) {
                if (j <= i + 1) {
                    1
                } else {
                    if (dp[i + 1][j - 1] == 1) {
                        1
                    } else {
                        0
                    }
                }
            } else {
                0
            }
        }
    }
    return dp
}
