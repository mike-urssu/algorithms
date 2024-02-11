package tags.math

/**
 * https://www.acmicpc.net/problem/31247
 */
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val t = reader.readLine().toInt()
    repeat(t) {
        val (n, k) = reader.readLine().split(" ").map { it.toLong() }
        writer.write("${countSpecialNumbers(n, k)}\n")
    }
    writer.flush()
}

private fun countSpecialNumbers(n: Long, k: Long): Long {
    var currentValue = n
    for (i in 0 until k) {
        currentValue = currentValue shr 1
        if (currentValue == 0L) {
            return 0
        }
    }
    return (currentValue + 1) / 2
}
