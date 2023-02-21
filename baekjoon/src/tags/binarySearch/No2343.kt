package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/2343
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val (_, m) = reader.readLine().split(" ").map { it.toInt() }
    val numbers = reader.readLine().split(" ").map { it.toInt() }

    var low = 0
    var high = 1000000000
    while (low + 1 < high) {
        val mid = (low + high) / 2
        if (numbers.any { it > mid }) {
            low = mid
        } else {
            var count = 0
            var sum = 0
            for (number in numbers) {
                if (sum + number > mid) {
                    sum = number
                    count++
                } else {
                    sum += number
                }
            }
            count++

            if (count > m) {
                low = mid
            } else {
                high = mid
            }
        }
    }

    writer.write("$high")
    writer.flush()
}
