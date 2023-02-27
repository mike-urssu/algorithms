package tags.binarySearch

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * https://www.acmicpc.net/problem/11561
 */
private val reader = BufferedReader(InputStreamReader(System.`in`))
private val writer = BufferedWriter(OutputStreamWriter(System.out))

fun main() {
    val testCase = reader.readLine().toInt()
    repeat(testCase) {
        val number = reader.readLine().toULong()
        writer.write("${getMaxStoneCount(number)}")
        writer.newLine()
    }
    writer.flush()
}

private fun getMaxStoneCount(number: ULong): ULong {
    var low = 1UL
    var high = number + 1UL
    while (low + 1UL < high) {
        val mid = (low + high) / 2UL
        val stone = mid * (mid + 1UL) / 2UL
        if (stone > number) {
            high = mid
        } else {
            low = mid
        }
    }
    return low
}
