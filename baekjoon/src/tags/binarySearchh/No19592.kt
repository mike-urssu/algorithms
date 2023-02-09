package tags.binarySearchh

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/19592
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val (_, x, y) = reader.readLine().split(" ").map { it.toInt() }
        val vs = reader.readLine().split(" ").map { it.toDouble() }

        if (vs.max() == vs.last()) {
            writer.write("0")
        } else {
            val s = x / vs.max()

            var low = 0
            var high = 1000000
            while (low + 1 < high) {
                val mid = (low + high) / 2
                val t = (x - mid) / vs.last() + 1
                if (s <= t) {
                    low = mid
                } else {
                    high = mid
                }
            }

            if (high > y) {
                writer.write("-1")
            } else if (high <= vs.last()) {
                writer.write("0")
            } else {
                writer.write("$high")
            }
        }
        writer.newLine()
    }
    writer.flush()
}
