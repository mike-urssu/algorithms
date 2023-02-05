package level.bronze4

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/4299
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (n1, n2) = reader.readLine().split(" ").map { it.toInt() }

    if ((n1 + n2) == 1 || (n1 - n2) % 2 == 1 || n1 < n2) {
        writer.write("-1")
    } else {
        val score1 = (n1 + n2) / 2
        val score2 = (n1 - n2) / 2
        writer.write("${score1.coerceAtLeast(score2)} ${score1.coerceAtMost(score2)}")
    }
    writer.flush()
}
