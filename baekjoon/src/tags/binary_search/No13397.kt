package tags.binary_search

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/13397
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (_, m) = reader.readLine().split(" ").map { it.toInt() }
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var low = -1
    var high = numbers.max()
    while (low + 1 < high) {
        val mid = (low + high) / 2
        var group = 1

        var min = numbers.first()
        var max = numbers.first()

        for (i in 1 until numbers.size) {
            val number = numbers[i]
            if (abs(min - number) > mid || abs(max - number) > mid) {
                min = number
                max = number
                group++
            } else {
                min = min.coerceAtMost(number)
                max = max.coerceAtLeast(number)
            }
        }

        if (group > m) {
            low = mid
        } else {
            high = mid
        }
    }

    writer.write("$high")
    writer.flush()
}
