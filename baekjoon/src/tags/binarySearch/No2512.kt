package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2512
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    reader.readLine()
    val numbers = reader.readLine().split(" ").map { it.toInt() }
    val budget = reader.readLine().toInt()

    if (numbers.sum() <= budget) {
        writer.write("${numbers.max()}")
    } else {
        var low = 0
        var high = budget + 1
        while (low + 1 < high) {
            val mid = (low + high) / 2
            val sum = numbers.sumOf { it.coerceAtMost(mid) }
            if (sum > budget) {
                high = mid
            } else {
                low = mid
            }
        }
        writer.write("$low")
    }
    writer.flush()
}
